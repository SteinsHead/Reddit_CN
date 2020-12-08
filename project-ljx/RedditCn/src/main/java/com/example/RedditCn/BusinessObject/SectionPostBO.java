package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.RedditCn.entity.SectionPost;

public class SectionPostBO {
	private int sectionPostId;
	private String sectionPostName;
	private String sectionPostTime;
	private int sectionPostFloor;
	private int sectionPostVisit;
	private String sectionPostPhoto;
	private UserBO user;

	public SectionPostBO() {

	}

	public SectionPostBO(SectionPost sectionPost, UserBO user) {
		this.setSectionPostId(sectionPost.getSpId());
		this.setSectionPostName(sectionPost.getSpName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setSectionPostTime(sdf.format(sectionPost.getSpTime()));
		this.setSectionPostFloor(sectionPost.getSpFloor());
		this.setSectionPostVisit(sectionPost.getSpVisit());
		this.setSectionPostPhoto(sectionPost.getSpPhoto());
		this.setUser(user);
	}

	public List<SectionPostBO> listSectionPostBOBO(List<SectionPost> list1, List<UserBO> list2) {
		List<SectionPostBO> l = new ArrayList<SectionPostBO>();
		for (int i = 0; i < list1.size(); i++) {
			l.add(new SectionPostBO(list1.get(i), list2.get(i)));
		}
		return l;
	}

	public int getSectionPostId() {
		return sectionPostId;
	}

	public void setSectionPostId(int sectionPostId) {
		this.sectionPostId = sectionPostId;
	}

	public String getSectionPostName() {
		return sectionPostName;
	}

	public void setSectionPostName(String sectionPostName) {
		this.sectionPostName = sectionPostName;
	}

	public String getSectionPostTime() {
		return sectionPostTime;
	}

	public void setSectionPostTime(String sectionPostTime) {
		this.sectionPostTime = sectionPostTime;
	}

	public int getSectionPostVisit() {
		return sectionPostVisit;
	}

	public void setSectionPostVisit(int sectionPostVisit) {
		this.sectionPostVisit = sectionPostVisit;
	}

	public String getSectionPostPhoto() {
		return sectionPostPhoto;
	}

	public void setSectionPostPhoto(String sectionPostPhoto) {
		this.sectionPostPhoto = sectionPostPhoto;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public int getSectionPostFloor() {
		return sectionPostFloor;
	}

	public void setSectionPostFloor(int sectionPostFloor) {
		this.sectionPostFloor = sectionPostFloor;
	}

}
