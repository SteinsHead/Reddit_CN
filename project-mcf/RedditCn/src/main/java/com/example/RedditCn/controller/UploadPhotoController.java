package com.example.RedditCn.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UploadPhotoService;

@RestController
public class UploadPhotoController {
	@Autowired
	private UploadPhotoService uploadPhotoService;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	@UserLoginToken
	@PostMapping("/uploadPhoto")
	public String uploadPhoto(@RequestHeader(value = "token") String token,
			@RequestParam(value = "file") MultipartFile file) {
		System.out.println(df.format(new java.util.Date()) + " 用户-" + TokenUtils.verify(token) + "-上传图片");
		return uploadPhotoService.upload(uploadPhotoService.multipartFileToFile(file));
	}
}
