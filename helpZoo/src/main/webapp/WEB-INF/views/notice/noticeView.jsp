<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공지사항 상세페이지</title>
    <style>
        .header, .contents{
            margin: 0 auto;
            max-width: 800px;
        }

        /* 상세페이지 헤더 */
        .header .title{
            font-size: 22px;
            font-weight: 500;
        }

        .hr{
            border-bottom: 1px solid rgba(0,0,0,.1);
        }

        /* 상세페이지 contents */
        .contents{
            padding-bottom: 30px;
        }

        /* 상세페이지 하단 */
        .board-bottom{
            display: flex;
            background-color: #FAFAFA;
            padding: 20px 0 50px;
        }

        .board-bottom .toList{
            margin: 0 auto;
            padding: 0 24px;
            line-height: 2.8;
            font-size: 16px;
            background-color: white;
        }

        .info .user-info{
            font-size: 14px;
        }

    </style>
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
            <a data-aos="zoom-in" class="btn btn-info float-right" onclick="history.back()">
               	 목록으로 돌아가기
            </a>
        </div>
        
    </main>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>