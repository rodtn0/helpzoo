package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.admin.model.DAO.AMemberDAO;
import com.project.helpzoo.member.model.vo.Member;

@Service
public class AMemberServiceImpl implements AMemberService {

	@Autowired
	private AMemberDAO aMemberDAO;

	// 관리자 멤버 관리 페이지 리스트 ---------------------------------------------------------------
	@Override
	public List<Member> memberList() {
		return aMemberDAO.memberList();
	}

	// 멤버 계정 상태 확인 -------------------------------------------------------------------
	@Override
	public int selMember(int memberNo) {
		return aMemberDAO.selMember(memberNo);
	}

	// 멤버 계정 정지 --------------------------------------------------------------------
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int delMember(int memberNo) {
		return aMemberDAO.delMember(memberNo);
	}

	
}
