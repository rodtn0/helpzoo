package com.project.helpzoo.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event/*")
public class EventController {

	@RequestMapping("eventList")
	public String eventMain() {
		return "event/eventMain";
	}
	
	
}
