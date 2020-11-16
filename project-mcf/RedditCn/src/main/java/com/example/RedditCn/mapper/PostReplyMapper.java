package com.example.RedditCn.mapper;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.PostReply;

@Repository
public interface PostReplyMapper {
	PostReply Sel(int prId);
}
