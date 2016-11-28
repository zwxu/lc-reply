package com.ustc.zwxu.lc.reply.web.controller.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zwxu.lc.um.api.MenuQueryService;
import com.zwxu.lc.um.bean.QueryMenuResult;


@Controller
@RequestMapping("/api/auth")
public class ApiAuthController {
	private static Logger logger = Logger.getLogger(ApiAuthController.class);
	@Resource
	private MenuQueryService menuQueryService;
	
	@RequestMapping("/menulist")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		QueryMenuResult result=menuQueryService.queryAllByRoleId(1);
		logger.info(menuQueryService);
		logger.info(result.getInfo());
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("menuList", result.getInfo());
		data.put("userName", "xuzhiwei");
		/*Map<String, Object> data = new LinkedHashMap<String, Object>();
		Menu m1= new Menu();
		m1.setMenuId(1);
		m1.setMenuName("学生");
		m1.setMenuUrl("/student/index");
		//m1.setStatus(true);
		m1.setParentId(0);
		Menu m2= new Menu();
		m1.setMenuId(2);
		m2.setMenuName("老师");
		m2.setMenuUrl("/teacher/index");
		//m2.setStatus(true);
		m2.setParentId(0);
		List<Menu> list = new ArrayList<Menu>();
		list.add(m1);
		list.add(m2);
		data.put("menuList", list);
		data.put("userName", "xuzhiwei");*/
		return data;
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