package com.example.RedditCn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostReply {
	@JsonIgnore
	private String tableName;
	@JsonProperty("postReplyId")
	private int prId;
	@JsonIgnore
	private int suId;
	@JsonProperty("postFloorId")
	private int pfId;
	@JsonProperty("postReplyIntroduce")
	private String prIntroduce;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@JsonProperty("postReplyTime")
	private Date prTime;
	@JsonIgnore
	private String prBan;

	protected PostReply() {

	}

	public PostReply(String tableName, int suId, int pfId, String prIntroduce) {
		this.tableName = tableName;
		this.suId = suId;
		this.pfId = pfId;
		this.prIntroduce = prIntroduce;
	}

	public String toString() {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		jsonObject.put("prId", prId);
		jsonObject.put("prIntroduce", prIntroduce);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("prTime", sdf.format(prTime));
		return jsonObject.toJSONString();
	}

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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
