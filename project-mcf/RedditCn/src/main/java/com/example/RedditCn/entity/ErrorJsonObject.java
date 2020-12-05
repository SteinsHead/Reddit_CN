package com.example.RedditCn.entity;

import com.alibaba.fastjson.JSONObject;

public class ErrorJsonObject {
	private static JSONObject jsonObject = new JSONObject();

	public static String tokenInvalid() {
		jsonObject.put("errcode", "40001");
		jsonObject.put("errmsg", "invalid token");
		return jsonObject.toJSONString();
	}

	public static String tokenOverdue() {
		jsonObject.put("errcode", "40002");
		jsonObject.put("errmsg", "token overdue");
		return jsonObject.toJSONString();
	}

	public static String tokenNotMatch() {
		jsonObject.put("errcode", "40003");
		jsonObject.put("errmsg", "token not match");
		return jsonObject.toJSONString();
	}

	public static String createTokenFailed() {
		jsonObject.put("errcode", "40004");
		jsonObject.put("errmsg", "create token failed");
		return jsonObject.toJSONString();
	}

	public static String tokenNull() {
		jsonObject.put("errcode", "40005");
		jsonObject.put("errmsg", "token null");
		return jsonObject.toJSONString();
	}

	public static String notEnoughPermission() {
		jsonObject.put("errcode", "40006");
		jsonObject.put("errmsg", " Not enough permission");
		return jsonObject.toJSONString();
	}

	public static String loginUpFailed() {
		jsonObject.put("errcode", "40010");
		jsonObject.put("errmsg", "login up failed");
		return jsonObject.toJSONString();
	}

	public static String duplicateAccount() {
		jsonObject.put("errcode", "40011");
		jsonObject.put("errmsg", "duplicate account");
		return jsonObject.toJSONString();
	}

	public static String wrongAccountOrPassword() {
		jsonObject.put("errcode", "40012");
		jsonObject.put("errmsg", "wrong account or password");
		return jsonObject.toJSONString();
	}

	public static String userNotExist() {
		jsonObject.put("errcode", "40013");
		jsonObject.put("errmsg", "user not exist");
		return jsonObject.toJSONString();
	}

	public static String phoneExist() {
		jsonObject.put("errcode", "40014");
		jsonObject.put("errmsg", "phone Exist");
		return jsonObject.toJSONString();
	}

	public static String updatePhoneFailed() {
		jsonObject.put("errcode", "40015");
		jsonObject.put("errmsg", "update phone failed");
		return jsonObject.toJSONString();
	}

	public static String emailExist() {
		jsonObject.put("errcode", "40016");
		jsonObject.put("errmsg", "email Exist");
		return jsonObject.toJSONString();
	}

	public static String updateEmailFailed() {
		jsonObject.put("errcode", "40017");
		jsonObject.put("errmsg", "update email failed");
		return jsonObject.toJSONString();
	}

	public static String userAccountOrPasswordInvalid() {
		jsonObject.put("errcode", "40018");
		jsonObject.put("errmsg", "user account or password invalid");
		return jsonObject.toJSONString();
	}

	public static String updateIntroduceFailed() {
		jsonObject.put("errcode", "40019");
		jsonObject.put("errmsg", "update user introduce failed");
		return jsonObject.toJSONString();
	}

	public static String updateUserFollowFailed() {
		jsonObject.put("errcode", "40020");
		jsonObject.put("errmsg", "update user follow failed");
		return jsonObject.toJSONString();
	}

	public static String updateUserPublishFailed() {
		jsonObject.put("errcode", "400201");
		jsonObject.put("errmsg", "update user publish failed");
		return jsonObject.toJSONString();
	}

	public static String findUserInformationFailed() {
		jsonObject.put("errcode", "40021");
		jsonObject.put("errmsg", "find user information failed");
		return jsonObject.toJSONString();
	}

	public static String sectionNameExist() {
		jsonObject.put("errcode", "40031");
		jsonObject.put("errmsg", "section name Exist");
		return jsonObject.toJSONString();
	}

	public static String insertSectionFailed() {
		jsonObject.put("errcode", "40032");
		jsonObject.put("errmsg", "insert section failed");
		return jsonObject.toJSONString();
	}

