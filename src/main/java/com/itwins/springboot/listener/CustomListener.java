package com.itwins.springboot.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class CustomListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		log.info("CustomListener监听器 销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		log.info("CustomListener监听器 初始化");
	}

}
