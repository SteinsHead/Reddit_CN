package com.example.RedditCn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedditCn.BusinessObject.SectionPostBO;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.annotation.UserIsSectionAdmin;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.SectionPost;
import com.example.RedditCn.service.PostFloorService;
import com.example.RedditCn.service.PostReplyService;
import com.example.RedditCn.service.SectionPostService;
import com.example.RedditCn.service.SectionService;
import com.example.RedditCn.service.SectionUserPostService;
import com.example.RedditCn.service.SectionUserService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserSectionService;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/sectionPost")
public class SectionPostController {
	@Autowired
	private SectionPostService sectionPostService;
	@Autowired
	private PostFloorService postFloorService;
	@Autowired
	private UserSectionService userSectionService;
	@Autowired
	private PostReplyService postReplyService;
	@Autowired
	private SectionUserPostService sectionUserPostService;
	@Autowired
	private UserService userService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private SectionUserService sectionUserService;

	@UserLoginToken
	@PostMapping("/insertSectionPost")
	public SectionPost insertSectionPost(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostName") String spName,
			@RequestParam(value = "sectionPostPhoto") String spPhoto) {
		int uId = TokenUtils.verify(token);
		int suId = userSectionService.findUserSectionBuuIdAndsId(uId, sId).getSuid();
		int spId = sectionPostService.insertSectionPost(sId, suId, spName, spPhoto);
		postFloorService.createPostFloorTable(sId, spId);
		postReplyService.createPostReplyTable(sId, spId);
		sectionUserPostService.createSectionUserPostTable(sId);
		postFloorService.insertPostFloor(sId, spId, suId, spName, spPhoto);
		sectionUserPostService.insertSectionUserPost(sId, suId, spId);
		userService.updateUserPublish(uId);
		sectionService.updateSectionPublish(sId);
		sectionUserService.updateSectionUserRank(sId, suId, 5);
		System.out.println("版块-" + sId + "-新建帖子-" + spId);
		return sectionPostService.findSectionPostByspId(sId, spId);
	}

	@UserLoginToken
	@GetMapping("/findAllSectionPost")
	public List<SectionPostBO> findAllSectionPost(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId) {
		List<SectionPost> list1 = sectionPostService.findAll(sId);
		List<UserBO> list2 = new ArrayList<UserBO>();
		for (int i = 0; i < list1.size(); i++) {
			list2.add(userService.createUserBO(sId, list1.get(i).getSuId()));
		}
		System.out.println("版块-" + sId + "-寻找所有帖子");
		return new SectionPostBO().listSectionPostBOBO(list1, list2);
	}

	@UserLoginToken
	@UserIsSectionAdmin
	@PostMapping("/banSectionPost")
	public boolean banSectionPost(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId) {
		System.out.println("版块-" + sId + "-封禁帖子-" + spId);
		return sectionPostService.updateSectionPostBan(sId, "ban", spId);
	}
}
