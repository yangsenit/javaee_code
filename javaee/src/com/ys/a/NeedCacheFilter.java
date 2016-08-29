package com.ys.a;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NeedCacheFilter implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=filterConfig;

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request;
		HttpServletResponse response;
		long time=0;
	
		
		try{
			request=(HttpServletRequest)req;
			response=(HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("non-html request or response");
		}
		String uri=request.getRequestURI();
		String extension=uri.substring(uri.indexOf(".")+1);
		if("html".equals(extension)){
			time=Long.parseLong(filterConfig.getInitParameter("html"))*60*1000;
		}
		if("css".equals(extension)){
			time=Long.parseLong(filterConfig.getInitParameter("html"))*60*1000;
		}
		if("js".equals(extension)){
			time=Long.parseLong(filterConfig.getInitParameter("html"))*60*1000;
		}
		response.setHeader("expires",String.valueOf((System.currentTimeMillis()+time)));
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
