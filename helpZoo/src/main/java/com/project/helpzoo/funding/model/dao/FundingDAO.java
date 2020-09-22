package com.project.helpzoo.funding.model.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.funding.model.vo.funding.FundingMaker;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.funding.MakerAgent;
import com.project.helpzoo.funding.model.vo.funding.QFundingAttachment;
import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingTotalInfoDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
import com.project.helpzoo.funding.model.vo.funding.BusinessType;
import com.project.helpzoo.funding.model.vo.funding.FundingAttachment;
import com.project.helpzoo.funding.model.vo.funding.FundingCategory;
import com.project.helpzoo.funding.model.vo.funding.FundingFileCategory;
import com.project.helpzoo.funding.model.vo.funding.QFundingCategory;
import com.project.helpzoo.funding.model.vo.funding.QFundingFileCategory;
import com.project.helpzoo.funding.model.vo.funding.QFundingMaker;
import com.project.helpzoo.funding.model.vo.funding.QFundingProject;
import com.project.helpzoo.funding.model.vo.funding.QReward;
import com.project.helpzoo.funding.model.vo.funding.Reward;
import com.project.helpzoo.funding.model.vo.order.QOrderReward;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;
import com.project.helpzoo.funding.model.vo.search.SearchSort;
import com.project.helpzoo.funding.model.vo.search.SearchStatus;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import oracle.net.aso.e;

@Repository
@Transactional
public class FundingDAO {

	@PersistenceContext
	private EntityManager em;
	
	


	/** 처음 펀딩 페이지에 왔을때 검색 List를 반환하는 메소드 입니다.
	 * @param cp
	 * @param fundingSearch
	 * @return
	 */
	public List<FundingMainViewDto> selectList(int cp, FundingSearch fundingSearch) {


		
		JPAQueryFactory query = new JPAQueryFactory(em);

		QFundingProject funding = QFundingProject.fundingProject;

		QFundingCategory category = QFundingCategory.fundingCategory;

		QFundingMaker maker = QFundingMaker.fundingMaker;

		QReward reward = QReward.reward;

		QOrderReward orderReward = QOrderReward.orderReward;
		
		List<Tuple> result = query
				.select(funding.id,
						funding.title, category.category_name, maker.name, funding.goalAmount, reward.price,
						funding.summary,
						funding.readCount,funding.likeCount,
						orderReward.count.sum())
				
				.from(funding)
				.leftJoin(funding.rewards, reward)
				.leftJoin(orderReward).on(reward.id.eq(orderReward.reward.id))
				.leftJoin(funding.category, category)
				.leftJoin(funding.fundingMaker, maker)
				.groupBy(funding.id,funding.title, category.category_name, maker.name, funding.goalAmount, 
						reward.price,funding.readCount,funding.likeCount
						,funding.summary)
				.orderBy(orderby(fundingSearch.getSearchSort()))
				.offset(0)
				.limit(20)
				.fetch();
		
		
		List<FundingMainViewDto> mainViewList = new ArrayList<FundingMainViewDto>();
		
		
		
		for (Tuple tuple : result) {
			int totalOrderAmount = 0;
		if(  tuple.get(orderReward.count.sum())!= null && tuple.get(reward.price)!=null ) {
		totalOrderAmount =  tuple.get(orderReward.count.sum())*tuple.get(reward.price);
		}
		FundingMainViewDto mainView = new FundingMainViewDto
			(
			tuple.get(funding.id),
			tuple.get(funding.title),
			tuple.get(category.category_name), 
			tuple.get(funding.summary),
			tuple.get(funding.fundingMaker.name), 
			totalOrderAmount, 
			tuple.get(funding.goalAmount), 
			tuple.get(funding.endDay)
			,(int)(((double)totalOrderAmount/tuple.get(funding.goalAmount))*100)
			);
		
		
		mainViewList.add(mainView);
		}

		return mainViewList;
	}
	
	
	

