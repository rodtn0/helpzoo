package com.project.helpzoo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.helpzoo.admin.model.service.AQNAService;
import com.project.helpzoo.admin.model.vo.QNABoard;

// ${contextPath}/admin/faq/faqList

@Controller
@RequestMapping("/admin/qna/*")
public class AQNAController {
	
	@Autowired
	private AQNAService qnaService;
	
	
	@RequestMapping("qnaList")
	public String qnaMain(Model model) {
		
		List<QNABoard> qnaList = qnaService.selectList();
		
		for(QNABoard qna : qnaList) {
			
			int qnaNo = qna.getQnaNo();
			
			int qnaAnswer = qnaService.selectAnswer(qnaNo);
			
			qna.setQnaAnswer(qnaAnswer);
			
			System.out.println(qna);
		}
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin/qna/adminqnaMain";
	}
	//"${contextPath}/admin/qna/"+ boardNo;
	
	@RequestMapping("{boardNo}")
	public ModelAndView qnaView(@PathVariable int boardNo, ModelAndView mv) {
		
		QNABoard board = qnaService.selectBoard(boardNo);
		
		return mv;
		
	}
	
}
