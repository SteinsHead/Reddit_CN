package com.example.RedditCn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.UserSection;
import com.example.RedditCn.repository.UserSectionRepository;

@Service
public class UserSectionService {
	@Autowired
	private UserSectionRepository userSectionRepository;

	public void insertUserSection(int uId, int sId, int suId) {
		if (userSectionRepository.findByUidAndSid(uId, sId) == null) {
			try {
				userSectionRepository.save(new UserSection(uId, sId, suId));
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(ErrorJsonObject.insertUserSectionFailed());
			}
		} else {
			throw new RuntimeException(ErrorJsonObject.UserSectionExist());
		}
	}

	public UserSection findUserSectionBuuIdAndsId(int uId, int sId) {
		UserSection userSection;
		try {
			userSection = userSectionRepository.findByUidAndSid(uId, sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findUserSectionByuIdAndsIdFailed());
		}
		if (userSection == null)
			throw new RuntimeException(ErrorJsonObject.sectionUserNotExist());
		return userSectionRepository.findByUidAndSid(uId, sId);
	}
}
