package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@SequenceGenerator(
		name = "MAKER_AGENT_SEQ_GENERATOR",
		sequenceName = "MAKER_AGENT_SEQ",
		initialValue = 1, allocationSize = 1)
@Entity
@Table(name="MAKER_AGENT")
public class MakerAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "MAKER_AGENT_SEQ_GENERATOR")
	@Column(name="AGENT_ID")
	private long id;
	
	
	@Column(name="MAKER_AGENT_NAME")
	private String name;
	
	@Column(name="AGENT_PHONE")
	private int phone;
	
	@Column(name="AGENT_EMAIL")
	private String email;
	
	@Column(name="RESIDENT_NUMBER")
	private int residentNumber;
	
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;
	
	@Column(name="MAKER_AGENT_TEXEMAIL")
	private String texEmail;
	
	@Column(name="MAKER_AGENT_BANK")
	private String bank;
	
	@Column(name="MAKER_AGENT_ACCOUNT_HOLDER")
	private String accountHolder;
	
	@OneToOne(mappedBy = "makerAgent")
	private FundingMaker fundingMaker;

	
	
	
	
	
	
	
	
	
	public String getAccountHolder() {
		
		if( accountHolder == null) {
			
			accountHolder= "";
							}
		
		
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getBank() {
		
		
		if( bank == null) {
			
			bank= "";
							}
		
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getTexEmail() {
		
		
	if( texEmail == null) {
			
		texEmail	= "";
							}
		
		return texEmail;
	}

	public void setTexEmail(String texEmail) {
		this.texEmail = texEmail;
	}

	public String getName() {
		
		if( name == null) {
			
			name	= "";
								}
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		
		if( email == null) {
			
			email	= "";
								}
		
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getResidentNumber() {
		return residentNumber;
	}

	public void setResidentNumber(int residentNumber) {
		this.residentNumber = residentNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public FundingMaker getFundingMaker() {
		return fundingMaker;
	}

	public void setFundingMaker(FundingMaker fundingMaker) {
		this.fundingMaker = fundingMaker;
	}


	public MakerAgent(long id, int phone, String email, int residentNumber, int accountNumber,
			FundingMaker fundingMaker) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.residentNumber = residentNumber;
		this.accountNumber = accountNumber;
		this.fundingMaker = fundingMaker;
	}

	public MakerAgent() {
		super();
	}

	@Override
	public String toString() {
		return "MakerAgent [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", residentNumber="
				+ residentNumber + ", accountNumber=" + accountNumber + ", texEmail=" + texEmail + ", ]";
	}
	
	
	
	
}
