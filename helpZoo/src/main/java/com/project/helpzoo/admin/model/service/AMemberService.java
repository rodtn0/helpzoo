package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.AMemberDAO;
import com.project.helpzoo.member.model.vo.Member;

public interface AMemberService {

	/** 관리자 멤버 관리 페이지 리스트
	 * @return memberList
	 */
	public abstract List<Member> memberList();
	
	

}
