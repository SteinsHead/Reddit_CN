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

import com.example.RedditCn.BusinessObject.PostFloorBO;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.annotation.UserIsBan;
import com.example.RedditCn.annotation.UserIsSectionAdmin;
import com.example.RedditCn.annotation.UserIsSectionPostAdmin;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.PostFloor;
import com.example.RedditCn.service.PostFloorService;
import com.example.RedditCn.service.SectionPostService;
import com.example.RedditCn.service.SectionUserPostService;
import com.example.RedditCn.service.SectionUserService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserSectionService;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/postFloor")
public class PostFloorController {
	@Autowired
	private PostFloorService postFloorService;
	@Autowired
	private UserSectionService userSectionService;
	@Autowired
	private UserService userService;
	@Autowired
	private SectionPostService sectionPostService;
	@Autowired
	private SectionUserService sectionUserService;
	@Autowired
	private SectionUserPostService sectionUserPostService;

	@UserLoginToken
	@UserIsBan
	@PostMapping("/insertPostFloor")
	public PostFloor insertPostFloor(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postFloorIntroduce") String pfIntroduce,
			@RequestParam(value = "postFloorPhoto") String pfPhoto) {
		int suId = userSectionService.findUserSectionBuuIdAndsId(TokenUtils.verify(token), sId).getSuid();
		int pfId = postFloorService.insertPostFloor(sId, spId, suId, pfIntroduce, pfPhoto);
		sectionUserPostService.insertSectionUserPost(sId, suId, spId, pfId);
		sectionPostService.updateSectionPostFloor(sId, spId);
		sectionUserService.updateSectionUserRank(sId, suId, 3);
		System.out.println("版块-" + sId + "-帖子-" + spId + "-新建楼层-" + pfId);
		return postFloorService.findPostFloorBypfId(sId, spId, pfId);
	}

	@UserLoginToken
	@GetMapping("/findAllPostFloor")
	public List<PostFloorBO> findAllPostFloor(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId) {
		List<PostFloor> list1 = postFloorService.findAllPostFloor(sId, spId);
		List<UserBO> list2 = new ArrayList<UserBO>();
		for (int i = 0; i < list1.size(); i++) {
			list2.add(userService.createUserBO(sId, list1.get(i).getSuId()));
		}
		System.out.println("版块-" + sId + "-帖子-" + spId + "-寻找所有楼层");
		return new PostFloorBO().ListPostFloorBO(list1, list2);
	}

	@UserLoginToken
	@GetMapping("/findMinePostFloor")
	public List<PostFloorBO> findMineSectionPost(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId) {
		int suId = userSectionService.findUserSectionBuuIdAndsId(TokenUtils.verify(token), sId).getSuid();
		List<PostFloor> list1 = new ArrayList<PostFloor>();
		list1.add(postFloorService.findPostFloorBypfId(sId, spId, 100001));
		list1.addAll(postFloorService.findMinePostFloor(sId, spId, suId));
		List<UserBO> list2 = new ArrayList<UserBO>();
		list2.add(userService.createUserBO(sId, list1.get(0).getSuId()));
		for (int i = 1; i < list1.size(); i++) {
			list2.add(userService.createUserBO(sId, list1.get(i).getSuId()));
		}
		System.out.println("版块-" + sId + "-帖子-" + spId + "-查询帖子自己楼层");
		return new PostFloorBO().ListPostFloorBO(list1, list2);
	}

	@UserIsSectionAdmin
	@UserIsSectionPostAdmin
	@UserLoginToken
	@PostMapping("/banPostFloor")
	public boolean banPostFloor(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postFloorId") int pfId) {
		System.out.println("版块-" + sId + "-帖子-" + spId + "-封禁楼层-" + pfId);
		return postFloorService.updatePostFloorban(sId, spId, pfId, "ban");
	}
}
