package org.cdqt.module.security.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.cdqt.module.security.entity.UserInfo;
import org.cdqt.module.security.mapper.UserInfoMapper;
import org.cdqt.module.security.service.iface.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * UserInfoService
 *
 * @author LiuGangQiang Create in 2020/10/25
 */
@Service
public class UserInfoService implements IUserInfoService {
	@Resource
	private UserInfoMapper userInfoMapper;

	@Override
	public Map<String, Object> login(UserInfo userInfo) {
		return userInfoMapper.login(userInfo);
	}
}
