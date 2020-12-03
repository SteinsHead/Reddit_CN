package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.RedditCn.entity.PostFloor;

public class PostFloorBO {
	private int postFloorId;
	private String postFloorIntroduce;
	private String postFloorTime;
	private int postFloorReply;
	private String postFloorPhoto;
	private UserBO user;

	public PostFloorBO() {

	}

	public PostFloorBO(PostFloor postFloor, UserBO userBO) {
		this.setPostFloorId(postFloor.getPfId());
		this.setPostFloorIntroduce(postFloor.getPfIntroduce());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setPostFloorTime(sdf.format(postFloor.getPfTime()));
		this.setPostFloorReply(postFloor.getPfReply());
		this.setPostFloorPhoto(postFloor.getPfPhoto());
		this.setUser(userBO);
	}

	public List<PostFloorBO> ListPostFloorBO(List<PostFloor> list1, List<UserBO> list2) {
		List<PostFloorBO> l = new ArrayList<PostFloorBO>();
		for (int i = 0; i < list1.size(); i++) {
			l.add(new PostFloorBO(list1.get(i), list2.get(i)));
		}
		return l;
	}

	public int getPostFloorId() {
		return postFloorId;
	}

	public void setPostFloorId(int postFloorId) {
		this.postFloorId = postFloorId;
	}

	public String getPostFloorIntroduce() {
		return postFloorIntroduce;
	}

	public void setPostFloorIntroduce(String postFloorIntroduce) {
		this.postFloorIntroduce = postFloorIntroduce;
	}

	public String getPostFloorTime() {
		return postFloorTime;
	}

	public void setPostFloorTime(String postFloorTime) {
		this.postFloorTime = postFloorTime;
	}

	public int getPostFloorReply() {
		return postFloorReply;
	}

	public void setPostFloorReply(int postFloorReply) {
		this.postFloorReply = postFloorReply;
	}

	public String getPostFloorPhoto() {
		return postFloorPhoto;
	}

	public void setPostFloorPhoto(String postFloorPhoto) {
		this.postFloorPhoto = postFloorPhoto;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

}
