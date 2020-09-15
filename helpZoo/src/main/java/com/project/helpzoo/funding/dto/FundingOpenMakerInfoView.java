package com.project.helpzoo.funding.dto;

public class FundingOpenMakerInfoView {
	
	
	private String name;
	
	private String email;
	
	private int phone;
	
	private String kakaoId;
	
	private String kakaoUrl;
	
	private String homepage1;
	
	private String homepage2;
	
	private String sns1;
	
	private String sns2;
	
	private String sns3;
	
	private String businessType;
	

// 	대표자 정보
	
	
	private String agentName;
	
	private String agentEmail;
	
	private int agentPhone;
	
	private String taxEmail;
	
	private String bank;
	
	private int accountNumber;
	
	private String accountHolder;

	
	
	
	
	
	
	public FundingOpenMakerInfoView() {
		
	}
	
	
	
	
	
	// 필요 조건을 충족했는가.
	public String isSatisfied() {
		
		Boolean makerNameIsEmpty = name.isEmpty();
		Boolean emailIsEmpty = email.isEmpty();
		Boolean phoneIsEmpty = phone==0;


//사업자		
		Boolean businessTypeIsEmpty = businessType.isEmpty();
		Boolean agentNameIsEmpty = agentName.isEmpty();
		Boolean agentEmailIsEmpty = agentEmail.isEmpty();
		Boolean agentPhoneIsEmpty = agentPhone ==0;
		Boolean taxEmailIsEmpty = taxEmail.isEmpty();
		Boolean bankIsEmpty = bank.isEmpty();
		Boolean accountIsEmpty = accountNumber ==0;
		Boolean accountHolderIsEmpty = accountHolder.isEmpty();
		
		
		if(makerNameIsEmpty&&emailIsEmpty&&phoneIsEmpty&&businessTypeIsEmpty&&agentNameIsEmpty&&agentEmailIsEmpty&&agentPhoneIsEmpty
				&&taxEmailIsEmpty&&bankIsEmpty&&accountIsEmpty&&accountHolderIsEmpty) {
			
			return "작성 전";
			
		}else if(makerNameIsEmpty||emailIsEmpty||phoneIsEmpty||businessTypeIsEmpty||agentNameIsEmpty||agentEmailIsEmpty||agentPhoneIsEmpty
				||taxEmailIsEmpty||bankIsEmpty||accountIsEmpty||accountHolderIsEmpty) {
			
			return "작성 중";
		}else {
			
			return "작성 완료";
		}
		
		
		
	}
	
	
	
	
	
	
	
	public FundingOpenMakerInfoView(String name, String email, int phone, String kakaoId, String kakaoUrl,
			String homepage1, String homepage2, String sns1, String sns2, String sns3, String businessType,
			String agentName, String agentEmail, int agentPhone, String taxEmail, String bank, int accountNumber,
			String accountHolder) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.kakaoId = kakaoId;
		this.kakaoUrl = kakaoUrl;
		this.homepage1 = homepage1;
		this.homepage2 = homepage2;
		this.sns1 = sns1;
		this.sns2 = sns2;
		this.sns3 = sns3;
		this.businessType = businessType;
		this.agentName = agentName;
		this.agentEmail = agentEmail;
		this.agentPhone = agentPhone;
		this.taxEmail = taxEmail;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}

	public String getKakaoUrl() {
		return kakaoUrl;
	}

	public void setKakaoUrl(String kakaoUrl) {
		this.kakaoUrl = kakaoUrl;
	}

	public String getHomepage1() {
		return homepage1;
	}

	public void setHomepage1(String homepage1) {
		this.homepage1 = homepage1;
	}

	public String getHomepage2() {
		return homepage2;
	}

	public void setHomepage2(String homepage2) {
		this.homepage2 = homepage2;
	}

	public String getSns1() {
		return sns1;
	}

	public void setSns1(String sns1) {
		this.sns1 = sns1;
	}

	public String getSns2() {
		return sns2;
	}

	public void setSns2(String sns2) {
		this.sns2 = sns2;
	}

	public String getSns3() {
		return sns3;
	}

	public void setSns3(String sns3) {
		this.sns3 = sns3;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public int getAgentPhone() {
		
		return agentPhone;
	}

	public void setAgentPhone(int agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getTaxEmail() {
		return taxEmail;
	}

	public void setTaxEmail(String taxEmail) {
		this.taxEmail = taxEmail;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public String toString() {
		return "FundingOpenMakerInfoView [name=" + name + ", email=" + email + ", phone=" + phone + ", kakaoId="
				+ kakaoId + ", kakaoUrl=" + kakaoUrl + ", homepage1=" + homepage1 + ", homepage2=" + homepage2
				+ ", sns1=" + sns1 + ", sns2=" + sns2 + ", sns3=" + sns3 + ", businessType=" + businessType
				+ ", agentName=" + agentName + ", agentEmail=" + agentEmail + ", agentPhone=" + agentPhone
				+ ", taxEmail=" + taxEmail + ", bank=" + bank + ", accountNumber=" + accountNumber + ", accountHolder="
				+ accountHolder + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
