package com.itwins.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

//****在启动类中加上@ServletComponentScan注解即可****

/*****？？？？？为什么不起作用呢？？？？？？？
 * 【不起作用的原始是把Application的启动放在了controller这个包内了，拿在包外就可以了】
 * ****/

// 过滤器名称为customFilter, 拦截的url为所有
// @WebFilter时Servlet3.0新增的注解，原先实现过滤器，需要在web.xml中进行配置，
// 而现在通过此注解，启动启动时会自动扫描自动注册。
@WebFilter(filterName="customFilter2", urlPatterns= {"/*"}) //urlPatterns = "/login/*"
@Order(value=Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CustomFilter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("CustomFilter2 初始化...启动顺序Ordered.HIGHEST_PRECEDENCE");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("CustomFilter2 doFilter处理请求...");
		log.info("CustomFilter2 启动顺序Ordered.HIGHEST_PRECEDENCE");
		// 对request、response进行一些预处理
		// 比如设置请求编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 主要业务逻辑处理
		log.info("CustomFilter2 所有的业务逻辑在这里操作！业务逻辑处理完成！");
		
		// 链路，直接传给下一个过滤器
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("CustomFilter2 销毁.");
//		log.info("CustomFilter2销毁，顺序Ordered.HIGHEST_PRECEDENCE");
	}

}
