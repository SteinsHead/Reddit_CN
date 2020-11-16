package com.example.RedditCn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PostReply {
	private int prId;
	private int suId;
	private int pfId;
	private String prIntroduce;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	private Date prTime;
	private String prBan;

	public int getPrId() {
		return prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public int getSuId() {
		return suId;
	}

	public void setSuId(int suId) {
		this.suId = suId;
	}

	public int getPfId() {
		return pfId;
	}

	public void setPfIdInteger(int pfId) {
		this.pfId = pfId;
	}

	public String getPrIntroduce() {
		return prIntroduce;
	}

	public void setPrIntroduce(String prIntroduce) {
		this.prIntroduce = prIntroduce;
	}

	public Date getPrTime() {
		return prTime;
	}

	public void setPrTime(Date prTime) {
		this.prTime = prTime;
	}

	public String getPrBan() {
		return prBan;
	}

	public void setPrBan(String prBan) {
		this.prBan = prBan;
	}

	@Override
	public String toString() {
		return "PostReply{" + "prId=" + prId + ", suId=" + suId + ", pfId=" + pfId + ", prIntroduce='" + prIntroduce
				+ '\'' + ", prTime='" + prTime + '\'' + ", prBan='" + prBan + '\'' + '}';
	}
}
