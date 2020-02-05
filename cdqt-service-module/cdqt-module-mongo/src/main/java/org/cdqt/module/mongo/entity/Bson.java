package org.cdqt.module.mongo.entity;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Bson 这里是一个示例对象
 *
 * @author LiuGangQiang Create in 2020/02/01
 */
@Document
public class Bson {

	@Id
	private String id;

	private String name;

	private String contentType;

	private long size;

	private Date uploadDate;

	private String md5;

	private byte[] content;

	protected Bson() {
	}

	public Bson(String name, String contentType, long size, byte[] content) {
		this.name = name;
		this.contentType = contentType;
		this.size = size;
		this.uploadDate = new Date();
		this.content = content;
	}

	public Bson(String name, String contentType, long size, String md5, byte[] content) {
		this.name = name;
		this.contentType = contentType;
		this.size = size;
		this.uploadDate = new Date();
		this.md5 = md5;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Bson fileInfo = (Bson) object;
		return Objects.equals(size, fileInfo.size) && Objects.equals(name, fileInfo.name)
				&& Objects.equals(contentType, fileInfo.contentType) && Objects.equals(uploadDate, fileInfo.uploadDate)
				&& Objects.equals(md5, fileInfo.md5) && Objects.equals(id, fileInfo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, contentType, size, uploadDate, md5, id);
	}

	@Override
	public String toString() {
		return "Bson{" + "name='" + name + '\'' + ", contentType='" + contentType + '\'' + ", size=" + size
				+ ", uploadDate=" + uploadDate + ", md5='" + md5 + '\'' + ", id='" + id + '\'' + '}';
	}
}