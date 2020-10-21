package org.cdqt.module.mongo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.cdqt.module.mongo.service.GridFSService;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.tools.file.IOUtil;
import org.cdqt.night.tools.md5.MD5Util;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;

/**
 * GridFS类型控制器
 *
 * @author LiuGangQiang Create in 2020/02/01
 */
@RestController
@RequestMapping("/gridfs")
public class GridFSController {
	@Resource
	private GridFSService gridFSService;

	/**
	 * 上传单个文件
	 *
	 * @author LiuGangQiang Create in 2020/01/24
	 * @param file 文件
	 * @return {@link ResultApi}
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("/upload")
	public ResultApi<?> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException {
		/* 获得提交的文件名 */
		String fileName = multipartFile.getOriginalFilename();
		/* 获得文件输入流 */
		InputStream ins = multipartFile.getInputStream();
		/* 获取文件类型 */
		String contentType = multipartFile.getContentType();
		/* 获取文件MD5编码 */
		String md5 = MD5Util.getInstance().encryptBytes(multipartFile.getBytes());
		/* 根据MD5校验文件是否存在 */
		GridFSFile gridFSFile = gridFSService.queryByMD5(md5);
		if (gridFSFile != null) {
			return new ResultApi<>(ApiStatus.OK, gridFSFile.getObjectId().toHexString());
		}
		/* 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息 */
		ObjectId objectId = gridFSService.upload(fileName, ins, contentType);
		if (objectId != null) {
			return new ResultApi<>(ApiStatus.OK, objectId.toHexString());
		}
		return new ResultApi<>(ApiStatus.FAIL);
	}

	/**
	 * 下载单个文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param id 文件ID
	 * @return {@link ResponseEntity}
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable String id) throws IllegalStateException, IOException {
		GridFsResource gridFsResource = gridFSService.download(id);
		if (gridFsResource != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDispositionFormData("attachment", URLEncoder.encode(gridFsResource.getFilename().replaceAll(" ", ""), "UTF-8"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentLength(gridFsResource.contentLength());
			headers.setConnection("close");
			return new ResponseEntity<byte[]>(IOUtil.toByteArray(gridFsResource.getInputStream()), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 预览文件 主要是图片资源
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param id 文件ID
	 * @return {@link ResponseEntity}
	 * @throws IOException
	 */
	@GetMapping("/view/{id}")
	public ResponseEntity<byte[]> view(@PathVariable String id) throws IOException {
		GridFsResource gridFsResource = gridFSService.download(id);
		if (gridFsResource != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("inline").build());
			headers.setContentType(MediaType.parseMediaType(gridFsResource.getContentType()));
			headers.setContentLength(gridFsResource.contentLength());
			headers.setConnection("close");
			return new ResponseEntity<byte[]>(IOUtil.toByteArray(gridFsResource.getInputStream()), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 删除文件
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param id 文件ID
	 * @return {@link ResultApi}
	 */
	@DeleteMapping("/delete/{id}")
	public ResultApi<?> delete(@PathVariable String id) {
		if (gridFSService.remove(id)) {
			return new ResultApi<>(ApiStatus.OK);
		}
		return new ResultApi<>(ApiStatus.FAIL);
	}

}