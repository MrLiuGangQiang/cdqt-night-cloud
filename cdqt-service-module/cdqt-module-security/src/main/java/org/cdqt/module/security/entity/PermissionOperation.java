package org.cdqt.module.security.entity;

import java.util.Date;

import org.cdqt.night.core.entity.BaseEntity;

/**
 * 权限操作关联表
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class PermissionOperation extends BaseEntity {
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
     * 操作ID
     * 
     * @author LiuGangQiang Create in 2020/03/07
     */
    private String operationId;

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
     * @return the operationId
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * @param operationId the operationId to set
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
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