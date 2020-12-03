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
import com.example.RedditCn.annotation.UserLoginToken;
import com.example.RedditCn.entity.ErrorJsonObject;
import com.example.RedditCn.entity.User;
import com.example.RedditCn.service.UserService;

public class AuthenticationInterceptor implements HandlerInterceptor {
	@Autowired
	UserService userService;
	private static final String TOKEN_SECRET = "MCFTKJWSGREDDITCN";

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
		if (method.isAnnotationPresent(UserLoginToken.class)) {
			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
			if (userLoginToken.required()) {
				// 执行认证
				if (token == null) {
					throw new RuntimeException(ErrorJsonObject.tokenNull());
				}
				// 获取 token 中的 openId
				int uId;
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
				return true;
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
