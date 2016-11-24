package com.ustc.zwxu.lc.reply.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.zwxu.lc.um.api.AccountQueryService;

public class LoginInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	@Resource
	private AccountQueryService accountQueryService;


	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
	/*	HttpSession session = request.getSession();
		String username=(String) session.getAttribute("loginname");
		if(username == null)
		{
			request.getRequestDispatcher("/loginpage.html").forward(request,response); 
			return false;
		}*/
		
		
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
