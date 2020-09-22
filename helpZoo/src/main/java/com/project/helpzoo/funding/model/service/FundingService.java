package com.project.helpzoo.funding.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingTotalInfoDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
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
	 * @param string2 
	 * @param string 
	 * @return
	 */
	Long openFunding(String makerName, String businessType, int phone,int memberNo, String string, String string2);



	/** 펀딩 오픈 시 미리 입력한 기본요건을 받아오는 서비스.
	 * @param fundingNo
	 * @return
	 */
	FundingOpenRequireView openRequire(Long fundingNo);



	void openRequireSave(Long fundingNo, FundingOpenRequireView fundingOpenRequireView);



	FundingTotalInfoDto getFundingTotalInfo(Long fundingNo);



	void openInfoSave(Long fundingNo, FundingOpenInfoView fundingOpenInfoView);



	FundingOpenInfoView openInfo(Long fundingNo);



	void insertfundingStoryFile(FundingProject funding, List<MultipartFile> images, String savePath);

	
	//-----------------------------------------Summernote-----------------------------------------
	/** Summernote 이미지 업로드 Service
	 * @param uploadFile
	 * @param savePath
	 * @return map
	 */
	public abstract Map<String, String> insertImage(MultipartFile uploadFile, String savePath);

		
	/** DB에 저장된 파일 목록 조회 Service
	 * @return dbFileList
	 */
	public abstract List<String> selectDbFileList();
	//---------------------------------------------------------------------------------------------



	FundingOpenStoryView openStory(Long fundingNo);



	void insertfundingFile(FundingProject funding, ArrayList<MultipartFile> images, String savePath, Long fileCategory);



	void openRewardSave(Long fundingNo, FundingOpenRewardView rewardView);



	void openMakerSave(FundingOpenMakerInfoView fundingOpenMakerView, Long fundingNo);



	List<FundingDetailRewardView> selectReward(Long fundingNo);
	
	
}
