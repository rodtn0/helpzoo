package com.project.helpzoo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.model.service.MailingService;
import com.project.helpzoo.model.vo.Mailing;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/subscribe/*")
public class MailingController {

	@Autowired
	private JavaMailSender mailSender;	// 이메일
	
	@Autowired
	private MailingService mailingService; // 메일링서비스
	
	// 구독하기 메인화면
	@RequestMapping("mailing")
	public String mailingMain(Model model, HttpServletRequest request, RedirectAttributes rdAttr) {
		// sweet alert용 변수
		String status = null;
		String msg = null;
		String url = null;
		
		// session 회원정보
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		// session값 확인
		System.out.println(loginMember);
		
		if(loginMember != null) {
			
			// 메일링 가입 여부 확인
			Mailing selMailing = mailingService.selectMailing(loginMember.getMemberNo());
			
			// 가져온 값 출력
			System.out.println(selMailing);
			
			model.addAttribute("selMailing", selMailing);
			
			url = "mailing/mailingMain";
		}else {
    		rdAttr.addFlashAttribute("status", "error");
    		rdAttr.addFlashAttribute("msg", "로그인 후 이용바랍니다.");
			url = "redirect:/";
		}
		
		return url;
	}
	
	// 메일 보내기 기능
	@RequestMapping(value = "sendMail", method = RequestMethod.POST)
	public String sendMail(@RequestParam(value = "email", required = false) String email,
						@RequestParam(value = "title", required = false) String title,
						@RequestParam(value = "content", required = false) String content,
						RedirectAttributes rdAttr) {
		
		String setFrom = "helpzooFinal@gmail.com";	// 보내는 사람 메일
		
		// 파라미터값 받아오는지 출력
		System.out.println("메일 주소 : " + email);
		System.out.println("메일 제목 : " + title);
		System.out.println("메일 내용 : " + content);
		
		// 리스트로 받은 메일 주소
		List<String> test = new ArrayList<>();
		test.add(email);
		test.add("rodtn0@naver.com");
		test.add("injoo25@gmail.com");
		
		// List에서 Array로 변환
		String[] test2 = test.toArray(new String[test.size()]);
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setFrom); // 보내는 사람 이메일
			messageHelper.setBcc(test2); // 받는 사람 이메일
			messageHelper.setSubject(title); // 메일 제목 (생략 가능)
			messageHelper.setText(content); // 메일 내용
			
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rdAttr.addFlashAttribute("status", "success");
		rdAttr.addFlashAttribute("msg", "성공적으로 메시지를 보냈습니다.");
		
		return "redirect:/";
	}
	
	// 구독하기 등록
	@RequestMapping(value = "regSubscribe", method = RequestMethod.POST)
	public String regSubscribe(@PathVariable Mailing mailing, ModelAndView mv,
			RedirectAttributes rdAttr, HttpServletRequest request) {
		
		String status = null;
		String msg = null;
		String url = null;
		
		System.out.println("버튼 클릭 : " + mailing);
		
		int result = mailingService.regSubscribe(mailing);
		
		if(result > 0) {
			status = "success";
			msg = "구독 성공";
			url = "subscribe";
		}else {
			status = "error";
			msg = "구독 실패";
			url = request.getHeader("referer");
		}
		
		rdAttr.addFlashAttribute("status", status);
		rdAttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 구독하기 버튼 클릭
	@RequestMapping("subscribeAction")
	public int subscribe(@ModelAttribute Mailing mailing, RedirectAttributes rdAttr) {
		String status = null;
		String msg = null;
		int result = 0;
		System.out.println("버튼 클릭 : " + mailing);
		
		result = mailingService.subscribe(mailing);
		
		System.out.println("result : " + result);
		
//		if(result > 0) {
//			status = "success";
//			msg = "구독 성공";
//		}else {
//			status = "error";
//			msg = "구독 실패";
//		}
		
		return result;
	}
	
	// 구독 취소하기
	@RequestMapping("subscribeCancel")
	public int subscribeCancel(@ModelAttribute Mailing mailing) {
		String status = null;
		String msg = null;
		
		System.out.println("버튼 클릭 : " + mailing);
		
		int result = mailingService.subscribeCancel(mailing);
		
		System.out.println("result : " + result);
		
		return result;
	}
	
}
