package com.project.helpzoo.board.model.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.DAO.ReviewDAO;
import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.Review;
import com.project.helpzoo.member.model.vo.Member;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private PageInfo pInfo;
	

	
	
	// 페이징 처리를 위한 Service 구현
	@Override
	public PageInfo pagiNation(int type, int cp) {
		
		// 전체 게시글 수 조회
		int  listCount = reviewDAO.getListCount(type);
		System.out.println(listCount);
		// setPageInfo 호출
		pInfo.setPageInfo(cp, listCount, type);
		
		return pInfo;
	}
	
	
	// 리뷰 게시글 목록 조회 Service 구현
	@Override
	public List<Review> selectReviewList(PageInfo pInfo) {
		return reviewDAO.selectReviewList(pInfo);
		
	}

	// 구매 여부 확인 Service 구현
	@Override
	public int buyCount(int type, Member loginMember) {
		return reviewDAO.buyCount(type, loginMember);
	}

	// 리뷰 상세조회 Service 구현
	@Override
	public Review selectReviewVeiw(int type, int rBoardNo) {
		return reviewDAO.selectReviewView(type, rBoardNo);
	}

	// 글작성 페이지에 불러올 프로젝트 이미지, 제목 조회 Service 구현
	@Override
	public List<Review> selectInfo(int type, Member loginMember) {
		return reviewDAO.selectInfo(type, loginMember);
	}

	// 게시글 작성 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertReview(int type, Review review, List<MultipartFile> images, String savePath) {
		int result = 0;
		
		// 다음 시퀀스 번호 얻어오기.
		int reviewNo = reviewDAO.selectNextNo(type);
		
		if(reviewNo > 0) {
			review.setReviewNo(reviewNo);
			
			review.setReviewContent(replaceParameter(review.getReviewContent()));
			
			// 게시글 DB 삽입
			result = reviewDAO.insertReview(type, review);
			
			// 파일정보 DB 저장
			List<Attachment> files = new ArrayList<Attachment>();
			Attachment at = null;
			String filePath = "/resources/uploadImages";
			
			for(int i=0; i<images.size(); i++) {
				if(!images.get(i).getOriginalFilename().equals("")) {
					// 업로드된 이미지가 있다면
					
					String changeName = rename(images.get(i).getOriginalFilename());
					
					// Attachment 객체 생성
					at = new Attachment(reviewNo, images.get(i).getOriginalFilename(), 
										changeName, filePath, i);
					
					result = reviewDAO.insertImages(type, at);
				}
				files.add(at);
			}
			
			// 파일 서버에 저장
			if(result > 0) {
				for(int i=0; i<images.size() ; i++) {
					if(!images.get(i).getOriginalFilename().equals("")) {
						
						// transferTo(경로) : 지정한 경로에 업로드된 바이트 상태의 파일을 실제 파일로 변환해서 저장해라.
						try {
							images.get(i).transferTo(new File(savePath + "/" + files.get(i).getFileChangeName()));
						} catch (Exception e) {
							e.printStackTrace();
							// 서버에 파일 저장 중 문제가 발생할 경우
							// 이미 DB에 삽입되어 있는 파일정보를 삭제하는 DAO를 호출
							reviewDAO.deleteAttachment(type, reviewNo);
						}
					}
				}
		
			}
		}
		
		return result;
	}
	
	
	// 크로스 사이트 스크립트 방지 메소드
    private String replaceParameter(String param) {
    	String result = param;
    	if(param != null) {
    		result = result.replaceAll("&", "&amp;");
    		result = result.replaceAll("<", "&lt;");
    		result = result.replaceAll(">", "&gt;");
    		result = result.replaceAll("\"", "&quot;");
    	}
    	
    	return result;
    }
    
    // 파일명 변경
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

    // 게시글 상세조회시 이미지 조회 Service 구현
	@Override
	public List<Attachment> selectFiles(int type, int rBoardNo) {
		return reviewDAO.selectFiles(type, rBoardNo);
	}
}
