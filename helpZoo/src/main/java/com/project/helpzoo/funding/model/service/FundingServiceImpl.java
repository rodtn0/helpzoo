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
import com.project.helpzoo.funding.dto.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.FundingTotalInfoDto;
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

	
	
	

	@Override
	public Long openFunding(String makerName, String businessType, int phone, int memberNo) {
		
		
		Long type = 0L;
		
		if(businessType.equals("개인")) {
			type = 1L;
			
		}else if (businessType.equals("법인")){
			type = 2L;
			
		}else if (businessType.equals("개인사업자")){
			type = 3L;
			
		}
		
	
		
		
		
		
		return dao.openFunding(makerName, type, phone, memberNo);
	}


	@Override
	public FundingOpenRequireView openRequire(Long fundingNo) {
		
		
		
		
		
		return dao.openRequire(fundingNo);
	}


	@Override
	public void openRequireSave(Long fundingNo, FundingOpenRequireView fundingOpenRequireView) {
		
		dao.openRequireSave(fundingNo,fundingOpenRequireView);
		
	}
	


	@Override
	public FundingTotalInfoDto getFundingTotalInfo(Long fundingNo) {
		
		
		
		
		
		return dao.getFundingTotalInfo(fundingNo);
	}


	@Override
	public void openInfoSave(Long fundingNo, FundingOpenInfoView fundingOpenInfoView) {
		
		
		
		
		
		
		
		
		
		dao.openInfoSave(fundingNo,fundingOpenInfoView);
		
	}


	@Override
	public FundingOpenInfoView openInfo(Long fundingNo) {
		
		
		
		return dao.openInfo(fundingNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
