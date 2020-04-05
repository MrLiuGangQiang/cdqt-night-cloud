package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.PermissionMenu;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * PermissionMenuMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface PermissionMenuMapper extends IBaseMapper<PermissionMenu, String> {
}