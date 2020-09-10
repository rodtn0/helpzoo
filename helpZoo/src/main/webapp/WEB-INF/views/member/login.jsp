<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
</head>
<body>
	<div class="header">
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	</div>
	 <div class="content">
		<div class="login-page">
		  <div class="form">
			<h1 id="loginTxt">로그인</h1><br>
		    <form class="login-form" action="loginAction" method="post">
		      <input type="text" name="memberId" placeholder="아이디" required autofocus value="${cookie.saveId.value}"/>
		      <input type="password" name="memberPwd" placeholder="비밀번호"/>
      			<div class="checkbox mb-3">
				<label> 
				<!-- form 태그 안에 존재 -->
					<input type="checkbox" name="saveId"
						<c:if test="${!empty cookie.saveId.value}">
							checked
						</c:if>>아이디 저장
				</label>
			</div>
		      <button id="loginBtn" class="btn btn-lg btn-primary btn-block">로그인</button>
		      <p class="message" style="font-size:16px">아직 계정이 없으신가요?
		      <a href="signUp" id="registerTxt">회원가입</a><br>
		      <a href="findId" id="registerTxt">아이디 찾기</a> |
		      <a href="findPassword" id="registerTxt">비밀번호 찾기</a>
		      </p>
		    </form>
		  </div>
		</div>
		</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>