	/** 정렬조건  querydsl 설정 메소드 입니다.
	 * -jisan-
	 * @param searchSort
	 * @return
	 */
	private OrderSpecifier<Integer> orderby(SearchSort searchSort) {

		if (searchSort == searchSort.LIKE) {

			return QFundingProject.fundingProject.likeCount.desc();
		} else if (searchSort == searchSort.VIEW) {

			return QFundingProject.fundingProject.readCount.desc();
		} else if (searchSort == searchSort.TIME) {

			return null;
		}
		return QFundingProject.fundingProject.likeCount.desc();

	}
	

	/** 검색조건 설정 querydsl 메소드 입니다.
	 * @param searchStatus
	 * @return
	 */
	
	private BooleanExpression statusEq(SearchStatus searchStatus) {
		if (searchStatus == searchStatus.ALL) {

			return null;
		} else if (searchStatus == searchStatus.PROCEEDING) {

			return QFundingProject.fundingProject.status.eq("Y");
		} else if (searchStatus == searchStatus.TERMINATED) {

			return QFundingProject.fundingProject.status.eq("N");
		}

		return null;
	}

	
	
	
	
	/** 검색 텍스트 탐색 querydsl 메소드 입니다.
	 * @param searchText
	 * @return
	 */
	private BooleanExpression textEq(String searchText) {
			
		if(searchText == null) {
			return null;
			
		}
		
		return QFundingProject.fundingProject.title.like(searchText);
		
	}
	
	
	

	
	/**12시 이후 서버에서 프로젝트 마감기한이 지난 프로젝트를 자동으로 종료처리 하는 메소드입니다.
	 * @return
	 */
	public List<FundingProject> fundingStatusChange() {

		return em.createQuery("select f from FundingProject f where f.status = 'Y' ", FundingProject.class).getResultList();

	}




	public FundingDetailViewDto selectFunding(int fundingNo) {
		

		
		JPAQueryFactory query = new JPAQueryFactory(em);

		QFundingProject funding = QFundingProject.fundingProject;

		QFundingCategory category = QFundingCategory.fundingCategory;

		QFundingMaker maker = QFundingMaker.fundingMaker;

		QReward reward = QReward.reward;

		QOrderReward orderReward = QOrderReward.orderReward;
		
		
		
			Long no = Long.valueOf(fundingNo);

			
			List<Tuple> result  = query
					.select(funding.id,
							funding.title,
							funding.story, 
							funding.goalAmount,
							maker.name,
							maker.sns,
							funding.readCount,
							funding.likeCount,
							maker.kakaoURL,
							funding.endDay,
							funding.startDay,
							category.category_name,
							orderReward.count.sum())
					
					.from(funding)
					.leftJoin(funding.rewards, reward)
					.leftJoin(funding.fundingMaker, maker)
					.leftJoin(orderReward).on(reward.id.eq(orderReward.reward.id))
					.leftJoin(funding.category,category)
					.where(funding.id.eq(no))
					
					.groupBy(funding.id,
							funding.story, 
							funding.goalAmount,
							funding.title,
							maker.name,
							maker.sns,
							funding.readCount,
							funding.likeCount,
							maker.kakaoURL,
							funding.endDay,
							category.category_name,
							funding.startDay)
					.fetch();
		
			
			
			List<String> suppoter = new ArrayList<String>();  // 서포터를 아직 만들지 않아 빈공간으로 만들어둠.
			
			FundingDetailViewDto detailView = null;
			
		for (Tuple tuple : result) {
		
			int totalOrderAmount = 0;
			
			if(  tuple.get(orderReward.count.sum())!= null && tuple.get(reward.price)!=null ) {
			totalOrderAmount =  tuple.get(orderReward.count.sum())*tuple.get(reward.price);
			}
			
			System.out.println(
			tuple.get(reward.id) +" "+
			tuple.get(orderReward.count.sum())
			);
			
			detailView = new FundingDetailViewDto(
					tuple.get(funding.story),
					
					tuple.get(funding.goalAmount),
					
					totalOrderAmount, (int)(((double)totalOrderAmount/tuple.get(funding.goalAmount))*100), 
					
					suppoter, // 서포터를 아직 만들지 않아 빈공간으로 만들어둠.
					
					tuple.get(maker.name), 
					tuple.get(maker.sns), 
					tuple.get(maker.kakaoURL)
					,tuple.get(funding.likeCount)
					,tuple.get(funding.endDay),
					tuple.get(funding.startDay),
					tuple.get(funding.title),
					tuple.get(funding.category.category_name)
					);
			
			
			
			
			
			
			
			
			
			
			
			
		
			
		}
		
		
		
		return detailView;
	}




	
	
