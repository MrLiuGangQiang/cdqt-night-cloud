package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.UserInfo;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * UserInfoMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface UserInfoMapper extends IBaseMapper<UserInfo, String> {
}