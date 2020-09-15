package com.project.helpzoo.model.service;

import java.util.List;

import com.project.helpzoo.model.vo.DReply;


public interface ReplyService {

	/** 댓글 조회 Service
	 * @param boardNo
	 * @return rList
	 */
	public abstract List<DReply> selectList(int boardNo);

	/** 댓글 삽입
	 * @param reply
	 * @return
	 */
	public abstract int insertRelpy(DReply reply);

	/** 답글 삽입
	 * @param reply
	 * @return
	 */
	public abstract int insertRelpy2(DReply reply);

	/** 댓글 수정
	 * @param reply
	 * @return
	 */
	public abstract int updateReply(DReply reply);


}
