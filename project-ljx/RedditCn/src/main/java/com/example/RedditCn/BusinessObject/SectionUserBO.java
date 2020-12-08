package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;

import com.example.RedditCn.entity.SectionUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SectionUserBO {
	private String sectionUserTime;
	private String sectionUserRank;
	private int sectionUserPublish;
	private boolean sectionUserSignin;
	private String sectionUserPermission;

	@JsonIgnore
	private int[] rank = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

	protected SectionUserBO() {

	}

	public SectionUserBO(SectionUser sectionUser) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setSectionUserTime(sdf.format(sectionUser.getSuTime()));
		int suRank = sectionUser.getSuRank();
		int n = 0;
		for (int i = 0; i < rank.length; i++) {
			if (suRank < rank[i]) {
				break;
			} else {
				suRank -= rank[i];
				n++;
			}
		}
		this.setSectionUserRank(n + "级别" + suRank + "经验");
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

	public String getSectionUserRank() {
		return sectionUserRank;
	}

	public void setSectionUserRank(String sectionUserRank) {
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
