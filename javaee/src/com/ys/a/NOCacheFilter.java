package com.ys.a;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 控制动态资源不要缓存
public class NOCacheFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request;
		HttpServletResponse response;
		try{
			request=(HttpServletRequest)req;
			response=(HttpServletResponse)res;
		}catch(Exception e){
			throw new RuntimeException("non-http response or request");
		}
		
		response.setHeader("pragma", "no-cache"); // http1.0的头
		response.setHeader("cache-control", "no-chche"); // http1.1的头
		response.setHeader("expires","0");  //控制缓存时间，只要比当前时间小即可
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
