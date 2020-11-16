package com.example.RedditCn.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedditCn.entity.PostReply;
import com.example.RedditCn.entity.Section;
import com.example.RedditCn.entity.SectionPost;
import com.example.RedditCn.service.PostReplyService;
import com.example.RedditCn.service.SectionPostService;
import com.example.RedditCn.service.SectionService;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/testBoot")
public class UserController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!";
	}

	@Autowired
	private UserService userService;

	@GetMapping("getUser/{id}")
	public String GetUser(@PathVariable int id) {
		return userService.Sel(id).toString();
	}

	@Autowired
	private PostReplyService postReplyService;

	@GetMapping("getPostReply/{prId}")
	public PostReply GetPostReply(@PathVariable int prId) {
		return postReplyService.Sel(prId);
	}

	@Autowired
	private SectionPostService sectionPostService;

	@GetMapping("getSectionPost/{spId}")
	public SectionPost getSectionPost(@PathVariable int spId) {
		return sectionPostService.Sel(spId);
	}

	@RequestMapping("createSectionPost")
	public void createSectionPost(@Param(value = "tableName") String tableName) {
		sectionPostService.createSectionTanle(tableName);
	}

	@Autowired
	private SectionService sectionService;

	@GetMapping("getSection")
	public List<Section> getSections() {
		return sectionService.findAll();
	}

}
