<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div id="content">
		<div class="login-page">
		  <div class="form">
			<h1 id="loginTxt">로그인</h1><br>
		    <form class="register-form" method="POST" action="login" onsubmit="return fnLogin();">
		      <input type="text" placeholder="name"/>
		      <input type="password" placeholder="password"/>
		      <input type="text" placeholder="email address"/>
		      <button>create</button>
		      <p class="message">Already registered? <a href="#">Sign In</a></p>
		    </form>
		    <form class="login-form" action="loginAction" method="post">
		      <input type="text" name="memberId" placeholder="아이디"/>
		      <input type="password" name="memberPwd" placeholder="비밀번호"/>
		      <button id="loginBtn" class="btn btn-lg btn-primary btn-block">로그인</button>
		      <p class="message" style="font-size:16px">아직 계정이 없으신가요?
		      <a href="signUp" id="registerTxt">회원가입</a></p>
		    </form>
		  </div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	<script>
		function fnLogin(){
			
		}
	
	
	</script>
</body>
</html>