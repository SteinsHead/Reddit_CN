package com.example.RedditCn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedditCn.BusinessObject.SectionBO;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.Section;
import com.example.RedditCn.service.SectionPostService;
import com.example.RedditCn.service.SectionService;
import com.example.RedditCn.service.SectionUserPostService;
import com.example.RedditCn.service.SectionUserService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserSectionService;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/section")
public class SectionController {
	@Autowired
	private SectionService sectionService;
	@Autowired
	private SectionUserService sectionUserService;
	@Autowired
	private UserSectionService userSectionService;
	@Autowired
	private SectionPostService sectionPostService;
	@Autowired
	private SectionUserPostService sectionUserPostService;
	@Autowired
	private UserService userService;

	// 查找所有版块
	@UserLoginToken
	@GetMapping("/findAllSection")
	public List<Section> findAllSection() {
		System.out.println("寻找所有版块");
		return sectionService.findAll();
	}

	// 创建版块
	@UserLoginToken
	@PostMapping("/insertSection")
	public Section insertSection(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionName") String sName,
			@RequestParam(value = "sectionIntroduce") String sIntroduce,
			@RequestParam(value = "sectionPhoto") String sPhoto) {
		int uId = TokenUtils.verify(token);
		Section section = sectionService.insertSection(sName, sIntroduce, uId, sPhoto);
		int sId = section.getSid();
		sectionUserService.createSectionUserTable(sId);
		sectionPostService.createSectionPostTable(sId);
		sectionUserPostService.createSectionUserPostTable(sId);
		int suId = sectionUserService.insertSectionUser(sId, uId, "creater");
		userSectionService.insertUserSection(uId, sId, suId);
		userService.updateUserFollow(uId);
		System.out.println("新建版块-" + sId);
		return section;
	}

	@UserLoginToken
	@GetMapping("/findSectionBysId")
	public SectionBO findSectionBysId(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId) {
		Section section = sectionService.findBysId(sId);
		System.out.println("查询版块信息-" + sId);
		return new SectionBO(section,
				new UserBO(userService.findUserById(section.getUid()), sectionUserService.findSectionCreater(sId)));
	}
}
