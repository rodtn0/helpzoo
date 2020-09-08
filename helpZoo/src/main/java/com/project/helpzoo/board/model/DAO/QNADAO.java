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
		System.out.println(at.getParentBoardNo());
		
		return sqlSession.insert("qnaMapper.insertAttachment", at);
	}

	/** 게시글 상세 조회 구현
	 * @param qnaNo
	 * @return
	 */
	public QNABoard selectBoard(int qnaNo) {
		return sqlSession.selectOne("qnaMapper.selectBoard", qnaNo);
							// 단일행이기 때문에 SelectOne
	}

	/** 게시글 조회 수 증가
	 * @param qnaNo
	 * @return
	 */
	public int increaseCount(int qnaNo) {
		return sqlSession.update("qnaMapper.increaseCount", qnaNo);
	}

	
	/** 게시글 이미지 조회 Service 구현
	 * @param qnaNo
	 * @return
	 */
	public List<Attachment> selectFiles(int qnaNo) {
		return sqlSession.selectList("qnaMapper.selectFiles", qnaNo);
	}

	/** qna 질문 쓴 memberId 가져오기 구현
	 * @param qnaNo
	 * @return
	 */
	public String selectQuestionId(int qnaNo) {
		return sqlSession.selectOne("qnaMapper.selectQuestionId", qnaNo);
	}

	
	/** qna 수정
	 * @param upqnaBoard
	 * @return
	 */
	public int updateQNABoard(QNABoard upqnaBoard) {
		return sqlSession.update("qnaMapper.updateQNABoard", upqnaBoard);
	}

	/** qna 파일 수정
	 * @param at
	 * @return
	 */
	public int updateAttachment(Attachment at) {
		return sqlSession.update("qnaMapper.updateAttachment", at);
	}

	/** 파일 1개 정보 삭제
	 * @param fileNo
	 * @return
	 */
	public int deleteAttachment2(int fileNo) {
		return sqlSession.delete("qnaMapper.deleteAttachment2", fileNo);
	}

	
	/** qna 삭제
	 * @param qnaNo
	 * @return
	 */
	public int deleteBoard(int qnaNo) {
		return sqlSession.delete("qnaMapper.deleteBoard", qnaNo);
	}

	/** 검색 조건이 추가된 페이징 처리 DAO
	 * @param id
	 * @return
	 */
	public int getSearchListCount(String id) {
		return sqlSession.selectOne("qnaMapper.getSearchListCount", id);
	}
	

}
