package com.project.helpzoo.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.model.vo.Attachment;
import com.project.helpzoo.model.vo.Donation;
import com.project.helpzoo.model.vo.dPageInfo;
import com.project.helpzoo.model.vo.Search;

public interface DonationService {
	
	/** 페이징 처리를 위한 Service
	 * @param type
	 * @param cp
	 * @param search 
	 * @return pInfo
	 */
	public abstract dPageInfo pagination(int type, int cp);

	/** 게시글 목록 조회 Service
	 * @param pInfo
	 * @return boardList
	 */
	public abstract List<Donation> selectList(dPageInfo pInfo);

	/** 게시글  상세 조회 Service
	 * @param dBoardNo
	 * @return board
	 */
	public abstract Donation selectBoard(int dBoardNo);

	/** 게시글 등록 Service
	 * @param board
	 * @param savePath 
	 * @param images 
	 * @return result
	 */
	public abstract int insertBoard(Donation donation, List<MultipartFile> images, String savePath);

	/** 게시글 삭제 Service
	 * @param boardNo
	 * @return
	 */
	public abstract int donationDelete(int dBoardNo);

	/** 게시글 수정 Service
	 * @param upBoard
	 * @param images 
	 * @param savePath 
	 * @param deleteImages 
	 * @return result
	 */
	public abstract int updateBoard(Donation upBoard, String savePath, List<MultipartFile> images, boolean[] deleteImages);

	/** 게시글 이미지 조회
	 * @param boardNo
	 * @return files
	 */
	public abstract List<Attachment> selectFiles(int dBoardNo);

	/** 썸네일 조회
	 * @param boardList
	 * @return thList
	 */
	public abstract List<Attachment> selectThumbnailList(List<Donation> donationList);

	/** 게시판 조회수 높은 게시글 조회 Service
	 * @param type
	 * @return list
	 */
	public abstract List<Donation> selectTopViews(int type);
	
	
	
	/** 페이징 처리를 위한 Service 검색 조건 추가
	 * @param type
	 * @param cp
	 * @param search 
	 * @return pInfo
	 */
	public abstract dPageInfo pagination(int type, int cp, Search search);

	/** 검색 목록 조회 Service
	 * @param pInfo
	 * @param search
	 * @return boardList
	 */
	public abstract List<Donation> selectSearchList(dPageInfo pInfo, Search search);


}
