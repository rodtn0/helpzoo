package com.project.helpzoo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		
		for(QNABoard b : qnaList) {
			System.out.println(b);
		}
		
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("listCount", pInfo.getListCount());
		model.addAttribute("pInfo", pInfo);
		
		return "board/qnaMain";
	}
	
	// QNA 글쓰기 페이지로 이동
	@RequestMapping("insert")
	public String insertView() {
		return "board/qnaInsert";
	}
	
	@RequestMapping(value="insertAction", method=RequestMethod.POST)
	public String insertAction(QNABoard qnaBoard, Model model,
			@RequestParam(value="images", required=false) List<MultipartFile> images,
			HttpServletRequest request,
			Redirect) {
		
		// Member loginMember = (Member) model.getAttribute("loginMember");
		
		// qnaBoard.setQnaWriter(loginMember.getMemberNo()+"");
		qnaBoard.setQnaWriter(1+"");
		System.out.println(qnaBoard);
		for(int i=0; i<images.size(); i++) {
			System.out.println("images[" + i + "] :" + images.get(i).getOriginalFilename());
		}
		// 파일을 저장할 서버 컴퓨터의 로컬 경로
		String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
		
		
		int result = qnaService.insertBoard(qnaBoard, savePath, images);
		
		String url =null;
		if(result > 0) {
			
		}
		
		return null;
		
	}
	
	
}

