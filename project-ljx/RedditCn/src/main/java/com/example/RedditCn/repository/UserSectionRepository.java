package com.example.RedditCn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.UserSection;

@Repository
public interface UserSectionRepository extends CrudRepository<UserSection, Integer> {
	public List<UserSection> findByUid(int uId);

	public UserSection findByUidAndSid(int uId, int sId);
}
