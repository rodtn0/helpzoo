package com.project.helpzoo.board.model.DAO;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;

@Repository
public class QNADAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 전체 게시글 수 조회
	 * @param cp
	 * @return listCount
	 */
	public int getListCount(int cp) {
		return sqlSession.selectOne("qnaMapper.getListCount", null);
	}

	/** 게시글 목록 조회 DAO
	 * @param pInfo
	 * @return
	 */
	public List<QNABoard> selectList(PageInfo pInfo) {
		
		// RowBounds
		// 조회된 내용 중 지정한 만큼의 수를 건너 띄고나서
		// 이후 몇개를 조회할지를 정할 수 있는 객체
		
		// offset : 건너띌 게시글 수를 지정
		int offset = (pInfo.getCurrentPage() - 1 ) * pInfo.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
										// 10개 만큼 건너 띄고 나서 10개다.
										// 라고 해석
		return sqlSession.selectList("qnaMapper.selectList", null, rowBounds);
	}

	/** 글 번호 가져오기
	 * @return
	 */
	public int selectNexNo() {
		return sqlSession.selectOne("qnaMapper.selectNextNo", null);
	}

	
	/** 글 삽입
	 * @param qnaBoard
	 * @return
	 */
	public int insertBoard(QNABoard qnaBoard) {
		// TODO Auto-generated method stub
		return sqlSession.insert("qnaMapper.insertBoard", qnaBoard);
	}

	/** 파일 정보 삽입
	 * @param at
	 * @return
	 */
	public int insertAttachment(Attachment at) {
		return sqlSession.insert("qnaMapper.insertAttachment", at);
	}
	

}
