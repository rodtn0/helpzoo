package com.project.helpzoo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.board.model.service.QNAService;
import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;
import com.project.helpzoo.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember"})
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
		
		/*
		 * for(QNABoard b : qnaList) { System.out.println(b); }
		 */
		
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
	
	// Q&A 글쓰기
	@RequestMapping(value="insertAction", method=RequestMethod.POST)
	public String insertAction(QNABoard qnaBoard, Model model, String qnaContent,
			@RequestParam(value="images", required=false) List<MultipartFile> images,
			HttpServletRequest request,
			RedirectAttributes rdAttr) {
		
		Member loginMember = (Member) model.getAttribute("loginMember");
		
		qnaBoard.setQnaWriter(loginMember.getMemberNo()+"");
		
		// System.out.println(qnaBoard);
		
		for(int i=0; i<images.size(); i++) {
			System.out.println("images[" + i + "] :" + images.get(i).getOriginalFilename());
		}
		// 파일을 저장할 서버 컴퓨터의 로컬 경로
		String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
		
		System.out.println(savePath);
		
		int result = qnaService.insertBoard(qnaBoard, savePath, images);
		
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status= "success";
			msg = "등록되었습니다.";
			url = "qnaList";
		}else {
			status= "error";
			msg= "실패하였습니다.";
			url = "qnaList";
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
		
	}
	// Q&A 상세조회
	@RequestMapping("{qnaNo}")
	public String qnaView(@PathVariable int qnaNo, Model model
			, RedirectAttributes rdAttr) {
		
		QNABoard board = qnaService.selectBoard(qnaNo);
		
		String url = null;
		if(board != null) {
			
			// DB에서 해당 글에 작성도니 이미지 파일 모두 조회하기
			List<Attachment> files = qnaService.selectFiles(qnaNo);
			System.out.println(files);
			
			if(!files.isEmpty()) {
				model.addAttribute("files", files);
			}
			
			model.addAttribute("qnaBoard", board);
			url = "board/qnaView";
		}else {
			
			rdAttr.addFlashAttribute("status", "error");
			rdAttr.addFlashAttribute("msg","해당 게시글이 존재하지 않습니다.");
			url = "redirect:qna/qnaList";
		}
		return url;
	}
	
	
}

