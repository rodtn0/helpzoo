package com.project.helpzoo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.helpzoo.board.model.service.QNAService;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;

@Controller
@RequestMapping("/qna/*")
public class QNAController {
	
	@Autowired
	private QNAService qnaService;
	
	// QNA 메인 페이지로 이동
	@RequestMapping("qnaList")
	public String qnaMain(@RequestParam(value="cp", required=false,
							defaultValue="1")int cp, Model model) {
		
		PageInfo pInfo = qnaService.pagination(cp);
		
		System.out.println(pInfo);
		
		List<QNABoard> qnaList = qnaService.selectList(pInfo);
		
//		for(QNABoard b : qnaList) {
//			System.out.println(b);
//		}
		
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("listCount", pInfo.getListCount()+1);
		
		return "board/qnaMain";
	}
}

