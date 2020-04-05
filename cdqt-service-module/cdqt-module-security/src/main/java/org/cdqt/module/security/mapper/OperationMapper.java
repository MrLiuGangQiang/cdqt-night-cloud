package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.Operation;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * OperationMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface OperationMapper extends IBaseMapper<Operation, String> {
}