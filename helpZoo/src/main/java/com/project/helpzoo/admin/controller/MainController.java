package com.project.helpzoo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class MainController {

	
	@RequestMapping("main")
	public String adminMain() {
		return "admin/adminMain";
	}
}
