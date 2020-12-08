package com.example.RedditCn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.SectionUser;
import com.example.RedditCn.mapper.SectionUserMapper;

@Service
public class SectionUserService {
	@Autowired
	private SectionUserMapper sectionUserMapper;
	private String tableName = "sectionuser_";

	public void createSectionUserTable(int sId) {
		try {
			sectionUserMapper.createTable(tableName + sId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.createSectionUserTableFailed());
		}
	}

	public int insertSectionUser(int sId, int uId, String suPermission) {
		if (sectionUserMapper.findByuId(tableName + sId, uId) == null) {
			try {
				SectionUser sectionUser = new SectionUser(tableName + sId, uId, suPermission);
				sectionUserMapper.insertSectionUser(sectionUser);
				return sectionUser.getSuId();
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(ErrorJsonObject.insertSectionUserFailed());
			}
		} else {
			throw new RuntimeException(ErrorJsonObject.sectionUserExist());
		}
	}

	public SectionUser findSectionUserByuId(int sId, int uId) {
		SectionUser sectionUser;
		try {
			sectionUser = sectionUserMapper.findByuId(tableName + sId, uId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionUserByuIdFailed());
		}
		if (sectionUser == null)
			throw new RuntimeException(ErrorJsonObject.sectionUserNotExist());
		return sectionUser;
	}

	public SectionUser findSectionUserBysuId(int sId, int suId) {
		SectionUser sectionUser;
		try {
			sectionUser = sectionUserMapper.findBysuId(tableName + sId, suId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionUserBysuIdFailed());
		}
		if (sectionUser == null)
			throw new RuntimeException(ErrorJsonObject.sectionUserNotExist());
		return sectionUser;
	}

	public SectionUser findSectionCreater(int sId) {
		SectionUser sectionUser;
		try {
			sectionUser = sectionUserMapper.findBysuId(tableName + sId, 100001);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findSectionUserByuIdFailed());
		}
		if (sectionUser == null)
			throw new RuntimeException(ErrorJsonObject.sectionUserNotExist());
		return sectionUser;
	}

	public boolean updateSectionUserRank(int sId, int suId, int suRank) {
		try {
			sectionUserMapper.updateSuRank(tableName + sId, suRank, suId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateSectionUserRankFailed());
		}
		return true;
	}
}