	/** 펀딩을 오픈하는 dao. 
	 * @param makerName
	 * @param type
	 * @param phone
	 * @param memberNo
	 * @param managerName 
	 * @param managerEmail 
	 * @return
	 */
	public Long openFunding(String makerName, Long type, int phone, int memberNo, String managerEmail, String managerName) {
		
		
		
		FundingProject funding = new FundingProject();
		
		
		
	    BusinessType businessType = em.find(BusinessType.class, type);
		
	    
	    
	    
	    funding.setManagerEmail(managerEmail);
	    
	    funding.setManagerName(managerName);
	  
	    FundingMaker maker = new FundingMaker();
	    
	    
	    maker.setName(makerName);
	    
	    maker.setPhone(phone);
	    
	    em.persist(maker);
	    
	    
	    MakerAgent makerAgent = new MakerAgent();
	    
	    em.persist(makerAgent);
	    
	    maker.setMakerAgent(makerAgent);
	    
	    
	    
	    
	    
	    
	    funding.setFundingMaker(maker);
	    
	    funding.setBusinessType(businessType);
		
	  
	    
	    funding.setMemberNo(memberNo);
	    
		em.persist(funding);
		
		
		
		
		
		
		
		return funding.getId();
	}




	public FundingOpenRequireView openRequire(Long fundingNo) {
		
		
		
		FundingProject fundingProject = em.find(FundingProject.class, fundingNo);
		
		
		
		FundingOpenRequireView requireView = new FundingOpenRequireView(fundingProject.getRewardMakePlan(), fundingProject.getRewardDeliveryPlan());
		
		
		
		
		
		
		
		
		
		return requireView;
	}




	public void openRequireSave(Long fundingNo, FundingOpenRequireView fundingOpenRequireView) {
		
		
		
		FundingProject fundingProject = em.find(FundingProject.class, fundingNo);
		
		fundingProject.setRewardDeliveryPlan(fundingOpenRequireView.getRewardDeliveryPlan());
		
		fundingProject.setRewardMakePlan(fundingOpenRequireView.getRewardMakePlan());
		
		
		
	
		
	}




	/** 작성중을 확인하는 정보를 가져오는 dto
	 * @param fundingNo
	 * @return
	 */
	public FundingTotalInfoDto getFundingTotalInfo(Long fundingNo) {
		
		
		System.out.println("토탈인포 펀딩넘버 : " + fundingNo);
		
		
		
		
		
		FundingProject fundingProject = em.find(FundingProject.class, fundingNo);
		
		
		//기본 정보의 view에 표시될 정보 -작성 확인용-
		
		FundingMaker maker = fundingProject.getFundingMaker();
		
		MakerAgent agent = maker.getMakerAgent();
		
		List<Reward> rewardList = fundingProject.getReward();
		
		
		
		//기본 정보 뷰
		FundingOpenInfoView fundingOpenInfoView = getFundingOpenInfoView(fundingProject.getId());
		//메이커 정보 뷰
		FundingOpenMakerInfoView fundingOpenMakerInfoView = getFundingOpenMakerInfoView(fundingProject.getId(), maker.getId(), agent.getId());
		//기본 요건 뷰
		FundingOpenRequireView fundingOpenRequireView = getFundingOpenRequireView(fundingProject.getId());
		//리워드 목록 뷰
		List<FundingOpenRewardView> fundingOpenRewardView = getFundingOpenRewardView(fundingProject.getId());
		//펀딩 스토리 뷰
		FundingOpenStoryView fundingOpenStoryView = getFundingOpenStoryView(fundingProject.getId());
		
		
		
		
		
		
		FundingTotalInfoDto fundingTotalInfoDto = new FundingTotalInfoDto
		
		(fundingOpenInfoView, fundingOpenMakerInfoView, fundingOpenRequireView, fundingOpenRewardView, fundingOpenStoryView);
		
		
		
		
		
		
		
		
		
		
		return fundingTotalInfoDto;
	}




