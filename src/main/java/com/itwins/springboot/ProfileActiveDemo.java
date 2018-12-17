package com.itwins.springboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

// 当启动dev环境时，会触发。
@Profile("dev") // 支持数组，@Profile({"dev", "test"})
@Configuration
@Slf4j
public class ProfileActiveDemo {
	
	@Value("${sboot.name}")
	private String name;

	@PostConstruct
	public void init() {
		log.info("dev环境");
		System.err.println("dev环境" + name);
	}
	
}
