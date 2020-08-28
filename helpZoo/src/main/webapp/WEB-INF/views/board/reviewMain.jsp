<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>

	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/style.css" />
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
	
		<section class="main">
				<div class="wrapper-demo">
					<div id="dd" class="wrapper-dropdown-1" tabindex="1">
						<span>Gender</span>
					    <ul class="dropdown" tabindex="1">
					        <li><a href="#">Male</a></li>
					        <li><a href="#">Female</a></li>
					    </ul>
					</div>
				​</div>
		</section>
			
			
		<table class="table .table-hover">
			<thead>
				<tr>
					<th>분류</th>
					<th>글번호</th>
					<th>프로젝트명</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>펀딩 후기</td>
					<td>9999</td>
					<td>강아지 방석 펀딩</td>
					<td>참여 잘한것같아요</td>
					<td>펀딩 후기</td>
					<td>펀딩 후기</td>
				</tr>
				
			</tbody>
		</table>
	</div>
		
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>