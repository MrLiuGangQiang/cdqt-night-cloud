package org.cdqt.module.provider.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.cdqt.night.core.entity.BaseEntity;
import org.cdqt.night.core.valid.ValidGroup.Insert;
import org.cdqt.night.core.valid.ValidGroup.QueryList;

/**
 * 机构菜单表
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String id;

	/**
	 * 父级ID
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String pid;

	/**
	 * 菜单名
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotBlank(message = "{menu.name.not.blank}", groups = { Insert.class })
	private String name;

	/**
	 * 菜单编码
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotBlank(message = "{menu.code.not.blank}", groups = { Insert.class })
	private String code;

	/**
	 * 类型 0：菜单 1：按钮
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotNull(message = "{menu.type.not.null}", groups = { Insert.class })
	private Integer type;

	/**
	 * 排序
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotNull(message = "{menu.sort.not.null}", groups = { Insert.class })
	private Integer sort;

	/**
	 * 是否激活
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotNull(message = "{menu.enabled.not.null}", groups = { Insert.class })
	private Boolean enabled;

	/**
	 * 菜单图标
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String icon;

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
	 * @see org.cdqt.night.core.entity.BaseEntity#getPage()
	 */
	@Override
	@NotNull(message = "{page.not.null}", groups = { QueryList.class })
	public Integer getPage() {
		return super.getPage();
	}

	/**
	 * @see org.cdqt.night.core.entity.BaseEntity#getPageSize()
	 */
	@Override
	@NotNull(message = "{page.size.not.null}", groups = { QueryList.class })
	public Integer getPageSize() {
		return super.getPageSize();
	}

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
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
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
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
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