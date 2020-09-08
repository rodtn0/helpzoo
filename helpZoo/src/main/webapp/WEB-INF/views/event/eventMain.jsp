<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/event.css" rel="stylesheet" />
<title>도와zoo 이벤트 게시판</title>
</head>

<body>
	<jsp:include page="../common/header.jsp"/>
	    <main class="board zoo">
	
	        <!-- 공지사항 타이틀 -->
	        <div class="ui-header">
	            <h2 data-aos="fade-down" class="title">이벤트</h2>
	        </div>
	
	        <!-- 공지 / 이벤트 네비게이션 -->
	        <div class="ui-tabs">
	            <ul>
	                <li class="active">
	                    <a href="${contextPath}/notice/noticeList">공지사항</a>
	                </li>
	                <li>
	                    <a href="${contextPath}/event/eventList">이벤트</a>
	                </li>
	            </ul>
	        </div>
	
	        <!-- 게시판 리스트 -->
	        <div class="board-main">
	            <ul>
	                <li data-aos="fade-up" data-aos-delay="100">
	                    <a class="article" href="#">
	                        <em class="category">진행중</em>
	                        <div class="info">
	                            <h3 class="title">이벤트1</h3>
	                            <span class="author">admin</span>
	                            <span class="created-at">2020.08.28</span>
	                        </div>
	                    </a>
	                </li>
	                <li data-aos="fade-up" data-aos-delay="200">
	                    <a class="article" href="#">
	                        <em class="category">진행중</em>
	                        <div class="info">
	                            <h3 class="title">이벤트2</h3>
	                            <span class="author">admin</span>
	                            <span class="created-at">2020.08.28</span>
	                        </div>
	                    </a>
	                </li>
	                <li data-aos="fade-up" data-aos-delay="300">
	                    <a class="article" href="#">
	                        <em class="category">진행중</em>
	                        <div class="info">
	                            <h3 class="title">이벤트3</h3>
	                            <span class="author">admin</span>
	                            <span class="created-at">2020.08.28</span>
	                        </div>
	                    </a>
	                </li>
	                <li data-aos="fade-up" data-aos-delay="400">
	                    <a class="article" href="#">
	                        <em class="category">종료</em>
	                        <div class="info">
	                            <h3 class="title">이벤트4</h3>
	                            <span class="author">admin</span>
	                            <span class="created-at">2020.08.28</span>
	                        </div>
	                    </a>
	                </li>
	                <li data-aos="fade-up" data-aos-delay="500">
	                    <a class="article" href="#">
	                        <em class="category">종료</em>
	                        <div class="info">
	                            <h3 class="title">이벤트5</h3>
	                            <span class="author">admin</span>
	                            <span class="created-at">2020.08.28</span>
	                        </div>
	                    </a>
	                </li>
	                <li data-aos="fade-up" data-aos-delay="600">
	                    <a class="article" href="#">
	                        <em class="category">종료</em>
	                        <div class="info">
	                            <h3 class="title">이벤트6</h3>
	                            <span class="author">admin</span>
	                            <span class="created-at">2020.08.28</span>
	                        </div>
	                    </a>
	                </li>
	            </ul>
	        </div>
	    </main>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>