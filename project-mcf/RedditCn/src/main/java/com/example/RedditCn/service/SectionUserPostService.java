package com.example.RedditCn.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.BusinessObject.PostFloorListBO;
import com.example.RedditCn.BusinessObject.SectionPostListBO;
import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.PostFloor;
import com.example.RedditCn.entity.Section;
import com.example.RedditCn.entity.SectionPost;
import com.example.RedditCn.entity.SectionUserPost;
import com.example.RedditCn.entity.UserSection;
import com.example.RedditCn.mapper.PostFloorMapper;
import com.example.RedditCn.mapper.SectionPostMapper;
import com.example.RedditCn.mapper.SectionUserPostMapper;
import com.example.RedditCn.repository.SectionRepository;
import com.example.RedditCn.repository.UserSectionRepository;

@Service
public class SectionUserPostService {
	@Autowired
	private SectionUserPostMapper sectionUserPostMapper;
	@Autowired
	private UserSectionRepository userSectionRepository;
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private SectionPostMapper sectionPostMapper;
	@Autowired
	private PostFloorMapper postFloorMapper;

	private String tableName = "sectionuser_post_";

	public void createSectionUserPostTable(int sId) {
		try {
			sectionUserPostMapper.createTable(tableName + sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.createSectionUserPostTableFailed());
		}
	}

	public void insertSectionUserPost(int sId, int suId, int spId, int pfId) {
		try {
			sectionUserPostMapper.insertSectionUserPost(tableName + sId, suId, spId, pfId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.insertSectionUserPostFailed());
		}
	}

	public List<SectionUserPost> findSectionPostBysuId(int sId, int suId) {
		List<SectionUserPost> list;
		try {
			list = sectionUserPostMapper.findSectionPostBysuId(tableName + sId, suId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionUserPostBysuIdFailed());
		}
		return list;
	}

	public List<SectionUserPost> findPostFloorBysuId(int sId, int suId) {
		try {
			return sectionUserPostMapper.findPostFloorBysuId(tableName + sId, suId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findPostFloorBysuIdFailed());
		}
	}

	public List<SectionPostListBO> findUserSectionPost(int uId) {
		List<SectionPostListBO> list = new ArrayList<SectionPostListBO>();
		try {
			List<UserSection> list1 = userSectionRepository.findByUid(uId);
			List<SectionUserPost> list2 = new ArrayList<SectionUserPost>();
			for (int i = 0; i < list1.size(); i++) {
				int sId = list1.get(i).getSid();
				int suId = list1.get(i).getSuid();
				Section section = sectionRepository.findBySid(sId);
				list2 = findSectionPostBysuId(sId, suId);
				for (int j = 0; j < list2.size(); j++) {
					SectionPost sectionPost = sectionPostMapper.findByspId("sectionpost_" + sId,
							list2.get(j).getSpId());
					if (sectionPost != null)
						list.add(new SectionPostListBO(sId, section.getSname(), sectionPost));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionUserPostFailed());
		}
		Collections.sort(list);
		return list;
	}

	public List<PostFloorListBO> findUserPostFloor(int uId) {
		List<PostFloorListBO> list = new ArrayList<PostFloorListBO>();
		try {
			List<UserSection> list1 = userSectionRepository.findByUid(uId);
			List<SectionUserPost> list2 = new ArrayList<SectionUserPost>();
			for (int i = 0; i < list1.size(); i++) {
				int sId = list1.get(i).getSid();
				int suId = list1.get(i).getSuid();
				Section section = sectionRepository.findBySid(sId);
				list2 = findPostFloorBysuId(sId, suId);
				for (int j = 0; j < list2.size(); j++) {
					SectionPost sectionPost = sectionPostMapper.findByspId("sectionpost_" + sId,
							list2.get(j).getSpId());
					PostFloor postFloor = postFloorMapper.findByPfId(
							"sectionpost_" + sId + "_PostFloor_" + sectionPost.getSpId(), list2.get(j).getPfId());
					if (postFloor != null)
						list.add(new PostFloorListBO(section, sectionPost, postFloor));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
			// throw new RuntimeException(ErrorJsonObject.findSectionUserPostFloorFailed());
		}
		Collections.sort(list);
		return list;
	}
}
