package com.example.RedditCn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

@EntityListeners(AuditingEntityListener.class)
public class SectionUser {
	String tableName;
	@JsonIgnore
	private int suId;
	@JsonIgnore
	private int uId;
	@CreatedDate
	private Date suTime;
	private int suRank;
	private int suPublish;
	private boolean suSignin;
	@JsonIgnore
	private String suBan;
	private String suPermission;

	protected SectionUser() {

	}

	public SectionUser(String tableName, int uId, String suPermission) {
		this.tableName = tableName;
		this.uId = uId;
		this.suPermission = suPermission;
	}

	public String toString() {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("suTime", sdf.format(suTime));
		jsonObject.put("suRank", suRank);
		jsonObject.put("suPublish", suPublish);
		jsonObject.put("suSignin", suSignin);
		jsonObject.put("suPermission", suPermission);
		return jsonObject.toJSONString();
	}

	public int getSuId() {
		return suId;
	}

	public void setSuId(int suId) {
		this.suId = suId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Date getSuTime() {
		return suTime;
	}

	public void setSuTime(Date suTime) {
		this.suTime = suTime;
	}

	public int getSuRank() {
		return suRank;
	}

	public void setSuRank(int suRank) {
		this.suRank = suRank;
	}

	public int getSuPublish() {
		return suPublish;
	}

	public void setSuPublish(int suPublish) {
		this.suPublish = suPublish;
	}

	public boolean isSuSignin() {
		return suSignin;
	}

	public void setSuSignin(boolean suSignin) {
		this.suSignin = suSignin;
	}

	public String getSuBan() {
		return suBan;
	}

	public void setSuBan(String suBan) {
		this.suBan = suBan;
	}

	public String getSuPermission() {
		return suPermission;
	}

	public void setSuPermission(String suPermission) {
		this.suPermission = suPermission;
	}

}
