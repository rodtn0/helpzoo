package com.project.helpzoo.funding.model.vo.funding;

import java.sql.Date;
import java.sql.Timestamp;
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
	private Timestamp endDay;
	
	@Column(name="FUNDING_SEARCH_TAG")
	private String tag;
	
	@Column(name="FUNDING_SUMMARY")
	private String summary;
	
	@Column(name="FUNDING_STORY")
	private String story;
	
	@Column(name="FUNDING_START_DAY")
	private Timestamp startDay;
	
	@Column(name="FUNDING_STATUS")
	private String status;
	
	@Column(name="MEMBER_NO")
	private int memberNo;
	
	@Column(name="READ_COUNT")
	private int readCount;
	
	@Column(name="LIKE_COUNT")
	private int likeCount;
	
	@Column(name="REWARD_MAKE_PLAN")
	private String rewardMakePlan;
	
	@Column(name="REWARD_DELIVERY_PLAN")
	private String rewardDeliveryPlan;
	
	
	
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID")
	private FundingCategory category;
	
	
	@ManyToOne (fetch = FetchType.LAZY )
	@JoinColumn(name = "BUSINESS_TYPE_ID")
	private BusinessType businessType;
	
	@OneToMany (mappedBy = "fundingProject", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Reward> rewards;
	
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="FUNDING_MAKER_ID")
	private FundingMaker fundingMaker;

	
	
	
	
	
	

	
	public void addReward(Reward reward) {
		
		rewards.add(reward);
		if(reward.getFundingProject()!=this) {
			reward.setFundingProject(this);
		}
		
		
		
	}
	
	

	public int getReadCount() {
		return readCount;
	}



	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}



	public int getLikeCount() {
		return likeCount;
	}



	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}



	public String getRewardMakePlan() {
		
		if(rewardMakePlan == null) {
			
			rewardMakePlan = "";
		}
		
		
		return rewardMakePlan;
	}



	public void setRewardMakePlan(String rewardMakePlan) {
		this.rewardMakePlan = rewardMakePlan;
	}



	public String getRewardDeliveryPlan() {
		
		if(rewardDeliveryPlan == null) {
			
			rewardDeliveryPlan = "";
		}
		
		
		
		return rewardDeliveryPlan;
	}



	public void setRewardDeliveryPlan(String rewardDeliveryPlan) {
		this.rewardDeliveryPlan = rewardDeliveryPlan;
	}



	public List<Reward> getReward() {
		return rewards;
	}



	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}



	public String getStory() {
		
		if(story == null) {
			
			story = "";
		}
		
		return story;
	}



	public long getId() {
		
	
		
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		
		if(title == null) {
			
			title = "";
		}
		
		
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPlan() {
		
		if(plan == null) {
			
			plan = "";
		}
		
		
		
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
		
		
	if(managerName == null) {
			
		managerName = "";
		}
		
		return managerName;
	}



	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}



	public String getManagerEmail() {
		
		
		if(managerEmail == null) {
			
			managerEmail = "";
			}
		
		
		return managerEmail;
	}



	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}



	public Timestamp getEndDay() {
		return endDay;
	}



	public void setEndDay(Timestamp endDay) {
		this.endDay = endDay;
	}



	public String getTag() {
		
		
	if(tag == null) {
			
		tag = "";
			}
		
		
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}



	public String getSummary() {
		
		
		if(summary == null) {
			
			summary = "";
				}
			
		
		
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getstory() {
		
		if(story == null) {
			
			story = "";
				}
		
		
		return story;
	}



	public void setStory(String story) {
		this.story = story;
	}



	public Timestamp getStartDay() {
		return startDay;
	}



	public void setStartDay(Timestamp startDay) {
		this.startDay = startDay;
	}



	public String getStatus() {
		
if(status == null) {
			
	status = "";
				}
		
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
		
		if(category == null) {
			category =new FundingCategory(1L);
		}
		
		return category;
	}



	public void setCategory(FundingCategory category) {
		this.category = category;
	}



	public BusinessType getBusinessType() {
		
		if(businessType == null) {
			businessType =new BusinessType();
		}
		
		
		return businessType;
	}



	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}



	public FundingMaker getFundingMaker() {
		return fundingMaker;
	}



	public void setFundingMaker(FundingMaker fundingMaker) {
		this.fundingMaker = fundingMaker;
	}



	public FundingProject(long id, String title, String plan, int goalAmount, String managerName, String managerEmail,
			Timestamp endDay, String tag, String summary, String story, Timestamp startDay, String status, int memberNo,
			FundingCategory category, BusinessType indiOrCoparation, FundingMaker fundingMaker) {
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
		this.businessType = businessType;
		this.fundingMaker = fundingMaker;
	}



	public FundingProject() {
		super();
	}



	@Override
	public String toString() {
		return "FundingProject [id=" + id + ", title=" + title + ", plan=" + plan + ", goalAmount=" + goalAmount
				+ ", managerName=" + managerName + ", managerEmail=" + managerEmail + ", endDay=" + endDay + ", tag="
				+ tag + ", summary=" + summary + ", story=" + story + ", startDay=" + startDay + ", status=" + status
				+ ", memberNo=" + memberNo + ", readCount=" + readCount + ", likeCount=" + likeCount
				+ ", rewardMakePlan=" + rewardMakePlan + ", rewardDeliveryPlan=" + rewardDeliveryPlan + ", category="
				+ category + ", businessType=" + businessType + ", reward=" + rewards + ", fundingMaker=" + fundingMaker
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
