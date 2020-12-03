package com.example.RedditCn.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.RedditCn.BusinessObject.UserBO;
import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.SectionUser;
import com.example.RedditCn.entity.User;
import com.example.RedditCn.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SectionUserService sectionUserService;

	public boolean loginUpByAccount(String uName, String uAccount, String uPassword, char uSex, Date uBirthday,
			String uPhoto) {
		String ac = "^[a-zA-Z][a-zA-Z1-9-]{7,29}$";
		String ps = "^[a-zA-Z0-9_-]{6,30}$";
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
		String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String ph = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
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
		if (user == null)
			throw new RuntimeException(ErrorJsonObject.userNotExist());
		return user;
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

	public UserBO createUserBO(int sId, int suId) {
		SectionUser sectionUser = sectionUserService.findSectionUserBysuId(sId, suId);
		return new UserBO(this.findUserById(sectionUser.getuId()), sectionUser);
	}
}
