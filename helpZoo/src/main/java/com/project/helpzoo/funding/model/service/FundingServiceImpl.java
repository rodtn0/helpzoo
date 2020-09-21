package com.project.helpzoo.funding.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingMainViewDto;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenMakerInfoView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRequireView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenRewardView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingOpenStoryView;
import com.project.helpzoo.funding.dto.fundingOpen.FundingTotalInfoDto;
import com.project.helpzoo.funding.model.dao.FundingDAO;
import com.project.helpzoo.funding.model.vo.funding.FundingAttachment;
import com.project.helpzoo.funding.model.vo.funding.FundingCategory;
import com.project.helpzoo.funding.model.vo.funding.FundingFileCategory;
import com.project.helpzoo.funding.model.vo.funding.FundingProject;
import com.project.helpzoo.funding.model.vo.search.FundingSearch;

@Service
@Transactional
public class FundingServiceImpl implements FundingService {

	@Autowired
	private FundingDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(FundingServiceImpl.class);
	
	
	@Override
	public List<FundingMainViewDto> selectList(int cp, FundingSearch fundingSearch) {
		
		return dao.selectList(cp,fundingSearch);
	}


	/**
	 * 
	 * 매일 24시마다 각 프로젝트를 확인하여 기간이 만료된 프로젝트의 상태를 N으로 변환한다.
	 * 
	 */
	@Override
	public void fundingStatusChange() {
		
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("YY/MM/DD");
		
		
		Date nowTime = new Date();
		
			List<FundingProject> fundingProject = 	dao.fundingStatusChange();
			
			int compare = 0;
			for(FundingProject fp : fundingProject) {
				
				if((nowTime.compareTo(fp.getEndDay()) >	0) ) {
					
					fp.setStatus("N");
					logger.info(fp.getFundingMaker() + "의 " + 
					fp.getTitle() + "프로젝트가 만료되었습니다." );
			
			}
		}
	}



	/**
	 *펀딩 View 객체를 조회한다.
	 */
	@Override
	public FundingDetailViewDto selectFunding(int fundingNo) {
		
		return dao.selectFunding(fundingNo);
	}

	
	
	

	@Override
	public Long openFunding(String makerName, String businessType, int phone, int memberNo,String managerEmail, String managerName) {
		
		
		Long type = 0L;
		
		if(businessType.equals("개인")) {
			type = 1L;
			
		}else if (businessType.equals("법인")){
			type = 2L;
			
		}else if (businessType.equals("개인사업자")){
			type = 3L;
			
		}
		
	
		
		
		
		
		return dao.openFunding(makerName, type, phone, memberNo, managerEmail, managerName);
	}


	@Override
	public FundingOpenRequireView openRequire(Long fundingNo) {
		
		
		
		
		
		return dao.openRequire(fundingNo);
	}


	@Override
	public void openRequireSave(Long fundingNo, FundingOpenRequireView fundingOpenRequireView) {
		
		dao.openRequireSave(fundingNo,fundingOpenRequireView);
		
	}
	


	@Override
	public FundingTotalInfoDto getFundingTotalInfo(Long fundingNo) {
		
		
		
		
		
		return dao.getFundingTotalInfo(fundingNo);
	}


	@Override
	public void openInfoSave(Long fundingNo, FundingOpenInfoView fundingOpenInfoView) {
		
		
		
		
		
		
		
		
		
		dao.openInfoSave(fundingNo,fundingOpenInfoView);
		
	}


	@Override
	public FundingOpenInfoView openInfo(Long fundingNo) {
		
		
		
		return dao.openInfo(fundingNo);
	}


	@Override
	public void insertfundingStoryFile(FundingProject funding, List<MultipartFile> images, String savePath) {


		int result = 0;
		
		Long storyType = 5L;
		
		Long introType = 6L;
		
		FundingFileCategory storyFileCategory = dao.getFundingCategory(storyType);

		
		FundingFileCategory introFileCategory = dao.getFundingCategory(introType);
		
		
		
			// 3) 파일정보 DB 저장
		
		
		List<FundingAttachment> files = new ArrayList<FundingAttachment>();
		FundingAttachment at = null;
		String filePath = "/resources/uploadImages";
		
		
		imageUpload(funding, images, introFileCategory, files, at, filePath);
					
		savaAttachment(images, savePath, files,funding );
		
				
		storyInsert(funding, storyFileCategory);
		
		
		
	}


	private void imageUpload(FundingProject funding, List<MultipartFile> images,
			FundingFileCategory fundingFileCategory, List<FundingAttachment> files, FundingAttachment at,
			String filePath) {
	
		
		
		for(int i=0; i<images.size(); i++) {
			
			
			if(!images.get(i).getOriginalFilename().equals("")) {
				// 업로드된 이미지가 있다면
				
				
				// 파일명 변경 (cos.jar는 별도의 RenamePolicy가 존재하지만 스프링은 없음.)
				// -> 별도의 메소드를 제작하여 변경하기
				String changeName = rename(images.get(i).getOriginalFilename());
				
				// Attachment 객체 생성
				
				
				
				at = new FundingAttachment(	images.get(i).getOriginalFilename(), 
						changeName, filePath, i, funding, fundingFileCategory);
						
				
				
				dao.insertAttachment(at);
		
				
			}
			files.add(at);
			
			
		}
		
		
		
		
		
		
		
	}


