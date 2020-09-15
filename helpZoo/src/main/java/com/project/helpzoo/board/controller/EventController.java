package com.project.helpzoo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.board.model.service.EventService;
import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Search;
import com.project.helpzoo.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/event/*")
public class EventController {

	@Autowired
	private EventService eventService;
	
	// 이벤트 리스트 ---------------------------------------------------------------------------------
	@RequestMapping("eventList")
	public String eventMain(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			Model model) {
		
		int type = 6; //보드타입: 이벤트 6번
		
		PageInfo pInfo = eventService.pagination(type, cp);
		
		// 이벤트 글 목록
		List<Board> eventList = eventService.selectList(pInfo);
		
		//목록 조회 확인용 test
//		for(Board e : eventList) {
//			System.out.println("공지사항 리스트 : " + e);
//		}
		
		// 썸네일 목록
		if(!eventList.isEmpty()) {
			List<Attachment> thumList = eventService.selectThumList(eventList);
			
			model.addAttribute("thumList", thumList);
		}
		
		model.addAttribute("eventList", eventList);
		model.addAttribute("pInfo", pInfo);
		
		return "event/eventMain";
	}
	
	// 이벤트 상세 조회 --------------------------------------------------------------------------------
	// /notice/5/33
	@RequestMapping("{type}/{boardNo}")
	public String noticeView(@PathVariable int type, @PathVariable int boardNo,
			Model model, RedirectAttributes rdAttr, HttpServletRequest request) {
		
//		int type = 6;
		
		Board board = eventService.selectEvent(boardNo);
		
		System.out.println("상세조회 결과 : " + board);
		
		String url = null;
		
		if(board != null) {
			
			List<Attachment> files = eventService.selectFiles(boardNo);
			
			if(!files.isEmpty()) {
				model.addAttribute("files", files);
			}
			
			model.addAttribute("board", board);
			url = "event/eventView";
		}else {
			rdAttr.addFlashAttribute("status", "error");
			rdAttr.addFlashAttribute("msg", "해당 게시물이 존재하지 않습니다.");
			url = "redirect:/event/eventList";
		}
		
		
		return url;
	}
	
	// 이벤트 글 작성 뷰 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/insertView")
	public String insertView() {
		
		return "event/insertView";
		
	}
	
	// 이벤트 글 등록 -------------------------------------------------------------------------------------------
	@RequestMapping(value = "{type}/insertEvent", method = RequestMethod.POST)
	public String insertEvent(@PathVariable int type, Board board, Model model,
			@RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
			@RequestParam(value = "images", required = false) List<MultipartFile> images,
			HttpServletRequest request, RedirectAttributes rdAttr) {
		
		// session 회원정보
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		board.setBoardType(type);
		board.setBoardWriter(loginMember.getMemberNo()+"");
		
		System.out.println("board 정보 : " + board);
		System.out.println("loginMember 정보 : " + loginMember);
		
		// 파일 업로드시 입력값 확인
		System.out.println("썸네일 : " + thumbnail.getOriginalFilename());
		for(int i=0; i<images.size(); i++) {
			System.out.println("images[" + i + "] : " + images.get(i).getOriginalFilename());
		}
		
		// 썸네일 이미지 정보를 images 리스트 제일 앞에 추가
		images.add(0, thumbnail);
		
		// 파일을 저장할 서버 컴퓨터의 로컬 경로
		String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
		
		// 이벤트 글 등록 service 호출
		int result = eventService.insertEvent(board, images, savePath);
		
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
	
	// 이벤트 글 삭제 -------------------------------------------------------------------------------------
	// notice/5/547?cp=1
	@RequestMapping("{type}/{boardNo}/deleteEvent")
	public String deleteEvent(@PathVariable int type, @PathVariable int boardNo,
			RedirectAttributes rdAttr, HttpServletRequest request) {
		
		int result = eventService.deleteEvent(boardNo);
		
		// SweetAlert용 변수 선언
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status = "success";
			msg = "공지사항이 삭제되었습니다.";
			url = "../../eventList";
		}else {
			status = "error";
			msg = "공지사항 삭제에 실패했습니다.";
			url = request.getHeader("referer"); 
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 이벤트 글 수정 화면 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/{boardNo}/updateView")
	public ModelAndView updateView(@PathVariable int boardNo, ModelAndView mv) {
		
		// 수정할 게시글 내용 조회
		Board board = eventService.selectEvent(boardNo);
		
		mv.addObject("board", board);
		mv.setViewName("event/updateView");
		
		return mv;
	}
	
	// 이벤트 글 수정 -------------------------------------------------------------------------------------
	@RequestMapping("{type}/{boardNo}/updateEvent")
	public ModelAndView updateEvent(@PathVariable int type, @PathVariable int boardNo,
			ModelAndView mv, Board uBoard, int cp, RedirectAttributes rdAttr, HttpServletRequest request) {
		
		uBoard.setBoardNo(boardNo);
		
		int result = eventService.updateEvent(uBoard);
		
		// SweetAlert용 변수 선언
		String status = null;
		String msg = null;
		String url = null;
		
		if(result > 0) {
			status = "success";
			msg = "공지사항이 수정되었습니다.";
			url = "../../eventList";
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
	
	// 이벤트 글 검색 ---------------------------------------------------------------------
	// search/5?sKey=tc&sVal=검색어
	@RequestMapping("search/{type}")
	public String search(@PathVariable int type,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			Search search, Model model) {
		
		System.out.println("type:"+ type);
		System.out.println(search);
		
		// 게시글 수 조회
		PageInfo pInfo = eventService.pagination(type, cp, search);
		
		// 게시글 목록 조회
		List<Board> eventList = eventService.selectSearchList(pInfo, search);
		
		for(Board e : eventList) {
			System.out.println(e);
		}
		
		model.addAttribute("noticeList", eventList);
		model.addAttribute("pInfo", pInfo);
		
		return "event/eventMain";
	}
	
}
