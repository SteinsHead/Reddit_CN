package com.example.RedditCn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.RedditCn.mapper")
@SpringBootApplication
public class RedditCnApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCnApplication.class, args);
	}

}
