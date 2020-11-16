package com.example.RedditCn.mapper;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.SectionPost;

@Repository
public interface SectionPostMapper {
	SectionPost Sel(int spId);

	void createTable(String tableName);
}
