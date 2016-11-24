package com.ustc.zwxu.lc.reply.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.zwxu.lc.um.api.AccountQueryService;

public class LoginInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	@Resource
	private AccountQueryService accountQueryService;

	/**
	 * 前置方法，从前向后执行
	 * 在执行Handler之前执行
	 * 返回值：true：继续向下执行
	 *      false：终止执行
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("loginname");
		if(username == null)
		{
			logger.info("error");
			return false;
		}
		boolean flag = accountQueryService.checkAccount(username);
		logger.info(flag);
		if(flag)
		{
			return true;
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
		
		return false;
	}

	/**
	 * 后置方法，执行完handler之后执行，从后向前执行
	 * 整个拦截器中的所有的后置方法都不再执行
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===============这是后置方法===============");
	}

	/**
	 * 完成方法，视图渲染完成之后执行，从后向前执行
	 * 如果前置方法返回false， 之前执行的拦截器，的完成方法会执行
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===============这是完成方法===============");
		
	}

}
