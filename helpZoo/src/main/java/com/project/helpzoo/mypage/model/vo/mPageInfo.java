package com.project.helpzoo.mypage.model.vo;

import org.springframework.stereotype.Component;

@Component
public class mPageInfo {
	
	private int currentPage; // 현재 페이지 번호
	private int listCount; // 전체 게시글 수
	private int limit = 9; // 한 페이지에 보여질 게시글 수를 10으로 명시적 초기화
	private int pagingBarSize = 10; // 보여질 페이징바의 페이지 수
	
	private int maxPage; // 전체 페이지 수(== 가장 마지막 페이지)
	private int startPage; // 페이징바 시작 페이지 번호
	private int endPage; // 페이징바 끝 페이지 번호
	
	private int boardType; // 게시글 타입
	
	// (1) 기본 생성자
	public mPageInfo() {
		
	}
	
	// (2) getter와 setter 작성
		public int getCurrentPage() {
			return currentPage;
		}
		
		// 최근 페이지가 변할 때마다 페이지네이션 다시 되어야 함
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
			makePageInfo();
		}

		public int getListCount() {
			return listCount;
		}
		
		// 전체 게시글 수가 변할때마다 게시글 리스트가 변해야 함
		public void setListCount(int listCount) {
			this.listCount = listCount;
			makePageInfo();
		}

		public int getLimit() {
			return limit;
		}
		
		// limit 값이 변할때마다 페이지네이션 다시 되어야 함
		public void setLimit(int limit) {
			this.limit = limit;
			makePageInfo();
		}

		public int getPagingBarSize() {
			return pagingBarSize;
		}
		
		// 페이징바의 사이즈가 변할때마다 페이지네이션 다시 되어야 함
		public void setPagingBarSize(int pagingBarSize) {
			this.pagingBarSize = pagingBarSize;
			makePageInfo();
		}

		public int getMaxPage() {
			return maxPage;
		}

		public void setMaxPage(int maxPage) {
			this.maxPage = maxPage;
		}

		public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public int getEndPage() {
			return endPage;
		}

		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}
		
		
		public int getBoardType() {
			return boardType;
		}

		public void setBoardType(int boardType) {
			this.boardType = boardType;
		}
		
		// (3) toString 메소드 오버라이딩
		@Override
		public String toString() {
			return "mPageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
					+ ", pagingBarSize=" + pagingBarSize + ", maxPage=" + maxPage + ", startPage=" + startPage
					+ ", endPage=" + endPage + ", boardType=" + boardType + "]";
		}

		// 페이징 처리에 필요한 값을 계산하는 메소드.
	    private void makePageInfo() {
	        
	        // * maxPage - 총 페이지수 
	        // 게시글의 개수가 100개일 경우 필요 페이지 수 : 10 페이지
	        // 게시글의 개수가 101개일 경우 필요 페이지 수 : 11 페이지
	        // 전체 게시글 수 / 한 페이지에 보여질 개수 결과를 올림 처리함.
	        maxPage = (int)Math.ceil(((double)listCount / limit));
	        
	        // * startPage - 페이징바 시작 페이지 번호
	        //   아래쪽에 페이지 수가 10개씩 보여지게 할 경우
	        //   1, 11, 21, 31, .....
	        //startPage = (int)Math.floor(((double)currentPage - 1) / pagingBarSize) * pagingBarSize + 1;
	        startPage = (currentPage-1)/pagingBarSize * pagingBarSize + 1;
	        
	        // * endPage - 페이징바 끝 페이지 번호
	        //   아래쪽에 페이지 수가 10개씩 보여지게 할 경우
	        //   10, 20, 30, 40, ..... 
	        //endPage = startPage + pagingBarSize - 1;
	        
	        // 총 페이지의 수가endPage 보다 클 경우
	        endPage = startPage + pagingBarSize - 1;
	        if(maxPage <= endPage) {
	            // 총 페이지 수가 endPage보다 작을 경우
	            // ex) maxPage가 13페이지고 endPage가 20페이지일 경우 13이 끝이여야 함.
	            endPage = maxPage;
	        }
	    }
	    
	  
		public void setPageInfo(int currentPage, int listCount, int boardType) {
	    	this.currentPage = currentPage;
	    	this.listCount = listCount;
	    	this.boardType = boardType;
	    	
	    	makePageInfo();
	    }

	
}
