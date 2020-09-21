package com.project.helpzoo.model.service;

import java.util.List;

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

	// 메일링 서비스 구독하기
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int subscribe(Mailing mailing) {
		
		int iRtn = 0;
		
		if(mailing.getMailStatus() == null || mailing.getMailStatus() == "") {
			iRtn = mailingDAO.insertMailing(mailing);
		} else {
			iRtn = mailingDAO.updateMailing(mailing);
		}
		
		return iRtn;
	}

	// 메일링 서비스 구독 취소
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int subscribeCancel(Mailing mailing) {
		return mailingDAO.subscribeCancel(mailing);
	}
	
	// 구독한 계정 메일 주소 목록
	@Override
	public List<String> toSendMail() {
		return mailingDAO.toSendMail();
	}


}
