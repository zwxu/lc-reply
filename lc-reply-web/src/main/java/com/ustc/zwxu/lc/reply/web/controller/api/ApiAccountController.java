package com.ustc.zwxu.lc.reply.web.controller.api;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ustc.zwxu.lc.reply.web.domain.AccountQuery;
import com.zwxu.lc.um.api.AccountQueryService;
import com.zwxu.lc.um.api.AccountService;
import com.zwxu.lc.um.bean.AccountInfoResponse;
import com.zwxu.lc.um.bean.BaseResult;
import com.zwxu.lc.um.bean.QueryAccountResult;



@Controller
@RequestMapping("/api/account")
public class ApiAccountController {
	private static Logger logger = Logger.getLogger(ApiAccountController.class);
	
	@Resource
	private AccountQueryService accountQueryService;
	
	@Resource
	private AccountService accountService;

	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, AccountQuery query) {
		int start = query.getStart();
		int limit = query.getLimit();
		int offset = (start-1)*limit;
		int total = accountQueryService.queryAll().getCount();
		query.setTotal(total);
		List<AccountInfoResponse> result=accountQueryService.queryByPage(offset, limit);

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("query", query);
		ret.put("result", result);
		return ret;
	}
	
	@RequestMapping("/queryById")
	@ResponseBody
	public Object queryById(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		int id = Integer.parseInt(request.getParameter("id"));
		AccountInfoResponse data=accountQueryService.queryById(id);
		return data;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(HttpServletRequest request, AccountInfoResponse info) {
		
		BaseResult data=accountService.create(info);
		return data;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(HttpServletRequest request, AccountInfoResponse info) {
		int id = Integer.parseInt(request.getParameter("id"));
		BaseResult data=accountService.modify(info);
		return data;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(HttpServletRequest request, AccountInfoResponse info) {
		int id = Integer.parseInt(request.getParameter("id"));
		BaseResult data=accountService.delete(info);
		return data;
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public Object check(HttpServletRequest request, HttpServletResponse response,AccountInfoResponse info) {
		
		BaseResult data=accountService.check(info);
		if(data.isSuccess())
		{
			request.getSession().setAttribute("loginname", info.getLoginname());
			
			Cookie cookie = new Cookie("loginname", info.getLoginname());
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return data;
	}
}
