package com.project.helpzoo.funding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.dto.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.FundingTotalInfoDto;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.member.model.vo.Member;



@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/funding/*")
public class FundingController {
	
	@Autowired
	private FundingService service;
	
	

	
	
	
	@RequestMapping("fundingMain")
	public String fundingMain() {
	
		
		
		return "funding/fundingMain";
	}
	
	
	
	
	
	
	/** 펀딩 게시물에 대한 view 이동 컨트롤러
	 * @param fundingNo
	 * @param model
	 * @return
	 */
	@RequestMapping("fundingView/{fundingNo}")
	public String fundingView(@PathVariable int fundingNo, Model model) {
		
		
		FundingDetailViewDto funding = service.selectFunding(fundingNo);
		
		model.addAttribute("funding", funding);
		
		
		
		
		return "funding/fundingDetail";
	}
	

	
	
	/**펀딩 프로젝트 시작 시 처음 화면으로 이동하는 컨트롤러.
	 * @return
	 */
	@RequestMapping("fundingOpen")
	public String fundingOpen() {
		
	
	
		
		return "funding/fundingOpen";
	}
	
	
	
	
	
	
	
	
	
	

	/** 첫 상세페이지 오픈 컨트롤러
	 * @param makerName
	 * @param businessType
	 * @param phone
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "fundingOpenDetail", method = RequestMethod.POST)
	public String fundingOpenDetail(String makerName, String businessType, int phone,
									
			Model model) {
		
		
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		System.out.println(loginMember);
		
		
		int memberNo = loginMember.getMemberNo();


		Long fundingNo = service.openFunding(makerName,businessType,phone,memberNo);
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);
		
		
		
		
		
		
		return "funding/fundingOpenDetail";
	}
	
	
	/** 오픈 상세페이지 조회 컨트롤러
	 * @param makerName
	 * @param businessType
	 * @param phone
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "fundingOpenDetail", method = RequestMethod.GET)
	public String fundingOpenDetailView(Long fundingNo, String makerName, Model model) {
		
		
		
		FundingTotalInfoDto fundingTotalInfoDto = service.getFundingTotalInfo(fundingNo);
		
		
		FundingOpenInfoView fundingOpenInfoView = fundingTotalInfoDto.getFundingOpenInfoView();
		
		FundingOpenMakerInfoView fundingOpenMakerInfoView = fundingTotalInfoDto.getFundingOpenMakerInfoView();
		
		FundingOpenRequireView fundingOpenRequireView = fundingTotalInfoDto.getFundingOpenRequireView();
		
		List<FundingOpenRewardView> fundingOpenRewardView = fundingTotalInfoDto.getFundingOpenRewardView();
		
		FundingOpenStoryView fundingOpenStoryView = fundingTotalInfoDto.getFundingOpenStoryView();
		
		
		
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);
		
		model.addAttribute("fundingOpenInfoView", fundingOpenInfoView);
		
		model.addAttribute("fundingOpenMakerInfoView", fundingOpenMakerInfoView);
		
		model.addAttribute("fundingOpenRequireView", fundingOpenRequireView);
		
		model.addAttribute("fundingOpenRewardView ", fundingOpenRewardView);
		
		model.addAttribute("fundingOpenStoryView", fundingOpenStoryView);
		
		
		
		
		
		
		
		
		
		
		return "funding/fundingOpenDetail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/** 펀딩오픈 시 기본요건 입력 뷰 이동 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="fundingOpenRequire/{fundingNo}", method = RequestMethod.GET)
	public String fundingOpenRequire(Model model ,@PathVariable Long fundingNo) {
		
		
		
		
		FundingOpenRequireView fundingOpenRequireView = service.openRequire(fundingNo);
		
		
		model.addAttribute("fundingOpenRequireView", fundingOpenRequireView);
		
		
		
		return "funding/fundingOpenReq";
	}
	
	
	
	/** 펀딩오픈 시 기본요건 입력 후 저장시 뷰 이동 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="fundingOpenRequire/{fundingNo}", method = RequestMethod.POST)
	public String fundingOpenRequireSave(Model model,@PathVariable Long fundingNo) {
		
		
		
		
		String rewardDeliveryPlan = (String)model.getAttribute("rewardDeliveryPlan");
		
		String rewardMakePlan = (String)model.getAttribute("rewardMakePlan");
		
		
		FundingOpenRequireView fundingOpenRequireView = new FundingOpenRequireView(rewardMakePlan, rewardDeliveryPlan);
		
		
		service.openRequireSave(fundingNo,fundingOpenRequireView);
		
		
		
		
		
		
		
		return "funding/fundingOpenDetail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** 펀딩오픈 시 기본정보 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping("fundingOpenInfo")
	public String fundingOpenInfo() {
		

		
		
		return "funding/fundingOpenInfo";
	}
	
	
	
	
	/** 펀딩오픈 시 펀딩스토리 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping("fundingOpenStory")
	public String fundingOpenStory() {
		

		
		
		return "funding/fundingOpenStory";
	}
	
	
	
	
	/** 펀딩오픈 시 리워드 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping("fundingOpenReward")
	public String fundingOpenReward() {
		

		
		
		return "funding/fundingRewardDesign";
	}
	
	
	
	
	/** 펀딩오픈 시 메이커 정보 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping("fundingOpenMakerInfo")
	public String fundingOpenMakerInfo() {
		

		
		
		return "funding/fundingOpenMakerInfo";
	}
					   
	
	
	
	
	
	
	
	
	
	public void fundingStatusChange() {
		
		
		
	
		
	
	}
	
	
	

	
	
	
	

}
