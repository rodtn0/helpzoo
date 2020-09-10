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

	// 회원 탈퇴 Service 구현
	@Override
	public int deleteMember(Member loginMember) {
		
		String savePwd = myPageDAO.selectPwd(loginMember.getMemberNo());
		
		int result = 0;
		
		if(savePwd != null) {
			if(bcPwd.matches(loginMember.getMemberPwd(), savePwd)) {
				result = myPageDAO.deleteMember(loginMember);
			}
		}
		
		return result;
	}
	
}
