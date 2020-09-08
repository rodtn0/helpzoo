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
#postcodify_search_button{
background-color: #7fcdcd;
border: none;
}
</style>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
 <div class="main">
        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" action="../signUpAction" name="signUpForm" class="signup-form" onsubmit="return validate();">
               
                        <h2 class="form-title">회원 정보 입력</h2><br>
                       <!--  <h5 style="text-align:center;">정말 마지막 단계에요! 회원 정보를 입력하면 가입이 완료됩니다.</h5>-->
                        <div class="form-group">
                            <input type="text" class="form-input" name="memberId" id="id" placeholder="아이디를 입력해주세요." maxlength="12"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="memberPwd" id="pwd1" placeholder="비밀번호"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" id="pwd2" placeholder="비밀번호 확인"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="memberName" id="name" placeholder="이름을 입력해주세요."/>
                        </div>
                            <!-- 전화번호 -->
                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="phone1">연락처 </label>
                        </div>
                        <!-- 전화번호1 -->
                        <div class="col-md-3">
                            <select class="custom-select" id="phone1" name="phone1" required>
                                <option>010</option>
                                <option>011</option>
                                <option>016</option>
                                <option>017</option>
                                <option>019</option>
                            </select>
                        </div>
                        
                        <!-- 전화번호2 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control phone" id="phone2"  maxlength="4" name="phone2" required>
                        </div>
                        
                        <!-- 전화번호3 -->
                        <div class="col-md-3">
                            <input type="number" class="form-control phone" id="phone3"  maxlength="4" name="phone3" required>
                        </div>
                        
                        <div class="col-md-6 offset-md-3">
                            <span id="checkPhone">&nbsp;</span>
                        </div>
	                    </div>
	                    
                        <div class="form-group">
                            <input type="email" class="form-input" name="memberEmail" id="email" value="${memberEmail}">
                        </div>
                        
                        <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="postcodify_search_button">우편번호</label>
                        </div>
                        <div class="col-md-3">
                            <input type="text" name="post" id="post" class="form-control postcodify_postcode5">
                        </div>
                        <div class="col-md-3">
                            <button type="button" class="btn btn-primary" id="postcodify_search_button">검색</button>
                        </div>
                    </div>

                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="address1">도로명 주소</label>
                        </div>
                        <div class="col-md-9">
                            <input type="text" class="form-control postcodify_address" name="address1" id="address1">
                        </div>
                    </div>

                    <div class="row mb-3 form-row">
                        <div class="col-md-3">
                            <label for="address2">상세주소</label>
                        </div>
                        <div class="col-md-9">
                            <input type="text" class="form-control postcodify_details" name="address2" id="address2">
                        </div>
                    </div>
                     <!-- jQuery와 postcodify 를 로딩한다. -->
                    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
                    <script>
                        // 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
                        $(function(){
                            $("#postcodify_search_button").postcodifyPopUp();
                        });
                    </script>
                        <!--  
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span><a href="${contextPath}/member/signUp" class="term-service">서비스 약관</a> 의 모든 내용에 동의합니다.</label>
                        </div>
                        -->
                        
                        <hr><h5 class="form-title">선택사항</h5>
                         <div class="form-group">
                         <label for="inputEmail" 
                         class="col-lg-2 control-label">애완동물 종류</label>
							<select name=memberPetType id="pet-select">
							    <option value="">--애완동물 종류를 선택해주세요--</option>
							    <option value="dog">강아지</option>
							    <option value="cat">고양이</option>
							    <option value="hamster">햄스터</option>
							    <option value="hedgehog">고슴도치</option>
							    <option value="rabbit">토끼</option>
							    <option value="goldfish">금붕어</option>
							</select>
                        </div>
                         <div class="form-group">
                            <input type="text" class="form-input" name="memberPetName" id="petName" placeholder="애완동물의 이름을 입력해주세요."/>
                        </div>
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
    <script>
    var signUpCheck = {
    		"id" : false,
    		"pwd1" : false,
    		"pwd2" : false,
    		"name" : false,
    		"phone2" : false
    };
    
    // ******* 실시간 유효성 검사 *******
    // 정규 표현식
    var $id = $("#id");
    var $pwd1 = $("#pwd1");
    var $pwd2 = $("pwd2");
    var $pwd = $("#pwd1, #pwd2");
    var $name = $("#name");
    var $phone2 = $("#phone2");
    var $phone3 = $("#phone3");
    
    // 아이디 유효성 검사
    // #id라는 요소에 on(입력) 이벤트가 발생했을 때 함수를 수행하겠다.
    $id("input", function() {
    	
    	signUpCheck.id = false;
    	
    	// 영어 대/소문자 + 숫자 총 6~12글자
    	var regExp = /^[a-zA-Z\d]{6,12}$/;
    	
    	if(!regExp.test($id.val())){
    		
    		
    	}else{
    		
    	}
    	
    });
    
    
	function validate(){
		
		// 모든 입력 값이 유효할 경우
		// 커맨드 객체를 이용하여 파라미터를 한번에 받을 수 있도록 하기 위해
		// 입력된 전화번호, 주소를 하나의 문자열로 합쳐 form 태그 끝에 hidden 타입으로 추가하는 작업
		
		$memberPhone = $("<input>", {type : "hidden", name: "memberPhone",
						value : $("#phone1").val()+"-"+$("#phone2").val() + "-" +
								$("#phone3").val()});
		
		$memberAddress = $("<input>", {type : "hidden", name: "memberAddress",
			value : $("#post").val()+","+$("#address1").val() + "," +
					$("#address2").val()});
		
		// append : form 태그의 자식 중 마지막에 추가함
		$("form[name='signUpForm']").append($memberPhone, $memberAddress);
	}
    </script>
    <!-- JS -->
    <!--  
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>-->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</body>
</html>