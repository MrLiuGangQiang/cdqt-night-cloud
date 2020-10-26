package org.cdqt.study.security.service.iface;

import java.util.Map;

import org.cdqt.study.security.entity.UserInfo;

/**
 * IUserInfoService
 *
 * @author LiuGangQiang Create in 2020/10/25
 */
public interface IUserInfoService {

	/**
	 * 用户登录
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 * @param userInfo 用户信息
	 * @return {@link Map}
	 */
	Map<String, Object> login(UserInfo userInfo);

}
