package com.project.helpzoo.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@RequestMapping("noticeList")
	public String noticeMain() {
		return "notice/noticeMain";
	}
	
	
}
