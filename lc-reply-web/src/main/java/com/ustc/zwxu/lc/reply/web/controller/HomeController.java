/**
 * 
 */
package com.ustc.zwxu.lc.reply.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuzhiwei
 * @RequestParam  不存在时，要转向404，此时为原型模式 相对于Struts
 *
 */
@Controller
public class HomeController {
	
	@Value(value = "${web.assets.env}")
	private String assetsEnv;
	
	@RequestMapping("/")
	//@RequestMapping(value = {"/"})
	public String index_nologin(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> vars) {
		return assetsEnv+"_index";
	}
	
	@RequestMapping(value = {"/login"})
    public String login(HttpServletRequest request) {
        //return redirect(request, "/loginpage");
        return "loginpage";
    }
	
	public static String redirect(HttpServletRequest request, String path) {
        String url = String.format("redirect:%s/#" + path,
                request.getContextPath());

        return url;
    }
	
	@RequestMapping(value = {"/pub"}, params = "nologin=true")
	public String pub_index_nologin(HttpServletRequest request, HttpServletResponse response, @PathVariable Map<String, String> vars) {
		return assetsEnv + "_index";
	}
}
