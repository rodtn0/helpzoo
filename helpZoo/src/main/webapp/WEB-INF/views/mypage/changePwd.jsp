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
<title>My page - 비밀번호 변경</title>
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
	#postcodify_search_button{
	background-color:#7fcdcd;
	border:none;
	}
	.pass_show{position: relative} 
	
	.pass_show .ptxt { 
	
	position: absolute; 
	
	top: 50%; 
	
	right: 10px; 
	
	z-index: 1; 
	
	color: #f36c01; 
	
	margin-top: -10px; 
	
	cursor: pointer; 
	
	transition: .3s ease all; 
	
	} 
	
	.pass_show .ptxt:hover{color: #333333;} 
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
	          <ul class="navbar-nav mx-auto mt-2 mt-lg-0">
	            <li class="nav-item">
	              <a class="nav-link" href="${contextPath}/mypage/updateMember">회원정보 수정</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="${contextPath}/mypage/changePwd">비밀번호 변경</a>
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
	            <a class="nav-link" href="${contextPath}/mypage/secession">회원탈퇴</a>
	          </li>
	          </ul>
	        </div>
	      </nav>
			</div>
			</div>
			<div class="row">
			<div class="col-md-12">
			<br><h1 id="mainTxt">비밀번호 변경</h1>
			</div>
			</div>
			<div class="row">
			<div class="bg-white rounded shadow-sm container p-3">
			<div class="row mb-3 form-row">
			<form method="POST" action="updatePwd" onsubmit="return validate();" class="form-horizontal" role="form">
			<div class="row mb-3 form-row">
				<div class="col-md-3">
					<h6>아이디</h6>
				</div>
				<div class="col-md-6">
					<h5 id="id">${loginMember.memberId}</h5>
				</div>
			</div>

			<div class="row mb-3 form-row">
			<div class="col-md-3">
		        현재 비밀번호
		    </div>
		    <div class="col-md-6 form-group pass_show"> 
                <input type="password" class="form-control" name="memberPwd" placeholder="현재 비밀번호를 입력해주세요."> 
            </div>
			<div class="col-md-3">
		        새로운 비밀번호
		    </div>
            <div class="col-md-6 form-group pass_show"> 
                <input type="password"class="form-control" id="newPwd1" placeholder="변경할 비밀번호를 입력해주세요."> 
            </div> 
		       <label>Confirm Password</label>
            <div class="form-group pass_show"> 
                <input type="password" class="form-control" id="newPwd2" placeholder="비밀번호를 한번 더 입력해주세요."> 
            </div> 
		            
				</div>  
			</div>
						<div class="row mb-3 form-row">
						<hr>
							- 6~12자의 영어 대/소문자, 숫자를 사용할 수 있습니다.<br>
							- 생년월일, 전화번호 등 개인정보와 관련된 숫자, 연속된 숫자, 연속된 키보드배열과 같이 쉬운 비밀번호는
							타인이 쉽게 알아낼 수 있으니 사용을 자제해주세요.<br>
							- 이전에 사용했던 비밀번호나 타 사이트와 다른 비밀번호를 사용하고 비밀번호는 주기적으로 변경해주세요.
						</div>
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" type="submit">변경하기</button>
					</form>
				</div>
			<!-- 여기까지 -->
			</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<jsp:include page="/WEB-INF/views/common/footer.jsp" />
				</div>
			</div>
			<script>
			  
			$(document).ready(function(){
			$('.pass_show').append('<span class="ptxt">Show</span>');  
			
			});
			$(document).on('click','.pass_show .ptxt', function(){ 

			$(this).text($(this).text() == "Show" ? "Hide" : "Show"); 

			$(this).prev().attr('type', function(index, attr){return attr == 'password' ? 'text' : 'password'; }); 

			});  
			
			function validate() {
				// 비밀번호  유효성 검사
				//영어 대,소문자 + 숫자, 총 6~12글자
				var regExp = /^[A-Za-z0-9]{6,12}$/;
				if(!regExp.test($("#newPwd1").val())){ 
					swal({
						  icon: "error",
						  title : "유효하지 않은 비밀번호 입니다."
						});
					$("#newPwd1").focus();
					
					return false;
	            }
				
				if($("#newPwd1").val() != $("#newPwd2").val()){
					swal({
						  icon: "error",
						  title : "새 비밀번호가 일치하지 않습니다."
						});
					$("#newPwd2").focus();
					
					return false;
				}

			}
		    </script>
</body>
</html>