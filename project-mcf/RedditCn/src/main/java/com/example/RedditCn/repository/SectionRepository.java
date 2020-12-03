package com.example.RedditCn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
	public List<Section> findAll();

	public Section findBySname(String sName);

	public Section findBySid(int sId);
}
