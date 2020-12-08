package com.example.RedditCn.Interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.RedditCn.annotation.PassToken;
import com.example.RedditCn.annotation.UserIsBan;
import com.example.RedditCn.annotation.UserIsPostFloorAdmin;
import com.example.RedditCn.annotation.UserIsSectionAdmin;
import com.example.RedditCn.annotation.UserIsSectionPostAdmin;
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.PostFloor;
import com.example.RedditCn.entity.SectionPost;
import com.example.RedditCn.entity.SectionUser;
import com.example.RedditCn.entity.User;
import com.example.RedditCn.service.PostFloorService;
import com.example.RedditCn.service.SectionPostService;
import com.example.RedditCn.service.SectionUserService;
import com.example.RedditCn.service.UserService;

public class AuthenticationInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
	@Autowired
	private SectionUserService sectionUserService;
	private static final String TOKEN_SECRET = "MCFTKJWSGREDDITCN";
	@Autowired
	private SectionPostService sectionPostService;
	@Autowired
	private PostFloorService postFloorService;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object object) throws Exception {
		String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
		// 如果不是映射到方法直接通过
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		// 检查是否有passtoken注释，有则跳过认证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		// 检查有没有需要用户权限的注解
		int uId = 0;
		if (method.isAnnotationPresent(UserLoginToken.class)) {
			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
			if (userLoginToken.required()) {
				// 执行认证
				if (token == null) {
					throw new RuntimeException(ErrorJsonObject.tokenNull());
				}
				// 获取 token 中的 openId

				DecodedJWT jwt;
				try {
					Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
					JWTVerifier verifier = JWT.require(algorithm).build();
					jwt = verifier.verify(token);
					uId = jwt.getClaim("uId").asInt();
				} catch (Exception j) {
					throw new RuntimeException(ErrorJsonObject.tokenInvalid());
				}
				Date date = jwt.getExpiresAt();
				if (date.before(new Date(System.currentTimeMillis()))) {
					throw new RuntimeException(ErrorJsonObject.tokenOverdue());
				}
				User user = userService.findUserById(uId);
				if (user == null) {
					throw new RuntimeException(ErrorJsonObject.userNotExist());
				}
			}
		}

		if (method.isAnnotationPresent(UserIsBan.class)) {
			int sId = Integer.parseInt(httpServletRequest.getParameter("sectionId"));
			UserIsBan userIsBan = method.getAnnotation(UserIsBan.class);
			if (userIsBan.required()) {
				SectionUser sectionUser;
				sectionUser = sectionUserService.findSectionUserByuId(sId, uId);
				String suBan = sectionUser.getSuBan();
				if (suBan != null) {
					if (suBan.equals("ban"))
						throw new RuntimeException(ErrorJsonObject.sectionUserIsBan());
				}
			}
		}

		if (method.isAnnotationPresent(UserIsSectionAdmin.class)) {
			int sId = Integer.parseInt(httpServletRequest.getParameter("sectionId"));
			UserIsSectionAdmin userIsSectionAdmin = method.getAnnotation(UserIsSectionAdmin.class);
			if (userIsSectionAdmin.required()) {
				SectionUser sectionUser;
				sectionUser = sectionUserService.findSectionUserByuId(sId, uId);
				String suPermission = sectionUser.getSuPermission();
				if (suPermission != null) {
					if (!(suPermission.equals("creater") | suPermission.equals("admin"))) {
						throw new RuntimeException(ErrorJsonObject.notEnoughPermission());
					}
				} else {
					if (method.isAnnotationPresent(UserIsSectionPostAdmin.class)) {
						UserIsSectionPostAdmin userIsSectionPostAdmin = method
								.getAnnotation(UserIsSectionPostAdmin.class);
						if (userIsSectionPostAdmin.required()) {
							int spId = Integer.parseInt(httpServletRequest.getParameter("sectionPostId"));
							SectionPost sectionPost = sectionPostService.findSectionPostByspId(sId, spId);
							if (sectionPost != null) {
								if (sectionPost.getSpId() != sectionUser.getSuId()) {
									if (method.isAnnotationPresent(UserIsPostFloorAdmin.class)) {
										UserIsPostFloorAdmin userIsPostFloorAdmin = method
												.getAnnotation(UserIsPostFloorAdmin.class);
										if (userIsPostFloorAdmin.required()) {
											System.out.print("1");
											int pfId = Integer.parseInt(httpServletRequest.getParameter("postFloorId"));
											PostFloor postFloor = postFloorService.findPostFloorBypfId(sId, spId, pfId);
											if (postFloor != null) {
												System.out.print(postFloor.getSuId() + " " + sectionUser.getSuId());
												if (postFloor.getSuId() != sectionUser.getSuId()) {
													throw new RuntimeException(ErrorJsonObject.notEnoughPermission());
												}
											} else {
												throw new RuntimeException(ErrorJsonObject.postFloorNotExist());
											}
										}
									} else {
										throw new RuntimeException(ErrorJsonObject.notEnoughPermission());
									}
								}
							} else {
								throw new RuntimeException(ErrorJsonObject.sectionPostNotExist());
							}
						}
					} else {
						throw new RuntimeException(ErrorJsonObject.notEnoughPermission());
					}
				}
			}
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
