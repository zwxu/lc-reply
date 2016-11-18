package com.ustc.zwxu.lc.reply.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor2 implements HandlerInterceptor{

	/**
	 * 前置方法，从前向后执行
	 * 在执行Handler之前执行
	 * 返回值：true：继续向下执行
	 *      false：终止执行
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===============这是前置方法2===============");
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
		System.out.println("===============这是后置方法2===============");
	}

	/**
	 * 完成方法，视图渲染完成之后执行，从后向前执行
	 * 如果前置方法返回false， 之前执行的拦截器，的完成方法会执行
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===============这是完成方法2===============");
		
	}

}
