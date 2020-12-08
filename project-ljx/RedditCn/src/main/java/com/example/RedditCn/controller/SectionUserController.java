package com.example.RedditCn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedditCn.BusinessObject.SectionUserBO;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.SectionUser;
import com.example.RedditCn.entity.User;
import com.example.RedditCn.service.SectionService;
import com.example.RedditCn.service.SectionUserService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserSectionService;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/sectionUser")
public class SectionUserController {
	@Autowired
	SectionUserService sectionUserService;
	@Autowired
	UserSectionService userSectionService;
	@Autowired
	UserService userService;
	@Autowired
	SectionService sectionService;

	@UserLoginToken
	@PostMapping("/insertSectionUser")
	public SectionUserBO insertSectionUser(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId) {
		int uId = TokenUtils.verify(token);
		int suId = sectionUserService.insertSectionUser(sId, uId, null);
		userSectionService.insertUserSection(uId, sId, suId);
		userService.updateUserFollow(uId);
		sectionService.updateSectionFollow(sId);
		System.out.println("版块-" + sId + "-注册用户-" + suId);
		return new SectionUserBO(sectionUserService.findSectionUserByuId(sId, uId));
	}

	@UserLoginToken
	@GetMapping("/findSectionCreater")
	public UserBO findSectionCreater(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId) {
		SectionUser sectionUser = sectionUserService.findSectionCreater(sId);
		User user = userService.findUserById(sectionUser.getuId());
		System.out.println("版块-" + sId + "-寻找创建者");
		return new UserBO(user, sectionUser);
	}
}
