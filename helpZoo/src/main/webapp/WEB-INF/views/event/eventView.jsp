<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
            <p class="title">
            	<!-- JSTL/JSP 개행문자 처리 -->
	        	<% pageContext.setAttribute("newLine", "\n"); %>
            	${fn:replace(board.boardTitle, newLine, "<br>")}
            </p>
            <div class="info">
                <span class="user-info">${board.boardWriter}
                <br>작성일 : ${board.boardCreateDate}
                <br>수정일 : ${board.boardModifyDate}</span>
                <span class="readCount">조회수 : ${board.readCount}</span>
            </div>
        </div>

        <p class="hr"/>

        <!-- 상세페이지 contents -->
        <div data-aos="fade-up" class="contents">
            ${fn:replace(board.boardContent, newLine, "<br>")}
        </div>
        
        <!-- 상세페이지 하단 -->
        <div class="board-bottom">
            <a data-aos="zoom-in" class="toListBtn" onclick="history.back()">
               	 목록으로 돌아가기
            </a>
            <c:if test="${loginMember.memberNo == 1}">
	            <a data-aos="zoom-in" class="toListBtn" onclick="location.href='${board.boardNo}/updateView?cp=${param.cp}'">
	               	 수정하기
	            </a>
	            <a data-aos="zoom-in" class="toListBtn" id="deleteBtn">
	               	 삭제하기
	            </a>
            	
            </c:if>
        </div>
        
    </main>
    
    <jsp:include page="../common/footer.jsp"/>
    
    <script>
 		/* $('#deleteBtn').on('click', function() {
			if(confirm("정말 삭제하시겠습니까?")){
				location.href="${boardNo}/deleteNotice";
			}
		}); */
 		$('#deleteBtn').on('click', function() {
			swal({
					title:"정말 삭제하시겠습니까?",
					icon:"warning",
					buttons:{
						cancel:{
							text : "Cancel",
							visible : true,
							value :false
						},
						confirm:{
							text : "Ok",
							value : true
						}
					}
			}).then((result)=>{
				if(result){
					location.href="${boardNo}/deleteEvent";
				}
			})
					
					
 		});
    </script>
</body>
</html>