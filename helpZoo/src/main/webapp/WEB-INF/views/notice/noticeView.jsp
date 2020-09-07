<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/noticeView.css" rel="stylesheet" />
<title>공지사항 상세페이지</title>
</head>

<body>
	<jsp:include page="../common/header.jsp"/>
    <main class="board notice">
        
        <!-- 상세페이지 헤더 -->
        <div data-aos="fade-down" class="header">
            <p class="title">${board.boardTitle}</p>
            <div class="info">
                <span class="user-info">${board.boardWriter}
                <br>${board.boardCreateDate}</span>
            </div>
        </div>

        <p class="hr"/>

        <!-- 상세페이지 contents -->
        <div data-aos="fade-up" class="contents">
            	${board.boardContent}
        </div>
        
        <!-- 상세페이지 하단 -->
        <div class="board-bottom">
            <a data-aos="zoom-in" class="toListBtn" onclick="history.back()">
               	 목록으로 돌아가기
            </a>
        </div>
        
    </main>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>