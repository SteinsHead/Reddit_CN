package com.example.RedditCn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostFloor {
	@JsonIgnore
	private String tableName;
	@JsonProperty("postFloorId")
	private int pfId;
	@JsonIgnore
	private int suId;
	@JsonProperty("postFloorIntroduce")
	private String pfIntroduce;
	@JsonProperty("postFloorTime")
	private Date pfTime;
	@JsonIgnore
	private String pfBan;
	@JsonProperty("postFloorReply")
	private int pfReply;
	@JsonProperty("postFloorPhoto")
	private String pfPhoto;

	public String toString() {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		jsonObject.put("pfId", pfId);
		jsonObject.put("pfIntroduce", pfIntroduce);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("pfTime", sdf.format(pfTime));
		jsonObject.put("pfReply", pfReply);
		jsonObject.put("pfPhoto", pfPhoto);
		return jsonObject.toJSONString();
	}

	protected PostFloor() {

	}

	public PostFloor(String tableName, int suId, String pfIntroduce, String pfPhoto) {
		this.tableName = tableName;
		this.suId = suId;
		this.pfIntroduce = pfIntroduce;
		this.pfPhoto = pfPhoto;
	}

	public int getPfId() {
		return pfId;
	}

	public void setPfId(int pfId) {
		this.pfId = pfId;
	}

	public int getSuId() {
		return suId;
	}

	public void setSuId(int suId) {
		this.suId = suId;
	}

	public String getPfIntroduce() {
		return pfIntroduce;
	}

	public void setPfIntroduce(String pfIntroduce) {
		this.pfIntroduce = pfIntroduce;
	}

	public Date getPfTime() {
		return pfTime;
	}

	public void setPfTime(Date pfTime) {
		this.pfTime = pfTime;
	}

	public String getPfBan() {
		return pfBan;
	}

	public void setPfBan(String pfBan) {
		this.pfBan = pfBan;
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