	private void storyInsert(FundingProject funding, FundingFileCategory fundingFileCategory) {
		FundingAttachment at;
		String filePath;
		
		
		Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
		
		// SummerNote에 작성된 내용 중 img태그의 src속성의 값을 검사하여 매칭되는 값을 Matcher객체에 저장함.
		Matcher matcher = pattern.matcher(funding.getStory());     
		 
		String changeFileName = null; // 파일명 변환 후 저장할 임시 참조 변수
		String src = null; // src 속성값을 저장할 임시 참조 변수
		// matcher.find() : Matcher 객체에 저장된 값(검사를 통해 매칭된 src 속성 값)에 반복 접근하여 값이 있을 경우 true 
		
		while(matcher.find()){
			src=  matcher.group(1); // 매칭된 src 속성값을  Matcher 객체에서 꺼내서 src에 저장 
			
			filePath = src.substring(src.indexOf("/", 2), src.lastIndexOf("/")); // 파일명을 제외한 경로만 별도로 저장.
			
			changeFileName = src.substring(src.lastIndexOf("/")+ 1); // 업로드된 파일명만 잘라서 별도로 저장.
			
			// Attachment 객체를 이용하여 DB에 파일 정보를 저장
			at = new FundingAttachment(changeFileName, changeFileName, filePath, 4, funding, fundingFileCategory);
			dao.insertAttachment(at);
			
		}
		
		
	}

	
	

	private void savaAttachment(List<MultipartFile> images, String savePath, List<FundingAttachment> files,FundingProject funding) {
		for(int i = 0; i<images.size(); i++) {
		
		if(!images.get(i).getOriginalFilename().equals("")) {
			// 이미지가 업로드가 되었다면
			
			
			// transferTo(경로) : 지정한 경로에 업로드된 바이트 상태의 파일을 실제 파일로 변환해서 저장해라.
			try {
				images.get(i).transferTo(new File(savePath + "/" + files.get(i).getFileChangeName()));
				System.out.println(savePath);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				// 서버에 파일 저장 중 문제가 발생할 경우
				// 이미 DB에 삽입되어 있는 파일 정보를 삭제하는 DAO를 호출.
				dao.deleteAttachment(funding);
				
				}
			
			}
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	public String rename(String originFileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

        int ranNum = (int)(Math.random()*100000); // 5자리 랜덤 숫자 생성

        String str = "" + String.format("%05d", ranNum);
        //String.format : 문자열을 지정된 패턴의 형식으로 변경하는 메소드
        // %05d : 오른쪽 정렬된 십진 정수(d) 5자리(5)형태로 변경. 빈자리는 0으로 채움(0)

        String ext = originFileName.substring(originFileName.lastIndexOf("."));

        return date + "" + str + ext;
    }


	
	//-----------------------------------------Summernote-----------------------------------------
		@Override
		public Map<String, String> insertImage(MultipartFile uploadFile, String savePath) {
			// 저장 폴더 선택
			File folder = new File(savePath);
			
			// 만약 폴더가 없을 경우 자동 생성 시키기
			if(!folder.exists())  folder.mkdir(); 
			Map<String, String> result = new HashMap<String, String>();
			
			// rename 작업
			String changeFileName = rename(uploadFile.getOriginalFilename());
			
			String filePath = "/resources/infoImages/";
			result.put("filePath", filePath);
			result.put("changeFileName", changeFileName);
			
			
			// transferTo() : 지정한 경로에 업로드된 파일정보를 실제 파일로 변환하는 메소드 -> 정상 호출 시 파일이 저장됨.
			try {
				uploadFile.transferTo(new File(savePath + "/" + changeFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		

		
		// DB에 저장된 파일 목록 조회 Service 구현
		@Override
		public List<String> selectDbFileList() {
			return dao.selectDbFileList();
		}


		
		
		
		
		
		
		@Override
		public FundingOpenStoryView openStory(Long fundingNo) {
		
			return dao.openStory(fundingNo);
		}


		@Override
		public void insertfundingFile(FundingProject funding, ArrayList<MultipartFile> images, String savePath,
				Long fileCategory) {
			
	
			FundingFileCategory fileCategoryType = dao.getFundingCategory(fileCategory);
			
			System.out.println(images.get(0).toString());
			
				// 3) 파일정보 DB 저장
			
			
			List<FundingAttachment> files = new ArrayList<FundingAttachment>();
			FundingAttachment at = null;
			String filePath = "/resources/uploadImages";
			
			
			imageUpload(funding, images, fileCategoryType, files, at, filePath);
						
			savaAttachment(images, savePath, files,funding );
			
					
			
		}


		@Override
		public void openRewardSave(Long fundingNo, FundingOpenRewardView rewardView) {
			
			
			
			dao.openRewardSave(fundingNo, rewardView);
			
		}


		@Override
		public void openMakerSave(FundingOpenMakerInfoView fundingOpenInfoView, Long fundingNo) {
			
			
			
			
			dao.openMakerSave(fundingOpenInfoView, fundingNo);
			
		}
		
	
	
	
}
