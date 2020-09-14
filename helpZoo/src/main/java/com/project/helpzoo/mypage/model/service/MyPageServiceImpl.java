package com.project.helpzoo.mypage.model.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.mypage.model.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageDAO myPageDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcPwd;
	
	// 회원 정보 수정 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateMember(Member upMember) {
		
		return myPageDAO.updateMember(upMember);
	}

	// 회원 탈퇴 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteMember(Member loginMember) {
		
		String savePwd = myPageDAO.selectPwd(loginMember.getMemberNo());
		
		int result = 0;
		System.out.println("savepwd :" +savePwd);
		System.out.println("memberPwd :"+loginMember.getMemberPwd());
		if(savePwd != null) {
			if(bcPwd.matches(loginMember.getMemberPwd(), savePwd)) {
				result = myPageDAO.deleteMember(loginMember);
			}
		}
		
		return result;
	}
	
	// 비밀번호 변경 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updatePwd(Member loginMember, String newPwd1) {
		
		// (1) 입력받은 현재 비밀번호 일치 여부 판단
		String savePwd = myPageDAO.selectPwd(loginMember.getMemberNo());
		int result = 0;
		
		if(savePwd != null) {

			if(bcPwd.matches(loginMember.getMemberPwd(), savePwd)) {
				
				// (2) 새로 입력받은 비밀번호로 비밀번호 수정
				// 새 비밀번호 암호화
				String encPwd = bcPwd.encode(newPwd1);
				
				// 암호화된 비밀번호를 loginMember에 세팅
				loginMember.setMemberPwd(encPwd);
				
				// 비밀번호 변경 DAO 메소드 호출
				result = myPageDAO.updatePwd(loginMember);
			}
			
		}
				return result;
	}
	
}
