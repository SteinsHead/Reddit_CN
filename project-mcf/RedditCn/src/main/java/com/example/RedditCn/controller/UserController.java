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
		return userService.loginUpByAccount(uName, uAccount, uPassword, uSex, uBirthday, uPhoto);
	}

	// 登录
	@GetMapping("loginInByAnyway")
	public String loginIn(@RequestParam(value = "userAccount") String uAccount,
			@RequestParam(value = "userPassword") String uPassword) {
		return userService.loginInByAnyway(uAccount, uPassword);
	}

	// 查询用户个人信息
	@UserLoginToken
	@GetMapping("findUserMine")
	public User FindUserMine(@RequestHeader(value = "token") String token) {
		return userService.findUserById(TokenUtils.verify(token));
	}

	// 查询用户信息
	@UserLoginToken
	@GetMapping("findUserByuId")
	public User findUserByuId(@RequestHeader(value = "token") String token, @RequestParam(value = "userId") int uId) {
		return userService.findUserById(uId);
	}

	// 绑定手机号
	@UserLoginToken
	@PostMapping("updateUserPhone")
	public boolean updateUserPhone(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userPhone") String uPhone) {
		return userService.updateUserPhone(TokenUtils.verify(token), uPhone);
	}

	// 绑定邮箱
	@PostMapping("updateUserEmail")
	public boolean updateUserEmail(@RequestHeader(value = "token") String token,
			@RequestParam(value = "userEmail") String uEmail) {
		return userService.updateUserEmail(TokenUtils.verify(token), uEmail);
	}
}
