package org.cdqt.study.security.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.night.core.mapper.IBaseMapper;
import org.cdqt.study.security.entity.UserInfo;

/**
 * UserInfoMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface UserInfoMapper extends IBaseMapper<UserInfo, String> {

	/**
	 * 用户登录
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 * @param userInfo 用户信息
	 * @return {@link Map}
	 */
	Map<String, Object> login(UserInfo userInfo);
}