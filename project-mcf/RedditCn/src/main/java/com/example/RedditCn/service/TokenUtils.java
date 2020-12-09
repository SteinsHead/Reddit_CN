package com.example.RedditCn.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.RedditCn.entity.ErrorJsonObject;

public class TokenUtils {
	// 设置过期时间
	private static final long EXPIRE_DATE = 6 * 60 * 60 * 1000;
	// token秘钥
	private static final String TOKEN_SECRET = "MCFTKJWSGREDDITCN";

	public static String token(int uId) {

		String token = "";
		try {
			// 过期时间
			Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
			// 秘钥及加密算法
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			// 设置头部信息
			Map<String, Object> header = new HashMap<>();
			header.put("typ", "JWT");
			header.put("alg", "HS256");
			// 携带uId信息，生成签名
			token = JWT.create().withHeader(header).withClaim("uId", uId).withExpiresAt(date).sign(algorithm);
		} catch (Exception e) {
			throw new RuntimeException(ErrorJsonObject.createTokenFailed());
		}
		return token;
	}

	public static int verify(String token) {
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT jwt = verifier.verify(token);
		return jwt.getClaim("uId").asInt();
	}
}
