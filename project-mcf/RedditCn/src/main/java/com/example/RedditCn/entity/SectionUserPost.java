package com.example.RedditCn.entity;

public class SectionUserPost {
	private int suId;
	private int spId;
	private int pfId;

	protected SectionUserPost() {

	}

	public SectionUserPost(int suId, int spId, int pfId) {
		this.suId = suId;
		this.spId = spId;
		this.setPfId(pfId);
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

	public int getPfId() {
		return pfId;
	}

	public void setPfId(int pfId) {
		this.pfId = pfId;
	}

}
