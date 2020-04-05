package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.RolePermission;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * RolePermissionMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface RolePermissionMapper extends IBaseMapper<RolePermission, String> {
}