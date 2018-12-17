package com.itwins.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * Filter执行的顺序是，先执行init初始化，后执行doFilter，最后执行destroy销毁。
 * 通过@Order指定执行顺序。值越小，越先执行。销毁时也是这个顺序，值越小，越先销毁。
 * 通过过滤器的名字filterName，进行顺序的约定，
 * 比如LogFilter和AuthFilter，此时AuthFilter就会比LogFilter先执行，因为首字母A比L前面。
 * 如果两个Filter的filterName相同(一般不存在同名情况，除非配错了)，则只有最后启动的Filter起作用。
 */

//****在启动类中加上@ServletComponentScan注解即可****

/*****？？？？？为什么不起作用呢？？？？？？？
 * 【不起作用的原因是把Application的启动放在了controller这个包内了，拿在包外就可以了】
 * ****/

// 过滤器名称为customFilter, 拦截的url为所有
// @WebFilter时Servlet3.0新增的注解，原先实现过滤器，需要在web.xml中进行配置，
// 而现在通过此注解，启动启动时会自动扫描自动注册。
@WebFilter(filterName="customFilter", urlPatterns= {"/*"}) //urlPatterns = "/login/*"
@Order(value=1)
@Slf4j
public class CustomFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("CustomFilter 初始化...启动顺序1");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("CustomFilter doFilter处理请求...");
		log.info("CustomFilter 启动顺序1");
		// 对request、response进行一些预处理
		// 比如设置请求编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 主要业务逻辑处理
		log.info("CustomFilter 所有的业务逻辑在这里操作！业务逻辑处理完成！");
		
		// 链路，直接传给下一个过滤器
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("CustomFilter 销毁.");
//		log.info("CustomFilter 销毁，顺序1.");
	}

}
