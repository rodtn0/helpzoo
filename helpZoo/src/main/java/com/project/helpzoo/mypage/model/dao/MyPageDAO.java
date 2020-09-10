package com.project.helpzoo.mypage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.member.model.vo.Member;

@Repository
public class MyPageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;


	/** 회원 정보 수정 DAO
	 * @param upMember
	 * @return result
	 */
	public int updateMember(Member upMember) {
		
		return sqlSession.update("memberMapper.updateMember", upMember);
	}
	
}
