package com.project.helpzoo.mypage.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.member.model.vo.Member;
import com.project.helpzoo.mypage.model.vo.mPageInfo;

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

	/** 전체 게시글 수 조회
	 * @param type
	 * @param loginMember
	 */
	public int getListCount(Member loginMember) {
		
		return sqlSession.selectOne("mypageMapper.getListCount", loginMember);
	}

	/** 내가 주최한 펀딩 리스트 조회
	 * @param map
	 * @return mInfo
	 */

	public List<Member> selectList(mPageInfo mInfo, Member loginMember) {
		
		int offset = (mInfo.getCurrentPage()-1)*mInfo.getLimit();

		RowBounds rowBounds = new RowBounds(offset, mInfo.getLimit());
		
		System.out.println("loginMember :" + loginMember);
		
		return sqlSession.selectList("mypageMapper.selectList", loginMember, rowBounds);
	}

	public List<Member> selectThumbnailList(List<Member> fdListbyMe) {
		
		return sqlSession.selectList("mypageMapper.selectThumbnailList", fdListbyMe);
	}


	
	
}
