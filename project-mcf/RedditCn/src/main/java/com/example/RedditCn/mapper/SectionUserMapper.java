package com.example.RedditCn.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.SectionUser;

@Repository
public interface SectionUserMapper {
	public void createTable(String tableName);

	public SectionUser findByuId(String tableName, int uId);

	public SectionUser findBysuId(String tableName, int suId);

	public List<SectionUser> findBan(String tableName);

	public void insertSectionUser(SectionUser sectionUser);

	public void updateSuRank(String tableName, int suRank, int suId);

	public void updateSuBan(String tableName, String suBan, int suId);
}
