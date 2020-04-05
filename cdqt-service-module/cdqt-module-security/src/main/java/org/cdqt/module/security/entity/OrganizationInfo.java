package org.cdqt.module.security.entity;

import java.util.Date;

import org.cdqt.night.core.entity.BaseEntity;

/**
 * 组织信息表
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class OrganizationInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String id;

	/**
	 * 机构名称
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String name;

	/**
	 * 机构编码
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String code;

	/**
	 * 修改时间
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private Date updateTime;

	/**
	 * 创建时间
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private Date createTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}