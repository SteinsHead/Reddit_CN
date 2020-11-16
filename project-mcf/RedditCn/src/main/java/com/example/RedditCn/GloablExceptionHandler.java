package com.example.RedditCn;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@ControllerAdvice
public class GloablExceptionHandler {
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Object handleException(Exception e) {
		String msg = e.getMessage();
		if (msg == null || msg.equals("")) {
			msg = "服务器出错";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", msg);
		return jsonObject;
	}
}
