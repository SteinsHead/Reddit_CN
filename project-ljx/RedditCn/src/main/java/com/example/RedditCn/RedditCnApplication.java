package com.example.RedditCn;

import java.time.ZoneId;
import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@MapperScan("com.example.RedditCn.mapper")
@SpringBootApplication
public class RedditCnApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.SHORT_IDS.get("CTT")));
		SpringApplication.run(RedditCnApplication.class, args);
	}

}
