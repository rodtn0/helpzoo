package com.project.helpzoo.funding.model.vo.funding;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.project.helpzoo.funding.model.vo.order.Reward;


@SequenceGenerator(
		name = "FUNDING_PROJECT_SEQ_GENERATOR",
		sequenceName = "FUNDING_PROJECT_SEQ",
		initialValue = 1, allocationSize = 1)
@Entity
@Table(name="FUNDING_PROJECT")
public class FundingProject {
	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "FUNDING_PROJECT_SEQ_GENERATOR")
	
	@Column(name="FUNDING_ID")
	private long id;
	
	@Column(name="FUNDING_TITLE")
	private String title;
	
	@Column(name="FUNDING_PLAN")
	private String plan;
	
	@Column(name="FUNDING_GOAL")
	private int goalAmount;
	
	@Column(name="MANAGER_NAME")
	private String managerName;
	
	@Column(name="MANAGER_EMAIL")
	private String managerEmail;
	
	@Column(name="FUNDING_END_DAY")
	private Date endDay;
	
	@Column(name="FUNDING_SEARCH_TAG")
	private String tag;
	
	@Column(name="FUNDING_SUMMARY")
	private String summary;
	
	@Column(name="FUNDING_STORY")
	private String story;
	
	@Column(name="FUNDING_START_DAY")
	private String startDay;
	
	@Column(name="FUNDING_STATUS")
	private String status;
	
	@Column(name="MEMBER_NO")
	private int memberNo;
	
	@Column(name="READ_COUNT")
	private int readCount;
	
	@Column(name="LIKE_COUNT")
	private int likeCount;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", insertable = false, updatable = false)
	private FundingCategory category;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "INDI_OR_COPARATION_ID", insertable = false, updatable = false)
	private IndiOrCoparation indiOrCoparation;
	
	@OneToMany (mappedBy = "fundingProject")
	private List<Reward> reward;
	
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="FUNDING_MAKER_ID")
	private FundingMaker fundingMaker;



	@Override
	public String toString() {
		return "FundingProject [id=" + id + ", title=" + title + ", plan=" + plan + ", goalAmount=" + goalAmount
				+ ", managerName=" + managerName + ", managerEmail=" + managerEmail + ", endDay=" + endDay + ", tag="
				+ tag + ", summary=" + summary + ", stroy=" + story + ", startDay=" + startDay + ", status=" + status
				+ ", memberNo=" + memberNo + ", category=" + category + ", indiOrCoparation=" + indiOrCoparation
				+ ", fundingMaker=" + fundingMaker + "]";
	}


	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPlan() {
		return plan;
	}



	public void setPlan(String plan) {
		this.plan = plan;
	}



	public int getGoalAmount() {
		return goalAmount;
	}



	public void setGoalAmount(int goalAmount) {
		this.goalAmount = goalAmount;
	}



	public String getManagerName() {
		return managerName;
	}



	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}



	public String getManagerEmail() {
		return managerEmail;
	}



	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}



	public Date getEndDay() {
		return endDay;
	}



	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}



	public String getTag() {
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getstory() {
		return story;
	}



	public void setStory(String story) {
		this.story = story;
	}



	public String getStartDay() {
		return startDay;
	}



	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public FundingCategory getCategory() {
		return category;
	}



	public void setCategory(FundingCategory category) {
		this.category = category;
	}



	public IndiOrCoparation getIndiOrCoparation() {
		return indiOrCoparation;
	}



	public void setIndiOrCoparation(IndiOrCoparation indiOrCoparation) {
		this.indiOrCoparation = indiOrCoparation;
	}



	public FundingMaker getFundingMaker() {
		return fundingMaker;
	}



	public void setFundingMaker(FundingMaker fundingMaker) {
		this.fundingMaker = fundingMaker;
	}



	public FundingProject(long id, String title, String plan, int goalAmount, String managerName, String managerEmail,
			Date endDay, String tag, String summary, String story, String startDay, String status, int memberNo,
			FundingCategory category, IndiOrCoparation indiOrCoparation, FundingMaker fundingMaker) {
		super();
		this.id = id;
		this.title = title;
		this.plan = plan;
		this.goalAmount = goalAmount;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.endDay = endDay;
		this.tag = tag;
		this.summary = summary;
		this.story = story;
		this.startDay = startDay;
		this.status = status;
		this.memberNo = memberNo;
		this.category = category;
		this.indiOrCoparation = indiOrCoparation;
		this.fundingMaker = fundingMaker;
	}



	public FundingProject() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
