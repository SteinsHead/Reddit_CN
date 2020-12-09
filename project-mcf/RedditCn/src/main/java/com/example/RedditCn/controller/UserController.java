package com.example.RedditCn.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedditCn.BusinessObject.PostFloorListBO;
import com.example.RedditCn.BusinessObject.SectionPostListBO;
import com.example.RedditCn.BusinessObject.UserSectionBO;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.service.SectionUserPostService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private SectionUserPostService sectionUserPostService;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
	// 注册新账号

	@PostMapping("loginUpByAccount")
	public boolean loginUpByAccount(@RequestParam(value = "userName") String uName,
			@RequestParam(value = "userAccount") String uAccount,
			@RequestParam(value = "userPassword") String uPassword, @RequestParam(value = "userSex") char uSex,
			@RequestParam(value = "userBirthday") Date uBirthday, @RequestParam(value = "userPhoto") String uPhoto) {
		System.out.println(df.format(new java.util.Date()) + " 注册新用户-" + uAccount);
		return userService.loginUpByAccount(uName, uAccount, uPassword, uSex, uBirthday, uPhoto);
	}

	// 登录
	@GetMapping("/loginInByAnyway")
	public String loginIn(@RequestParam(value = "userAccount") String uAccount,
			@RequestParam(value = "userPassword") String uPassword) {
		System.out.println(df.format(new java.util.Date()) + " 登录用户-" + uAccount);
		return userService.loginInByAnyway(uAccount, uPassword);
	}

	// 查询用户个人信息
	@UserLoginToken
	@GetMapping("/findUserMine")
	public UserSectionBO FindUserMine(@RequestHeader(value = "token") String token) {
		int uId = TokenUtils.verify(token);
		System.out.println(df.format(new java.util.Date()) + " 用户-" + uId + "-查找用户自己");
		return userService.findUserInformationById(uId);
	}

	// 查询用户信息
	@UserLoginToken
	@GetMapping("/findUserByuId")
	public UserSectionBO findUserByuId(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userId") int uId) {
		System.out.println(df.format(new java.util.Date()) + " 用户-" + TokenUtils.verify(token) + "-查找指定用户-" + uId);
		return userService.findUserInformationById(uId);
	}

	// 绑定手机号
	@UserLoginToken
	@PostMapping("/updateUserPhone")
	public boolean updateUserPhone(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userPhone") String uPhone) {
		int uId = TokenUtils.verify(token);
		System.out.println(df.format(new java.util.Date()) + " 用户-" + uId + "-更新手机号");
		return userService.updateUserPhone(uId, uPhone);
	}

	// 绑定邮箱
	@UserLoginToken
	@PostMapping("/updateUserEmail")
	public boolean updateUserEmail(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userEmail") String uEmail) {
		int uId = TokenUtils.verify(token);
		System.out.println(df.format(new java.util.Date()) + " 用户-" + uId + "-更新邮箱");
		return userService.updateUserEmail(uId, uEmail);
	}

	// 更新信息
	@UserLoginToken
	@PostMapping("/updateUserInformation")
	public boolean updateUserIntroduce(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userName") String uName, @RequestParam(value = "userSex") char uSex,
			@RequestParam(value = "userBirthday") Date uBirthday, @RequestParam(value = "userPhoto") String uPhoto,
			@RequestParam(value = "userIntroduce") String uIntroduce) {
		int uId = TokenUtils.verify(token);
		userService.updateUserInformation(uName, uSex, uBirthday, uPhoto, uIntroduce, uId);
		System.out.println(df.format(new java.util.Date()) + " 用户-" + uId + "-更新自我信息");
		return true;
	}

	@UserLoginToken
	@GetMapping("/findUserSectionPost")
	public List<SectionPostListBO> findUserSectionPost(@RequestHeader(value = "token") String token) {
		int uId = TokenUtils.verify(token);
		System.out.println(df.format(new java.util.Date()) + " 用户-" + uId + "-查询自己发过的帖子");
		return sectionUserPostService.findUserSectionPost(uId);
	}

	@UserLoginToken
	@GetMapping("/findUserPostFloor")
	public List<PostFloorListBO> findUserPostFloor(@RequestHeader(value = "token") String token) {
		int uId = TokenUtils.verify(token);
		System.out.println(df.format(new java.util.Date()) + " 用户-" + uId + "-查询自己发过的楼层");
		return sectionUserPostService.findUserPostFloor(uId);
	}
}
