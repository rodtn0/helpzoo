package com.project.helpzoo.funding.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.vo.FundingProject;

@Service
@Transactional
public class FundingServiceImpl implements FundingService {

	@Autowired
	private FundingDAO dao;
	
	
	@Override
	public List<FundingProject> selectList(int cp) {
		
		return dao.selectList(cp);
	}
	
	
	
	
	
	
}
