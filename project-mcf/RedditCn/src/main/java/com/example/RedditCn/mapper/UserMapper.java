package com.example.RedditCn.mapper;

import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.User;

@Repository
public interface UserMapper {
	User Sel(int id);
}