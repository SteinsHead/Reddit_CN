package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;

import com.example.RedditCn.entity.PostFloor;
import com.example.RedditCn.entity.Section;
import com.example.RedditCn.entity.SectionPost;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostFloorListBO implements Comparable<PostFloorListBO> {
	@JsonProperty("sectionId")
	private int sId;
	@JsonProperty("sectionName")
	private String sName;
	@JsonProperty("sectionPostId")
	private int spId;
	@JsonProperty("sectionPostName")
	private String spName;
	@JsonProperty("postFloorId")
	private int pfId;
	@JsonProperty("postFloorIntroduce")
	private String pfIntroduce;
	@JsonProperty("postFloorTime")
	private String pfTime;
	@JsonProperty("postFloorReply")
	private int pfReply;
	@JsonProperty("postFloorPhoto")
	private String pfPhoto;

	protected PostFloorListBO() {

	}

	public PostFloorListBO(Section section, SectionPost sectionPost, PostFloor postFloor) {
		this.setsId(section.getSid());
		this.setsName(section.getSname());
		this.setSpId(sectionPost.getSpId());
		this.setSpName(sectionPost.getSpName());
		this.setPfId(postFloor.getPfId());
		this.setPfIntroduce(postFloor.getPfIntroduce());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setPfTime(sdf.format(postFloor.getPfTime()));
		this.setPfReply(postFloor.getPfReply());
		this.setPfPhoto(postFloor.getPfPhoto());
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public int getPfId() {
		return pfId;
	}

	public void setPfId(int pfId) {
		this.pfId = pfId;
	}

	public String getPfIntroduce() {
		return pfIntroduce;
	}

	public void setPfIntroduce(String pfIntroduce) {
		this.pfIntroduce = pfIntroduce;
	}

	public String getPfTime() {
		return pfTime;
	}

	public void setPfTime(String pfTime) {
		this.pfTime = pfTime;
	}

	public int getPfReply() {
		return pfReply;
	}

	public void setPfReply(int pfReply) {
		this.pfReply = pfReply;
	}

	public String getPfPhoto() {
		return pfPhoto;
	}

	public void setPfPhoto(String pfPhoto) {
		this.pfPhoto = pfPhoto;
	}

	@Override
	public int compareTo(PostFloorListBO o) {
		// TODO Auto-generated method stub
		return -this.getPfTime().compareTo(o.getPfTime());
	}
}
