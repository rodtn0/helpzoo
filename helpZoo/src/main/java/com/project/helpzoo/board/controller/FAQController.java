package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.helpzoo.board.model.service.FAQService;
import com.project.helpzoo.board.model.vo.Board;

@Controller
@RequestMapping("/faq/*")
public class FAQController {

	@Autowired
	private FAQService faqService;
	// FAQ 메인 페이지로 이동
	@RequestMapping("faqList")
	public String faqMain(Model model) {
		
		int type = 3;
		
		List<Board> boardList = faqService.selectList(type);
		
		for(Board b : boardList) {
			System.out.println(b);
		}
		model.addAttribute("faqList", boardList);
		
		return "board/faqMain";
	}
	
}
