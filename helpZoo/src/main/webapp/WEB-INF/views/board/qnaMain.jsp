<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<style>
	#paging {
		text-align:center;
	}
	#paging li {
		display:inline;
		vertical-align:middle;
	}
	#paging li a {
		display:-moz-inline-stack;	/*FF2*/
		display:inline-block;
		vertical-align:top;
		padding:4px;
		margin-right:3px;
		width:30px !important;
		color:#000;
		font:bold 12px tahoma;
		border:1px solid #eee;
		text-align:center;
		text-decoration:none;
		width /**/:26px;	/*IE 5.5*/
	
	}
	#paging li a.now {
		color:#fff;
		background-color:#f40;
		border:1px solid #f40;
	}
	#paging li a:hover, #paging li a:focus {
		color:#fff;
		border:1px solid #7fcdcd;
		background-color:#7fcdcd;
	}
	.btn{
	width: 80px;
    height: 34px;
    font-size: small !important;
	}
	
	/* 눌렀을 때 색깔 유지 */
	li.active-color { color:#7fcdcd; }
	    
	</style>
	
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>

	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
	<br>
	<h3>질문과 답변</h3>
	</div>
	
<%-- 	<div style="text-align:center; min-height:320px;">
		<img class="d-block w-100" src="<%=request.getContextPath()%>/resources/images/QNA배너.png">
	</div> --%>
	<br>
	<div class="container">
		<table class="table table-sm">
		  <thead>
		    <tr>
		      <th scope="col">글번호</th>
		      <th scope="col">제목</th>
		      <th scope="col">글쓴이</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody>
		  <!-- else if -->
		  	<c:choose>
		  		<c:when test="${empty qnaList }">
		  			<tr><td colsepan="4"> 존재하는 게시글이 없습니다.</td></tr>
		  		</c:when>
		  		
		  	<c:otherwise>
		  		<c:forEach var="qnaBoard" items="${qnaList}" varStatus="vs">
			    <tr>
			      <th scope="row">${listCount-( (pInfo.currentPage-1) * pInfo.limit)-vs.index}</th>
			      <td><i class="fas fa-lock"></i> ${qnaBoard.qnaTitle}</td>
			      <td>${qnaBoard.qnaWriter}</td>
 	              <td>
        			<jsp:useBean id="now" class="java.util.Date"/>
        			<%-- Date now = new Date(); (현재시간) --%>
        			<fmt:formatDate var="today" value="${now}" pattern="yyyy-MM-dd"/>
        			<fmt:formatDate var="createDate" value="${qnaBoard.qnaCreateDate}" pattern="yyyy-MM-dd"/>
        			<fmt:formatDate var="createTime" value="${qnaBoard.qnaCreateDate}" pattern="hh:mm:ss"/>
        						
         			<c:choose>
         					
	         			<c:when test="${today == createDate}">
	         				${createTime}
	         			</c:when>
	         			<c:otherwise>
	         			${createDate}
	         			</c:otherwise>
         						
         			</c:choose>
				</td>
				<td>${qnaBoard.readCount}</td>
         	</tr>
         </c:forEach>
        </c:otherwise>
       </c:choose>
	</tbody>
   </table>
   	<a class="btn btn-info float-right " href="#"><i class="fas fa-pencil-alt"></i> 글쓰기</a>
   	<br><br>
   	
    <ul id="paging">
   		<c:if test="${pInfo.currentPage > pInfo.pagingBarSize }">
	        <li>
	        	<!-- 맨 처음으로(<<) -->
	        <a href="?cp=1">&lt;&lt;</a></li>
	        	<!-- 이전으로(<) -->
	        	<!-- prev 생성 식 : (현재 페이지 -1) / 페이징바 사이즈(10) * 10-->
	            <!-- el은 자료형이 없어서 나눌 때(4/10) int로 처리 되어 0이 아니라 0.4로 나옴 -->
	            <!-- fmt태그를 이용한 소수점 제거 -->
	        <fmt:parseNumber var="operand1" 
	         value="${(pInfo.currentPage-1)/pInfo.pagingBarSize}"
	         integerOnly="true"/>
	         <c:set var="prev" value="${operand1 * 10}"/>
	        <li><a href="?cp=${prev}">&lt;</a></li>
   		</c:if>
   		
   		<!-- 10개의 페이지 목록 -->
   		<c:forEach var="p" begin="${pInfo.startPage}" end="${pInfo.endPage}">
   			<c:choose>
   			<c:when test="${p==pInfo.currentPage}">
	        <li><a>${p}</a></li>
	        </c:when>
	        <c:otherwise>
	        <li><a href="?cp=${p}">${p}</a></li>
	        </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    
	    <!-- next 생성식 : (현재 페이지 + 9 ) /10 * 10 + 1-->
        <c:if test="${pInfo.maxPage > pInfo.endPage }">
	       <li>
	       	<fmt:parseNumber var="operand2" value="${(pInfo.currentPage + pInfo.pagingBarSize-1) / pInfo.pagingBarSize}" integerOnly="true"/>
	       	<c:set var="next" value="${operand2 * pInfo.pagingBarSize + 1 }"/>
        	<a href="?cp=${next}">&gt;</a>
        	</li>
        	
        	<!-- 맨 끝으로(>>) -->
	        <li>
	        <a href="?cp=${pInfo.maxPage}">&gt;&gt;</a>
	        </li>  
	  </c:if> 
    </ul>
</div>

	<jsp:include page="../common/footer.jsp"/>
	
	<script>
	$("li").click(function() {
	    toggleClass(".active-color");
	});
</script>
</body>
</html>