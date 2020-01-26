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
 * FileService
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
@Service
public class GridFSService {
	@Resource
	private GridFsTemplate gridFsTemplate;
	@Resource
	private GridFSBucket gridFSBucket;

	/**
	 * upload 上传文件 最好不要使用此方法 因为不设置文件类型在预览时会出现异常
	 *
	 * @author LiuGangQiang Create in 2020/01/25
	 * @param fileName 文件名
	 * @param ins      输入流
	 * @return {@link ObjectId}
	 */
	@Deprecated 
	public ObjectId upload(String fileName, InputStream ins) {
		return gridFsTemplate.store(ins, fileName);
	}

	/**
	 * upload 上传文件
	 *
	 * @author LiuGangQiang Create in 2020/01/25
	 * @param fileName    文件名
	 * @param ins         输入流
	 * @param contentType 文件类型
	 * @return {@link ObjectId}
	 */
	public ObjectId upload(String fileName, InputStream ins, String contentType) {
		return gridFsTemplate.store(ins, fileName, contentType);
	}

	/**
	 * download 下载文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param objectId 文件ID
	 * @return GridFsResource
	 */
	public GridFsResource download(String objectId) {
		Query query = Query.query(Criteria.where("_id").is(objectId));
		GridFSFile gridFSFile = gridFsTemplate.findOne(query);
		GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
		GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
		return gridFsResource;
	}

	/**
	 * remove 删除文件
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
