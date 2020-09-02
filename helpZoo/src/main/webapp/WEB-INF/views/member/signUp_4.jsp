<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - 회원 정보 입력</title>
<link rel="stylesheet" href="${contextPath}/resources/css/register.css">
</head>
<style>
.form-title{
font-family: "Recipekorea";
text-align : center;
font-size : 50px;
}
</style>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
 <div class="main">
        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="GET" action="signUpAction" id="signup-form" class="signup-form">
                        <h2 class="form-title">회원 정보 입력</h2><br>
                        <h5 style="text-align:center;">정말 마지막 단계에요! 회원 정보를 입력하면 가입이 완료됩니다.</h5>
                        <div class="form-group">
                            <input type="text" class="form-input" name="memberId" id="id" placeholder="아이디를 입력해주세요." maxlength="12"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="memberPwd" id="pwd1" placeholder="비밀번호"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" id="pwd1" placeholder="비밀번호 확인"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="memberName" id="name" placeholder="이름을 입력해주세요."/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="memberEmail" id="email" value="${memberEmail}" placeholder="Your Email" disabled/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="${contextPath}/member/signUp" class="term-service">Terms of service</a></label>
                        </div>
                        <hr>
                        <h5 style="text-align:center;">선택사항</h5>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="회원가입"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        	이미 계정이 있으신가요? <a href="${contextPath}/member/login" class="loginhere-link">로그인</a>
                    </p>
                </div>
            </div>
        </section>
    </div>
    <!-- JS -->
    <!--  
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>-->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</body>
</html>