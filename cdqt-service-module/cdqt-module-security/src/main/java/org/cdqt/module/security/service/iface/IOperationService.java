package org.cdqt.module.security.service.iface;

import java.util.List;
import java.util.Map;

import org.cdqt.module.security.entity.Operation;

/**
 * IOperationService
 *
 * @author LiuGangQiang Create in 2020/04/06
 */
public interface IOperationService {

	/**
	 * 查询重复
	 *
	 * @author LiuGangQiang Create in 2020/04/08
	 * @param operation 操作对象
	 * @return {@link Map}
	 */
	Map<String, Object> queryUnique(Operation operation);

	/**
	 * 新增操作
	 *
	 * @author LiuGangQiang Create in 2020/04/08
	 * @param operation 操作对象
	 * @return {@link Integer}
	 */
	Integer insert(Operation operation);

	/**
	 * 查询详情
	 *
	 * @author LiuGangQiang Create in 2020/04/08
	 * @param operation 操作对象
	 * @return {@link Map}
	 */
	Map<String, Object> queryOne(Operation operation);

	/**
	 * 删除操作
	 *
	 * @author LiuGangQiang Create in 2020/04/08
	 * @param operation 操作对象
	 * @return {@link Integer}
	 */
	Integer delete(Operation operation);

	/**
	 * 修改操作
	 *
	 * @author LiuGangQiang Create in 2020/04/08
	 * @param operation 操作对象
	 * @return {@link Integer}
	 */
	Integer update(Operation operation);

	/**
	 * 查询列表
	 *
	 * @author LiuGangQiang Create in 2020/04/08
	 * @param operation 操作对象
	 * @return {@link List}
	 */
	List<Map<String, Object>> queryList(Operation operation);

}
