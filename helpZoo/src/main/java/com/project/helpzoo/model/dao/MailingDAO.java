package com.project.helpzoo.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.helpzoo.model.vo.Mailing;

@Repository
public class MailingDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Mailing selectMailing(int memberNo) {
		return sqlSession.selectOne("MailingMapper.selectMailing", memberNo);
	}

	/** 메일링 서비스 등록(신규등록)
	 * @param mailing
	 * @return result
	 */
	public int insertMailing(Mailing mailing) {
		return sqlSession.insert("MailingMapper.insertMailing", mailing);
	}

	/** 메일링 서비스 등록(수정)
	 * @param mailing
	 * @return result
	 */
	public int updateMailing(Mailing mailing) {
		return sqlSession.update("MailingMapper.updateMailing", mailing);
	}

	/** 메일링 서비스 구독 취소
	 * @param mailing
	 * @return result
	 */
	public int subscribeCancel(Mailing mailing) {
		return sqlSession.update("MailingMapper.subscribeCancel", mailing);
	}

}
