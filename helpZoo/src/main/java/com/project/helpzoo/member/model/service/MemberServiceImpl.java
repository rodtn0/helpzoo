package com.project.helpzoo.member.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	
	// 회원 정보 수정 Service 구현
	@Override
	public int updateMember(Member upMember) {
		
		return memberDAO.updateMember(upMember);
	}

}