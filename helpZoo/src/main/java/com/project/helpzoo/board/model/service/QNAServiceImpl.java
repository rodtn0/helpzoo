package com.project.helpzoo.board.model.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.helpzoo.board.model.DAO.QNADAO;
import com.project.helpzoo.board.model.vo.Attachment;
import com.project.helpzoo.board.model.vo.PageInfo;
import com.project.helpzoo.board.model.vo.QNABoard;

@Service
public class QNAServiceImpl implements QNAService{

	@Autowired
	private QNADAO qnaDAO;
	
	@Autowired
	private PageInfo pInfo;
	
	/**
	 * qna 페이징 처리
	 */
	@Override
	public PageInfo pagination(int cp) {
		
		// 전체 게시글 수 조회
		int listCount = qnaDAO.getListCount(cp);
		
		pInfo.setPageInfo(cp, listCount);
		
		return pInfo;
	}

	/**
	 * qna 목록 조회
	 */
	@Override
	public List<QNABoard> selectList(PageInfo pInfo) {
		return qnaDAO.selectList(pInfo);
	}

	/**
	 * qna 작성
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertBoard(QNABoard qnaBoard, String savePath,
						List<MultipartFile> images) {
		// 계속 0x100번지를 저장한 qnaBoard 참조형 변수
		
		int result = 0;
		
		// 1) 다음 시퀀스를 얻어옴.
		int qnaNo = qnaDAO.selectNexNo();
		
		if(qnaNo > 0) {
			// 2) 다음번호 board 객체에 세팅
			qnaBoard.setQnaNo(qnaNo);
			
			// 크로스 사이트 스크립트 방지 처리
			qnaBoard.setQnaContent(replaceParameter(qnaBoard.getQnaContent()));
			
			// 게시글 DB 삽입
			result = qnaDAO.insertBoard(qnaBoard);
			
			System.out.println("qnaNo : " + qnaNo);
			System.out.println("result : " + result);
			
			
			// 파일 정보 DB 저장
			List<Attachment> files = new ArrayList<Attachment>();
			
			Attachment at = null;
			
			String filePath = "/resources/uploadImages";
			
			for(int i=0; i<images.size(); i++) {
				if(!images.get(i).getOriginalFilename().equals("")) {
					// 업로드 된 이미지가 있다면
					
					// --> 별도의 메소드를 제작하여 변경하기
					String changeFileName = rename(images.get(i).getOriginalFilename());
				
					at = new Attachment(qnaBoard.getQnaNo(), images.get(i).getOriginalFilename(),
							changeFileName, filePath, i);
					
					result = qnaDAO.insertAttachment(at);
					
				}
				
				files.add(at);
				
			}
			// 파일을 서버에 저장
			// 디비에 저장이 되었다면
			if(result > 0) {
				for(int i=0; i<images.size(); i++) {
					
					System.out.println("ser: " + savePath);
					System.out.println("ser: " + files.get(i).getFileChangeName());
					
					if(!images.get(i).getOriginalFilename().equals("")) {
						// transferTo(경로) : 지정한 경로에 업로드된 바이트 상태의 파일을 
						// 실제 파일로 변환해서 저장해라.
						// byte에서 실제 이미지 사진으로 바꿔주는 것.
						try {
							images.get(i).transferTo(new File(savePath + "/" +files.get(i).getFileChangeName()));
							// 이미지 저장하는 것을 시도
							// 컨트롤러에서에서 처리할 수 도 있지만 
							// 파일 업로드 하면서 예외가 발생할 수 있기 때문에 예외 그냥 바로 처리
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
		return result;
	}
    
    // Q&A 상세 조회 Service / 조회수 증가
    @Transactional(rollbackFor= Exception.class)
    @Override
    public QNABoard selectBoard(int qnaNo) {
    	
    	QNABoard board = qnaDAO.selectBoard(qnaNo);
    	
    	if(board != null) {
    		int result = qnaDAO.increaseCount(qnaNo);
    		
    		if(result > 0 ) {
    			board.setReadCount(board.getReadCount() +1 );
    		}
    	}
    	return board;
    }
    
    // 게시글 이미지 조회 Service 구현
	@Override
	public List<Attachment> selectFiles(int qnaNo) {
		return qnaDAO.selectFiles(qnaNo);
	}
    
	// qna 질문 쓴 memberId 가져오기
	@Override
	public String selectQuestionId(int qnaNo) {
		
		return qnaDAO.selectQuestionId(qnaNo);
	}

    // qna 수정 Service
    @Transactional(rollbackFor = Exception.class)
	@Override
	public int updateBoard(QNABoard upqnaBoard, String savePath, List<MultipartFile> images, boolean[] deleteImages) {
		
    	upqnaBoard.setQnaContent(replaceParameter(upqnaBoard.getQnaContent()));
    	
    	int result = qnaDAO.updateQNABoard(upqnaBoard); // 게시글만 수정
    	
    	if( result > 0) {
    		List<Attachment> oldFiles = qnaDAO.selectFiles(upqnaBoard.getQnaNo());
    		
    		// DB에 저장할 웹상에서의 이미지 접근 경로
    		String filePath = "/resources/uploadImages";
    		
    		List<Attachment> files = new ArrayList<Attachment>(); // 파일 정보를 모아 놓은 List
    		List<Attachment> removeFiles = new ArrayList<Attachment>(); // 서버 측 파일 제거 List
    		Attachment at = null;
    		
    		for(int i=0; i<images.size(); i++) {
    			
    			if(!images.get(i).getOriginalFilename().equals("")) {
    				// 현재 접근중인 images 요소의 실제 파일명이 빈 문자열이 아닌 경우 == update / insert O
    				
    				// 파일명 변경(rename 작업)
    				String changeFileName = rename(images.get(i).getOriginalFilename());
    				
    				// 수정된 이미지 파일 정보를 저장할 Attachment 객체 생성
    				at = new Attachment(upqnaBoard.getQnaNo(), images.get(i).getOriginalFilename(),
    						changeFileName, filePath, i);
    				
    				// 기존 이미지가 존재하는 경우 -> update
    				// 기존 이미지가 존재하지 않았던 경우 -> insert
    				
    				boolean flag = false; // 기존 이미지가 존재하는 경우 true, 아니면 false;
    				for(Attachment old : oldFiles ) {
    					if(old.getFileLevel() == i) {
    						// 현재 접근한 이전 파일의 레벨이 새롭게 업로드된 파일의 레벨과 같을 경우
    						// == 이전 파일이 새로운 파일로 수정이 된 경우
    						
    						flag = true;
    						removeFiles.add(old); // 서버 파일 제거 List에 수정 예정인 이전 파일 정보를 저장
    						
    						at.setFileNo(old.getFileNo());
    						// 이전 파일의 번호를 얻어와 DB 상에서 데이터 수정을 할 수 있게
    						// 새로운 파일에 번호 세팅
    						
    						break;
    					}
    				}
    				if(flag) {
    					result = qnaDAO.updateAttachment(at);
    				}else {
    					result = qnaDAO.insertAttachment(at);
    				}
    			}else { // if end
    				// 업로드(수정)된 이미지가 없을 경우
    				if(deleteImages[i]) { // 삭제 버튼이 눌러진 인덱스인 경우
    					for(Attachment old: oldFiles) {
    						if(old.getFileLevel() == i) {
    							result = qnaDAO.deleteAttachment2(old.getFileNo());
    							
    							// 서버측 파일 삭제 목록에 해당 파일 정보를 추가
    							removeFiles.add(old);
    						}
    					}
    				}
    			} // else
    		files.add(at);
    		} // for end
    		
    		// 수정된 이미지를 서버에 저장
    		if(result > 0) {
    			for(int i=0; i<images.size(); i++) {
    				if(!images.get(i).getOriginalFilename().equals("")){
    					try {
    						// transferTo() : 지정된 경로에 업로드된 파일 정보를 실제 파일로 변환하는 메소드
    						images.get(i).transferTo(new File(savePath + "/" +files.get(i).getFileChangeName()));
    					}catch (Exception e) {
    						e.printStackTrace();
						}
    				}
    			}// end for
    		}// end if
    		for(Attachment removeFile : removeFiles) {
    			File rm = new File(savePath + "/" + removeFile.getFileChangeName());
    			rm.delete();
    		}
    	}
		return result;
	}
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteBoard(int qnaNo) {
    	int result = qnaDAO.deleteBoard(qnaNo);
    	return result;
    }
    
    // 검색 조건이 추가된 페이징 처리 Service
	@Override
	public PageInfo pagination(int cp, String id) {
		
		int searchListCount = qnaDAO.getSearchListCount(id);
		
		return null;
	}
    // 파일명 변경
    // 200821152611_12345.jpg
    public String rename(String originFileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

        int ranNum = (int)(Math.random()*100000); // 5자리 랜덤 숫자 생성

        String str = "" + String.format("%05d", ranNum);
        //String.format : 문자열을 지정된 패턴의 형식으로 변경하는 메소드
        // %05d : 오른쪽 정렬된 십진 정수(d) 5자리(5)형태로 변경. 빈자리는 0으로 채움(0)

        String ext = originFileName.substring(originFileName.lastIndexOf("."));

        return date + "_" + str + ext;
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



}
