package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Board;
import com.project.helpzoo.board.model.vo.PageInfo;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 전체 게시글 수 조회
	 * @param type
	 * @return listCount
	 */
	public int getListCount(int type) {
		return sqlSession.selectOne("noticeMapper.getListCount", type);
	}

	/** 공지사항 목록 조회 dao
	 * @param type
	 * @return noticeList
	 */
	public List<Board> selectList(PageInfo pInfo) {
		// RowBounds
		// 조회된 내용 중 지정한 만큼의 수를 건너 띄고 나서 
		// 이후 몇 개를 조회할지를 정할 수 있는 객체
		
		// offset : 건너 띌 게시글 수를 지정
		int offset = (pInfo.getCurrentPage() -1) * pInfo.getLimit();
						// (1 - 1) * 10 = 0페이지
						// (2 - 1) * 10 = 10
						// (3 - 1) * 10 = 20
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
						// selectList는 List 타입 반환
		return sqlSession.selectList("noticeMapper.selectList", pInfo.getBoardType(), rowBounds);
										// 매퍼이름.태그id,			파라미터(없으면null),	 RowBounds
		
//		return sqlSession.selectList("noticeMapper.selectList", type);
	}

	/** 공지사항 글 조회 dao
	 * @param boardNo
	 * @return board
	 */
	public Board selectNotice(int boardNo) {
		return sqlSession.selectOne("noticeMapper.selectNotice", boardNo);
	}

	
	/** 공지사항 조회 수 증가 dao
	 * @param boardNo
	 * @return result
	 */
	public int increaseCount(int boardNo) {
		return sqlSession.update("noticeMapper.increaseCount", boardNo);
	}

	/** 공지사항 글 번호 조회 dao
	 * @return boardNo
	 */
	public int selectNextNo() {
		return sqlSession.selectOne("noticeMapper.selectNextNo");
	}

	/** 공지사항 글 등록 dao
	 * @param board
	 * @return result
	 */
	public int insertNotice(Board board) {
		return sqlSession.insert("noticeMapper.insertNotice", board);
	}


}
