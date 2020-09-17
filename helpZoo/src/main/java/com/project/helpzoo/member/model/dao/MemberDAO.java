package com.project.helpzoo.member.model.dao;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	
	public String findIdAction(HttpServletResponse response, String memberEmail){
		
		return sqlSession.selectOne("memberMapper.findId", memberEmail);
		
	}
 
	/** 이메일 중복 검사 DAO
	 * @param memberEmail
	 * @return result
	 */
	public int emailDupCheck(String memberEmail) {
		
		return sqlSession.selectOne("memberMapper.emailDupCheck", memberEmail);
	}
	
	/** 비밀번호 변경 DAO
	 * @param loginMember
	 * @return loginMember
	 */
	public int updatePwd(Member member) {
		
		return sqlSession.update("mypageMapper.updatePwd", member);
	}

	/** 비밀번호 변경 DAO
	 * @param member
	 * @return result
	 */
	public int updatePwd2(Member member) {
		
		return sqlSession.update("memberMapper.updatePwd2", member);
	}
	
	

}