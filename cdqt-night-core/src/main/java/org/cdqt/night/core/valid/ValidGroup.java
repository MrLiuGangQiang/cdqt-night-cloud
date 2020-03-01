package org.cdqt.night.core.valid;

import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * 校验分组接口<br>
 * 这里对应{@link IBaseMapper}内参数传实体对象的方法<br>
 * 如超出默认定义的方法请在对应实体类中定义和接口方法一致的接口
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public abstract interface ValidGroup {
	/**
	 * 新增单条记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 * 
	 */
	public abstract interface Insert {
	};

	/**
	 * 新增多条记录
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface BatchInsert {
	};

	/**
	 * 删除单条记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface Delete {
	};

	/**
	 * 修改记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface Update {
	};

	/**
	 * 查询单条记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface QueryOne {
	};

	/**
	 * 查询单条记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface QueryOneForEntity {
	};

	/**
	 * 查询多条记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface QueryList {
	};

	/**
	 * 查询多条记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface QueryListForEntity {
	};

	/**
	 * 查询重复记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface QueryUnique {
	};

	/**
	 * 查询重复记录
	 * 
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public abstract interface QueryUniqueForEntity {
	};
}
