<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/notice.css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/6473591abd.js" crossorigin="anonymous"></script>
<title>도와zoo 공지사항</title>
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	
	<main class="board zoo">

		<!-- 공지사항 타이틀 -->
		<div class="ui-header">
			<h2 data-aos="fade-down" class="title">공지사항</h2>
		</div>

		<!-- 공지 / 이벤트 네비게이션 -->
		<div class="ui-tabs">
			<ul>
				<li class="active"><a href="${contextPath}/notice/noticeList">공지사항</a></li>
				<li><a href="${contextPath}/event/eventList">이벤트</a></li>
			</ul>
		</div>

		<!-- 게시판 리스트 -->
		<div class="board-main">
			<c:choose>
			
				<c:when test="${empty noticeList}">
					<ul>
						<li><a class="article" href="#"> <em class="category">공지사항</em>
								<div class="info">
									<h3 data-aos="zoom-in" class="title">공지사항이 없습니다.</h3>
									<span class="author">admin</span> 
								</div>
						</a></li>
					</ul>
				</c:when>

				<c:otherwise>
					<ul>
						<c:forEach var="notice" items="${noticeList}" varStatus="status">
							<li data-aos="fade-up" data-aos-delay="${(status.index+1)*100}"><a class="article" href="#">
								<span class="boardNo">${notice.boardNo}</span>
								<em class="category">${notice.boardName}</em>
								<div class="info">
									<h3 class="title">${notice.boardTitle}</h3>
									<span class="author">${notice.boardWriter}</span>
									<span class="created-at">${notice.boardCreateDate}</span>
								</div>
							</a></li>
						</c:forEach>
					</ul>
				</c:otherwise>
				
			</c:choose>
			
		</div>
		
		<!-- 공지 footer -->	
		<div class="board-footer">
		
			<!-- 페이징 -->
			<!-- <div class="pagination">
				<div class="page">
					<div class="desktop-only">
						<button class="prev-page icon-chevron-double-left" disabled>
                			<span class="text-hidden">맨 처음 목록</span>
						</button>
						<button class="prev-page icon-chevron-left" disabled>
                			<span class="text-hidden">이전 목록</span>
              			</button>
              			<a class="current" href="#" >1</a>
              			<a href="#">2</a>
              			<a href="#">3</a>
              			<a href="#">4</a>
              			<a href="#">5</a>
              			<a href="#">6</a>
              			<button class="prev-page icon-chevron-right">
                			<span class="text-hidden">다음 목록</span>
              			</button>
						<button class="prev-page icon-chevron-double-right" disabled>
                			<span class="text-hidden">맨 마지막 목록</span>
						</button>
					</div>
				</div>
			</div> -->
			
			<div class="pagination">
				<div class="page">
					<div class="desktop-only">
						<c:if test="${pInfo.currentPage > pInfo.pagingBarSize}">
							
							<!-- 맨 처음으로 -->
							<%-- <i class="fas fa-angle-double-left">
								<a class="first-page" href="${pInfo.boardType}?cp=1"/>
							</i> --%>
							
							<!-- 이전으로 -->
							<fmt:parseNumber var="operand1"
									value="${(pInfo.currentPage - 1)/pInfo.pagingBarSize}"
									integerOnly="true"/>
									
							<c:set var="prev" value="${operand1 * 10}"/>
							<button class="prev-page icon-chevron-left" onclick="location.href='?cp=${prev}'">
	                			<span class="text-hidden">이전 목록</span>
	              			</button>
							<%-- <i class="fas fa-angle-left">
								<fmt:parseNumber var="operand1"
									value="${(pInfo.currentPage - 1)/pInfo.pagingBarSize}"
									integerOnly="true"/>
									
								<c:set var="prev" value="${operand1 * 10}"/>
								
								<a class="prev-page" href="${pInfo.boardType}?cp=${prev}"/>
							</i> --%>
						</c:if>
						
						<!-- 각 페이지 번호 -->
						<c:forEach var="p" begin="${pInfo.startPage}" end="${pInfo.endPage}">
							<c:choose>
								<c:when test="${p == pInfo.currentPage}">
			              			<a class="current" href="#">${p}</a>
								</c:when>
								<c:otherwise>
			              			<a href="?cp=${p}">${p}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${pInfo.maxPage > pInfo.endPage}">
							
							<!-- 다음으로 -->
							<fmt:parseNumber var="operand2"
									value="${(pInfo.currentPage + pInfo.pagingBarSize - 1)/ pInfo.pagingBarSize}"
									integerOnly="true"/>
							<c:set var="next" value="${operand2 * pInfo.pagingBarSize + 1}"/>
							<button class="next-page icon-chevron-right" onclick="location.href='?cp=${next}'">
                				<span class="text-hidden">다음 목록2</span>
              				</button>
							
							<!-- 맨 끝으로 -->
							<%-- <i class="fas fa-angle-double-right">
								<a class="last-page" href="${pInfo.boardType}?cp=${pInfo.maxPage}"></a>
							</i> --%>
						
						</c:if>

					</div>
				</div>
			</div>
			
			<!-- 검색창 -->
			<div class="search">
				<form method="post" id="new-board-search">
					<div class="filter-container">
						<select id="searchSelectInBoard" class="filter">
							<option value="tc">제목+내용</option>
							<option value="t">제목</option>
							<option value="c">내용</option>
						</select>
					</div>
					<div class="field">
						<label class="text-hidden" for="">검색창</label>
						<input id="searchTextInBoard" name="searchTextInBoard" class="search-form" type="text" value="" />
						<button class="btn-search dense" type="submit">검색</button>
					</div>
				</form>
			</div>
			
		</div>
		
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	
	<script>
		
		/* 공지사항 상세페이지 */
		$(function() {
			$('.board-main .article').on('click', function() {
				
				var boardNo = $(this).children().eq(0).text();
				
				console.log(boardNo);
				
				var boardUrl =
					"${contextPath}/notice/${pInfo.boardType}/"
						+ boardNo + "?cp=${pInfo.currentPage}";
					
				location.href = boardUrl;
				
			});
		});
		
	</script>
	
</body>
</html>