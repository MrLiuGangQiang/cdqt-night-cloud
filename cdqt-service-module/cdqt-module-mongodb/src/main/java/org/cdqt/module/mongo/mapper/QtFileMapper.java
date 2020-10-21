package org.cdqt.module.mongo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cdqt.module.mongo.entity.QtFile;
import org.cdqt.night.core.mapper.IBaseMapper;

/**
 * 系统文件Mapper
 *
 * @author LiuGangQiang Create in 2020/7/09
 */
@Mapper
public interface QtFileMapper extends IBaseMapper<QtFile, String> {

	/**
	 * 通过MD5查询文件
	 *
	 * @author LiuGangQiang Create in 2020/07/28
	 * @param md5 MD5
	 * @return {@link QtFile}
	 */
	QtFile queryByMD5(String md5);

	/**
	 * 通过ID查询文件
	 *
	 * @author LiuGangQiang Create in 2020/07/28
	 * @param id ID
	 * @return {@link QtFile}
	 */
	QtFile queryByID(String id);

}