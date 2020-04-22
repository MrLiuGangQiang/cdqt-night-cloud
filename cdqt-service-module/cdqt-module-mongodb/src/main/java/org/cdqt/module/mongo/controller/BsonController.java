package org.cdqt.module.mongo.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;

import org.cdqt.module.mongo.entity.Bson;
import org.cdqt.module.mongo.service.BsonService;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.tools.md5.MD5Util;
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

/**
 * Bson类型控制器
 *
 * @author LiuGangQiang Create in 2020/02/03
 */
@RestController
@RequestMapping("/bson")
public class BsonController {
	/**
	 * {@link BsonService} 实例
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 */
	@Resource
	private BsonService bsonService;

	/**
	 * 上传文件
	 *
	 * @author LiuGangQiang Create in 2020/02/03
	 * @param multipartFile 文件
	 * @return {@link ResultApi}
	 * @throws IOException
	 */
	@PostMapping("/upload")
	public ResultApi<?> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		/* 获得提交的文件名 */
		String fileName = multipartFile.getOriginalFilename();
		/* 获取文件类型 */
		String contentType = multipartFile.getContentType();
		/* 获取文件内容 */
		byte[] content = multipartFile.getBytes();
		/* 获取文件MD5编码 */
		String md5 = MD5Util.getInstance().encryptBytes(content);
		/* 根据MD5校验文件是否存在 */
		Bson bson = bsonService.getBsonByMd5(md5);
		if (bson != null) {
			return new ResultApi<>(ApiStatus.OK, bson.getId());
		}
		bson = new Bson(fileName, contentType, content.length, md5, content);
		/* 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息 */
		Bson result = bsonService.insert(bson);
		if (result != null) {
			return new ResultApi<>(ApiStatus.OK, result.getId());
		}
		return new ResultApi<>(ApiStatus.FAIL);
	}

	/**
	 * 下载文件
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id 文件ID
	 * @return {@link ResponseEntity}
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable String id) throws IllegalStateException, IOException {
		Bson bson = bsonService.download(id);
		if (bson != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDispositionFormData("attachment", URLEncoder.encode(bson.getName().replaceAll(" ", ""), "UTF-8"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			byte[] content = bson.getContent();
			headers.setContentLength(content.length);
			headers.setConnection("close");
			return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 预览文件
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id 文件ID
	 * @return {@link ResponseEntity}
	 * @throws IOException
	 */
	@GetMapping("/view/{id}")
	public ResponseEntity<byte[]> view(@PathVariable String id) throws IOException {
		Bson bson = bsonService.download(id);
		if (bson != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("inline").build());
			headers.setContentType(MediaType.parseMediaType(bson.getContentType()));
			byte[] content = bson.getContent();
			headers.setContentLength(content.length);
			headers.setConnection("close");
			return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 删除文件
	 *
	 * @author LiuGangQiang Create in 2020/02/05
	 * @param id 文件ID
	 * @return {@link ResultApi}
	 */
	@DeleteMapping("/delete/{id}")
	public ResultApi<?> delete(@PathVariable String id) {
		if (bsonService.remove(id)) {
			return new ResultApi<>(ApiStatus.OK);
		}
		return new ResultApi<>(ApiStatus.FAIL);
	}
}
