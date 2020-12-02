package com.example.RedditCn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "uid")
	private int uid;
	@Column(name = "sid")
	private int sid;
	@Column(name = "suid")
	private int suid;

	protected UserSection() {

	}

	public UserSection(int uid, int sid, int suid) {
		this.uid = uid;
		this.sid = sid;
		this.suid = suid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSuid() {
		return suid;
	}

	public void setSuid(int suid) {
		this.suid = suid;
	}

}
