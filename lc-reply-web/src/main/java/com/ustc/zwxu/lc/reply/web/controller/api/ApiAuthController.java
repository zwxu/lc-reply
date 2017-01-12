package com.ustc.zwxu.lc.reply.web.controller.api;

import java.util.ArrayList;
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
import com.zwxu.lc.um.api.MenuQueryService;
import com.zwxu.lc.um.bean.BaseResult;
import com.zwxu.lc.um.bean.QueryMenuResult;


@Controller
@RequestMapping("/api/auth")
public class ApiAuthController {
	private static Logger logger = Logger.getLogger(ApiAuthController.class);
	@Resource
	private MenuQueryService menuQueryService;
	
	@RequestMapping("/menulist")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("loginname");
		QueryMenuResult result=menuQueryService.queryAllByUserName(username);
		logger.info(menuQueryService);
		logger.info(result.getInfo());
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("menuList", result.getInfo());
		data.put("userName", username);
		
		return data;
	}
	
	@RequestMapping("/signOut")
	@ResponseBody
	public Object signOut(HttpServletRequest request,HttpServletResponse response) {
		BaseResult data = new BaseResult();
		data.setSuccess(true);
		request.getSession().invalidate();
		Cookie[] cookies = request.getCookies();
		for(Cookie c:cookies)
		{
			Cookie cookie = new Cookie("loginname",null); 
			cookie.setMaxAge(0); 
			cookie.setPath("/");//根据你创建cookie的路径进行填写 
			response.addCookie(cookie); 
		}
		
		
		return data;
	}
	
	/**
	 * 根据名字获取cookie
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
	    Map<String,Cookie> cookieMap = ReadCookieMap(request);
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	 
	 
	 
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
}

class Menu
{
	private int menuId;
	private String menuName;
	private String menuUrl;
	private boolean status;
	private int parentId;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}