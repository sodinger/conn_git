package com.itwins.springboot.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		WebMvcConfigurer.super.addInterceptors(registry);
		// 注册拦截器，拦截规则
		// 多个拦截器时，依次添加。按照添加顺序先后执行。
		registry.addInterceptor(getLastHandlerIntercepter());
		registry.addInterceptor(getCustomHandlerIntercepter());
		/*******请求前先调用preHandle的拦截器，则请求后后调用postHandle拦截器，回调方法afterCompletion也是后调用****/
	}
	
	@Bean
	public HandlerInterceptor getCustomHandlerIntercepter() {
		return new CustomHandlerIntercepter();
	}
	
	@Bean
	public HandlerInterceptor getLastHandlerIntercepter() {
		return new LastHandlerIntercepter();
	}

}
