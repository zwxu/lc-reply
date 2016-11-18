package com.ustc.zwxu.lc.reply.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api")
public class APIController {

	@RequestMapping(value = "/userList")
	public void userList(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String result = "{\"result\":\"error\"}";
		
		
		
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}
}
