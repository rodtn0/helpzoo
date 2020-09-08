<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부 후기 게시판</title>

	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/noJS.css" />
	
	
	<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/resources/assets/vendor/bootstrap/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/assets/vendor/bootstrap/bootstrap.min.css" /> --%>
	
	<style>
		.container .btn-get-started {
		  font-family: "Montserrat", sans-serif;
		  text-transform: uppercase;
		  font-weight: 400;
		  font-size: 16px;
		  letter-spacing: 1px;
		  display: inline-block;
		  padding: 14px 30px;
		  border-radius: 3px;
		  transition: 0.5s;
		  margin: 10px;
		  color: #fff;
		  background: #7fcdcd;
		}
		
		/* .container > a {
			float : right;
		} */
		
		#dd{
			float : left;
		}
		
		.containers table{
			
			clear : both;
		}
		
		.main{
			width : 1140px;
		}
		
		.paginationz{
			position: absolute;
			left: 50%;
			top: 100%;
			transform: translate(-50%,-50%);
			margin: 0;
			padding: 10px;
			background-color: #fff;
			border-radius: 40px;
			/* box-shadow: 0 5px 25px 0 rgba(0,0,0,.5); */
		}
		
		.paginationz li {
			display: inline-block;
			list-style: none;
		}
		
		.paginationz a{
			display: block;
			width: 40px;
			height: 40px;
			line-height: 40px;
			background-color: #fff;
			text-align: center;
			text-decoration: none;
			color: #252525;
			border-radius: 4px;
			margin: 5px;
			box-shadow: inset 0 5px 10px rgba(0,0,0,.1), 0 2px 5px rgba(0,0,0,.5);
			transition: all .3s ease;
		}
			
		&:hover, &.active{
			color: #fff;
			background-color: #7fcdcd;
		}
			
		&:first-child a{
			border-radius: 40px 0 0 40px;
		}
		
		&:last-child a{
			border-radius: 0 40px 40px 0;
		}
		
		
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
		
	<br>
	<div class="container">
	
		
		<div class="main">
				<div class="wrapper-demo">
					<div id="dd" class="wrapper-dropdown-1" tabindex="1">
						<span>분류 없음</span>
					    <ul class="dropdown" tabindex="1">
					        <li><a href="${contextPath}/board/review/1">펀딩 후기 게시판</a></li>
					        <li><a href="#">기부 후기 게시판</a></li>
					    </ul>
					</div>
				​</div>
		</div>
		
		<!-- Split button -->
		<!-- <div class="btn-group">
		  <button type="button" class="btn btn-danger">Action</button>
		  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
		    <span class="caret"></span>
		    <span class="sr-only">Toggle Dropdown</span>
		  </button>
		  <ul class="dropdown-menu" role="menu">
		    <li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		    <li class="divider"></li>
		    <li><a href="#">Separated link</a></li>
		  </ul>
		</div> -->
		
		<br><br>	
			
		<table class="table .table-hover">
			<thead>
				<tr>
					<th>분류</th>
					<th>글번호</th>
					<th>프로젝트명</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<c:choose>
					<c:when test="${empty dReview}">
						<tr><td colspan="7">존재하는 게시글이 없습니다.</td></tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach var="donationList" items="${dReview}">
							<tr>
								<td>펀딩 리뷰</td>
								<td>${donationList.reviewNo}</td>
								<td>${donationList.projectTitle}</td>
								<td>${donationList.reviewTitle}</td>
								<td>${donationList.memberId}</td>
								<td>${donationList.readCount}</td>
								<td>${donationList.reviewCreateDate}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				
				</c:choose>
		</table>
		
		<a href="#" class="btn-get-started scrollto">글작성</a>
		
		
		<br><br>
			<!-- Start Pagination -->
			<div class="my-4">
				<ul class="paginationz">
					<li><a href="#0">&lt;&lt;</a></li>
					<li><a href="#0">&lt;</a></li>
					<li><a class="active" href="#0">1</a></li>
					<li><a href="#0">2</a></li>
					<li><a href="#0">3</a></li>
					<li><a href="#0">4</a></li>
					<li><a href="#0">&gt;</a></li>
					<li><a href="#0">&gt;&gt;</a></li>
				</ul>
				<!-- End Pagination -->
			</div>
		</div>
		
		<br><br>
	</div>
	
		
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>