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

	@GetMapping("/findPostReplyBypfId")
	public List<PostReplyBO> findPostReplyBypfId(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postReplyId") int pfId) {
		List<PostReply> list1 = postReplyService.findPostReplyBypfId(sId, spId, pfId);
		List<UserBO> list2 = new ArrayList<UserBO>();
		for (int i = 0; i < list1.size(); i++) {
			list2.add(userService.createUserBO(sId, list1.get(i).getSuId()));
		}
		return new PostReplyBO().ListPostReplyBO(list1, list2);
	}

	@PostMapping("/insertPostReply")
	public PostReply insertPostReply(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postFloorId") int pfId,
			@RequestParam(value = "postReplyIntroduce") String prIntroduce) {
		int suId = userSectionService.findUserSectionBuuIdAndsId(TokenUtils.verify(token), sId).getSuid();
		int prId = postReplyService.insertPostReply(sId, spId, suId, pfId, prIntroduce);
		postFloorService.updatePostFloorReply(sId, spId, pfId);
		return postReplyService.findPostReplyByprId(sId, spId, prId);
	}
}
