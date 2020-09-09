package com.project.helpzoo.funding.model.service;

import java.util.List;

import com.project.helpzoo.funding.dto.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.FundingMainViewDto;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;

public interface FundingService {

	List<FundingMainViewDto> selectList(int cp, FundingSearch fundingSearch);

	void fundingStatusChange();

	FundingDetailViewDto selectFunding(int fundingNo);

}
