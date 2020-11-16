package com.example.RedditCn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.PostReply;
import com.example.RedditCn.mapper.PostReplyMapper;

@Service
public class PostReplyService {
	@Autowired
	PostReplyMapper postReplyMapper;

	public PostReply Sel(int prId) {
		return postReplyMapper.Sel(prId);
	}
}
