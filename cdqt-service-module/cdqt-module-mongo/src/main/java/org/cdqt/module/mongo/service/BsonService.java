package org.cdqt.module.mongo.service;

import javax.annotation.Resource;

import org.cdqt.module.mongo.entity.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;

/**
 * BsonService
 *
 * @author LiuGangQiang Create in 2020/02/03
 */
@Service
public class BsonService {
	/**
	 * mongoTemplate
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 */
	@Resource
	private MongoTemplate mongoTemplate;
	/**
	 * collectionName 集合名
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 */
	private static final String collectionName = "bson";

	/**
	 * getBsonByMd5
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param md5
	 * @return {@link Bson}
	 */
	public Bson getBsonByMd5(String md5) {
		Query query = new Query(Criteria.where("md5").is(md5));
		return mongoTemplate.findOne(query, Bson.class);
	}

	/**
	 * insert
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param bson
	 * @return {@link Bson}
	 */
	public Bson insert(Bson bson) {
		return mongoTemplate.insert(bson, collectionName);
	}

	/**
	 * download
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id
	 * @return {@link Bson}
	 */
	public Bson download(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, Bson.class);
	}

	/**
	 * remove
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id
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
