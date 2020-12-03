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
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.PostFloor;
import com.example.RedditCn.service.PostFloorService;
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

	@UserLoginToken
	@PostMapping("/insertPostFloor")
	public PostFloor insertPostFloor(@RequestHeader(value = "token") String token,
			@RequestParam(value = "sectionId") int sId, @RequestParam(value = "sectionPostId") int spId,
			@RequestParam(value = "postFloorIntroduce") String pfIntroduce,
			@RequestParam(value = "postFloorPhoto") String pfPhoto) {
		int suId = userSectionService.findUserSectionBuuIdAndsId(TokenUtils.verify(token), sId).getSuid();
		int pfId = postFloorService.insertPostFloor(sId, spId, suId, pfIntroduce, pfPhoto);
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
		return new PostFloorBO().ListPostFloorBO(list1, list2);
	}
}
