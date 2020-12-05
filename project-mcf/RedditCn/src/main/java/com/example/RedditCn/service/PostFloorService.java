package com.example.RedditCn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.PostFloor;
import com.example.RedditCn.mapper.PostFloorMapper;

@Service
public class PostFloorService {
	@Autowired
	private PostFloorMapper postFloorMapper;
	String tableName1 = "SectionPost_";
	String tableName2 = "_PostFloor_";

	public void createPostFloorTable(int sId, int spId) {
		try {
			postFloorMapper.createTable(tableName1 + sId + tableName2 + spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.createPostFloorTableFailed());
		}
	}

	public List<PostFloor> findAllPostFloor(int sId, int spId) {
		List<PostFloor> list;
		try {
			list = postFloorMapper.findAll(tableName1 + sId + tableName2 + spId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findAllPostFloorFailed());
		}
		return list;
	}

	public PostFloor findPostFloorBypfId(int sId, int spId, int pfId) {
		PostFloor postFloor;
		try {
			postFloor = postFloorMapper.findByPfId(tableName1 + sId + tableName2 + spId, pfId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findPostFloorBypfIdFailed());
		}
		if (postFloor == null)
			throw new RuntimeException(ErrorJsonObject.postFloorNotExist());
		return postFloor;
	}

	public int insertPostFloor(int sId, int spId, int suId, String pfIntroduce, String pfPhoto) {
		try {
			if (pfPhoto.equals(""))
				pfPhoto = null;
			PostFloor postFloor = new PostFloor(tableName1 + sId + tableName2 + spId, suId, pfIntroduce, pfPhoto);
			postFloorMapper.insertPostFloor(postFloor);
			return postFloor.getPfId();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.insertPostFloorFailed());
		}
	}

	public void updatePostFloorReply(int sId, int spId, int pfId) {
		try {
			postFloorMapper.updatePfReply(tableName1 + sId + tableName2 + spId, pfId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updatePostFloorReplyFailed());
		}
	}

	public boolean updatePostFloorban(int sId, int spId, int pfId, String spBan) {
		try {
			postFloorMapper.updatePfBan(tableName1 + sId + tableName2 + spId, spBan, pfId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updatePostFloorBanFailed());
		}
		return true;
	}
}
