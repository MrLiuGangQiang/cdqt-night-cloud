package org.cdqt.module.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.provider.entity.Menu;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * 菜单Mapper
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
@Mapper
public interface MenuMapper extends IBaseMapper<Menu, String> {
}