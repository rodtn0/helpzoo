package com.project.helpzoo.funding.model.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.helpzoo.funding.dto.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.FundingMainViewDto;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;

@Service
@Transactional
public class FundingServiceImpl implements FundingService {

	@Autowired
	private FundingDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(FundingServiceImpl.class);
	
	
	@Override
	public List<FundingMainViewDto> selectList(int cp, FundingSearch fundingSearch) {
		
		return dao.selectList(cp,fundingSearch);
	}


	/**
	 * 
	 * 매일 24시마다 각 프로젝트를 확인하여 기간이 만료된 프로젝트의 상태를 N으로 변환한다.
	 * 
	 */
	@Override
	public void fundingStatusChange() {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("YY/MM/DD");
		
		
		Date nowTime = new Date();
		
			List<FundingProject> fundingProject = 	dao.fundingStatusChange();
			
			int compare = 0;
			for(FundingProject fp : fundingProject) {
				
				if((nowTime.compareTo(fp.getEndDay()) >	0) ) {
					
					fp.setStatus("N");
					logger.info(fp.getFundingMaker() + "의 " + 
					fp.getTitle() + "프로젝트가 만료되었습니다." );
			
			}
		}
	}



	@Override
	public FundingDetailViewDto selectFunding(int fundingNo) {
		
		return dao.selectFunding(fundingNo);
	}
	
	
	
	
	
	
}
