package org.cdqt.module.mongo.service;

import java.util.Date;

import javax.annotation.Resource;

import org.cdqt.module.mongo.entity.QtFile;
import org.cdqt.module.mongo.mapper.QtFileMapper;
import org.springframework.stereotype.Service;

@Service
public class QtFileService {
	@Resource
	private QtFileMapper mapper;

	/**
	 * 通过文件ID删除文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param fileId 系统文件ID
	 * @return {@link Integer}
	 */
	public Integer deleteByPrimaryKey(String fileId) {
		return mapper.deleteByPrimaryKey(fileId);
	}

	/**
	 * 通过文件ID删除文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param qtFile 系统文件对象
	 * @return {@link Integer}
	 */
	public Integer insert(QtFile qtFile) {
		Date now = new Date();
		qtFile.setUpdateTime(now);
		qtFile.setCreateTime(now);
		return mapper.insert(qtFile);
	}

	/**
	 * 通过MD5查询文件
	 *
	 * @author LiuGangQiang Create in 2020/07/28
	 * @param md5 MD5
	 * @return {@link QtFile}
	 */
	public QtFile queryByMD5(String md5) {
		return mapper.queryByMD5(md5);
	}

	/**
	 * 通过ID查询文件
	 *
	 * @author LiuGangQiang Create in 2020/07/28
	 * @param id ID
	 * @return {@link QtFile}
	 */
	public QtFile queryByID(String id) {
		return mapper.queryByID(id);
	}
}