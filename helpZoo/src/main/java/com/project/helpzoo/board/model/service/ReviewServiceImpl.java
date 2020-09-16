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
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Review selectReviewVeiw(int type, int rBoardNo) {
		
		Review review = reviewDAO.selectReviewView(type, rBoardNo);
		
		if(review != null) {
			int result = reviewDAO.increaseCount(type, rBoardNo);
			
			if(result > 0) {
				review.setReadCount(review.getReadCount() + 1);
			}
		}
		return review;
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

	// 리뷰 글 삭제 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteReview(int type, int reviewNo) {
		return reviewDAO.deleteReview(type, reviewNo);
	}

	// 특정 번호의 (펀딩,기부)프로젝트 정보 조회 Service 구현
	@Override
	public Review selectInfoOne(int type, Review review) {
		return reviewDAO.selectInfoOne(type, review);
	}

	// 리뷰 수정 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateReview(int type, Review review, String savePath, List<MultipartFile> images, boolean[] deleteImages) {
		
		// 크로스 사이트 스크립트 방지 처리
		review.setReviewContent(replaceParameter(review.getReviewContent()));
		int result = reviewDAO.updateReview(type, review); // 게시글만 수정
		
		if(result > 0) {
			// 1) 이전 업로드 파일 목록 조회
			List<Attachment> oldFiles = reviewDAO.selectFiles(type, review.getReviewNo()); // 쿼리문 다시 봐야함(매개변수로 부분)
			
			// DB에 저장할 웹상에서의 이미지 접근 경로
			String filePath = "/resources/uploadImages";
			
			List<Attachment> files = new ArrayList<Attachment>(); // 파일 정보를 모아 놓은 List
			List<Attachment> removeFiles = new ArrayList<Attachment>(); // 서버측 파일 제거 List
			Attachment at = null;
			for(int i=0; i<images.size(); i++) {
				
				if(!images.get(i).getOriginalFilename().equals("")) {
					// 현재 접근중인 images 요소의 실제 파일명이 빈 문자열이 아닐 경우
					// == 수정된 이미지가 업로드된 경우
					
					// 파일명 변경(rename 작업)
					String changeFileName = rename(images.get(i).getOriginalFilename());
					
					// 수정된 이미지 파일정보를 저장할 Attachment 객체 생성
					at = new Attachment(review.getReviewNo(), images.get(i).getOriginalFilename(),
									changeFileName, filePath, i);
					
					// 기존 이미지가 존재하는 경우 -> update
					// 기존 이미지가 존재하지 않는 경우 -> insert
					
					boolean flag = false; // 기존 이미지가 존재하는 경우 true, 아니면 false;
					for(Attachment old : oldFiles) { // 이전 파일 목록에 반복 접근
						if(old.getFileLevel() == i) {
							// 현재 접근한 이전 파일의 레벨이
							// 새롭게 업로드된(수정된) 파일의 레벨과 같을 경우
							// == 이전 파일이 새로운 파일로 수정이 된 경우
							
							flag = true;
							removeFiles.add(old); // 서버 파일 제거 List에 수정 예정인 이전 파일 정보를 저장 
							
							at.setFileNo(old.getFileNo());
							// 이전 파일의 번호를 얻어와 DB상에서 데이터 수정할 수 있게
							// 새로운 파일에 번호 세팅
							break;
						}
					}
					
					if(flag) {// update
						result = reviewDAO.updateAttachment(type, at);
					}else {// insert
						result = reviewDAO.insertImages(type, at);
					}
					
				} else {// if end
					// 업로드(수정)된 이미지가 없을 경우
					
					if(deleteImages[i]) { // 삭제 버튼이 눌러진 인덱스인 경우
						for(Attachment old : oldFiles) {
							// 이전 이미지 파일 목록에 반복 접근하여
							// 삭제 버튼이 눌러진 인덱스(== 파일레벨)와
							// 이전 이미지 중 같은 파일레벨을 가지고 있는 DB 정보를 삭제
							if(old.getFileLevel() == i) {
								result = reviewDAO.deleteAttachment2(type, old.getFileNo());
								
								// 서버측 파일 삭제 목록에 해당 파일 정보를 추가
								removeFiles.add(old);
							}
						}
						
					}
				}
				
				files.add(at);
			} // for end
			
			// 수정된 이미지를 서버에 저장
			if(result > 0) {
				for(int i=0 ; i<images.size(); i++) {
					if(!images.get(i).getOriginalFilename().contentEquals("")) {
						try {
							// transferTo() : 지정된 경로에 업로드된 파일정보를 실제 파일로 변환하는 메소드
							images.get(i).transferTo(new File(savePath + "/" + files.get(i).getFileChangeName()));
						}catch (Exception e) {
							// 서버에 파일 저장 중 오류 발생 시
							// -> DB에 있는 파일 정보도 삭제
							reviewDAO.deleteAttachment(type, review.getReviewNo());
						}
					}
				} // end for
			} // end if
			
			// 제거 목록에 있는 파일을 삭제
			for(Attachment removeFile : removeFiles) {
				File rm = new File(savePath + "/" + removeFile.getFileChangeName());
				rm.delete(); // 파일 삭제
			}
		}
		
		return result;
	}
		
		
		
}
