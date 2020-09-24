package com.project.helpzoo.admin.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Board;

@Repository
public class ABoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 공지사항 관리 페이지 리스트
	 * @return noticeList
	 */
	public List<Board> noticeList() {
		return sqlSession.selectList("adminConfMapper.noticeList");
	}

	/** 이벤트 관리 페이지 리스트
	 * @return eventList
	 */
	public List<Board> eventList() {
		return sqlSession.selectList("adminConfMapper.eventList");
	}

	/** 공지사항 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public int confirmNotice(int boardNo) {
		return sqlSession.selectOne("adminConfMapper.confirmNotice", boardNo);
	}

	/** 공지사항 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public int delNotice(int boardNo) {
		return sqlSession.update("adminConfMapper.delNotice", boardNo);
	}

	/** 이벤트 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public int confirmEvent(int boardNo) {
		return sqlSession.selectOne("adminConfMapper.confirmEvent", boardNo);
	}

	/** 이벤트 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public int delEvent(int boardNo) {
		return sqlSession.update("adminConfMapper.delEvent", boardNo);
	}

	/** 펀딩 후기 관리 페이지 리스트
	 * @return ReviewList
	 */
	public List<Board> fundingList() {
		return sqlSession.selectList("adminConfMapper.fundingList");
	}

	/** 기부 후기 관리 페이지 리스트
	 * @return donationList
	 */
	public List<Board> donationList() {
		return sqlSession.selectList("adminConfMapper.donationList");
	}

	/** 펀딩 후기 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public int confirmFunding(int boardNo) {
		return sqlSession.selectOne("adminConfMapper.confirmFunding", boardNo);
	}

	/** 기부 후기 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public int confirmDonation(int boardNo) {
		return sqlSession.selectOne("adminConfMapper.confirmDonation", boardNo);
	}

	/** 펀딩 후기 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public int delFunding(int boardNo) {
		return sqlSession.update("adminConfMapper.delFunding", boardNo);
	}

	/** 기부 후기 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public int delDonation(int boardNo) {
		return sqlSession.update("adminConfMapper.delDonation", boardNo);
	}
	
}
