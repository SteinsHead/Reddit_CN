package com.example.RedditCn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.RedditCn.service.UploadPhotoService;

@RestController
public class UploadPhotoController {
	@Autowired
	private UploadPhotoService uploadPhotoService;

	@PostMapping("/uploadPhoto")
	public String uploadPhoto(@RequestParam(value = "file") MultipartFile file) {
		System.out.println("上传图片");
		return uploadPhotoService.upload(uploadPhotoService.multipartFileToFile(file));
	}
}
