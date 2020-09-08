package com.project.helpzoo.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 로그인 DAO
	 * @param member
	 * @return loginMember
	 */
	public Member login(Member member) {
		
		return sqlSession.selectOne("memberMapper.loginMember", member);
	}

	/** 회원가입 DAO
	 * @param signUpMember
	 * @return result
	 */
	public int signUp(Member signUpMember) {
		
		return sqlSession.insert("memberMapper.signUp",signUpMember);
	}

	/** 아이디 중복 검사 DAO
	 * @param memberId
	 * @return result
	 */
	public int idDupCheck(String memberId) {
		
		return sqlSession.selectOne("memberMapper.idDupCheck", memberId);
	}

}
