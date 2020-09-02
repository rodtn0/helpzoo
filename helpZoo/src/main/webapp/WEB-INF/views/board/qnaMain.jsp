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
	    
	</style>
	
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<table class="table table-sm">
		  <thead>
		    <tr>
		      <!-- <th scope="col">글번호</th> -->
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
		  			<tr><td colsepan="4"> 존재하는 게시글이 없습니다. </td></tr>
		  		</c:when>
		  	<c:otherwise>
		  		<c:forEach var="qnaBoard" items="${qnaList}">
			    <tr>
			      <%-- <th scope="row">${"listCount"-1}</th> --%>
			      <td>${qnaBoard.qnaTitle}</td>
			      <td>${qnaBoard.qnaWriter}</td>
			      <td>${qnaBoard.readCount}</td>
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
         	</tr>
         	</c:forEach>c:forEach>
        </c:otherwise>
       </c:choose>
	</tbody>
   </table>
    <ul id="paging">  
        <li><a href="#">1</a></li>  
        <li><a href="#">2</a></li>  
        <li><a href="#">3</a></li>  
        <li><a href="#">4</a></li>  
        <li><a href="#">5</a></li>  
        <li><a href="#">6</a></li>  
        <li><a href="#">7</a></li>  
        <li><a href="#">8</a></li>  
        <li><a href="#">9</a></li>  
        <li><a href="#">10</a></li>  
    </ul>
</div>
    
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>