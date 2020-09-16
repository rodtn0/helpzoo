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
<title>My page - 펀딩 내역(내가 주최한)</title>
<link rel="stylesheet" href="${contextPath}/resources/css/funding.css">
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
	color:#555555;
	}
	#submitBtn{
	background-color:#7fcdcd;
	border:none;
	}
	#postcodify_search_button{
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
	              <a class="dropdown-item" href="#">내가 참여한</a>
	            </div>
	          </li>
	            <li class="nav-item dropdown dmenu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	              	기부 내역
	            </a>
	            <div class="dropdown-menu sm-menu">
	              <a class="dropdown-item" href="${contextPath}/mypage/fundingList/1">내가 주최한</a>
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
				<!--  <h1 id="mainTxt">내가 참여한(펀딩)</h1><br>-->
				<!-- 여기부터 게시판 리스트 삽입 -->
				</div>
			</div>
		<div class="album text-muted">
     	 <div class="container">
     	 	<h1 id="mainTxt">내가 주최한(펀딩)</h1><br>
        <div class="row">
          <div class="card">
           <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>
          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
             <p class="card-text"></p>
          </div>
          <div class="card">
           <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>

          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>
          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>
          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
           <p class="card-text"></p>
          </div>

          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>
          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>
          <div class="card">
            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 361px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
            <p class="card-text"></p>
          </div>
        </div>
		
      </div>
    </div>
			<div class="row">
				<div class="col-md-12">
				<jsp:include page="/WEB-INF/views/common/footer.jsp" />
				</div>
			</div>
</body>
</html>