package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Board;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 공지사항 목록 조회 dao
	 * @param type
	 * @return noticeList
	 */
	public List<Board> selectList(int type) {
		return sqlSession.selectList("noticeMapper.selectList", type);
	}

}
