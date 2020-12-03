package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;

import com.example.RedditCn.entity.SectionUser;

public class SectionUserBO {
	private String sectionUserTime;
	private int sectionUserRank;
	private int sectionUserPublish;
	private boolean sectionUserSignin;
	private String sectionUserPermission;

	protected SectionUserBO() {

	}

	public SectionUserBO(SectionUser sectionUser) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setSectionUserTime(sdf.format(sectionUser.getSuTime()));
		this.setSectionUserRank(sectionUser.getSuRank());
		this.setSectionUserPublish(sectionUser.getSuPublish());
		this.setSectionUserSignin(sectionUser.isSuSignin());
		this.setSectionUserPermission(sectionUser.getSuPermission());
	}

	public String getSectionUserTime() {
		return sectionUserTime;
	}

	public void setSectionUserTime(String sectionUserTime) {
		this.sectionUserTime = sectionUserTime;
	}

	public int getSectionUserRank() {
		return sectionUserRank;
	}

	public void setSectionUserRank(int sectionUserRank) {
		this.sectionUserRank = sectionUserRank;
	}

	public int getSectionUserPublish() {
		return sectionUserPublish;
	}

	public void setSectionUserPublish(int sectionUserPublish) {
		this.sectionUserPublish = sectionUserPublish;
	}

	public boolean isSectionUserSignin() {
		return sectionUserSignin;
	}

	public void setSectionUserSignin(boolean sectionUserSignin) {
		this.sectionUserSignin = sectionUserSignin;
	}

	public String getSectionUserPermission() {
		return sectionUserPermission;
	}

	public void setSectionUserPermission(String sectionUserPermission) {
		this.sectionUserPermission = sectionUserPermission;
	}

}
