package com.ustc.zwxu.lc.reply.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zwxu.lc.um.api.MenuRoleQueryService;

public class PermissionRequiredInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(PermissionRequiredInterceptor.class);
	@Autowired
	MenuRoleQueryService menuRoleQueryService;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String url = request.getRequestURI();
    	logger.info("actionUrl is :" + url);
    	if(url.equals("/") || url.equals("/login") || url.equals("/api/account/check")){
    		return true;
    	}
    	
    	if(url.equals("/forbidden") || url.equals("/api/auth/menulist")){
    		return true;
    	}
    
		String username = (String) request.getSession().getAttribute("loginname");
	
		if(username == null || username.equals("")){
			logger.error("用户没有登录"); 

			return false;
		}
		
		
		
		
		boolean flag = menuRoleQueryService.hasRoleByUrl(url);
		if(flag == false)
		{
			
			response.sendRedirect("/forbidden");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
