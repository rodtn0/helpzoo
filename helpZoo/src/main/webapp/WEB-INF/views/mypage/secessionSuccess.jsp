<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 완료</title>
<style>
	#mainBtn{
	opacity: 90%;
	font-size: 16px;
	border: white;
	background-color:#97ecec;
	}
	#successTxt{
	font-family: "Recipekorea";
	text-align : center;
	}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<img src="/helpzoo/resources/images/crying.png">
		<h1 id="successTxt">회원 탈퇴 완료</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		그동안 도와주(Zoo)를 이용해 주셔서 감사합니다.<br>
		우리 또 만날 수 있는거겠죠?
       <button class="btn btn-lg btn-primary btn-block">도와주(Zoo) 첫화면</button><br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		</div>
	</div>
</div>
</body>
</html>