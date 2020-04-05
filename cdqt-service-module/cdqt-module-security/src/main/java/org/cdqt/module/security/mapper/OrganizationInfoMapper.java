package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.OrganizationInfo;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * OrganizationInfoMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface OrganizationInfoMapper extends IBaseMapper<OrganizationInfo, String> {
}