package com.example.RedditCn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.PostReply;
import com.example.RedditCn.mapper.PostReplyMapper;

@Service
public class PostReplyService {
	@Autowired
	private PostReplyMapper postReplyMapper;
	private String tableName1 = "sectionpost_";
	private String tableName2 = "_postreply_";

	public List<PostReply> findPostReplyBypfId(int sId, int spId, int pfId) {
		List<PostReply> list;
		try {
			list = postReplyMapper.findBypfId(tableName1 + sId + tableName2 + spId, pfId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findPostReplyBypfIdFailed());
		}
		return list;
	}

	public PostReply findPostReplyByprId(int sId, int spId, int prId) {
		PostReply postReply;
		try {
			postReply = postReplyMapper.findByprId(tableName1 + sId + tableName2 + spId, prId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findPostReplyByprIdFailed());
		}
		if (postReply == null)
			throw new RuntimeException(ErrorJsonObject.postReplyNotExist());
		return postReply;
	}

	public void createPostReplyTable(int sId, int spId) {
		try {
			postReplyMapper.createTable(tableName1 + sId + tableName2 + spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.createPostReplyTableFailed());
		}
	}

	public int insertPostReply(int sId, int spId, int suId, int pfId, String pfIntroduce) {
		try {
			PostReply postReply = new PostReply(tableName1 + sId + tableName2 + spId, suId, pfId, pfIntroduce);
			postReplyMapper.insertPostReply(postReply);
			return postReply.getPrId();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.insertPostReplyFailed());
		}
	}

	public boolean updatePostReplyBan(int sId, int spId, int prId, String prBan) {
		try {
			postReplyMapper.updatePrBan(tableName1 + sId + tableName2 + spId, prBan, prId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updatePostReplyBanFailed());
		}
		return true;
	}
}
