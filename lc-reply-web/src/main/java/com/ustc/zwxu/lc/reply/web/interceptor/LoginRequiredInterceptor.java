package com.ustc.zwxu.lc.reply.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.zwxu.lc.um.api.AccountQueryService;

public class LoginRequiredInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(LoginRequiredInterceptor.class);
	
	@Resource
	private AccountQueryService accountQueryService;


	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

	    try {  
			
	    	String url = request.getRequestURI();
	    	logger.info("actionUrl is :" + url);
	    	if(url.equals("/login") || url.equals("/api/account/check")){
	    		return true;
	    	}
	    	
	    	if(url.equals("/api/auth/menulist") || url.equals("/api/auth/signOut")){
	    		return true;
	    	}
			
	    	String username = (String) request.getSession().getAttribute("loginname");
	    	
			/*if(url.equals("/")){
				if(!StringUtils.isEmpty(username))
				{
					
					if(request.getSession().getAttribute("auth") == null)
					{
						int rid = accountQueryService.queryByUserName(username);
						if(rid == 3)
						{
							response.sendRedirect("/forbidden");
							return false;
						}
					}
					
		    		return true;
				}
	    	}*/
			
			/*if(username == null || username.equals("")){
				logger.error("用户没有登录");

				return false;
			}*/

	    	
	    	
	    	
	    	
	    } catch (Exception e) { 
	    	logger.error(e);
	    } 
		
		return true;
	}

	

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("===============postHandle===============");
	}

	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===============after===============");
		
	}

}
