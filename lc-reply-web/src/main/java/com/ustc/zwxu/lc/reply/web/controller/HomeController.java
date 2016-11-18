/**
 * 
 */
package com.ustc.zwxu.lc.reply.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hlw
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/home")
	public String index(@RequestParam String name, Model model){
		model.addAttribute("name", name);
		return "default";
	}
}