	public static String findAllSectionFailed() {
		jsonObject.put("errcode", "40033");
		jsonObject.put("errmsg", "find all section failed");
		return jsonObject.toJSONString();
	}

	public static String findSectionBysIdFailed() {
		jsonObject.put("errcode", "40034");
		jsonObject.put("errmsg", "find section by sId failed");
		return jsonObject.toJSONString();
	}

	public static String findSectionBysNameFailed() {
		jsonObject.put("errcode", "40035");
		jsonObject.put("errmsg", "find section by sName failed");
		return jsonObject.toJSONString();
	}

	public static String sectionNotExist() {
		jsonObject.put("errcode", "40036");
		jsonObject.put("errmsg", "section not exist");
		return jsonObject.toJSONString();
	}

	public static String updateSectionFollowFailed() {
		jsonObject.put("errcode", "40037");
		jsonObject.put("errmsg", "update section follow failed");
		return jsonObject.toJSONString();
	}

	public static String updateSectionPublishFailed() {
		jsonObject.put("errcode", "40038");
		jsonObject.put("errmsg", "update section publish failed");
		return jsonObject.toJSONString();
	}

	public static String createSectionUserTableFailed() {
		jsonObject.put("errcode", "40041");
		jsonObject.put("errmsg", "create section user table failed");
		return jsonObject.toJSONString();
	}

	public static String insertSectionUserFailed() {
		jsonObject.put("errcode", "40042");
		jsonObject.put("errmsg", "insert section user failed");
		return jsonObject.toJSONString();
	}

	public static String sectionUserExist() {
		jsonObject.put("errcode", "40043");
		jsonObject.put("errmsg", "section user Exist");
		return jsonObject.toJSONString();
	}

	public static String findSectionUserByuIdFailed() {
		jsonObject.put("errcode", "40044");
		jsonObject.put("errmsg", "find section user by uId failed");
		return jsonObject.toJSONString();
	}

	public static String sectionUserNotExist() {
		jsonObject.put("errcode", "40045");
		jsonObject.put("errmsg", "section user not Exist");
		return jsonObject.toJSONString();
	}

	public static String findSectionUserBysuIdFailed() {
		jsonObject.put("errcode", "40046");
		jsonObject.put("errmsg", "find section user by suId failed");
		return jsonObject.toJSONString();
	}

	public static String updateSectionUserRankFailed() {
		jsonObject.put("errcode", "40047");
		jsonObject.put("errmsg", "update section user rank failed");
		return jsonObject.toJSONString();
	}

	public static String insertUserSectionFailed() {
		jsonObject.put("errcode", "40051");
		jsonObject.put("errmsg", "insert User_Section failed");
		return jsonObject.toJSONString();
	}

	public static String UserSectionExist() {
		jsonObject.put("errcode", "40052");
		jsonObject.put("errmsg", "User_Section exist");
		return jsonObject.toJSONString();
	}

	public static String findUserSectionByuIdAndsIdFailed() {
		jsonObject.put("errcode", "40053");
		jsonObject.put("errmsg", "find user_section by uId and sId failed");
		return jsonObject.toJSONString();
	}

	public static String userSectionNotExist() {
		jsonObject.put("errcode", "40054");
		jsonObject.put("errmsg", "user_section not exist");
		return jsonObject.toJSONString();
	}

	public static String insertSectionPostFailed() {
		jsonObject.put("errcode", "40061");
		jsonObject.put("errmsg", "insert section post failed");
		return jsonObject.toJSONString();
	}

	public static String createSectionPostTableFailed() {
		jsonObject.put("errcode", "40062");
		jsonObject.put("errmsg", "create section post table failed");
		return jsonObject.toJSONString();
	}

	public static String findAllSectionPostFailed() {
		jsonObject.put("errcode", "40063");
		jsonObject.put("errmsg", "find all section post failed");
		return jsonObject.toJSONString();
	}

	public static String updateSectionPostFloorFailed() {
		jsonObject.put("errcode", "40064");
		jsonObject.put("errmsg", "update section post floor failed");
		return jsonObject.toJSONString();
	}

