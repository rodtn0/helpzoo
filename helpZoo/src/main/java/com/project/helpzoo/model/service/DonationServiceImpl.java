package com.project.helpzoo.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.model.dao.DonationDAO;
import com.project.helpzoo.model.vo.Attachment;
import com.project.helpzoo.model.vo.Donation;
import com.project.helpzoo.model.vo.PageInfo;
import com.project.helpzoo.model.vo.Search;

import oracle.net.aso.s;

@Service //bean 등록을 하자
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationDAO donationDAO;

	@Autowired
	private PageInfo pInfo; // DI 의존성 주입
	
	// 페이징 처리를 위한 Service 구현
	@Override
	public PageInfo pagination(int type, int cp) {

		// 1) 전체 게시글 수 조회
		int listCount = donationDAO.getListCount(type);
		
		// 2) setPageInfo 호출
		pInfo.setPageInfo(cp, listCount, type);
		
		return pInfo;
	}

	// 게시글 목록 조회 Service 구현
	@Override
	public List<Donation> selectList(PageInfo pInfo) {

		return donationDAO.selectList(pInfo);
	}

	// 게시글 상세 조회 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Donation selectBoard(int boardNo) {
		
		// 게시글 조회
		Donation donation = donationDAO.selectDonation(boardNo);
		
		
		// 조회 성공 시 조회 수 증가
		if(donation != null) { // 조회 결과가 있을 떄
			int result = donationDAO.increaseCount(boardNo);
			
			// 조회된 게시글(board)의 조회수를 1증가시켜야 DB와 일치됨
			if (result > 0) {
				donation.setdBoardReadCount(donation.getdBoardReadCount()+1);
			}
		}
		
		return donation;
	}

	// 게시글 등록 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertBoard(Donation donation, List<MultipartFile> images, String savePath) {
		
		int result = 0;
		
		// 1) 다음 SEQ_BNO를 얻어옴
		int dBoardNo = donationDAO.selectNextNo();
		
		if(dBoardNo>0) {// 다음 번호를 정상적으로 얻어 왔을 때
			// 1) 다음 번호 board 객체에 세팅
			donation.setdBoardNo(dBoardNo);
			
			// 크로스 사이트 스크립트 방지 처리
			donation.setdBoardQuestion1(replaceParameter(donation.getdBoardQuestion1()));
			donation.setdBoardQuestion2(replaceParameter(donation.getdBoardQuestion2()));
			donation.setdBoardQuestion3(replaceParameter(donation.getdBoardQuestion3()));
			donation.setdBoardQuestion4(replaceParameter(donation.getdBoardQuestion4()));
			donation.setdBoardQuestion5(replaceParameter(donation.getdBoardQuestion5()));

			
			// 2) 게시글(board) DB 삽입
			result = donationDAO.insertDonation(donation);
			
			// 3) 파일정보 DB 저장
			List<Attachment> files = new ArrayList<Attachment>();
			
			Attachment at = null;
			
			// DB에 저장할 웹상에서의 이미지 접근 경로
			String filePath = "/resources/donation/uploadImages";
			
			for(int i =0; i<images.size(); i++) {
				
				if(!images.get(i).getOriginalFilename().equals("")) {
					// 업로드된 이미지가 있다면 
					
					// 파일명 변경(cos.jar는 별도의 RenamePolicy가 존재하지만 스프링은 없음)
					// -> 별도의 메소드를 제작하여 변경하기
					String changeName = rename(images.get(i).getOriginalFilename());
					
					// Attachment 객체 생성
					at = new Attachment(dBoardNo, images.get(i).getOriginalFilename(), 
							changeName, filePath, i);					
					
					result = donationDAO.insertAttachment(at);
					
				}
				
				files.add(at);
					
			}
			
			// 4) 파일을 서버에 저장
			if(result > 0) {
				for(int i = 0; i<images.size(); i ++) {
					
					if(!images.get(i).getOriginalFilename().equals("")) {
						// 이미지가 업로드 되었다면
						
						// transferTo(경로) : 지정한 경로에 업로드된 바이트 상태의 파일을 실제 파일로 변환해서 저장해라
						try {
							images.get(i).transferTo(new File(
									savePath+ "/" + files.get(i).getFileChangeName()));
						} catch (Exception e) {
							e.printStackTrace();
							
							// 서버에 파일 저장 중 문제가 발생할 경우
							// 이미 DB에 삽입되어 있는 파일정보를 삭제하는 DAO를 호출
							donationDAO.deleteAttachment(dBoardNo);
							
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
    
    
    
    
    
    // 게시글 삭제 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int donationDelete(int dBoardNo) {

		int result = donationDAO.donationDelete(dBoardNo);
		
		return result;
	}
	
	// 게시글 수정 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateBoard(Donation upDonation, String savePath, 
							List<MultipartFile> images, boolean[] deleteImages) {
											// images : 수정된 파일 리스트
		// 크로스 사이트 스크립트 방지 처리 해야함
		upDonation.setdBoardQuestion1(replaceParameter(upDonation.getdBoardQuestion1()));
		upDonation.setdBoardQuestion2(replaceParameter(upDonation.getdBoardQuestion2()));
		upDonation.setdBoardQuestion3(replaceParameter(upDonation.getdBoardQuestion3()));
		upDonation.setdBoardQuestion4(replaceParameter(upDonation.getdBoardQuestion4()));
		upDonation.setdBoardQuestion5(replaceParameter(upDonation.getdBoardQuestion5()));

		
		int result = donationDAO.updateDonation(upDonation);
		
		if(result > 0) {
			// 1) 이전 업로드 파일 목록 조회
			List<Attachment> oldFiles = donationDAO.selectFiles(upDonation.getdBoardNo());
			
			// DB에 저장할 웹상에서의 이미지 접근 경로
			String filePath = "/resources/donation/uploadImages";
			
			// 파일 정보를 모아 놓을 List
			List<Attachment> files = new ArrayList<Attachment>();  // 파일 정보를 모아 놓은 List
			List<Attachment> removeFiles = new ArrayList<Attachment>(); // 서버 측 파일 제거 List
			
			Attachment at = null;
			
			for(int i = 0; i<images.size(); i++) {
				if(!images.get(i).getOriginalFilename().equals("")) {
					// 현재 접근중인 images 요소의 실제 파일명이 빈 문자열이 아닐 경우(update, insert가 진행됐을 떄)
					// == 수정된 이미지가 업로드된 경우
					
					// 파일명 변경(rename 작업)
					String changeFileName = rename(images.get(i).getOriginalFilename());
					
					// 수정된 이미지 파일 정보를 저장할 Attachment 객체 생성
					at = new Attachment(upDonation.getdBoardNo(), images.get(i).getOriginalFilename(), 
							changeFileName, filePath, i);
					
					
					// 기존 이미지가 존재하는 경우 -> update
					// 기존 이미지가 존재하지 않는 경우 -> insert
					
					boolean flag = false; // 기존 이미지가 존재하는 경우 true, 아니면 false
					
					for(Attachment old : oldFiles) { // 이전 파일 목록에 반복 접근
						if(old.getFileLevel()==i) {
							// 현재 접근한 이전 파일의 레벨이
							// 새롭게 업로드된 (수정된) 파일의 레벨과 같을 경우
							// == 이전 파일이 새로운 파일로 수정이된 경우
							
							flag = true;
							removeFiles.add(old); // 서버 파일 제거 List에 수정 예정인 이전 파일 정보를 저장
							
							at.setFileNo(old.getFileNo());
							// 이전 파일의 번호를 얻어와
							// DB상에서 데이터 수정할 수 있게
							// 새로운 파일에 번호 세팅
							break;
							
						}
					}
					
					if(flag) {
						// update
						result = donationDAO.updateAttachment(at);
					}else {
						// insert
						result = donationDAO.insertAttachment(at);
					}
				} else { // end if
					 // 업로드(수정)된 이미지가 없을 경우
					if(deleteImages[i]) { // 삭제 버튼이 눌러진 인덱스인 경우 true
						for(Attachment old : oldFiles) {
							// 이전 이미지 파일 목록에 반복 접근하여
							// 삭제 버튼이 눌러진 인덱스(== 파일레벨)와
							// 이전 이미지 중 같은 파일레벨을 가지고 있는 DB 정보를 삭제
							
							if(old.getFileLevel() == i) {
								result = donationDAO.deleteAttachment2(old.getFileNo());
								// 기존 deleteAttachment은 모두 삭제
								// deleteAttachment2 1개만 삭제하기 위해서
								
								// 서버측 파일 삭제 목록에 해당 파일 정보를 추가
								removeFiles.add(old);
							}
						}
					}
				}
				
				files.add(at);
				
			} // end for 
			
			// 수정된 이미지를 서버에 저장하는 구문
			if(result > 0) {
				for(int i = 0; i<images.size(); i++) {
					if(!images.get(i).getOriginalFilename().equals("")) {
						try {
							// transferTo() : 지정된 경로에 업로드된 파일정보를 실제 파일로 변환하는 메소드
							images.get(i).transferTo(new File(savePath+"/"+files.get(i).getFileChangeName()));
						}catch (Exception e) {
							// 서버에 파일 저장 중 오류 발생 시
							// -> DB에 있는 파일 정보도 삭제
							donationDAO.deleteAttachment(upDonation.getdBoardNo());
						}
					}
				} // end for
			} // end if
			
			// 제거 목록에 있는 파일 삭제
			for(Attachment removeFile : removeFiles) {
				File rm = new File(savePath + "/" + removeFile.getFileChangeName());
				rm.delete(); // 파일 삭제
			}
			
		}
		
		
		return result;
	}

	// 게시글 이미지 조회 Service 구현
	@Override
	public List<Attachment> selectFiles(int dBoardNo) {
		
		return donationDAO.selectFiles(dBoardNo);
	}

	// 썸네일 조회 Service 구현
	@Override
	public List<Attachment> selectThumbnailList(List<Donation> donationList) {

		return donationDAO.selectThumbnailList(donationList);
	}

	// 게시판 조회수 높은 게시글 조회 Service 구현
	@Override
	public List<Donation> selectTopViews(int type) {

		return donationDAO.selectTopViews(type);
	}
	
	
	
	// 페이징 처리를 위한 Service 구현 검색 조건 추가
	@Override
	public PageInfo pagination(int type, int cp, Search search) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search",search);
		map.put("type", type);
		
		// 1) 전체 게시글 수 조회
		int searchlistCount = donationDAO.getSearchListCount(map);
		
		// 2) setPageInfo 호출
		pInfo.setPageInfo(cp, searchlistCount, type);
		
		return pInfo;
	}

	// 검색 목록 조회 Service 구현
	@Override
	public List<Donation> selectSearchList(PageInfo pInfo, Search search) {
		// Mybatis는 파라미터 하나만 보낼 수 있음
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("type", pInfo.getdonationType());
		
		return donationDAO.selectSearchList(pInfo, map);
	}
	

}
