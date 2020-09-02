package com.project.helpzoo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ${contextPath}/admin/faq/faqList
@Controller
@RequestMapping("/admin/faq/*")
public class AFAQController {
	
	
	@RequestMapping("faqList")
	public String faqMain() {
		return "admin/faq/adminqnaMain";
	}
	
}
