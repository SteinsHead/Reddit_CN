package com.example.RedditCn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户实体类
 * **/
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
	//用户id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("userId")
	@Column(name = "uid")
	private int uid;

	//用户名
	@JsonProperty("userName")
	@Column(name = "uname")
	private String uname;

	//账号
	@JsonProperty("userAccount")
	@Column(name = "uaccount")
	private String uaccount;

	//用户密码
	@JsonIgnore
	@Column(name = "upassword")
	private String upassword;

	//用户手机号
	@JsonIgnore
	@Column(name = "uphone")
	private String uphone;

	//用户邮箱
	@JsonIgnore
	@Column(name = "uemail")
	private String uemail;

	//时间
	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@JsonProperty("userTime")
	@Column(name = "utime")
	private Date utime;

	//用户性别
	@JsonProperty("userSex")
	@Column(name = "usex")
	private char usex;

	//用户生日 时间格式：年月日
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
	@JsonProperty("userBirthday")
	@Column(name = "ubirthday")
	private Date ubirthday;

	//封号
	@JsonIgnore
	@Column(name = "uban")
	private String uban;

	//用户简介
	@JsonProperty("userIntroduce")
	@Column(name = "uintroduce")
	private String uintroduce;

	//关注
	@JsonProperty("userFollow")
	@Column(name = "ufollow")
	private int ufollow;

	//发出
	@JsonProperty("userPublish")
	@Column(name = "upublish")
	private int upublish;

	//用户许可
	@JsonProperty("userPermission")
	@Column(name = "upermission")
	private String upermission;

	//头像
	@JsonProperty("userPhoto")
	@Column(name = "uphoto")
	private String uphoto;

	protected User() {

	}

	public User(String uName, String uAccount, String uPassword, char uSex, Date uBirthday, String uPhoto) {
		this.uname = uName;
		this.uaccount = uAccount;
		this.upassword = uPassword;
		this.usex = uSex;
		this.ubirthday = uBirthday;
		this.uphoto = uPhoto;
	}

	@Override
	public String toString() {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		jsonObject.put("uId", uid);
		jsonObject.put("uName", uname);
		jsonObject.put("uAccount", uaccount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("uTime", sdf.format(utime));
		jsonObject.put("uSex", usex);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		jsonObject.put("uBirthday", sdf.format(ubirthday));
		jsonObject.put("uIntroduce", uintroduce);
		jsonObject.put("uFollow", ufollow);
		jsonObject.put("uPublish", upublish);
		jsonObject.put("uPermission", upermission);
		jsonObject.put("uPhoto", uphoto);
		return jsonObject.toJSONString();
	}

	public String toString(String jsonName, Object jsonString) {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		jsonObject.put("uId", uid);
		jsonObject.put("uName", uname);
		jsonObject.put("uAccount", uaccount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("uTime", sdf.format(utime));
		jsonObject.put("uSex", usex);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		jsonObject.put("uBirthday", sdf.format(ubirthday));
		jsonObject.put("uIntroduce", uintroduce);
		jsonObject.put("uFollow", ufollow);
		jsonObject.put("uPublish", upublish);
		jsonObject.put("uPermission", upermission);
		jsonObject.put("uPhoto", uphoto);
		jsonObject.put(jsonName, jsonString);
		return jsonObject.toJSONString();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaccount() {
		return uaccount;
	}

	public void setUaccount(String uaccount) { this.uaccount = uaccount; }

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUemail() { return uemail; }

	public void setUemail(String uemail) { this.uemail = uemail; }

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public char getUsex() {
		return usex;
	}

	public void setUsex(char usex) {
		this.usex = usex;
	}

	public Date getUbirthday() {
		return ubirthday;
	}

	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}

	public String getUban() {
		return uban;
	}

	public void setUban(String uban) {
		this.uban = uban;
	}

	public String getUintroduce() {
		return uintroduce;
	}

	public void setUintroduce(String uintroduce) {
		this.uintroduce = uintroduce;
	}

	public int getUfollow() {
		return ufollow;
	}

	public void setUfollow(int ufollow) {
		this.ufollow = ufollow;
	}

	public int getUpublish() {
		return upublish;
	}

	public void setUpublish(int upublish) {
		this.upublish = upublish;
	}

	public String getUpermission() {
		return upermission;
	}

	public void setUpermission(String upermission) {
		this.upermission = upermission;
	}

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

}
