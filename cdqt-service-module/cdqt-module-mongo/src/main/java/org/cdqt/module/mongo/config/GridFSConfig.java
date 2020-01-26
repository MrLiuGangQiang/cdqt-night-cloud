package org.cdqt.module.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

/**
 * GridConfig
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
@Configuration
public class GridFSConfig {

	@Value("${spring.data.mongodb.bucket}")
	private String bucketName;

	@Bean
	public GridFsTemplate gridFsTemplate(MongoDbFactory dbFactory, MongoConverter converter) {
		return new GridFsTemplate(dbFactory, converter, bucketName);
	}

	@Bean
	public GridFSBucket getGridFSBuckets(MongoDbFactory dbFactory) {
		MongoDatabase db = dbFactory.getDb();
		return GridFSBuckets.create(db, bucketName);
	}
}
