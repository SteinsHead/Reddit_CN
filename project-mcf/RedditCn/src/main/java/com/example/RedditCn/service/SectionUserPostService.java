package com.example.RedditCn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.SectionUserPost;
import com.example.RedditCn.mapper.SectionUserPostMapper;

@Service
public class SectionUserPostService {
	@Autowired
	private SectionUserPostMapper sectionUserPostMapper;
	private String tableName = "sectionuser_post_";

	public void createSectionUserPostTable(int sId) {
		try {
			sectionUserPostMapper.createTable(tableName + sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.createSectionUserPostTableFailed());
		}
	}

	public void insertSectionUserPost(int sId, int suId, int spId) {
		try {
			sectionUserPostMapper.insertSectionUserPost(tableName + sId, suId, spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.insertSectionUserPostFailed());
		}
	}

	public List<SectionUserPost> findSectionUserPostBysuId(int sId, int suId) {
		List<SectionUserPost> list;
		try {
			list = sectionUserPostMapper.findBysuId(tableName + sId, suId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionUserPostBysuIdFailed());
		}
		return list;
	}
}
