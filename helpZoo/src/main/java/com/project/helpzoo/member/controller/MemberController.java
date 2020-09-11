package com.project.helpzoo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.helpzoo.member.model.service.MemberService;
import com.project.helpzoo.member.model.vo.Member;

@SessionAttributes({"loginMember","memberEmail"})
@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MemberService memberService;
	
	// 로그인 화면으로 전환하는 메소드
	@RequestMapping("login")
	public String loginView() {
		
		return "member/login";
	}
	// 로그인 실행 메소드
	@RequestMapping("loginAction")
	public String loginAction(@ModelAttribute Member member, Model model, RedirectAttributes rdAttr,
			String saveId, HttpServletResponse response) {
		
		Member loginMember = memberService.login(member);
		System.out.println(loginMember);
		
		if(loginMember == null) {
			rdAttr.addFlashAttribute("status", "error");
			rdAttr.addFlashAttribute("msg", "로그인 실패");
			rdAttr.addFlashAttribute("text", "아이디 또는 비밀번호를 확인해주세요.");
		}else {

			model.addAttribute("loginMember", loginMember);
			Cookie cookie = new Cookie("saveId", member.getMemberId());
			
			if(saveId != null) {
				cookie.setMaxAge(60*60*24*7);
			}else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
		}
		System.out.println(loginMember);
		
		return "redirect:/";
	}
	
	// 로그아웃 (세션 만료)
	@RequestMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	// 회원 가입 약관동의 화면으로 전환하는 메소드 (회원가입 1)
	@RequestMapping("signUp")
	public String signUpView() {
		
		return "member/signUp_1";
	}
	// 회원 가입 이메일 인증 화면으로 전환하는 메소드(회원가입 2)
	@RequestMapping("signUp2")
	public String signUpView2() {
		
		return "member/signUp_2";
	}	
	
	// 이메일 인증 처리 메소드
	@RequestMapping("authEmail")
	public ModelAndView mailSending(HttpServletRequest request, String memberEmail, HttpServletResponse resEmail) 
	throws IOException{
		Random r = new Random();
		//이메일로 인증 코드를 받음(난수)
		int dice = r.nextInt(4589362) + 49311; 
		
		String setfrom = "helpzooFinal@gmail.com"; // 보내는 사람 이메일
		String tomail = request.getParameter("memberEmail"); // 받는 사람 이메일 설정
		String title = "도와주(Zoo) 반려동물 크라우드 펀딩&기부 회원가입 인증 이메일입니다."; // 메일 제목(타이틀)
		// 메일 내용
		String content = System.getProperty("line.separator")+
		System.getProperty("line.separator")+
		System.getProperty("안녕하세요. 도와주(Zoo) 반려동물 크라우드 펀딩 & 기부 웹사이트입니다.")+
		System.getProperty("line.separator")+
		System.getProperty("line.separator")+
		System.getProperty("line.separator")
		+ "인증번호는 " + dice + "입니다."+
		System.getProperty("line.separator")+
		System.getProperty("line.separator")+
		"인증번호를 입력해주시면 회원가입이 진행됩니다.";
		
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
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/signUp_3");
		mv.addObject("dice", dice);
		mv.addObject("memberEmail", memberEmail);
		
		System.out.println("mv :" + mv);
		
		resEmail.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = resEmail.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
		
		return mv;
		
	}
	
	// 이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드
	// 내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고
	// 틀리면 이전 페이지로 이동되게 함.
	@RequestMapping("joinAuth/{dice}")
	public ModelAndView joinAuth(String authCode, @PathVariable String dice, HttpServletResponse resEqauls)
	throws IOException{
		
		System.out.println("마지막 이메일 인증 : " + authCode);
		System.out.println("마지막 dice : " + dice);
		
		ModelAndView mv = new ModelAndView();
		
		if(authCode.equals(dice)) {
			// 인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입 창으로 이동함.
			mv.setViewName("member/signUp_4");

			// 만약 인증번호가 같다면, 이메일을 회원가입 페이지로 같이 넘겨 이메일을 따로 작성할 필요 없게 구현함.
			resEqauls.setContentType("text/html; charset=UTF-8");
			PrintWriter outEquals = resEqauls.getWriter();
			outEquals.println("<script>alert('인증번호가 일치하였습니다. 회원가입 창으로 이동합니다.');</script>");
			outEquals.flush();
			
			return mv;
			
		}else if(authCode != dice) {
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("member/signUp_3");
			
			resEqauls.setContentType("text/html; charset=UTF-8");
			PrintWriter outEquals = resEqauls.getWriter();
			outEquals.println("<script>alert('인증번호가 일치하지 않습니다. 인증번호를 다시 입력해주세요.); history.go(-1);"
					+ "</script>");
			outEquals.flush();

			return mv2;
		}
		return mv;
		
	}
	
	
	// 회원가입 
	@RequestMapping(value="signUpAction", method = RequestMethod.POST)
	public String signUpAction(Member signUpMember, RedirectAttributes rdAttr, Model model) {
		
		signUpMember.setMemberEmail((String)model.getAttribute("memberEmail"));
		System.out.println(signUpMember);
		
		try {
			int result = memberService.signUp(signUpMember);
			String status = null;
			String msg = null;
			String txt = null;
			
			if(result >0) {
				status="success";
				msg="가입 성공";
				txt="이제 로그인해서 도와주(Zoo)를 이용해보세요.";
				
			}else {
				status="error";
				msg="가입 실패";
				
			}
			rdAttr.addFlashAttribute("status", status);
			rdAttr.addFlashAttribute("msg", msg);
			rdAttr.addFlashAttribute("txt", txt);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("idDupCheck")
	public String idDupCheck(String memberId) {
		int result = memberService.idDupCheck(memberId);
		return result + "";
	}
	
	@RequestMapping("findId")
	public String findId() {
		return "member/findId";
	}
	
	@RequestMapping("findIdAction")
	public String findIdAction(HttpServletResponse response, String memberEmail, Model model) throws Exception {
		
		model.addAttribute("memberId", memberService.findIdAction(response, memberEmail));

		return "member/findIdResult";
	}
	
	
}