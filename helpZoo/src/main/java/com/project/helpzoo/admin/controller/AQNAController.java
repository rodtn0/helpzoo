package com.project.helpzoo.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.admin.model.service.AQNAService;
import com.project.helpzoo.admin.model.vo.QNABoard;
import com.project.helpzoo.board.model.service.QNAService;
import com.project.helpzoo.board.model.vo.Attachment;

// ${contextPath}/admin/faq/faqList

@Controller
@RequestMapping("/admin/qna/*")
public class AQNAController {
	
	@Autowired
	private AQNAService aqnaService;
	
	// QNA Service
	@Autowired
	private QNAService qnaService;
	
	// 이메일
	@Autowired
	private JavaMailSender mailSender;
	
	
	@RequestMapping("qnaList")
	public String qnaMain(Model model) {
		
		List<QNABoard> qnaList = aqnaService.selectList();
		
		for(QNABoard qna : qnaList) {
			
			int qnaNo = qna.getQnaNo();
			
			int qnaAnswer = aqnaService.selectAnswer(qnaNo);
			
			qna.setQnaAnswer(qnaAnswer);
			
			System.out.println(qna);
		}
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin/qna/adminqnaMain";
	}
	
	// 상세 조회
	// http://localhost:8080/helpzoo/admin/qna/2
	@RequestMapping("{qnaNo}")
	public ModelAndView qnaView(@PathVariable int qnaNo, ModelAndView mv) {
		
		System.out.println(qnaNo);
		
		QNABoard board = aqnaService.selectBoard(qnaNo);
		
		if(board != null) {
			
			List<Attachment> files = qnaService.selectFiles(qnaNo);
			
			if(!files.isEmpty()) {
				mv.addObject("files", files);
			}
			
			QNABoard answerBoard = aqnaService.selectAnswerBoard(qnaNo);
			
			if( answerBoard != null) {
				mv.addObject("answerBoard", answerBoard);
			}
			
			mv.addObject("board", board);
		}
		
		mv.setViewName("admin/qna/adminqnaView");
		
		return mv;
		
	}
	
	// 답변 등록
	// ${contextPath}/admin/qna/${board.qnaNo}/answer
	
	@ResponseBody
	@RequestMapping(value="{qnaNo}/answer",
			produces="application/text; charset=utf-8;")
	// produces : 응답 데이터의 Mime type, 문자인코딩 지정 속성
	// -> ajax 통신 시 한글로 된 String을 리턴할 경우 주로 사용함.
	public String qnaAnswer(@PathVariable int qnaNo, QNABoard qnaBoard,
							HttpServletRequest request, String Writer,
							String Content,
							HttpServletResponse resEmail) throws IOException {
		
		// 관리자 셋팅
		qnaBoard.setQnaNo(qnaNo);
		qnaBoard.setQnaTitle("답변드립니다.");
		qnaBoard.setQnaWriter("1");
		
		int resultAnswer = aqnaService.insertAnswer(qnaBoard);
		
		System.out.println(Content);
		System.out.println("resultAnswer : " +  resultAnswer);
		System.out.println("Writer : " + Writer);
		
		// 이메일 보내기
		
		
		String setfrom = "helpzooFinal@gmail.com"; 
		String tomail = aqnaService.selectEmail(Writer);
		String title = "도와주(Zoo) 1:1문의에 대한 답변이 등록되었습니다."; // 메일 제목(타이틀)
		String content = System.getProperty("line.separator") +
							System.getProperty("line.separator") +
							System.getProperty("line.separator") + "안녕하세요. 도와주(Zoo) 반려동물 크라우드 펀딩 & 기부 웹사이트입니다." +
							System.getProperty("line.separator") + "답변을 받기까지 많이 기다리시진 않으셨는지요?" +
							System.getProperty("line.separator") + "최대한 빠르고 정확한 답변을 드리기 위해 더욱 노력하겠습니다." +
							System.getProperty("line.separator") +
							System.getProperty("line.separator") + "고객님께서 문의하신 내용입니다." +
							System.getProperty("line.separator") + "Q." + Content +
							System.getProperty("line.separator") +
							System.getProperty("line.separator") + "문의하신 내용에 대한 답변입니다."+
							System.getProperty("line.separator") + "A." + qnaBoard.getQnaContent() +
							System.getProperty("line.separator") +
							System.getProperty("line.separator") + "만족스런 답변이 되셨기를 바랍니다. 감사합니다.";
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setfrom); // 보내는 사람 이메일
			messageHelper.setTo(tomail); // 받는 사람 이메일
			messageHelper.setSubject(title); // 메일 제목 (생략 가능)
			messageHelper.setText(content); // 메일 내용
			
			mailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String str = "답변";
		if(resultAnswer > 0) {
			str = "성공";
		}else {
			str = "실패";
		}
		return str;
	}
	
}
