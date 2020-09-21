package com.project.helpzoo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.model.dao.MailingDAO;
import com.project.helpzoo.model.vo.Mailing;

@Service
public class MailingServiceImpl implements MailingService{

	@Autowired
	MailingDAO mailingDAO;
	
	// 메일링 서비스 등록 여부 확인
	@Override
	public Mailing selectMailing(int memberNo) {
		return mailingDAO.selectMailing(memberNo);
	}

	// 메일링 서비스 등록
	@Override
	public int regSubscribe(Mailing mailing) {
		return mailingDAO.insertMailing(mailing);
	}

	// 메일링 서비스 구독하기
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int subscribe(Mailing mailing) {
		
		return mailingDAO.updateMailing(mailing);
		
	}

	// 메일링 서비스 구독 취소
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int subscribeCancel(Mailing mailing) {
		return mailingDAO.subscribeCancel(mailing);
	}


}
