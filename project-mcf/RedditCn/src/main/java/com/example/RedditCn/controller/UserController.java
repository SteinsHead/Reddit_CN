package com.example.RedditCn.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.User;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 注册新账号
	@PostMapping("loginUpByAccount")
	public boolean loginUpByAccount(@RequestParam(value = "userName") String uName,
			@RequestParam(value = "userAccount") String uAccount,
			@RequestParam(value = "userPassword") String uPassword, @RequestParam(value = "userSex") char uSex,
			@RequestParam(value = "userBirthday") Date uBirthday, @RequestParam(value = "userPhoto") String uPhoto) {
		System.out.println("注册新用户-" + uAccount);
		return userService.loginUpByAccount(uName, uAccount, uPassword, uSex, uBirthday, uPhoto);
	}

	// 登录
	@GetMapping("loginInByAnyway")
	public String loginIn(@RequestParam(value = "userAccount") String uAccount,
			@RequestParam(value = "userPassword") String uPassword) {
		System.out.println("登录用户-" + uAccount);
		return userService.loginInByAnyway(uAccount, uPassword);
	}

	// 查询用户个人信息
	@UserLoginToken
	@GetMapping("findUserMine")
	public User FindUserMine(@RequestHeader(value = "token") String token) {
		System.out.println("查找用户自己");
		return userService.findUserById(TokenUtils.verify(token));
	}

	// 查询用户信息
	@UserLoginToken
	@GetMapping("findUserByuId")
	public User findUserByuId(@RequestHeader(value = "token") String token, @RequestParam(value = "userId") int uId) {
		System.out.println("查找指定用户-" + uId);
		return userService.findUserById(uId);
	}

	// 绑定手机号
	@UserLoginToken
	@PostMapping("updateUserPhone")
	public boolean updateUserPhone(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userPhone") String uPhone) {
		System.out.println("更新手机号");
		return userService.updateUserPhone(TokenUtils.verify(token), uPhone);
	}

	// 绑定邮箱
	@PostMapping("updateUserEmail")
	public boolean updateUserEmail(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userEmail") String uEmail) {
		System.out.println("更新邮箱");
		return userService.updateUserEmail(TokenUtils.verify(token), uEmail);
	}

	// 更新信息
	@PostMapping("updateUserIntroduce")
	public boolean updateUserIntroduce(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userIntroduce") String userIntroduce) {
		System.out.println("更新自我介绍");
		return userService.updateUserIntroduce(TokenUtils.verify(token), userIntroduce);
	}
}
