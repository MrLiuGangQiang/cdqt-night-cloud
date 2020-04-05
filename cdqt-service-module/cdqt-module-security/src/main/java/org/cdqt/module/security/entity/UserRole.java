package org.cdqt.module.security.entity;

import java.util.Date;

import org.cdqt.night.core.entity.BaseEntity;

/**
 * 用户角色信息表
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class UserRole extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String id;

	/**
	 * 角色名称
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String name;

	/**
	 * 角色编码
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String code;

	/**
	 * 是否激活
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private Boolean enabled;

	/**
	 * 备注
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String remark;

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
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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