package com.example.RedditCn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SectionPost {
	private int spId;
	private int suId;
	private String spName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	private Date spTime;
	private String spBan;
	private String spTheme;
	private int spVisit;

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public int getSuId() {
		return suId;
	}

	public void setSuId(int suId) {
		this.suId = suId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public Date getSpTime() {
		return spTime;
	}

	public void setSpTime(Date spTime) {
		this.spTime = spTime;
	}

	public String getSpBan() {
		return spBan;
	}

	public void setSpBan(String spBan) {
		this.spBan = spBan;
	}

	public String getSpTheme() {
		return spTheme;
	}

	public void setSpTheme(String spTheme) {
		this.spTheme = spTheme;
	}

	public int getSpVisit() {
		return spVisit;
	}

	public void setSpVisit(int spVisit) {
		this.spVisit = spVisit;
	}
}
