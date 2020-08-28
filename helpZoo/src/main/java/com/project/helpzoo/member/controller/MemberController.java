package com.project.helpzoo.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
