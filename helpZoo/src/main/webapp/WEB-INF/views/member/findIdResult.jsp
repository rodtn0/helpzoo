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
			<h1 id="loginTxt">검색결과</h1><br>
		      <h5 style="color:#7fcdcd">${memberId}</h5><br>
		      <button id="loginBtn" class="btn btn-lg btn-primary btn-block" onclick="button_click();">로그인</button>
		  </div>
		</div>
		</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script>
			function button_click() {
				location.href='${contextPath}/member/login';
			}
			
	</script>
</body>
</html>