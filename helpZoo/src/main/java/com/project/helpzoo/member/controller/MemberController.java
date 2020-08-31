package com.project.helpzoo.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Autowired
private JavaMailSender mailSender;

@Controller
@RequestMapping("/member/*")

public class MemberController {
	
	// 로그인 화면으로 전환하는 메소드
	@RequestMapping("login")
	public String loginView() {
		
		return "member/login";
	}
	@RequestMapping("loginAction")
	public String loginAction() {
		return null;
	}
	
	@RequestMapping("signUp")
	public String signUpView() {
		
		return "member/signUp_1";
	}
	
	@RequestMapping("signUp2")
	public String signUpView2() {
		
		return "member/signUp_2";
	}	
	
	@RequestMapping(value="authEmail", method=RequestMethod.POST)
	public ModelAndView mailSending(HttpServletRequest request, String authEmail, HttpServletResponse resEmail) 
	throws IOException{
		Random r = new Random();
		//이메일로 인증 코드를 받음(난수)
		int dice = r.nextInt(4589362) + 49311; 
		
		String setfrom = "";
		String tomail = request.getParameter("authEmail");
		String title = "회원가입 인증 이메일입니다.";
		String content = System.getProperty("line.separator")+
		System.getProperty("line.separator")+
		System.getProperty("안녕하세요. 도와주(Zoo) 반려동물 크라우드 펀딩 & 기부 웹사이트입니다.")+
		System.getProperty("line.separator")+
		System.getProperty("line.separator")+
		System.getProperty("line.separator")
		+ "인증번호는 " + dice + "입니다."+
		System.getProperty("line.separator")+
		System.getProperty("line.separator")+
		"인증번호를 입력해주시면 회원가입 진행이 완료됩니다.";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return mv;
		
	}
	
}
