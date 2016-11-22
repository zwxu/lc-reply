package com.ustc.zwxu.lc.reply.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zwxu.lc.um.api.UserQueryService;
import com.zwxu.lc.um.bean.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserQueryService userQueryService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		HttpSession session = request.getSession();
		String start = request.getParameter("start");
		if(start ==null)
		{
			start=String.valueOf(1);
		}
		int limit = 2;
		
		model.addAttribute("limit", limit) ;
		model.addAttribute("total", 6) ;
		model.addAttribute("start", Integer.parseInt(start));
		List<UserInfo> list=userQueryService.queryPage(Integer.parseInt(start),limit);
		session.setAttribute("userList", list);
		return "allUser";
	}

	
}
