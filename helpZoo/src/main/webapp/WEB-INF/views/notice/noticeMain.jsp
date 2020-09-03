<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/notice.css" rel="stylesheet" />
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
						<c:set var="num" value="100"/>
						<c:forEach var="notice" items="${noticeList}">
							<li data-aos="fade-up" data-aos-delay="${num}"><a class="article" href="#">
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
			<div class="pagination">
				<div class="page">
					<div class="desktop-only">
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
					"${contextPath}/notice/5/" + boardNo;
					
				location.href = boardUrl;
				
			});
		});
		
	</script>
	
</body>
</html>