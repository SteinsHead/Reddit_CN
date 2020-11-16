package com.example.RedditCn.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	private int sId;
	@Column(name = "sname")
	private String sName;
	@Column(name = "sintroduce")
	private String sIntroduce;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	@Column(name = "stime")
	private Date sTime;
	@Column(name = "uid")
	private int uId;
	@Column(name = "sfollow")
	private int sFollow;
	@Column(name = "sban")
	private String sBan;
	@Column(name = "spublish")
	private int sPublish;
	@Column(name = "stheme")
	private String sTheme;
	@Column(name = "svisit")
	private int sVisit;
	@Column(name = "sphoto")
	private String sPhoto;

	protected Section() {

	}

	public Section(String sName, String sIntroduce, Date sTime, int uId, int sFollow, String sBan, int sPublish,
			int sVisit) {
		this.sName = sName;
		this.sIntroduce = sIntroduce;
		this.sTime = sTime;
		this.uId = uId;
		this.sFollow = sFollow;
		this.sBan = sBan;
		this.sPublish = sPublish;
		this.sVisit = sVisit;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsIntroduce() {
		return sIntroduce;
	}

	public void setsIntroduce(String sIntroduce) {
		this.sIntroduce = sIntroduce;
	}

	public Date getsTime() {
		return sTime;
	}

	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getsFollow() {
		return sFollow;
	}

	public void setsFollow(int sFollow) {
		this.sFollow = sFollow;
	}

	public String getsBan() {
		return sBan;
	}

	public void setsBan(String sBan) {
		this.sBan = sBan;
	}

	public int getsPublish() {
		return sPublish;
	}

	public void setsPublish(int sPublish) {
		this.sPublish = sPublish;
	}

	public String getsTheme() {
		return sTheme;
	}

	public void setsTheme(String sTheme) {
		this.sTheme = sTheme;
	}

	public int getsVisit() {
		return sVisit;
	}

	public void setsVisit(int sVisit) {
		this.sVisit = sVisit;
	}

	public String getsPhoto() {
		return sPhoto;
	}

	public void setsPhoto(String sPhoto) {
		this.sPhoto = sPhoto;
	}

}
