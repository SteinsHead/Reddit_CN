package com.example.RedditCn.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.SectionPost;

@Repository
public interface SectionPostMapper {
	public List<SectionPost> findAll(String tableName);

	public SectionPost findByspId(String tableName, int spId);

	public void createTable(String tableName);

	public void insertSectionPost(SectionPost sectionPost);
}
