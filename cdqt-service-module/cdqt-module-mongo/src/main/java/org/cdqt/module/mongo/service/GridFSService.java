package org.cdqt.module.mongo.service;

import java.io.InputStream;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;

/**
 * GridFS服务
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
@Service
public class GridFSService {
	/**
	 * {@link GridFsTemplate} 对象
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	@Resource
	private GridFsTemplate gridFsTemplate;
	/**
	 * {@link GridFSBucket} 对象
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	@Resource
	private GridFSBucket gridFSBucket;

	/**
	 * 上传文件 最好不要使用此方法 因为不设置文件类型在预览时会出现异常
	 *
	 * @author LiuGangQiang Create in 2020/01/25
	 * @param fileName 文件名
	 * @param ins      输入流
	 * @return {@link ObjectId} 对象
	 */
	@Deprecated
	public ObjectId upload(String fileName, InputStream ins) {
		return gridFsTemplate.store(ins, fileName);
	}

	/**
	 * 上传文件
	 *
	 * @author LiuGangQiang Create in 2020/01/25
	 * @param fileName    文件名
	 * @param ins         输入流
	 * @param contentType 文件类型
	 * @return {@link ObjectId} 对象
	 */
	public ObjectId upload(String fileName, InputStream ins, String contentType) {
		return gridFsTemplate.store(ins, fileName, contentType);
	}

	/**
	 * 通过文件ID下载文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param objectId 文件ID
	 * @return {@link GridFsResource} 对象
	 */
	public GridFsResource download(String objectId) {
		Query query = Query.query(Criteria.where("_id").is(objectId));
		GridFSFile gridFSFile = gridFsTemplate.findOne(query);
		if (gridFSFile == null) {
			return null;
		}
		GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
		GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
		return gridFsResource;
	}

	/**
	 * 通过MD5下载文件（不包含文件数据值包含文件描述）
	 *
	 * @author LiuGangQiang Create in 2020/01/27
	 * @param md5 文件MD5编码
	 * @return {@link GridFSFile} 对象
	 */
	public GridFSFile queryByMD5(String md5) {
		Query query = Query.query(Criteria.where("md5").is(md5));
		GridFSFile gridFSFile = gridFsTemplate.findOne(query);
		return gridFSFile;
	}

	/**
	 * 通过文件ID删除文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param objectId 文件ID
	 * @return {@link Boolean}
	 */
	public Boolean remove(String objectId) {
		Query query = Query.query(Criteria.where("_id").is(objectId));
		gridFsTemplate.delete(query);
		GridFSFile gridFSFile = gridFsTemplate.findOne(query);
		if (gridFSFile != null) {
			return false;
		}
		return true;
	}
}
