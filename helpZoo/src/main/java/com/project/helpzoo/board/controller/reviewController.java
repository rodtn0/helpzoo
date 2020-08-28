package com.project.helpzoo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class reviewController {

	@RequestMapping("review")
	public String reviewPg() {
		return "board/reviewMain";
	}
}
