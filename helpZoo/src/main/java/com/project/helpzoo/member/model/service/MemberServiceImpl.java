package com.project.helpzoo.member.model.service;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.helpzoo.member.model.dao.MemberDAO;
import com.project.helpzoo.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcPwd;
	
	
	// 로그인 기능 Service 구현
	@Override
	public Member login(Member member) {
		
		Member loginMember = memberDAO.login(member);
		
		if(!bcPwd.matches(member.getMemberPwd(), loginMember.getMemberPwd())) {
			// 입력한 비밀번호와 DB에 저장된 비밀번호 값이 일치하지 않으면 null을 반환
			loginMember = null;
		}else {
			// 입력한 비밀번호와 DB에 저장된 값이 같을 경우 비교가 끝난 조회된 비밀번호를 삭제
			loginMember.setMemberPwd(null);
		}
		
		return loginMember;
	}

	
	// 회원가입 Service 구현
	@Transactional(rollbackFor = SQLException.class)
	@Override
	public int signUp(Member signUpMember) {
		
		String encPwd = bcPwd.encode(signUpMember.getMemberPwd());
		
		signUpMember.setMemberPwd(encPwd);
		
		System.out.println(signUpMember.getMemberPwd());
		
		int result = memberDAO.signUp(signUpMember);
		
		return result;
	}


	// 아이디 중복 검사 Service 구현
	public int idDupCheck(String memberId) {
		
		return memberDAO.idDupCheck(memberId);
	}

	
	// 아이디 찾기
	@Override
	public String findIdAction(HttpServletResponse response, String memberEmail) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String memberId = memberDAO.findIdAction(response,memberEmail);
		
		if(memberId == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		}else {
			return memberId;
		}

	}

	// 이메일 중복 검사 Service 구현
	@Override
	public int emailDupCheck(String memberEmail) {
		
		return memberDAO.emailDupCheck(memberEmail);
	}

	// 비밀번호 재설정 Service 구현
	@Override
	public int pwdChangeAction(Map<String, Object> map, Member member) {
		
		int result = memberDAO.pwdChangeAction(map, member);
		
		return result;
		
	}



}