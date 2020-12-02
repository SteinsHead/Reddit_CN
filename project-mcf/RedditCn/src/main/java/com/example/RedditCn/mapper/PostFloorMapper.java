package com.example.RedditCn.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.PostFloor;

@Repository
public interface PostFloorMapper {
	public List<PostFloor> findAll(String tableName);

	public PostFloor findBypfId(String tableName, int pfId);

	public void createTable(String tableName);

	public void insertPostFloor(PostFloor postFloor);

	public void updatePfReply(String tableName, int pfId);
}
