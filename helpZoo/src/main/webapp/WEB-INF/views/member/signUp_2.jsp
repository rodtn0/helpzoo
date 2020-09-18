<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - 이메일 인증</title>
    <!-- Main css -->
    <link rel="stylesheet" href="css/register.css">
</head>
<style>
	#authTxt{
	font-family: "Recipekorea";
	text-align : center;
	font-size : 50px;
	}
</style>
<body style="overflow-x:hidden; overflow-y:auto;">
	<!-- 헤더 영역 -->
	<div class="row">
		<div class="col-md-12">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		</div>
	</div>
	<!-- 바디 영역 -->
	<div class="container mt-5 mb-5" style="padding-bottom:10em;">
    <div class="row justify-content-md-center">
            <div class="card" style="width: 40rem;">
                <div class="card-body">
                        <div class="col-12">
                        <form action="authEmail" method="POST" onsubmit="return validate(); ">
                          	<div id="authTxt">이메일 인증</div><br>
							<div class="col-12 text-center">
							<span style="color:#7fcdcd; font-weight:bold;">이메일을 인증받아야 회원가입 절차를 진행할 수 있습니다.</span><br>
							이메일 : <input type="email" name="memberEmail" id="memberEmail" placeholder="이메일 주소를 입력하세요."><br><br>
                            <span id="checkEmail"></span>
                            <div class="col-12 text-center">
                                <button type="submit" name="authBtn" style="opacity: 90%; font-size: 16px; border: white;
                                	background-color:#97ecec"
                                    class="btn btn-lg btn-primary btn-block" value="authBtn">이메일 인증받기</button>
                            </div>
	                    </div>
	                    </form>
			                </div>
			            </div>
			        </div>
			    </div>
			    </div>
		<div class="row">
			<div class="col-md-12">
			<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		</div>
	</div>
	<script>
	var signUpCheck= {
			
			"email" : false
	};
	
	var $email = $("#memberEmail");
	
	$email.on("input", function(){
		
		signUpCheck.email = false;
		
		var regExp =  /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
		
		if(!regExp.test($email.val())){
			$("#checkEmail").text("유효하지 않은 이메일 형식입니다.").css("color", "red");
			signUpCheck.email= false;
			if($email.val().length == 0) $("#checkEmail").text("");
			
		}else{
			$.ajax({

				url : "emailDupCheck",
				data : {"memberEmail": $email.val()},
				type : "GET",
				
				success : function(result){
					console.log(result);
					if(result == 0){
						$("#checkEmail").text("이메일 인증이 가능한 이메일입니다.").css("color", "#7fcdcd");
						signUpCheck.email= true;
						
					}else{
						$("#checkEmail").text("이미 회원으로 등록된 이메일입니다.").css("color", "red");
						signUpCheck.email= false;
					}
				}, error : function() {
					console.log("이메일 중복 검사 실패");
				}	
			});
		}
	});
	
		function validate(){
			
			for(var key in signUpCheck){
				if(!signUpCheck[key]){

					var msg;
					switch(key){
					case "email" : msg="입력하신 이메일은 "; break;
					}
				
				swal(msg + "사용 불가한 이메일입니다.");
				
				var el = "#" + key;
				$(el).focus();
				return false;
			}
			
			}
		}
	
	</script>
</body>
</html>