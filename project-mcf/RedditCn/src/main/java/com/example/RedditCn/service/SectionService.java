package com.example.RedditCn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.Section;
import com.example.RedditCn.repository.SectionRepository;

@Service
public class SectionService {
	@Autowired
	private SectionRepository sectionRepository;

	public List<Section> findAll() {
		try {
			return sectionRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findAllSectionFailed());
		}
	}

	public Section findBysId(int sId) {
		Section section;
		try {
			section = sectionRepository.findBySid(sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionBysIdFailed());
		}
		return section;
	}

	public Section findBysName(String sName) {
		Section section;
		try {
			section = sectionRepository.findBySname(sName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionBysNameFailed());
		}
		return section;
	}

	public Section insertSection(String sName, String sIntroduce, int uId, String sPhoto) {
		if (sectionRepository.findBySname(sName) == null) {
			try {
				if (sPhoto.equals(""))
					sPhoto = null;
				Section section = new Section(sName, sIntroduce, uId, sPhoto, 1);
				sectionRepository.saveAndFlush(section);
				return section;
			} catch (Exception e) {
				throw new RuntimeException(ErrorJsonObject.insertSectionFailed());
			}
		} else {
			throw new RuntimeException(ErrorJsonObject.sectionNameExist());
		}
	}

	public boolean updateSectionFollow(int sId) {
		try {
			sectionRepository.updateSectionFollow(sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateSectionFollowFailed());
		}
		return true;
	}

	public boolean updateSectionPublish(int sId) {
		try {
			sectionRepository.updateSectionPublish(sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateSectionPublishFailed());
		}
		return true;
	}
}
