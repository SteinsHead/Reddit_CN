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
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.Section;
import com.example.RedditCn.service.SectionPostService;
import com.example.RedditCn.service.SectionService;
import com.example.RedditCn.service.SectionUserPostService;
import com.example.RedditCn.service.SectionUserService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserSectionService;

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

	// 查找所有版块
	@UserLoginToken
	@GetMapping("/findAllSection")
	public List<SectionBO> findAllSection() {
		List<Section> list = sectionService.findAll();
		return new SectionBO().ListSectionBO(list);
	}

	// 创建版块
	@UserLoginToken
	@PostMapping("/insertSection")
	public SectionBO insertSection(@RequestHeader(value = "token") String token,
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
		return new SectionBO(section);
	}
}
