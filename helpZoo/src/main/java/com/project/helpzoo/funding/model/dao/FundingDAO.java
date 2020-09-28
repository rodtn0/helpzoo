package com.project.helpzoo.funding.model.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.cache.spi.QueryCache;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.funding.model.vo.funding.FundingMaker;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.funding.MakerAgent;
import com.project.helpzoo.funding.model.vo.funding.QFundingAttachment;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingTotalInfoDto;
import com.project.helpzoo.funding.dto.viewDetail.FundingDetailRewardView;
import com.project.helpzoo.funding.dto.viewDetail.OrderRewardView;
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
import com.project.helpzoo.funding.model.vo.order.Address;
import com.project.helpzoo.funding.model.vo.order.Delivery;
import com.project.helpzoo.funding.model.vo.order.OrderReward;
import com.project.helpzoo.funding.model.vo.order.Orders;
import com.project.helpzoo.funding.model.vo.order.QOrderReward;
import com.project.helpzoo.funding.model.vo.order.QOrders;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;
import com.project.helpzoo.funding.model.vo.search.SearchSort;
import com.project.helpzoo.funding.model.vo.search.SearchStatus;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
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
	 * @param startNo 
	 * @param pageListSize 
	 * @return
	 */
	public List<FundingMainViewDto> selectList(PageInfo pInfo) {


		
		JPAQueryFactory query = new JPAQueryFactory(em);

		QFundingProject funding = QFundingProject.fundingProject;

		QFundingCategory category = QFundingCategory.fundingCategory;

		QFundingMaker maker = QFundingMaker.fundingMaker;


		
		QFundingAttachment attachment = QFundingAttachment.fundingAttachment;
		
		QOrders order = QOrders.orders;
		
		
		
		
		
		
		List<Tuple> result = query
				.selectDistinct(funding.id,
						funding.title, category.category_name, maker.name, funding.goalAmount, 
						funding.summary,
						attachment.fileChangeName,
						attachment.fundingFileCategory.id,
						funding.startDay,
						order.price.sum())
				.from(funding)
				.leftJoin(funding.category, category)
				.leftJoin(attachment).on(attachment.parentFunding.id.eq(funding.id))
				.leftJoin(order).on(order.funding.id.eq(funding.id))
				.leftJoin(funding.fundingMaker, maker)
				.groupBy(funding.id,funding.title, category.category_name, maker.name, funding.goalAmount
						,funding.summary, attachment.fileChangeName,funding.startDay,attachment.fundingFileCategory.id)
				.where(funding.status.eq("Y").and(attachment.fundingFileCategory.id.eq(1L)))
				.orderBy(funding.startDay.desc())	
				.offset((pInfo.getCurrentPage()-1)*9)
				.limit(pInfo.getLimit())
				.fetch();		
		
		System.out.println(pInfo);
		
		List<FundingMainViewDto> mainViewList = new ArrayList<FundingMainViewDto>();
		
		
		for(Tuple re : result) {
			
			System.out.println(re.toString() + "펀딩프로젝트");
		}
		
		System.out.println("펀딩프로젝트");
		
		for (Tuple tuple : result) {
			int totalOrderAmount = 0;
		if(  tuple.get(order.price.sum())!=null ) {
			
			
		totalOrderAmount =  tuple.get(order.price.sum()).intValue();
		
		
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
		
		mainView.setFileChangeName(tuple.get(attachment.fileChangeName));
		
		mainViewList.add(mainView);
		}

		return mainViewList;
	}
	
	
	

	/** 정렬조건  querydsl 설정 메소드 입니다.
	 * -jisan-
	 * @param searchSort
	 * @return
	 */
	private OrderSpecifier<Long> orderby(SearchSort searchSort) {

		QOrders order = QOrders.orders;
		
		
		 if (searchSort == searchSort.VIEW) {

			return QFundingProject.fundingProject.readCount.desc();
		} else if (searchSort == searchSort.TIME) {

			return QFundingProject.fundingProject.id.desc();
		}
		 
		 return new CaseBuilder().when(order.status.ne("Y")).then(0L).otherwise(order.price).sum().desc();
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
		
		QOrders order = QOrders.orders;
		
		QOrderReward orderReward = QOrderReward.orderReward;
		
		QFundingAttachment attachment = QFundingAttachment.fundingAttachment;
		
		
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
							attachment.fileChangeName,
							
							order.price.sum())
					.from(funding)
					.leftJoin(funding.fundingMaker, maker)
					.leftJoin(funding.category,category)
					.leftJoin(order).on(order.funding.id.eq(funding.id))
					.leftJoin(attachment).on(attachment.parentFunding.id.eq(funding.id))
					.where(funding.id.eq(no).and(attachment.fundingFileCategory.id.eq(6L)))
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
							attachment.fileChangeName,
							funding.startDay)
					.fetch();
		
			
			
			List<String> suppoter = new ArrayList<String>();  // 서포터를 아직 만들지 않아 빈공간으로 만들어둠.
			
			FundingDetailViewDto detailView = null;
			
		for (Tuple tuple : result) {
		
			int totalOrderAmount = 0;
			
			if(  tuple.get(order.price.sum())!= null) {
			totalOrderAmount =  tuple.get(order.price.sum()).intValue();
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
					tuple.get(funding.category.category_name),
					tuple.get(attachment.fileChangeName)
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
		
	    
	    
	    
	    funding.setManagerEmail(managerName);
	    
	    
	    funding.setManagerName(managerEmail);
	  
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
			
		}else if (businessTypeId.equals("법인 사업자")){
			type = 2L;
			
		}else if (businessTypeId.equals("개인 사업자")){
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
						
						reward.amount, reward.originRewardAmount, reward.deliveryDay,reward.rewardSeq, reward.content, reward.id)
				.from(reward)
				.where(reward.fundingProject.id.eq(fundingNo))
				.orderBy(reward.rewardSeq.asc())
				.fetch();
		
		
		
		
		
		FundingDetailRewardView rewardView = null;
		
		List<FundingDetailRewardView> rewardViewList = new ArrayList<FundingDetailRewardView>();
		for(Tuple re : result) {
			
			
			rewardView = new FundingDetailRewardView(re.get(reward.price), re.get(reward.title), re.get(reward.deliveryPrice), re.get(reward.amount), 
	
					re.get(reward.originRewardAmount), re.get(reward.deliveryDay), re.get(reward.rewardSeq), re.get(reward.content)
					, re.get(reward.id)
					
					);
			
			rewardViewList.add(rewardView);
		}
		
		
		
		
		
		
		return rewardViewList;
	}




	public Long makeOrder() {
		
	Orders order = new Orders();
			
	em.persist(order);
		
	
	
	
	
		return order.getId();
	}




	public int getPrice(int id) {
		
		
		Long rewardId = ((Integer)id).longValue();
		
		Reward reward = em.find(Reward.class, rewardId);
		
		
		
		
		
		return reward.getPrice();
	}




	public String getRewardName(int id) {
		
		Long rewardId = ((Integer)id).longValue();
		
		Reward reward = em.find(Reward.class, rewardId);
		
		return reward.getTitle();
	}




	public List<OrderReward> persisOrderReward(OrderRewardView orderRewardView, Long orderId) {
		
		List<OrderReward> rewardOrderList = new ArrayList<OrderReward>();
		
		OrderReward orderReward = null;
		
		
		Orders order = em.find(Orders.class, orderId);
		
		
		int totalAmount = 0;
		
		for(int i = 0; i<orderRewardView.getId().length; i++) {
			
			
			int id = orderRewardView.getId()[i];
			
			Long rewardId = ((Integer)id).longValue();
			
			
			
			Reward reward = em.find(Reward.class, rewardId);
			
			
			int price = reward.getPrice();
			
			int aamount = orderRewardView.getAmount()[i];
			
			int orTotalPrice = price * aamount;
			
			orderReward = new OrderReward(reward, order,orderRewardView.getAmount()[i],((Integer)orTotalPrice).longValue());
			
			orderReward.setFunding(order.getFunding());
			
			em.persist(orderReward);
			
			rewardOrderList.add(orderReward);
			
			totalAmount += orTotalPrice;
			
			
		}
		
		order.setPrice(totalAmount);
		
		
		
		
		
		return rewardOrderList;
	}




	public Long orderSave(Orders order) {
	
		
		
		em.persist(order);
		
		
		return order.getId();
	}




	public Long saveOrder(Orders order, Address address, Long fundingNo) {
		
		
		
		
		FundingProject fundingProject = em.find(FundingProject.class, fundingNo);
		
		Delivery delivery = new Delivery(address , "Ready");
		
		
		em.persist(delivery);
		
		
		System.out.println(order);
		
		order.setDelivery(delivery);
		
		order.setFunding(fundingProject);
		
		
		em.persist(order);
		
		System.out.println(order);
		
		
		Long id = order.getId();
		
		
		System.out.println(id);
		
		
		
		
		return id;
	}




	public void saveDelivery(Delivery delivery) {
	

		em.persist(delivery);
		
	}




	public void permitOrder(Long ordersId) {
		
		
		Orders order = em.find(Orders.class, ordersId);
		
		order.setStatus("Y");
		
		
		
	}




	public Orders findOrder(Long orderNo2) {
		
		
		Orders order = em.find(Orders.class, orderNo2);
		
		
		
		
		List<OrderReward> orderRewardList = order.getOrderRewards();
		
		
		for(OrderReward orList : orderRewardList) {
			
			Reward reward = orList.getReward();
			
			System.out.println(reward);
			
			System.out.println(orList.getCount());
			
			try {
			reward.minusStock(orList.getCount());
			
			order.setStatus("Y");
			
			}
			
			
			catch (Exception e) {
			
				e.printStackTrace();
				
			}
			
			
		}
		
	
		
		
		
		return order;
	}




	public String findRewardName(Long id) {
		
		
		System.out.println( id);
		
		Reward reward = em.find(Reward.class, id);
		
		
		
			
		
		
		return reward.getTitle();
	}




	public FundingOpenMakerInfoView openMaker(Long fundingNo) {
	
		
		FundingProject funding = em.find(FundingProject.class, fundingNo);
		
	
		FundingMaker maker = funding.getFundingMaker();
		
		Long makerNo = maker.getId();
		
		Long agentNo = maker.getMakerAgent().getId();
		
		
		
		return getFundingOpenMakerInfoView(fundingNo, makerNo, agentNo);
	}




	public FundingAttachment getAttachment(Long fundingNo, long categoryNo) {
		
		
		QFundingAttachment attachment = QFundingAttachment.fundingAttachment;
		
		QFundingFileCategory fileCategory = QFundingFileCategory.fundingFileCategory;
		
		QFundingProject funding = QFundingProject.fundingProject;
		
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		
		
		
		
		
		
		
		
		
		
		return query.select(attachment).from(attachment)
				.leftJoin(attachment.fundingFileCategory, fileCategory)
				.leftJoin(attachment.parentFunding, funding)
				.where(fileCategory.id.eq(categoryNo).and(funding.id.eq(fundingNo))).fetchOne();
	}




	public FundingFileCategory findFundingFileCategory(Long categoryId) {
	
		return em.find(FundingFileCategory.class, categoryId);
	}




	public void saveAttachment(FundingAttachment updatedattach) {
		
		
		
		em.persist(updatedattach);
		
	}




	public void deleteAttachment(FundingProject funding, FundingFileCategory category) {
		
		
		QFundingProject fundingProject = QFundingProject.fundingProject;
		
		QFundingFileCategory fileCategory = QFundingFileCategory.fundingFileCategory;
		
		QFundingAttachment attachment = QFundingAttachment.fundingAttachment;
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		
		
		
	query.delete(attachment).where(attachment.parentFunding.id.eq(funding.getId()).and(attachment.fundingFileCategory.id.eq(category.getId()))).execute();
		
		
		
		
		
	}




	public int getListCount() {
	
		QFundingProject funding = QFundingProject.fundingProject;
		
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		
		
		return query.select(funding.count()).from(funding).where(funding.status.eq("Y")).fetchFirst().intValue();
	}



	
	
	
	

	public List<FundingMainViewDto> selectList(PageInfo pInfo, FundingSearch search) {
		
		
		
		
		
		
		JPAQueryFactory query = new JPAQueryFactory(em);

		QFundingProject funding = QFundingProject.fundingProject;

		QFundingCategory category = QFundingCategory.fundingCategory;

		QFundingMaker maker = QFundingMaker.fundingMaker;

		QReward reward = QReward.reward;

		QOrderReward orderReward = QOrderReward.orderReward;
		
		QFundingAttachment attachment = QFundingAttachment.fundingAttachment;
		
		QOrders order = QOrders.orders;
		
		
		
		
		
		
		List<Tuple> result = query
				.select(funding.id,
						funding.title, category.category_name, maker.name, funding.goalAmount, 
						funding.summary,
						funding.readCount,funding.likeCount,
						attachment.fileChangeName,
						funding.startDay,
						order.status,
						order.price.sum())
				.from(funding)
				.leftJoin(funding.category, category)
				.leftJoin(funding.fundingMaker, maker)
				.leftJoin(attachment).on(funding.id.eq(attachment.parentFunding.id))
				
				.leftJoin(funding.rewards, reward)
				.leftJoin(orderReward).on(reward.id.eq(orderReward.reward.id))
				.leftJoin(orderReward.order, order)
				.groupBy(funding.id,funding.title, category.category_name, maker.name, funding.goalAmount, 
						funding.readCount,funding.likeCount
						,funding.summary, attachment.fileChangeName,order.status,funding.startDay)
				.where(attachment.fundingFileCategory.id.eq(1L).and(funding.status.eq("Y")))
				.orderBy(funding.startDay.desc())
				.offset(pInfo.getCurrentPage())
				.limit(pInfo.getLimit())
				.fetch();		
		
		List<FundingMainViewDto> mainViewList = new ArrayList<FundingMainViewDto>();
		
		
		for(Tuple re : result) {
			
			System.out.println(re.toString());
		}
		
		
		
		for (Tuple tuple : result) {
			int totalOrderAmount = 0;
		if(  tuple.get(order.price.sum())!=null ) {
			
			
		totalOrderAmount =  tuple.get(order.price.sum()).intValue();
		
		
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
		
		mainView.setFileChangeName(tuple.get(attachment.fileChangeName));
		
		mainViewList.add(mainView);
		}

		return mainViewList;
		
		
		
		
		
		
	}



	
	
	
	
	





	




	
	
	
	
}









