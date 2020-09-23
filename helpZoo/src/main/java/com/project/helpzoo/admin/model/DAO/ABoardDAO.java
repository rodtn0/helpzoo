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
	
}
