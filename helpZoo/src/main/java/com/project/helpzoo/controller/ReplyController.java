package com.project.helpzoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.model.service.ReplyService;
import com.project.helpzoo.model.vo.DReply;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;

	// 댓글 조회
	@ResponseBody
	@RequestMapping("selectList/{dBoardNo}")
	public String selectList(@PathVariable int dBoardNo) {
		
		List<DReply> rList = replyService.selectList(dBoardNo);

		Gson gson = new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH:mm:ss").create();

        return gson.toJson(rList);
		
	}
	
	// 댓글 삽입
	@ResponseBody
	@RequestMapping(value="insertReply/{dBoardNo}", 
					produces = "application/text; charset=utf-8;")
	// produces : 응답 데이터의 Mime type, 문자인코딩 지정 속성
	// -> ajax 통신 시 한글로 된 String을 리턴할 경우 주로 사용함
	public String insertReply(@PathVariable int dBoardNo, DReply reply){
		// reply 커맨드 객체를 이용하여 전달받은 이름, 댓글 내용을 한 객체에 저장
		// + boardNo도 reply 객체의 parentBoardNo에 저장
		reply.setdBoardNo(dBoardNo);
		
		int result = replyService.insertRelpy(reply);
		
		String str = "댓글 삽입 ";
		
		if(result>0) {
			str += "성공";
			
		}else {
			str += "실패";
		}
		
		return str;
	}
	
	
	
	
	
	
	
	// 댓글 수정
	@ResponseBody
	@RequestMapping(value="updateReply/{dBoardNo}", 
			produces = "application/text; charset=utf-8;")
	public String updateReply(@PathVariable int dBoardNo, DReply reply) {
		
		reply.setdBoardNo(dBoardNo);
		
		int result = replyService.updateReply(reply);
		
		String str = "댓글 수정 ";
		
		if(result>0) {
			str += "성공";
			
		}else {
			str += "실패";
		}
		
		return str;
		
	}
	
}
