package com.example.RedditCn.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

@Service
public class UploadPhotoService {
	private static final String secretId = "AKIDpVjkYPHqYhhvsYtR4aSCZxMiyDGZqQyL";
	private static final String secretKey = "GXHmlTv470RcryoRovYvSlrqrdBgpkoo";
	private static final String region = "ap-beijing";
	private static final String bucket = "redditcn-1301983393";

	public String upload(File file) {
		int index = file.getName().lastIndexOf(".");
		// 上传到桶里的文件名
		String key = getKey() + file.getName().substring(index);

		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(region));
		COSClient cosClient = new COSClient(cred, clientConfig);

		PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, file);
		cosClient.putObject(putObjectRequest);
		cosClient.shutdown();

		return key;
	}

	public String getKey() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public File multipartFileToFile(MultipartFile file) {

		File toFile = null;
		try {
			if (file.equals("") || file.getSize() <= 0) {
				file = null;
			} else {
				InputStream ins = null;
				ins = file.getInputStream();
				toFile = new File(file.getOriginalFilename());
				inputStreamToFile(ins, toFile);
				ins.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.toFileFailed());
		}

		return toFile;
	}

	// 获取流文件
	private void inputStreamToFile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
