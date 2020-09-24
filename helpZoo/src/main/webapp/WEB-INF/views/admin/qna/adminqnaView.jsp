<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#board-area{ margin-bottom:50px;}
	#board-content{ padding-bottom:150px;}
	#date-area{font-size: 12px; line-height: 12px}
	#date-area>p{margin: 0}
 

	.boardImgArea{
		height: 300px;
	}

	.boardImg{
		width : 100%;
		height: 100%;
		
		max-width : 300px;
		max-height: 300px;
		
		margin : auto;
	}
	
	#content-main{ margin: 100px auto;}
	

	/* 이미지 화살표 색 조정
	-> fill='%23000' 부분의 000을
	   RGB 16진수 값을 작성하여 변경 가능 
	 */
	.carousel-control-prev-icon {
 		background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E") !important;
	}
	.carousel-control-next-icon {
  		background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E") !important;
	}
	
	.btn{
	width: 85px;
    height: 30px;
    font-size: small !important;
	}
	
	.fa-cat{
	font-size: 50px;
	}
	
</style>
</head>
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
	<div class="container-fluid">
		
		<h1 class="h3 mb-2 text-gray-800">Question And Answer</h1>
        <p class="mb-4">관리자가 사용자 질문에 답변해주는 페이지입니다.</p>
        
        <div class="card shadow mb-4">
        	<div class="card-header py-3">
        		<h6 class="m-0 font-weight-bold text-primary">Question</h6>
        	</div>
        	<div class="card-body">

					<div>
						<i class="fas fa-cat"></i>
						<hr>
						<div id="board-area">
							<!-- Title -->
							<h3 class="mt-4">${board.qnaNo}. ${board.qnaTitle}</h3>
							
				
							<hr>
			
							<!-- Writer -->
							<div class="lead">
							<span><i class="fas fa-user"></i> ${board.qnaWriter}</span>
							<span id="readCount"><i class="far fa-eye"></i> ${board.readCount}</span>
							 	<%-- <span class="float-right">조회수 : ${qnaBoard.readCount}</span> --%>
								<div id="date-area">
									<p>작성일 : ${board.qnaCreateDate}</p>
									<p>마지막 수정일 : ${board.qnaModifyDate}</p>  
								</div>
								
							</div>
			
							<hr>
			
							
							<!-- 이미지 부분 -->
							<c:if test="${!empty files }">
			
			                    <div class="carousel slide m-3" id="carousel-325626">
			
			                        <div class="carousel-inner boardImgArea">
			
			
			                            <c:forEach var="at" items="${files}" varStatus="vs">
			                                <c:set var="src" value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
															<!-- /spring --><!-- db에서 꺼내옴 /resources/uploadImages --><!-- 151312421.jpg -->
			                                <div class="carousel-item <c:if test="${vs.index == 0}"> active</c:if>">
			                                    <img class="d-block w-100 boardImg" src="${src}" />
			                                    <input type="hidden" value="${at.fileNo}">
			                                </div>
			                            </c:forEach>
			
			                        </div> 
			
			
			                        <a class="carousel-control-prev" href="#carousel-325626" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-325626" data-slide="next">
			                        <span class="carousel-control-next-icon"></span> 
			                        <span class="sr-only">Next</span></a>
			                    </div>
			                </c:if>
			
			
							<!-- Content -->
							<!-- JSTL/JSP 개행문자 처리 -->
							<div id="board-content"><%pageContext.setAttribute("newLine","\n");%>${fn:replace(board.qnaContent,newLine,"<br>")}</div>
							<hr>
							<div class="float-right">
								<a href="${contextPath}/admin/qna/qnaList" class="btn btn-info mb-3">목록으로</a>
							</div>
							<hr>
						</div>
						<!-- 답글 영역 -->
						<jsp:include page="adminqnaAnswer.jsp"/>
						
				</div>
        	</div>
        </div>
    </div>
    <jsp:include page="../../common/adfooter.jsp"/>
</body>
</html>