package com.itwins.springboot.filter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web组件配置
 * @author Administrator
 *
 */
@Configuration
public class WebComponent2Config {

	@Bean
	public FilterRegistrationBean<Filter> filterDemo1RegistrationBean() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(demo1Filter());
		Set<String> pSet = new HashSet<>();
		pSet.add("/*");
		registrationBean.setUrlPatterns(pSet);
		registrationBean.setName("demo1Filter");
		// 这种方式好像比直接在Filter上加@Order注解执行的要早。为什么？？
		registrationBean.setOrder(6);
		return registrationBean;
	}

	@Bean
	public Filter demo1Filter() {
		return new Demo1Filter();
	}
	
	@Bean
	public FilterRegistrationBean<Filter> filterDemo2RegistrationBean() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(demo2Filter());
		Set<String> pSet = new HashSet<>();
		pSet.add("/*");
		registrationBean.setUrlPatterns(pSet);
		registrationBean.setName("demo2Filter");
		registrationBean.setOrder(-10);
		return registrationBean;
	}

	@Bean
	public Filter demo2Filter() {
		return new Demo2Filter();
	}
	
}
