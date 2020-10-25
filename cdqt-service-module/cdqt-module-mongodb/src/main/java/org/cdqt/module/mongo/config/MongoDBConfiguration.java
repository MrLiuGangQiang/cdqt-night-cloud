package org.cdqt.module.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

/**
 * 配置MongoDB
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
@Configuration
public class MongoDBConfiguration {

	/**
	 * 存储桶的名字
	 *
	 * @author LiuGangQiang Create in 2020/02/01
	 */
	@Value("${spring.data.mongodb.bucket}")
	private String bucketName;

	/**
	 * 配置 {@link MongoTemplate}
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param dbFactory MongoDatabaseFactory
	 * @return {@link MongoTemplate}
	 */
	@Bean
	public MongoTemplate mongoTemplate(MongoDatabaseFactory dbFactory) {
		return new MongoTemplate(dbFactory);
	}

	/**
	 * 配置 {@link GridFsTemplate}
	 *
	 * @author LiuGangQiang Create in 2020/02/01
	 * @param dbFactory MongoDatabaseFactory
	 * @param converter MongoConverter
	 * @return {@link GridFsTemplate}
	 */
	@Bean
	public GridFsTemplate gridFsTemplate(MongoDatabaseFactory dbFactory, MongoConverter converter) {
		return new GridFsTemplate(dbFactory, converter, bucketName);
	}

	/**
	 * 配置 {@link GridFSBucket}
	 *
	 * @author LiuGangQiang Create in 2020/02/01
	 * @param dbFactory
	 * @return {@link GridFSBucket}
	 */
	@Bean
	public GridFSBucket gridFSBuckets(MongoDatabaseFactory dbFactory) {
		MongoDatabase db = dbFactory.getMongoDatabase();
		return GridFSBuckets.create(db, bucketName);
	}
}
