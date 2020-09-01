<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>

	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/categoryCss/css/noJS.css" />
	
	
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/assets/vendor/bootstrap/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/assets/vendor/bootstrap/bootstrap.min.css" />
	
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
		
		
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
		
		
	<div class="container">
	
		
		<section class="main">
				<div class="wrapper-demo">
					<div id="dd" class="wrapper-dropdown-1" tabindex="1">
						<span>분류 없음</span>
					    <ul class="dropdown" tabindex="1">
					        <li><a href="#">펀딩 후기 게시판</a></li>
					        <li><a href="#">기부 후기 게시판</a></li>
					    </ul>
					</div>
				​</div>
		</section>
		
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
		
		<a href="#" class="btn-get-started scrollto">글작성</a>
	</div>
	
		
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>