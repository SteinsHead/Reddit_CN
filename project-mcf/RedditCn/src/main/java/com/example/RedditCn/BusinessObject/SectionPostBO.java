package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.RedditCn.entity.SectionPost;

public class SectionPostBO {
	private int sctionPostId;
	private String sctionPostName;
	private String sctionPostTime;
	private int sctionPostVisit;
	private String sctionPostPhoto;
	private UserBO user;

	public SectionPostBO() {

	}

	public SectionPostBO(SectionPost sectionPost, UserBO user) {
		this.setSctionPostId(sectionPost.getSpId());
		this.setSctionPostName(sectionPost.getSpName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setSctionPostTime(sdf.format(sectionPost.getSpTime()));
		this.setSctionPostVisit(sectionPost.getSpVisit());
		this.setSctionPostPhoto(sectionPost.getSpPhoto());
		this.setUser(user);
	}

	public List<SectionPostBO> listSectionPostBOBO(List<SectionPost> list1, List<UserBO> list2) {
		List<SectionPostBO> l = new ArrayList<SectionPostBO>();
		for (int i = 0; i < list1.size(); i++) {
			l.add(new SectionPostBO(list1.get(i), list2.get(i)));
		}
		return l;
	}

	public int getSctionPostId() {
		return sctionPostId;
	}

	public void setSctionPostId(int sctionPostId) {
		this.sctionPostId = sctionPostId;
	}

	public String getSctionPostName() {
		return sctionPostName;
	}

	public void setSctionPostName(String sctionPostName) {
		this.sctionPostName = sctionPostName;
	}

	public String getSctionPostTime() {
		return sctionPostTime;
	}

	public void setSctionPostTime(String sctionPostTime) {
		this.sctionPostTime = sctionPostTime;
	}

	public int getSctionPostVisit() {
		return sctionPostVisit;
	}

	public void setSctionPostVisit(int sctionPostVisit) {
		this.sctionPostVisit = sctionPostVisit;
	}

	public String getSctionPostPhoto() {
		return sctionPostPhoto;
	}

	public void setSctionPostPhoto(String sctionPostPhoto) {
		this.sctionPostPhoto = sctionPostPhoto;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

}
