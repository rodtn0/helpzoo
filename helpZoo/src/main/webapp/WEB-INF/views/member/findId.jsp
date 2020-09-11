<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
</head>
<body>
	<div class="header">
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	</div>
	 <div class="content">
		<div class="login-page">
		  <div class="form">
			<h1 id="loginTxt">아이디 찾기</h1><br>
		    <form class="login-form" action="findIdAction" method="post">
		      <input type="email" name="memberEmail" placeholder="이메일을 입력해주세요."/>
		      <button id="loginBtn" class="btn btn-lg btn-primary btn-block">아이디 찾기</button>
		    </form>
		  </div>
		</div>
		</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>