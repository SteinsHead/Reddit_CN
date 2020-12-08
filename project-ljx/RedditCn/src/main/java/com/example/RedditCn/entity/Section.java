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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("sectionId")
	@Column(name = "sid")
	private int sid;

	@JsonProperty("sectionName")
	@Column(name = "sname")
	private String sname;

	@JsonProperty("sectionIntroduce")
	@Column(name = "sintroduce")
	private String sintroduce;

	@CreatedDate
	@JsonProperty("sectionTime")
	@Column(name = "stime")
	private Date stime;

	@JsonIgnore
	@Column(name = "uid")
	private int uid;

	@JsonProperty("sectionFollow")
	@Column(name = "sfollow")
	private int sfollow;

	@JsonIgnore
	@Column(name = "sban")
	private String sban;

	@JsonProperty("sectionPublish")
	@Column(name = "spublish")
	private int spublish;

	@JsonIgnore
	@Column(name = "stheme")
	private String stheme;

	@JsonProperty("sectionVisit")
	@Column(name = "svisit")
	private int svisit;

	@JsonProperty("sectionPhoto")
	@Column(name = "sphoto")
	private String sphoto;

	protected Section() {

	}

	public Section(String sName, String sIntroduce, int uId, String sPhoto, int sFollow) {
		this.sname = sName;
		this.sintroduce = sIntroduce;
		this.uid = uId;
		this.sphoto = sPhoto;
		this.sfollow = sFollow;
	}

	public String toString() {
		JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
		jsonObject.put("sId", sid);
		jsonObject.put("sName", sname);
		jsonObject.put("sIntroduce", sintroduce);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("sTime", sdf.format(stime));
		jsonObject.put("sFollow", sfollow);
		jsonObject.put("sPublish", spublish);
		jsonObject.put("sVisit", svisit);
		jsonObject.put("sPhoto", sphoto);
		return jsonObject.toString();
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getsIntroduce() {
		return sintroduce;
	}

	public void setsIntroduce(String sintroduce) {
		this.sintroduce = sintroduce;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSfollow() {
		return sfollow;
	}

	public void setSfollow(int sfollow) {
		this.sfollow = sfollow;
	}

	public String getSban() {
		return sban;
	}

	public void setSban(String sban) {
		this.sban = sban;
	}

	public int getSpublish() {
		return spublish;
	}

	public void setSpublish(int spublish) {
		this.spublish = spublish;
	}

	public String getStheme() {
		return stheme;
	}

	public void setStheme(String stheme) {
		this.stheme = stheme;
	}

	public String getSphoto() {
		return sphoto;
	}

	public void setSphoto(String sphoto) {
		this.sphoto = sphoto;
	}

	public int getSvisit() {
		return svisit;
	}

	public void setSvisit(int svisit) {
		this.svisit = svisit;
	}
}
