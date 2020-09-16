<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
<style>
	#findPwdTxt{
	font-family: "Recipekorea";
	}
</style>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
	<!-- header -->
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="/WEB-INF/views/common/header.jsp" />
		</div>
	</div>
	<!-- body -->
	<div class="row">
		<div class="col-md-12">
		<div class="login-page">
		  <div class="form">
			<h1 id="findPwdTxt">비밀번호 변경</h1><br>
		    <form class="login-form" action="pwdChange" method="post">
		      <input type="text" name="memberPwd" placeholder="변경할 비밀번호 입력"/>
      			<div class="checkbox mb-3">
			</div>
		      <button id="loginBtn" class="btn btn-lg btn-primary btn-block">비밀번호 변경</button>
		    </form>
		  </div>
		</div>
		</div>
	</div>
	<!-- footer -->
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		</div>
	</div>
</body>
</html>