package com.example.RedditCn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.Section;
import com.example.RedditCn.repository.SectionRepository;

@Service
public class SectionService {
	@Autowired
	private SectionRepository sectionRepository;

	public List<Section> findAll() {
		return sectionRepository.findAll();
	}
}
