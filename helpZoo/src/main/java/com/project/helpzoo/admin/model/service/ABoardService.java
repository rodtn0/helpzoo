package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.ABoardDAO;
import com.project.helpzoo.board.model.vo.Board;

public interface ABoardService {

	/** 공지사항 관리 페이지 리스트
	 * @return noticeList
	 */
	public abstract List<Board> noticeList();

	/** 이벤트 관리 페이지 리스트
	 * @return eventList
	 */
	public abstract List<Board> eventList();

	/** 공지사항 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public abstract int confirmNotice(int boardNo);

	/** 공지사항 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public abstract int delNotice(int boardNo);

	/** 이벤트 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public abstract int confirmEvent(int boardNo);

	/** 이벤트 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public abstract int delEvent(int boardNo);

	/** 펀딩 후기 관리 페이지 리스트
	 * @return ReviewList
	 */
	public abstract List<Board> fundingList();

	/** 기부 후기 관리 페이지 리스트
	 * @return donationList
	 */
	public abstract List<Board> donationList();

	/** 펀딩 후기 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public abstract int confirmFunding(int boardNo);

	/** 기부 후기 게시물 상태 확인
	 * @param boardNo
	 * @return confirm
	 */
	public abstract int confirmDonation(int boardNo);

	/** 펀딩 후기 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public abstract int delFunding(int boardNo);

	/** 기부 후기 게시물 삭제
	 * @param boardNo
	 * @return result
	 */
	public abstract int delDonation(int boardNo);

}
