package com.example.RedditCn.BusinessObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.RedditCn.entity.SectionUser;
import com.example.RedditCn.entity.User;

public class UserBO {
	private int userId;
	private String userName;
	private String userAccount;
	private String userTime;
	private char userSex;
	private String userBirthday;
	private String userIntroduce;
	private int userFollow;
	private int userPublish;
	private String userPermission;
	private String userPhoto;
	private SectionUserBO sectionUser;

	public UserBO() {

	}

	public UserBO(User user, SectionUser sectionUser) {
		this.setUserId(user.getUid());
		this.setUserName(user.getUname());
		this.setUserAccount(user.getUaccount());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setUserTime(sdf.format(user.getUtime()));
		this.setUserSex(user.getUsex());
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.setUserBirthday(sdf.format(user.getUbirthday()));
		this.setUserIntroduce(user.getUintroduce());
		this.setUserFollow(user.getUfollow());
		this.setUserPublish(user.getUpublish());
		this.setUserPermission(user.getUpermission());
		this.setUserPhoto(user.getUphoto());
		this.setSectionUser(new SectionUserBO(sectionUser));
	}

	public List<UserBO> ListUserBO(List<User> list1, List<SectionUser> list2) {
		List<UserBO> list = new ArrayList<UserBO>();
		for (int i = 0; i < list1.size(); i++) {
			list.add(new UserBO(list1.get(i), list2.get(i)));
		}
		return list;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserTime() {
		return userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

	public char getUserSex() {
		return userSex;
	}

	public void setUserSex(char userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserIntroduce() {
		return userIntroduce;
	}

	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}

	public int getUserFollow() {
		return userFollow;
	}

	public void setUserFollow(int userFollow) {
		this.userFollow = userFollow;
	}

	public int getUserPublish() {
		return userPublish;
	}

	public void setUserPublish(int userPublish) {
		this.userPublish = userPublish;
	}

	public String getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public SectionUserBO getSectionUser() {
		return sectionUser;
	}

	public void setSectionUser(SectionUserBO sectionUser) {
		this.sectionUser = sectionUser;
	}
}
