package com.example.RedditCn.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.SectionUserPost;

@Repository
public interface SectionUserPostMapper {
	public void createTable(String tableName);

	public List<SectionUserPost> findBysuId(String tableName, int suId);

	public void insertSectionUserPost(String tableName, int suId, int spId);
}