	private FundingOpenStoryView getFundingOpenStoryView(long fundingNo) {
		
		
		
		QFundingAttachment fundingAttachment = QFundingAttachment.fundingAttachment;
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		
		
		FundingAttachment attachment = query.select(fundingAttachment).
				from(fundingAttachment)
				.where(fundingAttachment.fundingFileCategory.id.eq(6L)
				.and(fundingAttachment.parentFunding.id.eq(funding.getId())))
				.fetchFirst();
		
		
		
		FundingOpenStoryView fundingOpenStoryView = new FundingOpenStoryView
				(funding.getSummary(), funding.getStory(), attachment);
		
		
		
		return fundingOpenStoryView;
	}




	private List<FundingOpenRewardView> getFundingOpenRewardView(long fundingNo) {
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		List<Reward> rewardList = new ArrayList<Reward>();
		
		rewardList = funding.getReward();
		
		
		List<FundingOpenRewardView> fundingOpenRewardView = new ArrayList<FundingOpenRewardView>();
		
		
		
		FundingOpenRewardView rewardView = null;
		
		for( Reward reward : rewardList ) {
			rewardView = new FundingOpenRewardView
		(reward.getPrice(), reward.getTitle(), reward.getContent(), 
		 reward.getOption(), reward.getDeliveryPrice(), reward.getAmount(), reward.getDeliveryDay());
			
			fundingOpenRewardView.add(rewardView);
		
		}
		
		
		
		return fundingOpenRewardView;
	}




	private FundingOpenRequireView getFundingOpenRequireView(long fundingNo) {
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		FundingOpenRequireView fundingOpenRequireView 
		= new FundingOpenRequireView(funding.getRewardMakePlan(), funding.getRewardDeliveryPlan());
		return fundingOpenRequireView;
	}




	private FundingOpenMakerInfoView getFundingOpenMakerInfoView(long fundingNo, long makerNo,
			long agentNo) {
		
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		FundingMaker maker = em.find(FundingMaker.class, makerNo);
		
		MakerAgent agent = em.find(MakerAgent.class, agentNo);
		
		
		
		FundingOpenMakerInfoView fundingOpenMakerInfoView = new FundingOpenMakerInfoView
		
			(maker.getName(), maker.getEmail(), maker.getPhone(), maker.getKakaoId(), maker.getKakaoURL(), maker.getHomepage1(), maker.getHomepage2(), 
					
			maker.getSns(), maker.getSns2(), maker.getSns3(), funding.getBusinessType().getBusinessType(), agent.getName(), agent.getEmail(), agent.getPhone(), 
			
			 agent.getBank(), agent.getAccountNumber(),  agent.getAccountHolder());
		return fundingOpenMakerInfoView;
	}




	private FundingOpenInfoView getFundingOpenInfoView(long fundingNo) {
		
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		
		
		FundingOpenInfoView fundingOpenInfoView = new FundingOpenInfoView(
				
				funding.getTitle(), funding.getGoalAmount(), funding.getCategory().getId()
				, funding.getEndDay(), funding.getTag());
		return fundingOpenInfoView;
	}




