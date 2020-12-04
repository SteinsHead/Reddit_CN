package com.example.RedditCn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.RedditCn.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
	public List<Section> findAll();

	public Section findBySname(String sName);

	public Section findBySid(int sId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update section set sfollow = sfollow + 1 where sid = ?1", nativeQuery = true)
	public void updateSectionFollow(int sId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update section set spublish = spublish + 1 where sid = ?1", nativeQuery = true)
	public void updateSectionPublish(int sId);
}
