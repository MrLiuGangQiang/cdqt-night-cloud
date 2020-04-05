package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.PermissionOperation;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * PermissionOperationMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface PermissionOperationMapper extends IBaseMapper<PermissionOperation, String> {
}