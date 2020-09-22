package com.project.helpzoo.funding.model.vo.funding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FUNDING_IMAGE")
@SequenceGenerator(
		name = "FD_IMAGE_SEQ_GENERATOR",
		sequenceName = "FD_IMAGE_SEQ",
		initialValue = 1, allocationSize = 1)
public class FundingAttachment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "FD_IMAGE_SEQ_GENERATOR")
	@Column(name="FUNDING_FILE_NO")
	private Long fundingFileNo;
	
	@Column(name="FILE_ORIGIN_NAME")
	private String fileOriginName;
	
	@Column(name="FILE_CHANGE_NAME")
	private String fileChangeName;
	
	@Column(name="FILE_PATH")
	private String filePath;
	
	@Column(name="FILE_LEVEL")
	private int fileLevel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_PROJECT_NO")
	private FundingProject parentFunding;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUNDING_FILE_CATEGORY_ID")
	private FundingFileCategory fundingFileCategory;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REWARD_ID")
	private Reward reward;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "FUNDING_MAKER_ID")
	private FundingMaker maker;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "AGENT_ID")
	private MakerAgent agent;
	
	

	
	
	
	
	
	
	
	public FundingAttachment() {
		
	}
	

	
	

	

	public FundingAttachment(String fileOriginName, String fileChangeName, String filePath, int fileLevel,
			FundingProject parentFunding, FundingFileCategory fundingFileCategory) {
		super();
		this.fileOriginName = fileOriginName;
		this.fileChangeName = fileChangeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.parentFunding = parentFunding;
		this.fundingFileCategory = fundingFileCategory;
	}

	public FundingAttachment(Long fundingFileNo, String fileOriginName, String fileChangeName, String filePath,
			int fileLevel, FundingProject parentFunding) {
		super();
		this.fundingFileNo = fundingFileNo;
		this.fileOriginName = fileOriginName;
		this.fileChangeName = fileChangeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.parentFunding = parentFunding;
	}

	public Long getFundingFileNo() {
		return fundingFileNo;
	}

	public void setFundingFileNo(Long fundingFileNo) {
		this.fundingFileNo = fundingFileNo;
	}

	public String getFileOriginName() {
		return fileOriginName;
	}

	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}

	public String getFileChangeName() {
		return fileChangeName;
	}

	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public FundingProject getParentFunding() {
		return parentFunding;
	}

	public void setParentFunding(FundingProject parentFunding) {
		this.parentFunding = parentFunding;
	}

	public FundingFileCategory getFundingCategory() {
		return fundingFileCategory;
	}

	public void setFundingCategory(FundingFileCategory fundingCategory) {
		this.fundingFileCategory = fundingCategory;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}


	public FundingMaker getMaker() {
		return maker;
	}

	public void setMaker(FundingMaker maker) {
		this.maker = maker;
	}

	public MakerAgent getAgent() {
		return agent;
	}

	public void setAgent(MakerAgent agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "FundingAttachment [fundingFileNo=" + fundingFileNo + ", fileOriginName=" + fileOriginName
				+ ", fileChangeName=" + fileChangeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel + "]";
	}
	
	
	
	
	
}









