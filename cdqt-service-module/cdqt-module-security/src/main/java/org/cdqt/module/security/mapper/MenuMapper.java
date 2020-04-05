package org.cdqt.module.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.security.entity.Menu;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * MenuMapper
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@Mapper
public interface MenuMapper extends IBaseMapper<Menu, String> {
}