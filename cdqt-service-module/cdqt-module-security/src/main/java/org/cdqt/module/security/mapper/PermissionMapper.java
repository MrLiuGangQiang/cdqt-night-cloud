package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.Permission;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * PermissionMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface PermissionMapper extends IBaseMapper<Permission, String> {
}