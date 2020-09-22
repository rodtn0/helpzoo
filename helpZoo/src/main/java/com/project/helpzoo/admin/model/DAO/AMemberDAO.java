package com.project.helpzoo.admin.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.member.model.vo.Member;

@Repository
public class AMemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 관리자 멤버 관리 페이지 리스트
	 * @return memberList
	 */
	public List<Member> memberList() {
		return sqlSession.selectList("adminConfMapper.memberList");
	}
	
}
