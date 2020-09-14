package com.project.helpzoo.board.model.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;

@Repository
public class EventDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 전체 게시글 수 조회
	 * @param type
	 * @return listCount
	 */
	public int getListCount(int type) {
		return sqlSession.selectOne("eventMapper.getListCount", type);
	}

	/** 이벤트 목록 조회 dao
	 * @param pInfo
	 * @return eventList
	 */
	public List<Board> selectList(PageInfo pInfo) {
		
		int offset = (pInfo.getCurrentPage() -1) * pInfo.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
		return sqlSession.selectList("eventMapper.selectList", pInfo.getBoardType());
	}
	
	/** 이벤트 글 조회 dao
	 * @param boardNo
	 * @return board
	 */
	public Board selectEvent(int boardNo) {
		return sqlSession.selectOne("eventMapper.selectEvent", boardNo);
	}

	
	/** 이벤트 조회 수 증가 dao
	 * @param boardNo
	 * @return result
	 */
	public int increaseCount(int boardNo) {
		return sqlSession.update("eventMapper.increaseCount", boardNo);
	}

	/** 이벤트 글 번호 조회 dao
	 * @return boardNo
	 */
	public int selectNextNo() {
		return sqlSession.selectOne("eventMapper.selectNextNo");
	}

	/** 이벤트 글 등록 dao
	 * @param board
	 * @return result
	 */
	public int insertEvent(Board board) {
		return sqlSession.insert("eventMapper.insertEvent", board);
	}

	/** 공지사항 글 삭제 dao
	 * @param boardNo
	 * @return result
	 */
	public int deleteEvent(int boardNo) {
		return sqlSession.update("eventMapper.deleteEvent", boardNo);
	}

	/** 이벤트 글 수정 dao
	 * @param uBoard
	 * @return result
	 */
	public int updateEvent(Board uBoard) {
		return sqlSession.update("eventMapper.updateEvent", uBoard);
	}

	/** 검색 조건 추가된 페이지 처리 dao
	 * @param map
	 * @return listCount
	 */
	public int getSearchListCount(Map<String, Object> map) {
		return sqlSession.selectOne("eventMapper.getSearchListCount", map);
	}

	/** 검색 목록 조회 service 구현 dao
	 * @param pInfo
	 * @param map
	 * @return noticeList
	 */
	public List<Board> selectSearchList(PageInfo pInfo, Map<String, Object> map) {
		// RowBounds
		// 조회된 내용 중 지정한 만큼의 수를 건너 띄고 나서 
		// 이후 몇 개를 조회할지를 정할 수 있는 객체
		
		// offset : 건너 띌 게시글 수를 지정
		int offset = (pInfo.getCurrentPage() -1) * pInfo.getLimit();
						// (1 - 1) * 10 = 0페이지
						// (2 - 1) * 10 = 10
						// (3 - 1) * 10 = 20
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
		return sqlSession.selectList("eventMapper.selectSearchList", map, rowBounds);
	}
	
}
