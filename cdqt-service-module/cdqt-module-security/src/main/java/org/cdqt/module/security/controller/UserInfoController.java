package org.cdqt.module.security.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.annotation.Resource;

import org.cdqt.module.security.entity.UserInfo;
import org.cdqt.module.security.entity.UserInfo.Login;
import org.cdqt.module.security.global.BaseGlobal;
import org.cdqt.module.security.service.iface.IUserInfoService;
import org.cdqt.night.core.auth.Authentication;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.redis.RedisCacheManager;
import org.cdqt.night.session.QtDeviceEnum;
import org.cdqt.night.session.QtLoginInfo;
import org.cdqt.night.session.QtToken;
import org.cdqt.night.tools.md5.MD5Util;
import org.cdqt.night.tools.valid.MapUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserInfoController
 *
 * @author LiuGangQiang Create in 2020/10/25
 */
@RestController
public class UserInfoController {
	@Resource
	private RedisCacheManager redisCacheManager;
	@Resource
	private IUserInfoService userInfoService;

	/**
	 * 用户登录
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 * @param userInfo 用户信息
	 * @return {@link ResultApi}
	 * @throws NoSuchAlgorithmException
	 */
	@GetMapping(value = { "/user/login" })
	@Authentication(ignore = true)
	public ResultApi<?> login(@Validated({ Login.class }) UserInfo userInfo) throws NoSuchAlgorithmException {
		/* 密码MD5加密 */
		userInfo.setPassword(MD5Util.getInstance().encrypt(userInfo.getPassword()));
		/* 查询用户信息 */
		Map<String, Object> userinfoMap = userInfoService.login(userInfo);
		if (MapUtils.isEmpty(userinfoMap)) {
			/* 数据为空登录失败 */
			return new ResultApi<>(ApiStatus.DATA_NOT_FOUND).setKey("user.info.login.error");
		}
		/* 登录成功生成token并存入缓存 */
		String userId = userinfoMap.get("id").toString();
		String token = QtToken.getInstance().createQtToken(QtDeviceEnum.WEB, userId);
		/* 存入缓存 */
		redisCacheManager.putSession(BaseGlobal.CACHE_WEB_USER, token, userinfoMap);
		/* 设置Token */
		QtLoginInfo<Map<String, Object>> loginInfo = new QtLoginInfo<Map<String, Object>>(token, userinfoMap);
		return new ResultApi<>(ApiStatus.OK, loginInfo);
	}
}
