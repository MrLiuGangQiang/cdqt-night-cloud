package org.cdqt.module.mongo.service;

import javax.annotation.Resource;

import org.cdqt.module.mongo.entity.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;

/**
 * Bson服务
 *
 * @author LiuGangQiang Create in 2020/02/03
 */
@Service
public class BsonService {
	/**
	 * {@link MongoTemplate} 实例
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 */
	@Resource
	private MongoTemplate mongoTemplate;
	/**
	 * 集合名 值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 */
	private static final String collectionName = "bson";

	/**
	 * 通过MD5编码获取 {@link Bson} 对象
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param md5 MD5编码
	 * @return {@link Bson}对象
	 */
	public Bson getBsonByMd5(String md5) {
		Query query = new Query(Criteria.where("md5").is(md5));
		return mongoTemplate.findOne(query, Bson.class);
	}

	/**
	 * 新增对象
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param bson {@link Bson} 对象
	 * @return {@link Bson} 对象
	 */
	public Bson insert(Bson bson) {
		return mongoTemplate.insert(bson, collectionName);
	}

	/**
	 * 通过ID下载 {@link Bson} 对象
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id 文件ID
	 * @return {@link Bson} 对象
	 */
	public Bson download(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, Bson.class);
	}

	/**
	 * 移除对象
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id 文件ID
	 * @return {@link Boolean}
	 */
	public boolean remove(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		DeleteResult result = mongoTemplate.remove(query, Bson.class);
		if (result.getDeletedCount() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
