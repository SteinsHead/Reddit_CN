package com.example.RedditCn.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.RedditCn.BusinessObject.SectionListBO;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.BusinessObject.UserSectionBO;
import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.SectionUser;
import com.example.RedditCn.entity.User;
import com.example.RedditCn.entity.UserSection;
import com.example.RedditCn.mapper.SectionUserMapper;
import com.example.RedditCn.repository.SectionRepository;
import com.example.RedditCn.repository.UserRepository;
import com.example.RedditCn.repository.UserSectionRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SectionUserService sectionUserService;
	@Autowired
	private UserSectionRepository userSectionRepository;
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private SectionUserMapper sectionUserMapper;

	public boolean loginUpByAccount(String uName, String uAccount, String uPassword, char uSex, Date uBirthday,
			String uPhoto) {
		String ac = "^[a-zA-Z][a-zA-Z1-9-]{7,29}$";//account
		String ps = "^[a-zA-Z0-9_-]{6,30}$";//password
		if (uAccount.matches(ac) && uPassword.matches(ps)) {
			if (userRepository.findByUaccount(uAccount) == null) {
				try {
					if (uPhoto.equals(""))
						uPhoto = null;
					userRepository.save(new User(uName, uAccount, uPassword, uSex, uBirthday, uPhoto));
				} catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException(ErrorJsonObject.loginUpFailed());
				}
			} else {
				throw new RuntimeException(ErrorJsonObject.duplicateAccount());
			}
		} else {
			throw new RuntimeException(ErrorJsonObject.userAccountOrPasswordInvalid());
		}
		return true;
	}

	public String loginInByAnyway(String uAccount, String uPassword) {
		String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";//email
		String ph = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";//phone
		User user;
		if (uAccount.matches(ph)) {
			user = userRepository.findByUphone(uAccount);
		} else if (uAccount.matches(em)) {
			user = userRepository.findByUemail(uAccount);
		} else {
			user = userRepository.findByUaccount(uAccount);
		}
		if (user == null) {
			throw new RuntimeException(ErrorJsonObject.userNotExist());
		} else if (uPassword.equals(user.getUpassword())) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("token", TokenUtils.token(user.getUid()));
			return jsonObject.toJSONString();
		} else {
			throw new RuntimeException(ErrorJsonObject.wrongAccountOrPassword());
		}
	}

	public User findUserById(int uId) {
		User user;
		try {
			user = userRepository.findById(uId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.findUserInformationFailed());
		}
		return user;
	}

	public UserSectionBO findUserInformationById(int uId) {
		User user;
		List<SectionListBO> list1 = new ArrayList<SectionListBO>();
		try {
			user = userRepository.findById(uId);
			List<UserSection> list2 = userSectionRepository.findByUid(uId);
			if (list2 != null) {
				for (int i = 0; i < list2.size(); i++) {
					list1.add(new SectionListBO(sectionRepository.findBySid(list2.get(i).getSid()),
							sectionUserMapper.findByuId("sectionuser_" + list2.get(i).getSid(), uId)));
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
			// throw new RuntimeException(ErrorJsonObject.findUserInformationFailed());
		}
		return new UserSectionBO(user, list1);
	}

	public boolean updateUserPhone(int uId, String uPhone) {
		String ph = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
		if (userRepository.findByUphone(uPhone) == null && uPhone.matches(ph)) {
			try {
				userRepository.updateUserPhone(uPhone, uId);
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(ErrorJsonObject.updatePhoneFailed());
			}
		} else {
			throw new RuntimeException(ErrorJsonObject.phoneExist());
		}
		return true;
	}

	public boolean updateUserEmail(int uId, String uEmail) {
		String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (userRepository.findByUemail(uEmail) == null && uEmail.matches(em)) {
			try {
				userRepository.updateUserEmail(uEmail, uId);
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(ErrorJsonObject.updateEmailFailed());
			}
		} else {
			throw new RuntimeException(ErrorJsonObject.emailExist());
		}
		return true;
	}

	public boolean updateUserInformation(String uName, char uSex, Date uBirthday, String uPhoto, String uIntroduce,
			int uId) {
		try {
			userRepository.updateUserInformation(uName, uSex, uBirthday, uIntroduce, uPhoto, uId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateIntroduceFailed());
		}
		return true;
	}

	public boolean updateUserFollow(int uId) {
		try {
			userRepository.updateUserFollow(uId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateUserFollowFailed());
		}
		return true;
	}

	public boolean updateUserPublish(int uId) {
		try {
			userRepository.updateUserPublish(uId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(ErrorJsonObject.updateSectionPublishFailed());
		}
		return true;
	}

	public UserBO createUserBO(int sId, int suId) {
		SectionUser sectionUser = sectionUserService.findSectionUserBysuId(sId, suId);
		return new UserBO(this.findUserById(sectionUser.getuId()), sectionUser);
	}
}
