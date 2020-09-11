package com.project.helpzoo.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.helpzoo.admin.model.DAO.AFundingDAO;
import com.project.helpzoo.admin.model.vo.AFunding;

@Service
public class AFundingImpl implements AFundingService{

	@Autowired
	private AFundingDAO fundingDAO;
	/**
	 * 펀딩 가져오기
	 */
	@Override
	public List<AFunding> selectFunding() {
		return fundingDAO.selectFunding();
	}

}
