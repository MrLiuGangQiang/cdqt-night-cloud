package org.cdqt.module.mongo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.cdqt.module.mongo.entity.QtFile;
import org.cdqt.module.mongo.service.QtFileService;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.tools.code.UUIDUtil;
import org.cdqt.night.tools.file.IOUtil;
import org.cdqt.night.tools.md5.MD5Util;
import org.cdqt.night.tools.valid.IntegerUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 目录文件服务
 *
 * @author LiuGangQiang Create in 2020/07/28
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {
	/**
	 * 目录路径
	 *
	 * @author LiuGangQiang Create in 2020/07/28
	 */
	private static final String PATH = System.getProperty("user.dir") + File.separator + "upload";
	/**
	 * 文件服务
	 *
	 * @author LiuGangQiang Create in 2020/10/21
	 */
	@Resource
	private QtFileService qtFileService;

	/**
	 * 上传单个文件
	 *
	 * @author LiuGangQiang Create in 2020/01/24
	 * @param multipartFile 文件
	 * @return {@link ResultApi}
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("/upload")
	@Transactional
	public ResultApi<?> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		/* 获得提交的文件名 */
		String fileName = multipartFile.getOriginalFilename();
		/* 获取文件后缀 */
		String suffix = fileName.substring(fileName.lastIndexOf('.') + 1);
		/* 获取文件类型 */
		String contentType = multipartFile.getContentType();
		/* 获取文件MD5编码 */
		String md5 = MD5Util.getInstance().encryptBytes(multipartFile.getBytes());
		/* 根据MD5校验文件是否存在 */
		QtFile temp = qtFileService.queryByMD5(md5);
		if (temp != null) {
			return new ResultApi<>(ApiStatus.OK, temp);
		}
		/* 生成唯一的文件ID */
		String fileId = UUIDUtil.uuid();
		File file = new File(PATH + File.separator + fileId + "." + suffix);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		/* 将文件存储到目录中,将会返回这个文件的具体信息 */
		QtFile QtFile = new QtFile();
		QtFile.setFileSize(multipartFile.getSize());
		QtFile.setFileId(fileId);
		QtFile.setFileName(fileName.substring(0, fileName.lastIndexOf(".")));
		QtFile.setContentType(contentType);
		QtFile.setMd5(md5);
		QtFile.setFullName(fileName);
		QtFile.setFileSuffix(suffix);
		Integer rows = qtFileService.insert(QtFile);
		if (IntegerUtils.isLeZero(rows)) {
			return new ResultApi<>(ApiStatus.FAIL);
		}
		multipartFile.transferTo(file);
		return new ResultApi<>(ApiStatus.OK, QtFile);
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
		QtFile temp = qtFileService.queryByID(id);
		if (temp != null) {
			File file = new File(PATH + File.separator + temp.getFileId() + "." + temp.getFileSuffix());
			if (file.exists()) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDispositionFormData("attachment", URLEncoder.encode(temp.getFullName().replaceAll(" ", ""), "UTF-8"));
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentLength(file.length());
				headers.setConnection("close");
				return new ResponseEntity<byte[]>(IOUtil.toByteArray(new FileInputStream(file)), headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
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
		QtFile temp = qtFileService.queryByID(id);
		if (temp != null) {
			File file = new File(PATH + File.separator + temp.getFileId() + "." + temp.getFileSuffix());
			if (file.exists()) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDisposition(ContentDisposition.builder("inline").build());
				headers.setContentType(MediaType.parseMediaType(temp.getContentType()));
				headers.setContentLength(file.length());
				headers.setConnection("close");
				return new ResponseEntity<byte[]>(IOUtil.toByteArray(new FileInputStream(file)), headers, HttpStatus.OK);
			} else {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);

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
		QtFile temp = qtFileService.queryByID(id);
		if (temp != null) {
			File file = new File(PATH + File.separator + temp.getFileId() + "." + temp.getFileSuffix());
			if (file.exists()) {
				file.delete();
			}
			Integer rows = qtFileService.deleteByPrimaryKey(id);
			if (IntegerUtils.isLeZero(rows)) {
				return new ResultApi<>(ApiStatus.FAIL);
			}
		}
		return new ResultApi<>(ApiStatus.OK);
	}
}