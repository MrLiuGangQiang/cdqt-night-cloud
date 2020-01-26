package org.cdqt.module.mongo.dao;

import org.cdqt.module.mongo.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * BosnRepository
 *
 * @author LiuGangQiang Create in 2020/01/25
 */
@Repository
public interface BosnRepository extends MongoRepository<File, String> {

}
