package com.project.helpzoo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.board.model.service.NoticeService;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Search;
import com.project.helpzoo.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 리스트 --------------------------------------------------------------------------------
	// helpzoo/notice/noticeList
	@RequestMapping("noticeList") 
	public String noticeMain(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model) {
		
		int type = 5; //보드타입: 공지사항 5번
		
		PageInfo pInfo = noticeService.pagination(type, cp);
		
		List<Board> noticeList = noticeService.selectList(pInfo);
		
		//목록 조회 확인용 test
//		for(Board b : noticeList) {
//			System.out.println("공지사항 리스트 : " + b);
//		}
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pInfo", pInfo);
		
		return "notice/noticeMain";
	}
	
	// 공지사항 상세 조회 --------------------------------------------------------------------------------
	// /notice/5/33
	@RequestMapping("{type}/{boardNo}")
	public String noticeView(@PathVariable int type, @PathVariable int boardNo, Model model) {
		
//		int type = 5;
		
		Board board = noticeService.selectNotice(boardNo);
		
		System.out.println("상세조회 결과 : " + board);
		
		model.addAttribute("board", board);
		
		return "notice/noticeView";
	}
	
	// 공지사항 글 작성 뷰 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/insertView")
	public String insertView() {
		
		return "notice/insertView";
		
	}
	
	// 공지사항 글 등록 -------------------------------------------------------------------------------------------
	@RequestMapping("{type}/insertNotice")
	public String insertNotice(@PathVariable int type, Board board, Model model,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		System.out.println("board 정보 : " + board);
		System.out.println("loginMember 정보 : " + loginMember);
		
		board.setBoardType(type);
		board.setBoardWriter(loginMember.getMemberNo()+"");
		
		int result = noticeService.insertNotice(board);
		
		// SweetAlert용 변수 선언
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status = "success";
			msg = "공지사항이 성공적으로 등록되었습니다.";
			url = board.getBoardNo() + "?cp=1";
		}else {
			status = "error";
			msg = "공지사항 등록에 실패했습니다.";
			url = "/noticeList"; 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 공지사항 글 삭제 -------------------------------------------------------------------------------------
	// notice/5/547?cp=1
	@RequestMapping("{type}/{boardNo}/deleteNotice")
	public String deleteNotice(@PathVariable int type, @PathVariable int boardNo,
				RedirectAttributes rdAttr, HttpServletRequest request) {
		
		int result = noticeService.deleteNotice(boardNo);
		
		// SweetAlert용 변수 선언
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status = "success";
			msg = "공지사항이 삭제되었습니다.";
			url = "../../noticeList";
		}else {
			status = "error";
			msg = "공지사항 삭제에 실패했습니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 공지사항 글 수정 화면 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/{boardNo}/updateView")
	public ModelAndView updateView(@PathVariable int boardNo, ModelAndView mv) {
		
		// 수정할 게시글 내용 조회
		Board board = noticeService.selectNotice(boardNo);
		
		mv.addObject("board", board);
		mv.setViewName("notice/updateView");
		
		return mv;
	}
	
	// 공지사항 글 수정 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/{boardNo}/updateNotice")
	public ModelAndView updateNotice(@PathVariable int type, @PathVariable int boardNo,
			ModelAndView mv, Board uBoard, int cp, RedirectAttributes rdAttr, HttpServletRequest request) {
		
		uBoard.setBoardNo(boardNo);
		
		int result = noticeService.updateNotice(uBoard);
		
		// SweetAlert용 변수 선언
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status = "success";
			msg = "공지사항이 수정되었습니다.";
			url = "../../noticeList";
		}else {
			status = "error";
			msg = "공지사항 수정에 실패했습니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		mv.setViewName("redirect:" + url);
		
		return mv;
	}
	
	// 공지사항 검색 ---------------------------------------------------------------------
	@RequestMapping("search/{type}")
	public String search(@PathVariable int type,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Search search, Model model) {
		
		System.out.println("type:"+ type);
		System.out.println("search:"+ search);
		
		return null;
	}
	
	
	
}
