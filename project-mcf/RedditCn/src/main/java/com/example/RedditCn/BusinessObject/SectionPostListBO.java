package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;

import com.example.RedditCn.entity.SectionPost;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SectionPostListBO implements Comparable<SectionPostListBO> {
	@JsonProperty("sectionId")
	private int sId;
	@JsonProperty("sectionName")
	private String sName;
	@JsonProperty("sectionPostId")
	private int spId;
	@JsonProperty("sectionPostName")
	private String spName;
	@JsonProperty("sectionPostTime")
	private String spTime;
	@JsonProperty("sectionPostFloor")
	private int spFloor;
	@JsonProperty("sectionPostVisit")
	private int spVisit;
	@JsonProperty("sectionPostPhoto")
	private String spPhoto;

	protected SectionPostListBO() {

	}

	public SectionPostListBO(int sId, String sName, SectionPost sectionPost) {
		this.setsId(sId);
		this.setsName(sName);
		this.setSpId(sectionPost.getSpId());
		this.setSpName(sectionPost.getSpName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setSpTime(sdf.format(sectionPost.getSpTime()));
		this.setSpFloor(sectionPost.getSpFloor());
		this.setSpVisit(sectionPost.getSpVisit());
		this.setSpPhoto(sectionPost.getSpPhoto());
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

	public String getSpTime() {
		return spTime;
	}

	public void setSpTime(String spTime) {
		this.spTime = spTime;
	}

	public int getSpFloor() {
		return spFloor;
	}

	public void setSpFloor(int spFloor) {
		this.spFloor = spFloor;
	}

	public int getSpVisit() {
		return spVisit;
	}

	public void setSpVisit(int spVisit) {
		this.spVisit = spVisit;
	}

	public String getSpPhoto() {
		return spPhoto;
	}

	public void setSpPhoto(String spPhoto) {
		this.spPhoto = spPhoto;
	}

	@Override
	public int compareTo(SectionPostListBO sectionPostListBO) {
		// TODO Auto-generated method stub
		return -this.getSpTime().compareTo(sectionPostListBO.getSpTime());
	}

}
