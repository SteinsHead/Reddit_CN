package com.example.RedditCn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RedditCn.entity.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Integer> {
	public List<Section> findAll();

	public Section findBysName(String sName);

}
