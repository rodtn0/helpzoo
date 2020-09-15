package com.project.helpzoo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.model.vo.Attachment;
import com.project.helpzoo.model.vo.Donation;
import com.project.helpzoo.model.vo.PageInfo;


@Repository
public class DonationDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession; // DI : 의존성 주입

	/** 전체 게시글 수 조회
	 * @param type
	 * @return listCount
	 */
	public int getListCount(int type) {

		return sqlSession.selectOne("DonationMapper.getListCount", type);
	}

	/** 게시글 목록 조회DAO
	 * @param pInfo
	 * @return DonationList
	 */
	public List<Donation> selectList(PageInfo pInfo) {

		// RowBounds
		// 조회된 내용 중 지정한 만큼의 수를 건너 띄고나서
		// 이후 몇개를 조회 할지를 정할 수 있는 객체
		
		// offset : 건너 띌 게시글 수를 지정
		int offset = (pInfo.getCurrentPage()-1) * pInfo.getLimit();
					// (1-1) * 10 = 0
					// (2-1) * 10 = 10
					// (3-1) * 10 = 20
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
				// selectLists는 List 타입 반환
		return sqlSession.selectList("DonationMapper.selectList", pInfo.getdonationType(), rowBounds);
								// 매퍼이름.태그id, 파라미터(없으면 null), RowBounds
	}

	/** 게시글 상세 조회 DAO
	 * @param DonationNo
	 * @return Donation
	 */
	public Donation selectDonation(int DonationNo) {
		return sqlSession.selectOne("DonationMapper.selectDonation", DonationNo);
	}

	/** 조회수 증가
	 * @param DonationNo
	 * @return result
	 */
	public int increaseCount(int DonationNo) {

		return sqlSession.update("DonationMapper.increaseCount", DonationNo);
	}

	/** 다음 게시글 번호 조회
	 * @return
	 */
	public int selectNextNo() {

		return sqlSession.selectOne("DonationMapper.selectNextNo");
	}

	/** 게시글 등록
	 * @param Donation
	 * @return
	 */
	public int insertDonation(Donation Donation) {

		return sqlSession.insert("DonationMapper.insertDonation", Donation);
	}

	/** 게시글 삭제
	 * @param DonationNo
	 * @return
	 */
	public int donationDelete(int DonationNo) {

		return sqlSession.insert("DonationMapper.donationDelete", DonationNo);
	}

	/** 게시글 수정
	 * @param upDonation
	 * @return
	 */
	public int updateDonation(Donation upDonation) {

		return sqlSession.insert("DonationMapper.updateDonation", upDonation);
	}

	/** 파일 정보 삽입 DAO
	 * @param at
	 * @return
	 */
	public int insertAttachment(Attachment at) {
		
		return sqlSession.insert("DonationMapper.insertAttachment", at);
	}

	/** 게시글 이미지 조회
	 * @param DonationNo
	 * @return result
	 */
	public List<Attachment> selectFiles(int DonationNo) {

		return sqlSession.selectList("DonationMapper.selectFiles", DonationNo);
	}

	/** 파일 저장 오류 시 DB에 저장된 내용 삭제 DAO
	 * @param DonationNo
	 */
	public void deleteAttachment(int DonationNo) {
		sqlSession.delete("DonationMapper.deleteAttachment",DonationNo);
	}

	/** 썸네일 목록 조회 
	 * @param DonationList
	 * @return thList
	 */
	public List<Attachment> selectThumbnailList(List<Donation> DonationList) {

		return sqlSession.selectList("DonationMapper.selectThumbnailList", DonationList);
	}

	/** 파일 정보 수정 DAO
	 * @param at
	 * @return result
	 */
	public int updateAttachment(Attachment at) {

		return sqlSession.update("DonationMapper.updateAttachment", at);
	}

	/** 파일 1개 정보 삭제 DAO
	 * @param fileNo
	 * @return result
	 */
	public int deleteAttachment2(int fileNo) {

		return sqlSession.delete("DonationMapper.deleteAttachment2", fileNo);
	}

	/** 게시판 조회수 높은 게시글 조회 DAO
	 * @param type
	 * @return
	 */
	public List<Donation> selectTopViews(int type) {

		return sqlSession.selectList("DonationMapper.selectTopView", type);
	}

	/** 검색 조건 추가된 페이징 처리 DAO
	 * @param map
	 * @return
	 */
	public int getSearchListCount(Map<String, Object> map) {
		return sqlSession.selectOne("DonationMapper.getSearchListCount",map);
	}

	/** 검색 목록 조회 DAO
	 * @param pInfo
	 * @param map
	 * @return DonationList
	 */
	public List<Donation> selectSearchList(PageInfo pInfo, Map<String, Object> map) {

		int offset = (pInfo.getCurrentPage()-1)*pInfo.getLimit();
		
		// offset : 몇 칸을 건너뛸 것인가
		// limit : 건너 뛴 것부터 몇개를 보여줄 것인가
		RowBounds rowBounds = new RowBounds(offset, pInfo.getLimit());
		
		return sqlSession.selectList("DonationMapper.selectSearchList", map, rowBounds);
	}
	
	

}
