package com.example.RedditCn.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.PostReply;

@Repository
public interface PostReplyMapper {
	public List<PostReply> findBypfId(String tableName, int pfId);

	public void createTable(String tableName);

	public void insertPostReply(PostReply postReply);

	public PostReply findByprId(String tableName, int prId);
}
