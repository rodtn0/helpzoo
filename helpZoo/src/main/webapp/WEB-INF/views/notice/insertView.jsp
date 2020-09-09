<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/insertView.css" rel="stylesheet"/>
<title>공지사항 등록</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div class="insertViewMain">
		
            <h3 class="noticeTitleH3" data-aos="fade-down">공지사항 등록</h3>
            
            <form class="insertViewForm" action="insertNotice" method="post">
                <hr>
                <div>
                    <br>
                    <label class="titleLabel" for="title" data-aos="zoom-in">제목</label>
                    <input type="text" id="title" name="boardTitle">
                    <br>
                </div>

                <div>
                    <br>
                    <label class="contentLabel" for="content" data-aos="fade-up">내용</label>
                    <textarea name="boardContent" id="content"></textarea>
                    <br>
                </div>


                <div class="btn">
                    <br>
                    <button data-aos="zoom-in" type="submit" class="insertBtn">등록</button>
                	<a data-aos="zoom-in" class="toListBtn" onclick="history.back()">목록으로</a>
                </div>

            </form>
        </div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>