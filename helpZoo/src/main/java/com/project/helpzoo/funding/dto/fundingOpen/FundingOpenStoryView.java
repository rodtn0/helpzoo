package com.project.helpzoo.funding.dto.fundingOpen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.funding.model.vo.funding.FundingAttachment;

public class FundingOpenStoryView {

	
	
	private String fundingSummary;
	
	private String fundingStory;

	private FundingAttachment IntroAttachment; // 펀딩 소개에 대한 파일이며 스토리에 관한 파일이며 펀딩 파일 카테고리 5번입니다.
	
	private List<FundingAttachment> images = new ArrayList<FundingAttachment>(); // 스토리에 관한 파일이며 펀딩 파일 카테고리 6번입니다.
	
	
	
	
	
	
	
	
	public FundingOpenStoryView(String fundingSummary, String fundingStory, FundingAttachment introAttachment) {
		super();
		this.fundingSummary = fundingSummary;
		this.fundingStory = fundingStory;
		IntroAttachment = introAttachment;
	}

	public FundingOpenStoryView(String fundingSummary, String fundingStory, FundingAttachment introAttachment,
			List<FundingAttachment> images) {
		super();
		this.fundingSummary = fundingSummary;
		this.fundingStory = fundingStory;
		IntroAttachment = introAttachment;
		this.images = images;
	}

	public FundingAttachment getIntroAttachment() {
		return IntroAttachment;
	}

	public void setIntroAttachment(FundingAttachment introAttachment) {
		IntroAttachment = introAttachment;
	}

	public List<FundingAttachment> getImages() {
		return images;
	}

	public void setImages(List<FundingAttachment> images) {
		this.images = images;
	}

	public FundingOpenStoryView() {
		
	}
	
	public String isSatisfied() {
		
		
		Boolean fundingSummaryIsEmpty = fundingSummary.trim().isEmpty();
		Boolean fundingStoryIsEmpty = fundingStory.trim().isEmpty();
		
		Boolean introAttachIsEmpty = IntroAttachment == null;
		
	if	(fundingStoryIsEmpty&&fundingSummaryIsEmpty&&introAttachIsEmpty) {
		
		return "작성 전";
	}
	
	else if (fundingStoryIsEmpty||fundingSummaryIsEmpty||introAttachIsEmpty){
		return "작성 중";
	}else {
		return "작성 완료";
	}
	
	
	
		
	}
	
	
	
	public FundingOpenStoryView(String fundingSummary, String fundingStory) {
		super();
		this.fundingSummary = fundingSummary;
		this.fundingStory = fundingStory;
	}

	public String getFundingSummary() {
		return fundingSummary;
	}

	public void setFundingSummary(String fundingSummary) {
		this.fundingSummary = fundingSummary;
	}

	public String getFundingStory() {
		return fundingStory;
	}

	public void setFundingStory(String fundingStory) {
		this.fundingStory = fundingStory;
	}

	@Override
	public String toString() {
		return "FundingOpenStoryView [fundingSummary=" + fundingSummary + ", fundingStory=" + fundingStory
				+ ", IntroAttachment=" + IntroAttachment + ", images=" + images + "]";
	}


	
	
	
	
}
