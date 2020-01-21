package org.cdqt.night.core.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.cdqt.night.core.entity.BaseEntity;

/**
 * 通用Mapper
 * 
 * @author LiuGangQiang Create in 2020/01/20
 */
public abstract interface IBaseMapper<T extends BaseEntity, PK extends Serializable> {

	/**
	 * 通过实例新增记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20 Create in 2020/01/20
	 * @param entity 实例
	 * @return 受影响行数
	 */
	abstract int insert(T entity);

	/**
	 * 通过Map新增记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 受影响行数
	 */
	abstract int insertByMap(Map<String, Object> param);

	/**
	 * 通过实例删除记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 受影响行数
	 */
	abstract int delete(T entity);

	/**
	 * 通过Map删除记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 受影响行数
	 */
	abstract int deleteByMap(Map<String, Object> param);

	/**
	 * 通过主键删除记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param id 主键
	 * @return 受影响行数
	 */
	abstract int deleteByPrimaryKey(PK id);

	/**
	 * 通过实例修改记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 受影响行数
	 */
	abstract int update(T entity);

	/**
	 * 通过Map修改记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 受影响行数
	 */
	abstract int updateByMap(Map<String, Object> param);

	/**
	 * 通过实例查询单条记录（请谨慎使用，条件一定要明确，不然查询出多条记录会抛异常）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 单条记录
	 */
	abstract Map<String, Object> queryOne(T entity);

	/**
	 * 通过Map查询单条记录（请谨慎使用，条件一定要明确，不然查询出多条记录会抛异常）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 单条记录
	 */
	abstract Map<String, Object> queryOneByMap(Map<String, Object> param);

	/**
	 * 通过主键查询单条记录（请谨慎使用，条件一定要明确，不然查询出多条记录会抛异常）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param id 主键
	 * @return 单条记录
	 */
	abstract Map<String, Object> queryOneByPrimaryKey(PK id);

	/**
	 * 通过实例查询单条记录（请谨慎使用，条件一定要明确，不然查询出多条记录会抛异常）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 单个实例
	 */
	abstract T queryOneForEntity(T entity);

	/**
	 * 通过Map查询单条记录（请谨慎使用，条件一定要明确，不然查询出多条记录会抛异常）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 单个实例
	 */
	abstract T queryOneForEntityByMap(Map<String, Object> param);

	/**
	 * 通过主键查询单条记录（请谨慎使用，条件一定要明确，不然查询出多条记录会抛异常）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param id 主键
	 * @return 单个实例
	 */
	abstract T queryOneForEntityByPrimaryKey(PK id);

	/**
	 * 通过实例查询多条记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 多条记录
	 */
	abstract List<Map<String, Object>> queryList(T entity);

	/**
	 * 通过Map查询多条记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 多条记录
	 */
	abstract List<Map<String, Object>> queryListByMap(Map<String, Object> param);

	/**
	 * 通过实例查询多条记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 多个实例
	 */
	abstract List<T> queryListForEntity(T entity);

	/**
	 * 通过Map查询多条记录
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 多个实例
	 */
	abstract List<T> queryListForEntityByMap(Map<String, Object> param);

	/**
	 * 通过实例查询唯一记录（适用于通过唯一键或者组合唯一键来查询记录）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 单条记录
	 */
	abstract Map<String, Object> queryUnique(T entity);

	/**
	 * 通过Map查询唯一记录（适用于通过唯一键或者组合唯一键来查询记录）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 单条记录
	 */
	abstract Map<String, Object> queryUniqueByMap(Map<String, Object> param);

	/**
	 * 通过实例查询唯一记录（适用于通过唯一键或者组合唯一键来查询记录）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param entity 实例
	 * @return 单个实例
	 */
	abstract T queryUniqueForEntity(T entity);

	/**
	 * 通过Map查询唯一记录（适用于通过唯一键或者组合唯一键来查询记录）
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 * @param param 参数集合
	 * @return 单个实例
	 */
	abstract T queryUniqueForEntityByMap(Map<String, Object> param);
}