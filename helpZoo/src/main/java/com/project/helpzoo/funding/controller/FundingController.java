package com.project.helpzoo.funding.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingTotalInfoDto;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.service.FundingService;
import com.project.helpzoo.funding.model.vo.funding.FundingFileCategory;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.member.model.vo.Member;



@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/funding/*")
public class FundingController {
	
	@Autowired
	private FundingService service;
	
	@Autowired
	private FundingDAO dao;

	
	
	
	@RequestMapping("fundingMain")
	public String fundingMain() {
	
		
		
		return "funding/fundingMain";
	}
	
	//-----------------------------------------Summernote-----------------------------------------
		// Summernote 이미지 업로드
		@ResponseBody
		@RequestMapping("fundingOpenStory/insertImage")
		public String insertImage(HttpServletRequest request,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile) {
			
		
			String savePath =  request.getSession().getServletContext().getRealPath("resources/infoImages/");
			
			Map<String, String> result = service.insertImage(uploadFile, savePath);
			return new Gson().toJson(result);
		}
		//--------------------------------------------------------------------------------------------
	
	
	
	
	
	
	/** 펀딩 게시물에 대한 view 이동 컨트롤러
	 * @param fundingNo
	 * @param model
	 * @return
	 */
	@RequestMapping("fundingView/{fundingNo}")
	public String fundingView(@PathVariable int fundingNo, Model model) {
		
		
		FundingDetailViewDto funding = service.selectFunding(fundingNo);
		
		model.addAttribute("funding", funding);
		
		model.addAttribute("fundingNo", fundingNo);
		
		
		
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
	public String fundingOpenDetail(String makerName, String businessType, 
									
			Model model, HttpServletResponse response) {
		
		response.setHeader("Pragma", "no-cache"); 

		response.setHeader("Cache-Control", "no-cache"); 
		
		
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		String phone = loginMember.getMemberPhone();
	
		
		phone = phone.replaceAll("-", "");
		
		phone = phone.trim();
		
		
		
		int phoneNum = Integer.parseInt(phone);
		
		
		int memberNo = loginMember.getMemberNo();
		

		Long fundingNo = service.openFunding(makerName,businessType,phoneNum,memberNo,loginMember.getMemberName(),loginMember.getMemberEmail());
		
		
		
		openDetailViewMake(fundingNo, model);
		
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
	public String fundingOpenDetailView(Long fundingNo,  Model model) {
		
		
		
			openDetailViewMake(fundingNo, model);
	
			
			String makerName = 	dao.getMakerName(fundingNo);
			
			
			model.addAttribute("fundingNo", fundingNo);
			model.addAttribute("makerName", makerName);

		
		
		return "funding/fundingOpenDetail";
	}

	
	
	
	
	
	
	
	/** 펀딩오픈 시 기본요건 입력 뷰 이동 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="fundingOpenRequire/{fundingNo}", method = RequestMethod.GET)
	public String fundingOpenRequire(Model model ,@PathVariable Long fundingNo) {
		
		String makerName = 	dao.getMakerName(fundingNo);
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);
		
		
		FundingOpenRequireView fundingOpenRequireView = service.openRequire(fundingNo);
		
		
		model.addAttribute("fundingOpenRequireView", fundingOpenRequireView);
		
		
		
		return "funding/fundingOpenReq";
	}
	
	
	
	
	

	/** 펀딩오픈 시 기본정보 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping(value = "fundingOpenInfo/{fundingNo}", method = RequestMethod.GET)
	public String fundingOpenInfo(Model model ,@PathVariable Long fundingNo) {
		
		
		String makerName = 	dao.getMakerName(fundingNo);
		
		

		
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);
		
		FundingOpenInfoView fundingOpenInfoView = service.openInfo(fundingNo);
		
		
		model.addAttribute("fundingOpenInfoView", fundingOpenInfoView);
		
		
		
		
		
		return "funding/fundingOpenInfo";
	}
	
		
	
	
	
	
	
	/** 펀딩오픈 시 펀딩스토리 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping(value = "fundingOpenStory/{fundingNo}" , method = RequestMethod.GET)
	public String fundingOpenStory(@PathVariable Long fundingNo, Model model) {
		
		String makerName = 	dao.getMakerName(fundingNo);
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);
		
		
		FundingOpenStoryView fundingOpenStoryView = service.openStory(fundingNo);
		
		model.addAttribute("fundingOpenInfoView", fundingOpenStoryView);
		
		
		return "funding/fundingOpenStory";
	}
	
	
	
	
	
	
	
	
	/** 펀딩오픈 시 리워드 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping(value = "fundingOpenReward/{fundingNo}", method = RequestMethod.GET)
	public String fundingOpenReward(@PathVariable Long fundingNo, Model model) {
		
		String makerName = 	dao.getMakerName(fundingNo);
		
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);

		
		
		return "funding/fundingRewardDesign";
	}
	
	
	
	
	/** 펀딩오픈 시 메이커 정보 입력 뷰 이동 컨트롤러
	 * @return
	 */
	@RequestMapping(value = "fundingOpenMakerInfo/{fundingNo}" , method = RequestMethod.GET)
	public String fundingOpenMakerInfo(@PathVariable Long fundingNo, Model model) {
		
		String makerName = 	dao.getMakerName(fundingNo);
		
		model.addAttribute("fundingNo", fundingNo);
		
		model.addAttribute("makerName", makerName);
		
		
		
		

		
		
		return "funding/fundingOpenMakerInfo";
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void insertAction(FundingOpenStoryView fundingStory,
			Long fundingNo,
			HttpServletRequest request,
			MultipartFile introPhoto,
			List<MultipartFile> images
			) {
			
			
			FundingProject funding = dao.findFundingOne(fundingNo,fundingStory);
			
			
			//-----------------------------------------Summernote-----------------------------------------
			// name속성 값이 "images"인 파라미터 자체가 전달되지 않아 images 리스트가 생성되지 않아
					// images.add(0, thumbnail); 코드 진행 시 NullPointerException이 발생함.
			if(images.isEmpty()) { 
				images = new ArrayList<>();
			}
			//--------------------------------------------------------------------------------------------
			
			//썸네일 이미지 정보를 images 리스트 제일 앞에 추가
			images.add(0,introPhoto);
			
			// 파일을 저장할 경로 서버 컴퓨터의 로컬 경로
			String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
			
			// 게시글 작성 서비스 호출
			service.insertfundingStoryFile(funding,images,savePath);
			

}



@RequestMapping(value = "fundingOpenSubmit/{fundingNo}" , method = RequestMethod.GET)
public String fundingOpenSubmit(@PathVariable Long fundingNo, 
		Model model,
		HttpServletResponse response	) {
	
	
	

	response.setHeader("Pragma", "no-cache"); 

	response.setHeader("Cache-Control", "no-cache"); 
	
	
	dao.fundingStart(fundingNo);
	
	
	
	
	
	
	
	
	return "redirect:/";
}
	









@RequestMapping(value = "fundingOpenMakerInfo/{fundingNo}" , method = RequestMethod.POST)
public String fundingOpenMakerInfoSave(Model model,@PathVariable Long fundingNo,
		HttpServletResponse response,HttpServletRequest request,
		String name,
		String email,
		int phone,
		String kakaoId,
		String kakaoUrl,
		String homepage1,
		String homepage2,
		String sns1,
		String sns2,
		String sns3,
		String businessType,
		String agentName,
		String agentEmail,
		int agentPhone,
		String bank,
		int accountNumber,
		String accountHolder,
		@RequestParam(value="makerImage",required=false) MultipartFile makerImage
		
		) {
	
	
	
	response.setHeader("Pragma", "no-cache"); 

	response.setHeader("Cache-Control", "no-cache"); 
	
	
	

	System.out.println("메이커 컨트롤러 펀딩넘버 : " + fundingNo);
	
	FundingOpenMakerInfoView fundingOpenMakerView = new FundingOpenMakerInfoView(
	name, email, phone, kakaoId, kakaoUrl, homepage1, homepage2, sns1, 
	sns2, sns3, businessType, agentName, agentEmail, agentPhone, bank, accountNumber, accountHolder);
	
	
	
	
	
	Long fileCategory = 3L; // 메이커 사진파일 카테고리 id번호.
	
	
	
	insertImage(fundingNo, request,makerImage, new ArrayList<MultipartFile>(),fileCategory);
	
	
	
	service.openMakerSave(fundingOpenMakerView,fundingNo);
	
	
	

	String makerName = dao.getMakerName(fundingNo);
	
	model.addAttribute("fundingNo", fundingNo);
	
	model.addAttribute("makerName", makerName);
	
	
	openDetailViewMake(fundingNo, model);
	
	
	
	return "funding/fundingOpenDetail";
	
}


	
	
	

@RequestMapping(value = "fundingOpenReward/{fundingNo}", method = RequestMethod.POST)
public String fundingOpenRewardSave(@PathVariable Long fundingNo, Model model, HttpServletResponse response,
		int price,
		String title,
		String content,
		String option,
		int deleveryPrice,
		int rewardAmount,
		String deliveryDay
		
		) {
	
	
	
	Timestamp deliDay = null;
	
	
	
	
	
	
	if(deliveryDay != null && !deliveryDay.trim().isEmpty()) {
	Calendar cal;
	
	SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");

	String date = new String(deliveryDay);
	
	Timestamp time = null;
	
	try {
		   sd.parse(date);
		   cal=sd.getCalendar();
		   time = new Timestamp(cal.getTime().getTime());
		   System.out.println(time);
		  } catch (ParseException e) {
		   e.printStackTrace();
		  }

	deliDay = time;
	
	}
	
	FundingOpenRewardView rewardView = new FundingOpenRewardView(price, title, content, option, deleveryPrice, rewardAmount, deliDay);
	
	System.out.println("rewardView" + rewardView);
	
	response.setHeader("Pragma", "no-cache"); 

	response.setHeader("Cache-Control", "no-cache"); 
	
	
	
	
	service.openRewardSave(fundingNo, rewardView);
	
	
	
	
	
	
	
	
	String makerName = 	dao.getMakerName(fundingNo);
	
	
	model.addAttribute("fundingNo", fundingNo);
	
	model.addAttribute("makerName", makerName);
	

	
	
	
	return "funding/fundingRewardDesign";
}

	
	

	

@RequestMapping(value = "fundingOpenStory/{fundingNo}" , method = RequestMethod.POST)
public String fundingOpenStorySave(@PathVariable Long fundingNo, 
		Model model,
		HttpServletResponse response, 
		FundingOpenStoryView fundingStory, 
		HttpServletRequest request,
		@RequestParam(value="introPhoto",required=false)	MultipartFile introPhoto
		) {
	
	
	

	response.setHeader("Pragma", "no-cache"); 

	response.setHeader("Cache-Control", "no-cache"); 
	
	insertAction(fundingStory, fundingNo, request,introPhoto, new ArrayList<MultipartFile>());
	
	
	
	
	String makerName = dao.getMakerName(fundingNo);
	
	model.addAttribute("fundingNo", fundingNo);
	
	model.addAttribute("makerName", makerName);
	
	
	openDetailViewMake(fundingNo, model);
	
	
	
	return "funding/fundingOpenDetail";
}
	
	
	
	
	
	/** 펀딩오픈 시 기본요건 입력 후 저장시 뷰 이동 컨트롤러
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="fundingOpenRequire/{fundingNo}", method = RequestMethod.POST)
	public String fundingOpenRequireSave(Model model,@PathVariable Long fundingNo ,
			@RequestParam(value = "rewardDeliveryPlan", required = false)String rewardDeliveryPlan,
			@RequestParam(value = "rewardMakePlan", required = false)String rewardMakePlan,
			HttpServletResponse response
			) {
		
		
		
		response.setHeader("Pragma", "no-cache"); 

		response.setHeader("Cache-Control", "no-cache"); 
		
		
		
		FundingOpenRequireView fundingOpenRequireView = new FundingOpenRequireView(rewardMakePlan, rewardDeliveryPlan);
		
		service.openRequireSave(fundingNo,fundingOpenRequireView);
		
		
		
		openDetailViewMake(fundingNo, model);
		
		
		
		
		
		return "funding/fundingOpenDetail";
	}
	
	
	
	
	
	
	
	
	
	/** 펀딩오픈 시 기본정보 입력 후 저장시 뷰 이동 컨트롤러
	 * @param model
	 * @return
	 */						
	@RequestMapping(value ="fundingOpenInfo/{fundingNo}", method = RequestMethod.POST)
	public String fundingOpenInfoSave(Model model,@PathVariable Long fundingNo ,
			@RequestParam(value = "fundingTitle", required = false)String fundingTitle,
			@RequestParam(value = "fundingGoal", required = false)int fundingGoal,
			@RequestParam(value = "category", required = false)String category,
			@RequestParam(value = "fundingTag", required = false)String fundingTag, 
			@RequestParam(value = "fundingEndDay", required = false)String fundingEndDay,
			HttpServletRequest request,
			@RequestParam(value="titleImage",required=false) MultipartFile titleImage,
			HttpServletResponse response
			) {
		
		Timestamp endDay = null;
		
		
		
		
		
		
		if(fundingEndDay != null && !fundingEndDay.trim().isEmpty()) {
		Calendar cal;
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");

		String date = new String(fundingEndDay);
		
		Timestamp time = null;
		
		try {
			   sd.parse(date);
			   cal=sd.getCalendar();
			   time = new Timestamp(cal.getTime().getTime());
			   System.out.println(time);
			  } catch (ParseException e) {
			   e.printStackTrace();
			  }

		endDay = time;
		
		}
		
		
		response.setHeader("Pragma", "no-cache"); 

		response.setHeader("Cache-Control", "no-cache"); 
			
		Long categoryNo = 0L;
		if(fundingTag.equals("장난감")) {
			
			categoryNo = 1L;
			
		}else if (fundingTag.equals("사료")) {
			
			categoryNo = 2L;
		}else if(fundingTag.equals("운동기구")) {
			
			categoryNo = 3L;
		}else if(fundingTag.equals("옷")) {
			
			categoryNo = 4L;
		}else if(fundingTag.equals("간식")) {
			
			categoryNo = 5L;
		}
		
		
		
		
		FundingOpenInfoView fundingOpenInfoView = new FundingOpenInfoView(fundingTitle, fundingGoal, categoryNo, endDay, fundingTag);
		
		
		
		
		Long fileCategory = 1L;
		
		
		
		insertImage(fundingNo, request,titleImage, new ArrayList<MultipartFile>(),fileCategory);
		
		
		
		service.openInfoSave(fundingNo,fundingOpenInfoView);
		
		
		
		
		openDetailViewMake(fundingNo, model);
		
		
		
		
		
		return "funding/fundingOpenDetail";
	}
	
	
	
	
	
	private void insertImage(Long fundingNo, HttpServletRequest request, MultipartFile titleImage,
			ArrayList<MultipartFile> images, Long fileCategory) {


		
		
		FundingProject funding = dao.findFunding(fundingNo);
		
		
		//-----------------------------------------Summernote-----------------------------------------
		// name속성 값이 "images"인 파라미터 자체가 전달되지 않아 images 리스트가 생성되지 않아
				// images.add(0, thumbnail); 코드 진행 시 NullPointerException이 발생함.
		if(images.isEmpty()) { 
			images = new ArrayList<>();
		}
		//--------------------------------------------------------------------------------------------
		
		//썸네일 이미지 정보를 images 리스트 제일 앞에 추가
		images.add(0,titleImage);
		
		
		
		// 파일을 저장할 경로 서버 컴퓨터의 로컬 경로
		String savePath = request.getSession().getServletContext().getRealPath("resources/uploadImages");
		
		// 게시글 작성 서비스 호출
		service.insertfundingFile(funding,images,savePath,fileCategory);
		
		
		
		
	}

	
	
	
	
	
	
	
	public void fundingStatusChange() {
		
		
		
	
		
	
	}
	
	
	
	
	
	
	
	

	private void openDetailViewMake(Long fundingNo, Model model) {
		

		
		
			FundingTotalInfoDto fundingTotalInfoDto = service.getFundingTotalInfo(fundingNo);
			
			
			FundingOpenInfoView fundingOpenInfoView = fundingTotalInfoDto.getFundingOpenInfoView();
			
			FundingOpenMakerInfoView fundingOpenMakerInfoView = fundingTotalInfoDto.getFundingOpenMakerInfoView();
			
			FundingOpenRequireView fundingOpenRequireView = fundingTotalInfoDto.getFundingOpenRequireView();
			
			List<FundingOpenRewardView> fundingOpenRewardView = fundingTotalInfoDto.getFundingOpenRewardView();
			
			FundingOpenStoryView fundingOpenStoryView = fundingTotalInfoDto.getFundingOpenStoryView();
			
			
			String rewardStatus = null;
			
			if(fundingOpenRewardView.isEmpty()) {
				rewardStatus = "작성 전";
			}else {
				rewardStatus = "작성 완료";
			}
			
			
			String allSatis =null;
			
			if(fundingTotalInfoDto.isSatisfied()) {
				
				allSatis = "작성 완료";
				
			}else {
				
				allSatis = "작성 중";
			}
			
			
			
			model.addAttribute("makerName", fundingOpenMakerInfoView.getName());
			
			
			
			
			model.addAttribute("OpenInfoStatus", fundingOpenInfoView.isSatisfied());
			
			model.addAttribute("OpenMakerInfo", fundingOpenMakerInfoView.isSatisfied());
			
			model.addAttribute("OpenRequire", fundingOpenRequireView.isSatisfied());

			model.addAttribute("OpenReward", rewardStatus);
			
			model.addAttribute("OpenStory", fundingOpenStoryView.isSatisfied());
			
			model.addAttribute("allSatis", allSatis);
	}
	
	

	
	
	
	

}
