package org.cdqt.module.security.service.iface;

import java.util.List;
import java.util.Map;

import org.cdqt.module.security.entity.Menu;

/**
 * IMenuService
 *
 * @author LiuGangQiang Create in 2020/04/06
 */
public interface IMenuService {

	Map<String, Object> queryUnique(Menu menu);

	Integer insert(Menu menu);

	Map<String, Object> queryOne(Menu menu);

	Integer delete(Menu menu);

	Integer update(Menu menu);

	List<Map<String, Object>> queryList(Menu menu);

}
