<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i" rel="stylesheet">
<title>My page</title>
<style>
	.social-part .fa{
	    padding-right:20px;
	}
	
	ul li a{
	    margin-right: 20px;
	}
	
	#mainTxt{
	font-family: "Recipekorea";
	text-align:center;
	}
	#submitBtn{
	background-color:#7fcdcd;
	border:none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
$('.navbar-light .dmenu').hover(function () {
        $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
    }, function () {
        $(this).find('.sm-menu').first().stop(true, true).slideUp(105)
    });
});
</script>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
		<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
				<jsp:include page="/WEB-INF/views/common/header.jsp" />
				</div>
			</div>
		</div>
		</div>
			<div class="row">
		<div class="col-md-12">
		  <nav class="navbar navbar-expand-sm navbar-light bg-light">
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
	          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	            <li class="nav-item">
	              <a class="nav-link" href="${contextPath}/member/mypage">회원정보 수정</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">비밀번호 변경</a>
	            </li>
	            <li class="nav-item dropdown dmenu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	              	펀딩 내역
	            </a>
	            <div class="dropdown-menu sm-menu">
	              <a class="dropdown-item" href="#">내가 주최한</a>
	              <a class="dropdown-item" href="#">내가 참여한</a>
	            </div>
	          </li>
	            <li class="nav-item dropdown dmenu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	              	기부 내역
	            </a>
	            <div class="dropdown-menu sm-menu">
	              <a class="dropdown-item" href="#">내가 주최한</a>
	              <a class="dropdown-item" href="#">내가 참여한</a>
	            </div>
	          </li>
	            <li class="nav-item dropdown dmenu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	              	좋아한
	            </a>
	            <div class="dropdown-menu sm-menu">
	              <a class="dropdown-item" href="#">펀딩</a>
	              <a class="dropdown-item" href="#">기부</a>
	            </div>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">회원탈퇴</a>
	          </li>
	          </ul>
	        </div>
	      </nav>
				</div>
			</div>
			<div class="row">
			<div class="col-md-12">
			<br><h1 id="mainTxt">${loginMember.memberName}님의 회원 정보 수정</h1>
			<div class="bg-white rounded shadow-sm container p-3">
					<form method="POST" action="updateAction" name="updateForm" onsubmit="return validate();" class="form-horizontal" role="form">
			<hr class="mb-4">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
							<!-- loginMember가 session 객체에 존재하면 id를 꺼내와라 -->
								<h5 id="id">${loginMember.memberId}</h5>
							</div>
						</div>
	
						<!-- 이름 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>이름</h6>
							</div>
							<div class="col-md-6">
								<h5 id="name">${loginMember.memberName}</h5>
							</div>
						</div>
	
						<!-- 전화번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="phone1">연락처</label>
							</div>
							
							<!-- fn 태그를 이용하여 split을 진행 -->
							<!-- session에서 memberPhone을 꺼내와서 문자열을 쪼개서 배열로 만들어 배열로 지정-->
							<!-- 010  /  1234  / 5678 -->
							<!-- phone[0] phone[1]  phone[2]-->
							<c:set var="phone" value="${fn:split(loginMember.memberPhone, '-') }"/>
							
							<!-- 전화번호1 -->
							<div class="col-md-3">
								<select class="custom-select" id="phone1" name="phone1">
									<option <c:if test="${phone[0] == '010'}">selected</c:if> >010</option>
									<option<c:if test="${phone[0] == '011'}">selected</c:if> >011</option>
									<option<c:if test="${phone[0] == '016'}">selected</c:if> >016</option>
									<option<c:if test="${phone[0] == '017'}">selected</c:if> >017</option>
									<option<c:if test="${phone[0] == '019'}">selected</c:if> >019</option>
								</select>
							</div>
							<!-- 전화번호2 -->
							<div class="col-md-3">
								<input type="number" class="form-control phone" id="phone2" name="phone2" maxlength="4" value="${phone[1] }">
							</div>
	
							<!-- 전화번호3 -->
							<div class="col-md-3">
								<input type="number" class="form-control phone" id="phone3" name="phone3" maxlength="4" value="${phone[2] }">
							</div>
						</div>
	
						<!-- 이메일 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="memberEmail">Email</label>
							</div>
							<div class="col-md-6">
								<input type="email" class="form-control" id="email" name="memberEmail" value="${loginMember.memberEmail}" disabled>
							</div>
						</div>
						<br>
	
					<!-- 주소 -->
					<!-- 오픈소스 도로명 주소 API -->
					<!-- https://www.poesis.org/postcodify/ -->
					<div class="row mb-3 form-row">
					
						<c:set var="address" value="${fn:split(loginMember.memberAddress, ',')}"/>
					
						<div class="col-md-3">
							<label for="postcodify_search_button">우편번호</label>
						</div>
						<div class="col-md-3">
							<input type="text" name="post" id="post" class="form-control postcodify_postcode5" value="${address[0]}">
						</div>
						<div class="col-md-3">
							<button type="button" class="btn btn-primary" id="postcodify_search_button" id="searchBtn">검색</button>
						</div>
					</div>
		
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="address1">도로명 주소</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control postcodify_address" name="address1" id="address1"  value="${address[1]}">
						</div>
					</div>
		
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="address2">상세주소</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control postcodify_details" name="address2" id="address2"  value="${address[2]}">
						</div>
					</div>
						<!-- jQuery와 postcodify 를 로딩한다. -->
						<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
						<script>
							// 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
							$(function() {
								$("#postcodify_search_button").postcodifyPopUp();
							});
						</script>
						<!-- 추가정보  1-->
                        <div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="petType">애완동물 종류</label>
						</div>
						<div class="col-md-9">
						<select name="memberPetType" id="pet-select">
									<option>--애완동물 종류를 선택해주세요--</option>
									<option <c:if test="${loginMember.memberPetType == 'dog'}">selected</c:if>>강아지</option>
									<option <c:if test="${loginMember.memberPetType == 'cat'}">selected</c:if>>고양이</option>
									<option <c:if test="${loginMember.memberPetType == 'hamster'}">selected</c:if>>햄스터</option>
									<option <c:if test="${loginMember.memberPetType == 'hedgehog'}">selected</c:if>>고슴도치</option>
									<option <c:if test="${loginMember.memberPetType == 'rabbit'}">selected</c:if>>토끼</option>
									<option <c:if test="${loginMember.memberPetType == 'goldfish'}">selected</c:if>>금붕어</option>
						</select>
						</div>
					</div>
					<!-- 추가정보 2 -->
                    <div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="petName">애완동물 이름</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control" name="memberPetName" id="petName" value="${loginMember.memberPetName}">
						</div>
					</div>
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" type="submit" id="submitBtn">수정</button><br>
					</form>
				</div>
			</div>
		</div>
			<div class="row">
				<div class="col-md-12">
				<jsp:include page="/WEB-INF/views/common/footer.jsp" />
				</div>
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
</body>
</html>