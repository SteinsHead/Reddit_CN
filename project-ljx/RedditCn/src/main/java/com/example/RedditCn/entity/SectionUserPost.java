package com.example.RedditCn.entity;

public class SectionUserPost {
	private int suId;
	private int spId;

	protected SectionUserPost() {

	}

	public SectionUserPost(int suId, int spId) {
		this.suId = suId;
		this.spId = spId;
	}

	public int getSuId() {
		return suId;
	}

	public void setSuId(int suId) {
		this.suId = suId;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

}
