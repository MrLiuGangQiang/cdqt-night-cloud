package org.cdqt.module.security.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.cdqt.night.core.entity.BaseEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 用户信息表
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class UserInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户登录分组
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 */
	public abstract interface Login {
	};

	/**
	 * 主键
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String id;

	/**
	 * 姓名
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String name;

	/**
	 * 手机
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotBlank(message = "{user.info.phone.not.blank}", groups = { Login.class })
	private String phone;

	/**
	 * 身份证
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String idCard;

	/**
	 * 生日
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private Date birthday;

	/**
	 * 地址
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private String address;

	/**
	 * 密码
	 * 
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	@NotBlank(message = "{user.info.password.not.blank}", groups = { Login.class })
	@Length(message = "{user.info.password.length}", min = 6, max = 32, groups = { Login.class })
	private String password;

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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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