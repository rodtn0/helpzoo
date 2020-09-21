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
import org.springframework.web.bind.annotation.ResponseBody;
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
			
			// 임시 테스트용
//			List<String> mailList = mailingService.toSendMail();
//			for(Object i : mailList) {
//				System.out.println(i);
//			}
//			String[] toSendMail = mailList.toArray(new String[mailList.size()]);
//			for(int i=0; i<toSendMail.length; i++) {
//				System.out.println("["+i+"] : " + toSendMail[i]);
//			}
			
			
			
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
	public String sendMail(//@RequestParam(value = "email", required = false) String email,
						@RequestParam(value = "title", required = false) String title,
						@RequestParam(value = "content", required = false) String content,
						RedirectAttributes rdAttr) {
		
		String setFrom = "helpzooFinal@gmail.com";	// 보내는 사람 메일
		
		// 파라미터값 받아오는지 출력
//		System.out.println("메일 주소 : " + email);
		System.out.println("메일 제목 : " + title);
		System.out.println("메일 내용 : " + content);
		
		// 구독한 계정 메일 주소 목록
		List<String> mailList = mailingService.toSendMail();
		
//		for(String i : mailList) {
//			System.out.println(i);
//		}
//		test.add(email);
//		test.add("rodtn0@daum.net");
//		test.add("jjisanle@gmail.com");
//		test.add("a01041936838@gmail.com");
		
		// List에서 Array로 변환
		String[] toSendMail = mailList.toArray(new String[mailList.size()]);
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setFrom); // 보내는 사람 이메일
			messageHelper.setBcc(toSendMail); // 받는 사람 이메일
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
	
	// 구독하기
	@RequestMapping("subscribeAction")
	@ResponseBody
	public int subscribe(@ModelAttribute Mailing mailing, RedirectAttributes rdAttr) {
		
		System.out.println("버튼 클릭 : " + mailing);
		
		int result = mailingService.subscribe(mailing);
		
		return result;
	}
	
	// 구독 취소하기
	@RequestMapping("subscribeCancel")
	@ResponseBody
	public int subscribeCancel(@ModelAttribute Mailing mailing) {
		
		System.out.println("버튼 클릭 : " + mailing);
		
		int result = mailingService.subscribeCancel(mailing);
		
		return result;
	}
	
}
