package org.cdqt.night.core.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 实体类基类（程序内的实体类都应继承此类）
 * 
 * @author LiuGangQiang Create in 2020/01/20
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable {
	/**
	 * 默认页数
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 */
	private static final int DEFAULT_PAGE = 1;
	/**
	 * 默认每页记录数
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 */
	private static final int DEFAULT_PAGESIZE = 10;

	/**
	 * 当前页 默认为第一页
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 */
	transient Integer page;

	/**
	 * 每页记录数 默认每页十条
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 */
	transient Integer pageSize;
	/**
	 * 排序集合 支持多字段组合排序
	 *
	 * @author LiuGangQiang Create in 2020/01/20
	 */
	transient List<Sort> sorts;

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		if (page != null && page > 0) {
			this.page = page;
		} else {
			this.page = DEFAULT_PAGE;
		}
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = DEFAULT_PAGESIZE;
		}
	}

	/**
	 * @return the sorts
	 */
	public List<Sort> getSorts() {
		return sorts;
	}

	/**
	 * @param sorts the sorts to set
	 */
	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}
}
