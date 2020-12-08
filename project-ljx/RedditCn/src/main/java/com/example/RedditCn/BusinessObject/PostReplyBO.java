package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.RedditCn.entity.PostReply;

public class PostReplyBO {
	private int postReplyId;
	private int postFloorId;
	private String postReplyIntroduce;
	private String postReplyTime;
	private UserBO user;

	public PostReplyBO() {

	}

	public PostReplyBO(PostReply postReply, UserBO userBO) {
		this.setPostReplyId(postReply.getPrId());
		this.setPostFloorId(postReply.getPfId());
		this.setPostReplyIntroduce(postReply.getPrIntroduce());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setPostReplyTime(sdf.format(postReply.getPrTime()));
		this.setUser(userBO);
	}

	public List<PostReplyBO> ListPostReplyBO(List<PostReply> list1, List<UserBO> list2) {
		List<PostReplyBO> l = new ArrayList<PostReplyBO>();
		for (int i = 0; i < list1.size(); i++) {
			l.add(new PostReplyBO(list1.get(i), list2.get(i)));
		}
		return l;
	}

	public int getPostReplyId() {
		return postReplyId;
	}

	public void setPostReplyId(int postReplyId) {
		this.postReplyId = postReplyId;
	}

	public int getPostFloorId() {
		return postFloorId;
	}

	public void setPostFloorId(int postFloorId) {
		this.postFloorId = postFloorId;
	}

	public String getPostReplyIntroduce() {
		return postReplyIntroduce;
	}

	public void setPostReplyIntroduce(String postReplyIntroduce) {
		this.postReplyIntroduce = postReplyIntroduce;
	}

	public String getPostReplyTime() {
		return postReplyTime;
	}

	public void setPostReplyTime(String postReplyTime) {
		this.postReplyTime = postReplyTime;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}
}
