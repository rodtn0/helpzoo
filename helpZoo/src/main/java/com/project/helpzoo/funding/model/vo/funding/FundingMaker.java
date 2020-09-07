package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FUNDING_MAKER")
public class FundingMaker {
	
	@Id
	@Column(name="FUNDING_MAKER_ID")
	private long id;

	@Column(name="FUNDING_MAKER_NAME")
	private String name;
	
	@Column(name="FUNDING_MAKER_EMAIL")
	private String email;
	
	@Column(name="FUNDING_MAKER_PHONE")
	private String phone;
	
	@Column(name="FUNDING_MAKER_KAKAO_ID")
	private String kakaoId;
	
	@Column(name="FUNDING_MAKER_KAKAO_URL")
	private String kakaoURL;
	
	@Column(name="FUNDING_MAKER_SNS")
	private String sns;
	
	@Column(name="FUNDING_MAKER_SNS2")
	private String sns2;
	
	@Column(name="FUNDING_MAKER_SNS3")
	private String sns3;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="AGENT_ID")
	private MakerAgent makerAgent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FundingMaker() {
		super();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}

	public String getKakaoURL() {
		return kakaoURL;
	}

	public void setKakaoURL(String kakaoURL) {
		this.kakaoURL = kakaoURL;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
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

	public MakerAgent getMakerAgent() {
		return makerAgent;
	}

	public void setMakerAgent(MakerAgent makerAgent) {
		this.makerAgent = makerAgent;
	}

	@Override
	public String toString() {
		return "FundingMaker [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", kakaoId="
				+ kakaoId + ", kakaoURL=" + kakaoURL + ", sns=" + sns + ", sns2=" + sns2 + ", sns3=" + sns3
				+ ", makerAgent=" + makerAgent + "]";
	}

	public FundingMaker(long id, String name, String email, String phone, String kakaoId, String kakaoURL, String sns,
			String sns2, String sns3, MakerAgent makerAgent) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.kakaoId = kakaoId;
		this.kakaoURL = kakaoURL;
		this.sns = sns;
		this.sns2 = sns2;
		this.sns3 = sns3;
		this.makerAgent = makerAgent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
