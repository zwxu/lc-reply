package com.ustc.zwxu.lc.reply.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ustc.zwxu.lc.reply.web.view.DbUser;



@Controller
@RequestMapping("/error")
public class ErrorController {


	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/auth")
	public String auth(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		return "deniedpage";
	}
	
	@RequestMapping("/nologin")
	public String nologin(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		return "nologin";
	}
	
	
}
