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
import com.zwxu.lc.um.api.StudentQueryService;
import com.zwxu.lc.um.bean.QueryStudentResult;


@Controller
@RequestMapping("/api/student")
public class ApiStudentController {
	private static Logger logger = Logger.getLogger(ApiStudentController.class);
	
	@Resource
	private StudentQueryService studentQueryService;

	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable Map<String, String> vars) {
		QueryStudentResult result=studentQueryService.queryAll();
		logger.info(result.getInfo());
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("studentList", result.getInfo());
		data.put("total", result.getCount());
		return data;
	}
}
