package com.ustc.zwxu.lc.reply.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Application Lifecycle Listener implementation class FreemarkerFilter
 * 
 */
public class FreemarkerFilter implements Filter {

	private String suffix;

	private ApplicationContext ctx;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		suffix = filterConfig.getInitParameter("suffix");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (ctx == null) {
			ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession().getServletContext());
			if (null == ctx) {
				throw new ExceptionInInitializerError("spring context is not loaded!");
			}
		}
		try {
			String name = req.getRequestURI();
			name = name.substring(req.getContextPath().length() + 1, name.lastIndexOf(suffix));
			FreeMarkerViewResolver viewResolver = ctx.getBean(FreeMarkerViewResolver.class);
			FreeMarkerConfigurer configurer = ctx.getBean(FreeMarkerConfigurer.class);
			View view = viewResolver.resolveViewName(name, configurer.getConfiguration().getLocale());
			if (view != null) {
				view.render(null, req, res);
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {

	}

}
