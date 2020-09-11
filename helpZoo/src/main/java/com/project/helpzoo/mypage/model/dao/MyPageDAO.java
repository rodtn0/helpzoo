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
		
		return sqlSession.update("mypageMapper.updateMember", upMember);
	}

	/** 비밀번호 찾기 DAO
	 * @param memberNo
	 * @return
	 */
	public String selectPwd(int memberNo) {
		
		return sqlSession.selectOne("mypageMapper.selectPwd", memberNo);
	}
	
	/** 회원 탈퇴 DAO
	 * @param loginMember
	 * @return result
	 */
	public int deleteMember(Member loginMember) {
		
		return sqlSession.update("mypageMapper.deleteMember", loginMember);
	}

	/** 비밀번호 변경 DAO
	 * @param loginMember
	 * @return result
	 */
	public int updatePwd(Member loginMember) {
		
		return sqlSession.update("mypageMapper.updatePwd", loginMember);
	}

	
}
