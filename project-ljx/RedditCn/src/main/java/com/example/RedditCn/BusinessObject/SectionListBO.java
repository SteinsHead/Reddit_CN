package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;

import com.example.RedditCn.entity.Section;
import com.example.RedditCn.entity.SectionUser;

public class SectionListBO {
	private int sectionId;
	private String sectionName;
	private String sectionIntroduce;
	private String sectionTime;
	private int sectionFollow;
	private int sectionPublish;
	private int sectionVisit;
	private String sectionPhoto;
	private SectionUserBO sectionUser;

	public SectionListBO() {

	}

	public SectionListBO(Section section, SectionUser sectionUser) {
		this.setSectionId(section.getSid());
		this.setSectionName(section.getSname());
		this.setSectionIntroduce(section.getsIntroduce());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setSectionTime(sdf.format(section.getStime()));
		this.setSectionFollow(section.getSfollow());
		this.setSectionPublish(section.getSpublish());
		this.setSectionVisit(section.getSvisit());
		this.setSectionPhoto(section.getSphoto());
		this.setSectionUser(new SectionUserBO(sectionUser));
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionIntroduce() {
		return sectionIntroduce;
	}

	public void setSectionIntroduce(String sectionIntroduce) {
		this.sectionIntroduce = sectionIntroduce;
	}

	public String getSectionTime() {
		return sectionTime;
	}

	public void setSectionTime(String sectionTime) {
		this.sectionTime = sectionTime;
	}

	public int getSectionFollow() {
		return sectionFollow;
	}

	public void setSectionFollow(int sectionFollow) {
		this.sectionFollow = sectionFollow;
	}

	public int getSectionPublish() {
		return sectionPublish;
	}

	public void setSectionPublish(int sectionPublish) {
		this.sectionPublish = sectionPublish;
	}

	public int getSectionVisit() {
		return sectionVisit;
	}

	public void setSectionVisit(int sectionVisit) {
		this.sectionVisit = sectionVisit;
	}

	public String getSectionPhoto() {
		return sectionPhoto;
	}

	public void setSectionPhoto(String sectionPhoto) {
		this.sectionPhoto = sectionPhoto;
	}

	public SectionUserBO getSectionUser() {
		return sectionUser;
	}

	public void setSectionUser(SectionUserBO sectionUser) {
		this.sectionUser = sectionUser;
	}
}
