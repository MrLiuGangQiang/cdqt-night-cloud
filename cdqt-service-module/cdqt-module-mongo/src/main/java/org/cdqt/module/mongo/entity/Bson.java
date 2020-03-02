package org.cdqt.module.mongo.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * {@link Bson} 对象
 *
 * @author LiuGangQiang Create in 2020/02/01
 */
@Document
public class Bson {

	/**
	 * 文件ID
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private String id;

	/**
	 * 文件名
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private String name;

	/**
	 * 文件类型
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private String contentType;

	/**
	 * 文件大小
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private long size;

	/**
	 * 上传日期
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private Date uploadDate;

	/**
	 * 文件md5编码
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private String md5;

	/**
	 * 文件字节数组
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private byte[] content;

	protected Bson() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param name        文件名字
	 * @param contentType 文件类型
	 * @param size        文件大小
	 * @param content     文件字节数组
	 */
	public Bson(String name, String contentType, long size, byte[] content) {
		this.name = name;
		this.contentType = contentType;
		this.size = size;
		this.uploadDate = new Date();
		this.content = content;
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param name        文件名字
	 * @param contentType 文件类型
	 * @param size        文件大小
	 * @param md5         文件MD5编码
	 * @param content     文件字节数组
	 */
	public Bson(String name, String contentType, long size, String md5, byte[] content) {
		this.name = name;
		this.contentType = contentType;
		this.size = size;
		this.uploadDate = new Date();
		this.md5 = md5;
		this.content = content;
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
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @return the md5
	 */
	public String getMd5() {
		return md5;
	}

	/**
	 * @param md5 the md5 to set
	 */
	public void setMd5(String md5) {
		this.md5 = md5;
	}

	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}
}