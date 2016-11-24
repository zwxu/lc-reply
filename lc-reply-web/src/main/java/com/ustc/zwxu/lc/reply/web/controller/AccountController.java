package com.ustc.zwxu.lc.reply.web.controller;


import java.io.IOException;
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


import com.zwxu.lc.um.bean.QueryResult;
import com.zwxu.lc.um.api.AccountQueryService;
import com.zwxu.lc.um.bean.AccountInfoResponse;

@Controller
@RequestMapping("/user")
public class AccountController {
	private static Logger logger = Logger.getLogger(AccountController.class);
	
	@Resource
	private AccountQueryService accountQueryService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		HttpSession session = request.getSession();
		String start = request.getParameter("start");
		if(start ==null)
		{
			start=String.valueOf(1);
		}
        int limit=2;
		QueryResult result=accountQueryService.queryPage(Integer.parseInt(start),limit);
		logger.info(result.getInfo());
		model.addAttribute("limit", limit) ;
		model.addAttribute("total", result.getCount()) ;
		model.addAttribute("start", Integer.parseInt(start));
		session.setAttribute("userList", result.getInfo());
		return "allUser";
	}
	
	@RequestMapping("/doLogin")
	public String checkUser(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		HttpSession session = request.getSession();
		String username = request.getParameter("loginname");
		boolean flag = accountQueryService.checkAccount(username);
		logger.info(flag);
		if(flag==true)
		{
			
			session.setAttribute("loginname", username);
			return "allUser";
		}
		return "loginpage";

	}

	
}