	public void openInfoSave(Long fundingNo, FundingOpenInfoView fundingOpenInfoView) {
		
		
			FundingProject funding = em.find(FundingProject.class, fundingNo);
			
			FundingCategory category = em.find(FundingCategory.class,fundingOpenInfoView.getCategory());
			
			
			funding.setTitle(fundingOpenInfoView.getFundingTitle());
			
			funding.setCategory(category);
		
			funding.setGoalAmount(fundingOpenInfoView.getFundingGoal());
		
			funding.setEndDay(fundingOpenInfoView.getFundingEndDay());
		
			funding.setTag(fundingOpenInfoView.getFundingTag());
			
	}




	public FundingOpenInfoView openInfo(Long fundingNo) {
		
		
		
		
		
		
		
		return getFundingOpenInfoView(fundingNo);
	}




	/** 메이커 네임을 구하는 메소드.
	 * @param fundingNo
	 * @return
	 */
	public String getMakerName(Long fundingNo) {
		
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		String makerName = funding.getFundingMaker().getName();
		
		
		
			return makerName;
		
	}




	public FundingProject findFundingOne(Long fundingNo, FundingOpenStoryView fundingStory) {
		
	FundingProject funding = em.find(FundingProject.class, fundingNo);
	
		
		funding.setStory(fundingStory.getFundingStory());
		
		funding.setSummary(fundingStory.getFundingSummary());
		
		
		return funding;
	}




	public FundingFileCategory getFundingCategory(Long fileCategoryType) {
			
		return em.find(FundingFileCategory.class, fileCategoryType);
	}




	public void insertAttachment(FundingAttachment at) {

		
		
		em.persist(at);
	}




	public void deleteAttachment(FundingProject fundingProject) {
		
		
		QFundingProject funding = QFundingProject.fundingProject;
		QFundingAttachment attachment = QFundingAttachment.fundingAttachment;
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		
		
		query.delete(attachment)
		.where(attachment.fundingFileCategory.id.eq(6L)
		.and(attachment.parentFunding.id.eq(fundingProject.getId())));
		
		
		
		
		
		
		
		
	}
	
	
	//-----------------------------------------Summernote-----------------------------------------
	/**   DB에 저장된 파일 목록 조회 DAO
	 * @return dbFileList
	 */
	public List<String> selectDbFileList() {
		
	
		
	return 	em.createQuery("SELECT f.fileChangeName FROM FundingAttachment f "
				+ "where TO_DATE(SUBSTR(FILE_CHANGE_NAME,1,8),'YYMMDDHH24') >= (SYSDATE - 3)").getResultList();
		
				
		
		
		
		
	} 
	//---------------------------------------------------------------------------------------------
	
	
	public void fundingSave(FundingProject funding) {
		
				
				if(funding.getId()== 0) {
					
					em.persist(funding);
				}else {
					em.merge(funding);
				}
		
		
	}






	public FundingOpenStoryView openStory(Long fundingNo) {
		
		
		
		
		
		
		return getFundingOpenStoryView(fundingNo);
	}




	public FundingProject findFunding(Long fundingNo) {
		
		
		return em.find(FundingProject.class, fundingNo);
	}




	public void openRewardSave(Long fundingNo, FundingOpenRewardView rewardView) {
		
		QFundingProject funding = QFundingProject.fundingProject;
		QReward reward = QReward.reward;
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		
		Long rewardSeq =	query.select(reward.count()).from(reward).where(reward.fundingProject.id.eq(fundingNo)).fetchFirst();
		
		
	
		rewardSeq = rewardSeq+1L;
	
	
		FundingProject fundingProject = em.find(FundingProject.class, fundingNo);		
				
		
		Reward insertReward = new Reward(rewardSeq,rewardView.getContent(), rewardView.getTitle(), rewardView.getPrice(), 
				rewardView.getRewardAmount(), rewardView.getDeleveryPrice(), rewardView.getDeliveryDay(), rewardView.getRewardAmount());
		
		
		System.out.println("insertReward = : " + insertReward);
		
		
		insertReward.setFundingProject(fundingProject);
		
		em.persist(insertReward);
		
		
		
		
		
		
		
		
		
		fundingProject.addReward(insertReward);
	
		
		
		
		
		
		
	}




