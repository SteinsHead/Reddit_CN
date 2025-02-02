package com.example.RedditCn.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.RedditCn.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User findById(int uId);

	public User findByUaccount(String uAccount);

	public User findByUphone(String uPhone);

	public User findByUemail(String uEmail);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update user set uphone = ?1 where uid = ?2", nativeQuery = true)
	public void updateUserPhone(String uPhone, int uId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update user set uemail = ?1 where uid = ?2", nativeQuery = true)
	public void updateUserEmail(String uEmail, int uId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update user set uname = ?1, usex = ?2, ubirthday = ?3, uintroduce = ?4, uphoto = ?5 where uid = ?6", nativeQuery = true)
	public void updateUserInformation(String uName, char uSex, Date uBirthday, String uIntroduce, String uPhoto,
			int uId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update user set ufollow = ufollow + 1 where uid = ?1", nativeQuery = true)
	public void updateUserFollow(int uId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update user set upublish = upublish + 1 where uid = ?1", nativeQuery = true)
	public void updateUserPublish(int uId);
}