	public static String findSectionPostByspIdFailed() {
		jsonObject.put("errcode", "40065");
		jsonObject.put("errmsg", "find section post by spId failed");
		return jsonObject.toJSONString();
	}

	public static String sectionPostNotExist() {
		jsonObject.put("errcode", "40066");
		jsonObject.put("errmsg", "section post not exist");
		return jsonObject.toJSONString();
	}

	public static String updateSectionPostBanFailed() {
		jsonObject.put("errcode", "40067");
		jsonObject.put("errmsg", "update section post ban failed");
		return jsonObject.toJSONString();
	}

	public static String createPostFloorTableFailed() {
		jsonObject.put("errcode", "40071");
		jsonObject.put("errmsg", "create post floor table failed");
		return jsonObject.toJSONString();
	}

	public static String findAllPostFloorFailed() {
		jsonObject.put("errcode", "40072");
		jsonObject.put("errmsg", "find all post floor failed");
		return jsonObject.toJSONString();
	}

	public static String insertPostFloorFailed() {
		jsonObject.put("errcode", "40073");
		jsonObject.put("errmsg", "insert post floor failed");
		return jsonObject.toJSONString();
	}

	public static String findPostFloorBypfIdFailed() {
		jsonObject.put("errcode", "40074");
		jsonObject.put("errmsg", "find post floor by pfId failed");
		return jsonObject.toJSONString();
	}

	public static String postFloorNotExist() {
		jsonObject.put("errcode", "40075");
		jsonObject.put("errmsg", "post floor not exist");
		return jsonObject.toJSONString();
	}

	public static String updatePostFloorReplyFailed() {
		jsonObject.put("errcode", "40076");
		jsonObject.put("errmsg", "update post floor reply failed");
		return jsonObject.toJSONString();
	}

	public static String updatePostFloorBanFailed() {
		jsonObject.put("errcode", "40077");
		jsonObject.put("errmsg", "update post floor ban failed");
		return jsonObject.toJSONString();
	}

	public static String findPostReplyBypfIdFailed() {
		jsonObject.put("errcode", "40081");
		jsonObject.put("errmsg", "find post reply by pfId failed");
		return jsonObject.toJSONString();
	}

	public static String createPostReplyTableFailed() {
		jsonObject.put("errcode", "40082");
		jsonObject.put("errmsg", "create post reply table failed");
		return jsonObject.toJSONString();
	}

	public static String insertPostReplyFailed() {
		jsonObject.put("errcode", "40083");
		jsonObject.put("errmsg", "insert post reply failed");
		return jsonObject.toJSONString();
	}

	public static String findPostReplyByprIdFailed() {
		jsonObject.put("errcode", "40084");
		jsonObject.put("errmsg", "find post reply by prId failed");
		return jsonObject.toJSONString();
	}

	public static String postReplyNotExist() {
		jsonObject.put("errcode", "40085");
		jsonObject.put("errmsg", "post reply not exist");
		return jsonObject.toJSONString();
	}

	public static String updatePostReplyBanFailed() {
		jsonObject.put("errcode", "40086");
		jsonObject.put("errmsg", "update post reply ban failed");
		return jsonObject.toJSONString();
	}

	public static String createSectionUserPostTableFailed() {
		jsonObject.put("errcode", "40091");
		jsonObject.put("errmsg", "create section user post table failed");
		return jsonObject.toJSONString();
	}

	public static String insertSectionUserPostFailed() {
		jsonObject.put("errcode", "40092");
		jsonObject.put("errmsg", "insert section user post failed");
		return jsonObject.toJSONString();
	}

	public static String findSectionUserPostBysuIdFailed() {
		jsonObject.put("errcode", "40093");
		jsonObject.put("errmsg", "find section user post by suId failed");
		return jsonObject.toJSONString();
	}

	public static String sectionUserPostNotExist() {
		jsonObject.put("errcode", "40094");
		jsonObject.put("errmsg", "section user post not exist");
		return jsonObject.toJSONString();
	}

	public static String toFileFailed() {
		jsonObject.put("errcode", "40101");
		jsonObject.put("errmsg", "multipartFile to file failed");
		return jsonObject.toJSONString();
	}

}
