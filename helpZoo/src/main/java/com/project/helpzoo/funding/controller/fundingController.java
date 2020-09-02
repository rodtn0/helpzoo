package com.project.helpzoo.funding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/funding/*")
public class fundingController {
	
	@RequestMapping("fundingMain")
	public String faqMain() {
		return "funding/fundingMain";
	}
	

}
