package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.UserOrganizationRole;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * UserOrganizationRoleMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface UserOrganizationRoleMapper extends IBaseMapper<UserOrganizationRole, String> {
}