	public void openMakerSave(FundingOpenMakerInfoView fundingOpenMakerView, Long fundingNo) {
	
		
		FundingProject fundingProject = em.find(FundingProject.class, fundingNo);		
		
		
		FundingMaker maker = fundingProject.getFundingMaker();
		
		MakerAgent agent = maker.getMakerAgent();
		
		
		
		String businessTypeId = fundingOpenMakerView.getBusinessType();
		//입력된 비즈니스 키 탐색
		
		Long type = 0L;
		
		if(businessTypeId.equals("개인")) {
			type = 1L;
			
		}else if (businessTypeId.equals("법인")){
			type = 2L;
			
		}else if (businessTypeId.equals("개인사업자")){
			type = 3L;
			
		}
		
		
		
		BusinessType businessType = em.find(BusinessType.class, type);
		
		
		
		
		fundingProject.setBusinessType(businessType);
		
		
		
		maker.setName(fundingOpenMakerView.getName());
		
		maker.setEmail(fundingOpenMakerView.getEmail());
		
		maker.setPhone(fundingOpenMakerView.getPhone());
		
		maker.setKakaoId(fundingOpenMakerView.getKakaoId());
		
		maker.setKakaoURL(fundingOpenMakerView.getKakaoUrl());
		
		maker.setHomepage1(fundingOpenMakerView.getHomepage1());
		
		maker.setHomepage2(fundingOpenMakerView.getHomepage2());
		
		maker.setSns(fundingOpenMakerView.getSns1());
		
		maker.setSns2(fundingOpenMakerView.getSns2());
		
		maker.setSns3(fundingOpenMakerView.getSns3());
		
		
		
		
		// 대표자 정보 세팅
		agent.setName(fundingOpenMakerView.getAgentName());
		
		agent.setEmail(fundingOpenMakerView.getAgentEmail());
		
		agent.setPhone(fundingOpenMakerView.getAgentPhone());
		
		agent.setBank(fundingOpenMakerView.getBank());
		
		agent.setAccountNumber(fundingOpenMakerView.getAccountNumber());
		
		agent.setAccountHolder(fundingOpenMakerView.getAccountHolder());
		
		
		
		
	}




	public void fundingStart(Long fundingNo) {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
		funding.setStatus("Y");
		
		funding.setStartDay(ts);
		
		
		
	}




	public List<FundingDetailRewardView> selectReward(Long fundingNo) {
		
		JPAQueryFactory query = new JPAQueryFactory(em);

		QFundingProject funding = QFundingProject.fundingProject;
		
		QReward reward = QReward.reward;
		
		
		List<Tuple> result  = 
				query.select(reward.price, reward.title, reward.deliveryPrice, 
						
						reward.amount, reward.originRewardAmount, reward.deliveryDay)
				.from(reward)
				.where(reward.fundingProject.id.eq(fundingNo))
				.fetch();
		
		
		
		
		
		FundingDetailRewardView rewardView = null;
		
		List<FundingDetailRewardView> rewardViewList = new ArrayList<FundingDetailRewardView>();
		for(Tuple re : result) {
			
			
			rewardView = new FundingDetailRewardView(re.get(reward.price), re.get(reward.title), re.get(reward.deliveryPrice), re.get(reward.amount), 
					
					re.get(reward.originRewardAmount), re.get(reward.deliveryDay));
			
			rewardViewList.add(rewardView);
		}
		
		
		
		
		
		
		return rewardViewList;
	}
	
	
	
}
