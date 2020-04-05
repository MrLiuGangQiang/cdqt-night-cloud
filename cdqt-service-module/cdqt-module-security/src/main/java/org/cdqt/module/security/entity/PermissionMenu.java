package org.cdqt.module.security.entity;

import java.util.Date;

import org.cdqt.night.core.entity.BaseEntity;

/**
 * 权限菜单关联表
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class PermissionMenu extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
     * 主键
     * 
     * @author LiuGangQiang Create in 2020/03/07
     */
    private String id;

    /**
     * 权限ID
     * 
     * @author LiuGangQiang Create in 2020/03/07
     */
    private String permissionId;

    /**
     * 菜单ID
     * 
     * @author LiuGangQiang Create in 2020/03/07
     */
    private String menuId;

    /**
     * 是否激活
     * 
     * @author LiuGangQiang Create in 2020/03/07
     */
    private Boolean enabled;

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
     * @return the permissionId
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId the permissionId to set
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return the menuId
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
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