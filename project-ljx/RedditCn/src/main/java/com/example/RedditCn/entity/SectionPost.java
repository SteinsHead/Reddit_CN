package com.example.RedditCn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 **帖子
 *  **/
public class SectionPost {
	@JsonIgnore
	private String tableName;

	@JsonProperty("sectionPostId")
	private int spId;

	@JsonIgnore
	private int suId;

	@JsonProperty("sectionPostName")
	private String spName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@JsonProperty("sectionPostTime")
	private Date spTime;

	@JsonIgnore
	private String spBan;

	@JsonIgnore
	private String spTheme;

	@JsonProperty("sectionPostFloor")
	private int spFloor;

	@JsonProperty("sectionPostVisit")
	private int spVisit;

	@JsonProperty("sectionPostPhoto")
	private String spPhoto;

	protected SectionPost() {

	}

	public SectionPost(String tableName, int suId, String spName, String spPhoto) {
		this.tableName = tableName;
		this.suId = suId;
		this.spName = spName;
		this.spPhoto = spPhoto;
	}

	public String toString() {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		jsonObject.put("spId", spId);
		jsonObject.put("spName", spName);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("spTime", sdf.format(spTime));
		jsonObject.put("spVisit", spVisit);
		jsonObject.put("spPhoto", spPhoto);
		return jsonObject.toJSONString();
	}

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

	public String getSpPhoto() {
		return spPhoto;
	}

	public void setSpPhoto(String spPhoto) {
		this.spPhoto = spPhoto;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getSpFloor() {
		return spFloor;
	}

	public void setSpFloor(int spFloor) {
		this.spFloor = spFloor;
	}
}
