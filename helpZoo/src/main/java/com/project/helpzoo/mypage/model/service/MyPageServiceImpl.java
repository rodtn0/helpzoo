package com.project.helpzoo.mypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.mypage.model.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageDAO myPageDAO;
	
	private BCryptPasswordEncoder bcPwd;
	
	// 회원 정보 수정 Service 구현
	@Override
	public int updateMember(Member upMember) {
		
		return myPageDAO.updateMember(upMember);
	}
	
}
