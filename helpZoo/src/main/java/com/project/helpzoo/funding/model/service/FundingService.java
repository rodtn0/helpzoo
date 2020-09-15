package com.project.helpzoo.funding.model.service;

import java.util.List;

import com.project.helpzoo.funding.dto.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.FundingMainViewDto;
import com.project.helpzoo.funding.dto.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.FundingTotalInfoDto;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;

public interface FundingService {

	
	
	/** 펀딩 메인 뷰의 list를 가져오는 service.
	 * @param cp
	 * @param fundingSearch
	 * @return
	 */
	List<FundingMainViewDto> selectList(int cp, FundingSearch fundingSearch);

	
	
	/** 24시 정각에 현재 등록된 펀딩프로젝트를 확인하여 종료일이 지난 프로젝트를 종료상태로 만드는 service.
	 * 
	 */
	void fundingStatusChange();

	/** 펀딩을 클릭 후 해당하는 번호의 펀딩 내용을 가져오는 service.
	 * @param fundingNo
	 * @return
	 */
	FundingDetailViewDto selectFunding(int fundingNo);
	
	

	/** 펀딩 처음 오픈 시 사용하는 service.
	 * @param makerName
	 * @param businessType
	 * @param phone
	 * @param memberNo
	 * @return
	 */
	Long openFunding(String makerName, String businessType, int phone,int memberNo);



	/** 펀딩 오픈 시 미리 입력한 기본요건을 받아오는 서비스.
	 * @param fundingNo
	 * @return
	 */
	FundingOpenRequireView openRequire(Long fundingNo);



	void openRequireSave(Long fundingNo, FundingOpenRequireView fundingOpenRequireView);



	FundingTotalInfoDto getFundingTotalInfo(Long fundingNo);

	
}
