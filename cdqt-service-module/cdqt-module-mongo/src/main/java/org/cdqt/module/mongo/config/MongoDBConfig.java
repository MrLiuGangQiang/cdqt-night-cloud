package org.cdqt.module.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

/**
 * MongoDBConfig
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
@Configuration
public class MongoDBConfig {

	/**
	 * bucketName
	 *
	 * @author LiuGangQiang Create in 2020/02/01
	 */
	@Value("${spring.data.mongodb.bucket}")
	private String bucketName;

	/**
	 * mongoTemplate
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param dbFactory
	 * @return {@link MongoTemplate}
	 */
	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory dbFactory) {
		return new MongoTemplate(dbFactory);
	}

	/**
	 * gridFsTemplate
	 *
	 * @author LiuGangQiang Create in 2020/02/01
	 * @param dbFactory
	 * @param converter
	 * @return {@link GridFsTemplate}
	 */
	@Bean
	public GridFsTemplate gridFsTemplate(MongoDbFactory dbFactory, MongoConverter converter) {
		return new GridFsTemplate(dbFactory, converter, bucketName);
	}

	/**
	 * getGridFSBuckets
	 *
	 * @author LiuGangQiang Create in 2020/02/01
	 * @param dbFactory
	 * @return {@link GridFSBucket}
	 */
	@Bean
	public GridFSBucket getGridFSBuckets(MongoDbFactory dbFactory) {
		MongoDatabase db = dbFactory.getDb();
		return GridFSBuckets.create(db, bucketName);
	}
}
