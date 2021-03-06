package com.ecommerce.orderprocessing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	@Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response,  Object handler) throws Exception {
	    
	    log.info("[preHandle][request:" + request + "]" + "[" + request.getMethod()+ "]" + request.getRequestURI());	    
	    return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	    
	    log.info("[postHandle][response:" + response.toString() + "][response code:" + response.getStatus() + "]" + response.getContentType() );
	}

}
