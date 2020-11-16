package com.example.RedditCn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.SectionPost;
import com.example.RedditCn.mapper.SectionPostMapper;

@Service
public class SectionPostService {
	@Autowired
	SectionPostMapper sectionPostMapper;

	public SectionPost Sel(int spId) {
		return sectionPostMapper.Sel(spId);
	}

	public void createSectionTanle(String tableName) {
		sectionPostMapper.createTable(tableName);
	}
}
