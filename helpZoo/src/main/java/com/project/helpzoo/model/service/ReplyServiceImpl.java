package com.project.helpzoo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.model.dao.ReplyDAO;
import com.project.helpzoo.model.vo.DReply;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDAO replyDAO;

	// 댓글 조회
	@Override
	public List<DReply> selectList(int boardNo) {

		return replyDAO.selectList(boardNo);
	}

	// 댓글 삽입
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertRelpy(DReply reply) {
		
		// 크로스 사이트 스크립팅 방지
        reply.setdReplyContent(
                replaceParameter(reply.getdReplyContent()));

        // 개행문자 처리 \n -> <br>
        reply.setdReplyContent(
                reply.getdReplyContent().replaceAll("\n", "<br>"));

		return replyDAO.insertRelpy(reply);
	}
	
	
	
	
	
	// 댓글 수정
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateReply(DReply reply) {

		// 크로스 사이트 스크립팅 방지
        reply.setdReplyContent(
                replaceParameter(reply.getdReplyContent()));

        // 개행문자 처리 \n -> <br>
        reply.setdReplyContent(
                reply.getdReplyContent().replaceAll("\n", "<br>"));
        
		return replyDAO.updateReply(reply);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// 크로스 사이트 스크립트 방지 메소드
    private String replaceParameter(String param) {
        String result = param;
        if(param != null) {
            result = result.replaceAll("&", "&amp;");
            result = result.replaceAll("<", "&lt;");
            result = result.replaceAll(">", "&gt;");
            result = result.replaceAll("\"", "&quot;");
        }

        return result;
    }

}
