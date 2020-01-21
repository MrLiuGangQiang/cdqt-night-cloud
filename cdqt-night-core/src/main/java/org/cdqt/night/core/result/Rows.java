package org.cdqt.night.core.result;

import java.io.Serializable;
import java.util.List;

/**
 * 多行数据对象
 * 
 * @author LiuGangQiang Create in 2020/01/21
 */
public class Rows<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 总记录数
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	private Long total;

	/**
	 * 数据结果集
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	private List<T> rows;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	public Rows() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 * @param total 总记录数
	 * @param rows  数据结果集
	 */
	public Rows(long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 * @return {@link Rows}
	 */
	public Rows<T> setTotal(Long total) {
		this.total = total;
		return this;
	}

	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 * @return {@link Rows}
	 */
	public Rows<T> setRows(List<T> rows) {
		this.rows = rows;
		return this;
	}
}
