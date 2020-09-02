<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - 인증번호 받기</title>
</head>
<style>
	#authTxt{
	font-family: "Recipekorea";
	text-align : center;
	font-size : 50px;
	}
</style>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<!--  
<script>
	swal({
		  icon: "success",
		  text : "이메일이 발송되었습니다. 인증번호를 입력해주세요."
		});
</script>
-->
<div>
    <div class="row justify-content-md-center">
        <div style="position: absolute; top: 50%; height: 778.98px; margin-top: -389.49px;">
            <div class="card" style="width: 40rem;">
                <div class="card-body">
                        <div class="col-12">
                        <%-- <c:set var="memberEmail" value="${memberEmail }" scope="session"/> --%>
                        <form action="joinAuth/${dice}" method="POST">
                          	<div id="authTxt">인증번호 입력</div><br>
							<div class="col-12 text-center">
							<span style="color:#7fcdcd; font-weight:bold;">메일로 입력받은 인증번호를 입력하세요.</span><br>
							인증번호 : <input type="number" name="authCode" placeholder="인증번호를 입력하세요."><br><br>
                            <div class="col-12 text-center">
                                <button type="submit" name="authBtn" style="opacity: 90%; font-size: 16px; border: white;
                                	background-color:#97ecec"
                                    class="btn btn-lg btn-primary btn-block" value="successBtn">인증번호 전송</button>
                            </div>
			                    </div>
		                  </form>
			                </div>
			            </div>
			        </div>
			    </div>
	</div>
	</div>
</body>
</html>