package com.ustc.zwxu.lc.reply.web.controller.api;

import java.util.LinkedHashMap;
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
import com.zwxu.lc.um.api.TeacherQueryService;
import com.zwxu.lc.um.bean.QueryTeacherResult;



@Controller
@RequestMapping("/api/teacher")
public class ApiTeacherController {
	private static Logger logger = Logger.getLogger(ApiTeacherController.class);
	
	@Resource
	private TeacherQueryService teacherQueryService;

	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		QueryTeacherResult result=teacherQueryService.queryAll();
		logger.info(result.getInfo());
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("teacherList", result.getInfo());
		data.put("total", result.getCount());
		return data;
	}
}
