package com.example.RedditCn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.SectionPost;
import com.example.RedditCn.mapper.SectionPostMapper;

@Service
public class SectionPostService {
	@Autowired
	private SectionPostMapper sectionPostMapper;
	private String tableName = "sectionpost_";

	public List<SectionPost> findAll(int sId) {
		List<SectionPost> list;
		try {
			list = sectionPostMapper.findAll(tableName + sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findAllSectionPostFailed());
		}
		return list;
	}

	public SectionPost findSectionPostByspId(int sId, int spId) {
		SectionPost sectionPost;
		try {
			sectionPost = sectionPostMapper.findByspId(tableName + sId, spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionPostByspIdFailed());
		}
		if (sectionPost == null)
			throw new RuntimeException(ErrorJsonObject.sectionPostNotExist());
		return sectionPost;
	}

	public void createSectionPostTable(int sId) {
		try {
			sectionPostMapper.createTable(tableName + sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.createSectionPostTableFailed());
		}
	}

	public int insertSectionPost(int sId, int suId, String spName, String spPhoto) {
		try {
			if (spPhoto.equals(""))
				spPhoto = null;
			SectionPost sectionPost = new SectionPost(tableName + sId, suId, spName, spPhoto);
			sectionPostMapper.insertSectionPost(sectionPost);
			return sectionPost.getSpId();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.insertSectionPostFailed());
		}
	}

	public boolean updateSectionPostFloor(int sId, int spId) {
		try {
			sectionPostMapper.updateSpFloor(tableName + sId, spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateSectionPostFloorFailed());
		}
		return true;
	}

	public boolean updateSectionPostBan(int sId, String spBan, int spId) {
		try {
			sectionPostMapper.updateSpBan(tableName + sId, spBan, spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateSectionPostBanFailed());
		}
		return true;
	}
}
