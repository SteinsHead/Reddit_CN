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

import com.example.RedditCn.BusinessObject.PostReplyBO;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.annotation.UserIsPostFloorAdmin;
import com.example.RedditCn.annotation.UserIsSectionAdmin;
import com.example.RedditCn.annotation.UserIsSectionPostAdmin;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.PostReply;
import com.example.RedditCn.service.PostFloorService;
import com.example.RedditCn.service.PostReplyService;
import com.example.RedditCn.service.TokenUtils;
import com.example.RedditCn.service.UserSectionService;
import com.example.RedditCn.service.UserService;

@RestController
@RequestMapping("/postReply")
public class PostReplyController {
	@Autowired
	private PostReplyService postReplyService;
	@Autowired
	private UserSectionService userSectionService;
	@Autowired
	private UserService userService;
	@Autowired
	private PostFloorService postFloorService;

	@UserLoginToken
	@GetMapping("/findPostReplyBypfId")
	public List<PostReplyBO> findPostReplyBypfId(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postFloorId") int pfId) {
		List<PostReply> list1 = postReplyService.findPostReplyBypfId(sId, spId, pfId);
		List<UserBO> list2 = new ArrayList<UserBO>();
		for (int i = 0; i < list1.size(); i++) {
			list2.add(userService.createUserBO(sId, list1.get(i).getSuId()));
		}
		System.out.println("版块-" + sId + "-帖子-" + spId + "-楼层-" + pfId + "-寻找所有回复");
		return new PostReplyBO().ListPostReplyBO(list1, list2);
	}

	@UserLoginToken
	@PostMapping("/insertPostReply")
	public PostReply insertPostReply(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postFloorId") int pfId,
			@RequestParam(value = "postReplyIntroduce") String prIntroduce) {
		int suId = userSectionService.findUserSectionBuuIdAndsId(TokenUtils.verify(token), sId).getSuid();
		int prId = postReplyService.insertPostReply(sId, spId, suId, pfId, prIntroduce);
		postFloorService.updatePostFloorReply(sId, spId, pfId);
		System.out.println("版块-" + sId + "-帖子-" + spId + "-楼层-" + pfId + "-新建回复-" + prId);
		return postReplyService.findPostReplyByprId(sId, spId, prId);
	}

	@UserIsSectionAdmin
	@UserIsSectionPostAdmin
	@UserIsPostFloorAdmin
	@UserLoginToken
	@PostMapping("/banPostReply")
	public boolean banPostReply(@RequestParam(value = "sectionId") int sId,
			@RequestParam(value = "sectionPostId") int spId, @RequestParam(value = "postFloorId") int pfId,
			@RequestParam(value = "postReplyId") int prId) {
		System.out.print("版块-" + sId + "-帖子-" + spId + "-楼层-" + pfId + "-封禁回复-" + prId);
		return postReplyService.updatePostReplyBan(sId, spId, prId, "ban");
	}
}
