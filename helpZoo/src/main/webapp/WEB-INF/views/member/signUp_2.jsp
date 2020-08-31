<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - 이메일 인증</title>
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
<div>
    <div class="row justify-content-md-center">
        <div style="position: absolute; top: 50%; height: 778.98px; margin-top: -389.49px;">
            <div class="card" style="width: 40rem;">
                <div class="card-body">
                        <div class="col-12">
                        <form action="authEmail" method="POST">
                          	<div id="authTxt">이메일 인증</div><br>
							<div class="col-12 text-center">
							<span style="color:#7fcdcd; font-weight:bold;">이메일을 인증받아야 회원가입 절차를 진행할 수 있습니다.</span><br>
							이메일 : <input type="email" name="authEmail" placeholder="이메일 주소를 입력하세요."><br><br>
                            <div class="col-12 text-center">
                                <button type="submit" name="authBtn" style="opacity: 90%; font-size: 16px; border: white;
                                	background-color:#97ecec"
                                    class="btn btn-lg btn-primary btn-block" value="authBtn">이메일 인증받기</button>
                            </div>
			                    </div>
			                </div>
			            </div>
			        </div>
                            </form>
			    </div>
	</div>
	</div>
</body>
</html>