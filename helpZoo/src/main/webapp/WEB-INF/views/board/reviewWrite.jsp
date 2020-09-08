<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 작성하기</title>
	<style>
	
	#reviewTitle{
		width : 860px;
		height : 40px;
		border : 1px solid #ebecef; 
		padding : 5px 10px 5px 10px;
		margin : 0px 0px 20px 0px;
	}
	
	#reviewTitle input{
		border : 1px solid #fff;
	}
	
	#reviewContent{
		width : 860px;
		height : 412px;
		border : 1px solid #ebecef; 
		padding : 10px 10px 10px 10px;
	}
	
	
	
	#side{
		display: block;
		border : 1px solid #ebecef; 
		width : 70px;
	}
	
	h3{
		padding : 30px 0px 0px 0px;
		color : black;
	}
	
	hr{
		color : black;
	}
	
	
	</style>
	
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
		<h3>펀딩 후기 게시판</h3>
		<hr>
		
		<div>
			<div id="reviewTitle">
				<input type="text" placeholder="제목을 입력해주세요." >
			</div>
			
			<div id="reviewContent">
				<textarea placeholder="내용을 입력해주세요.">
				</textarea>
			</div>
			
			<div id="side">
				<div>
					ggg
				</div>
				<div>
				
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="../common/footer.jsp"/>
</body>
</html>