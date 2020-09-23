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
	#btn{
	background-color: #7fcdcd;
	color:white;
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
				  <a class="dropdown-item" href="${contextPath}/mypage/fundingList/1">내가 주최한</a>
	              <a class="dropdown-item" href="${contextPath}/mypage/partiFundingList/1">내가 참여한</a>
	            </div>
	          </li>
	            <li class="nav-item dropdown dmenu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	              	기부 내역
	            </a>
	            <div class="dropdown-menu sm-menu">
	              <a class="dropdown-item" href="${contextPath}/mypage/donationList/1">내가 주최한</a>
	              <a class="dropdown-item" href="${contextPath}/mypage/donationListPt/1">내가 참여한</a>
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
			<div class="col-md-6 mx-auto">
			<div class="col-md-12">
			<br><h1 id="mainTxt">${loginMember.memberName}님의 회원 탈퇴</h1>
			<!-- 여기부터 회원 탈퇴 영역 삽입 -->
			<div class="bg-white rounded shadow-sm container p-3">
					<form method="POST" action="deleteMember" onsubmit="return validate();" 
						class="form-horizontal" role="form">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
								<h5 id="id">${loginMember.memberId}</h5>
							</div>
						</div>

						<!-- 비밀번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>비밀번호</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="currentPwd"
									name="memberPwd">
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="form-group">
									<div class="col-xs-12">
						<textarea class="form-control" readonly rows="10" cols="100">
제 11 조 (회원 탈퇴 및 자격 상실)

① 회원은 회사에 언제든지 회원 탈퇴를 요청할 수 있으며 회사는 요청을 받은 즉시 해당 회원의 회원 탈퇴를 위한 절차를 밟아 개인정보취급방침에 따라 회원 등록을 말소합니다.

② 회사의 모든 서비스에서 이용중인 서비스의 기간이 남아있는 회원이 탈퇴 요청하였을 경우 회원탈퇴로 인한 서비스의 중지 또는 피해는 회원탈퇴 이용자에게 있습니다.

③ 회원이 서비스 이용에 있어서 본 양관 제 제 10조 내용을 위반하거나, 다음 각 호의 사유에 해당하는 경우 회사는 직권으로 회원자격 상실 및 회원탈퇴의 조치를 할 수 있습니다.

1. 다른 사람의 명의를 사용하여 가입 신청한 경우

2. 신청 시 필수 작성 사항을 허위로 기재한 경우

3. 관계법령의 위반을 목적으로 신청하거나 그러한 행위를 하는 경우

4. 사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청하거나 그러한 행위를 하는 경우

5. 다른 사람의 회사 서비스 이용을 방해하거나 그 정보를 도용하는 등 전자거래질서를 위협하는 경우

6. 관계 법령 위배와 본 약관이 금지하는 행위를 하는 회원 경우

④ 회사가 직권으로 화원탈퇴 처리를 하고자 하는 경우에는 말소 전에 회원에게 소명의 기회를 부여합니다.
					</textarea>
					</div>
					<div class="checkbox pull-right">
						<div class="custom-checkbox">
							<div class="form-check">
								<input type="checkbox" name="agree" id="agree"
									class="form-check-input custom-control-input"> <br>
								<label class="form-check-label custom-control-label"
									for="agree">위 약관에 동의합니다.</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 mx-auto">
						<hr class="mb-4">
						<button class="btn btn-priamry btn-lg btn-block" id="btn" type="submit">탈퇴</button><br>
				</div>	
					</form>
				</div>
			<!-- 여기까지 삽입 -->
			</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<jsp:include page="/WEB-INF/views/common/footer.jsp" />
				</div>
			</div>
		<script>
			// submit 동작
			function validate() {
	
				if(!$("#agree").prop("checked")){
					swal({
						  icon: "error",
						  title : "탈퇴 약관에 동의해주세요."
						});
					return false;
				}else{
					return confirm("정말로 탈퇴하시겠습니까?");
				}
				
			}
		</script>
</body>
</html>