<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i" rel="stylesheet">
<title>My page - 기부 내역(내가 주최한)</title>
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
   
   .card{ height: 500px; }
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
<body>
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
         <div class="row">
            <div class="col-md-12">
      <!-- 바디 영역 -->
		<div class="album bg-white text-muted">
            <div class="container">
               <h1 id="mainTxt">내가 주최한(기부)</h1><br>
            <c:choose>
               <c:when test="${empty doListByme}">
 				<p class="text-center" style="font-size:30px;">내가 주최한 기부가 없습니다. 기부를 주최해보세요!</p>
               <!-- <a href="${contextPath}/funding/fundingOpen">펀딩 주최하기</a> -->
                </c:when>
           <c:otherwise>
              <c:forEach var="doList" items="${doListByme}">
                <div class="card text-black">
                  <p class="card-head mx-auto">${doList.dBoardNo}번째 프로젝트</p>
                 <c:choose>
                    <c:when test="${!empty doThList }">
                      <c:set var = "src" value="/helpzoo/resources/images/not_thumbnail.png"/>
                       
                       <c:forEach items="${doThList}" var="th">
                          <%-- <c:set var = "src" value="${contextPath}${th.filePath}/${th.fileChangeName}"/> --%>
                          	<c:if test="${th.dParentBoardNo == doList.dBoardNo}">
                             	<c:set var = "src" value="${contextPath}${th.dfilePath}/${th.dfileChangeName}"/>
                            </c:if>
                       </c:forEach>
                       
                       <img style="height: 361px; width: 100%; display: block;" alt="" src="${src}" data-holder-rendered="true">
                    </c:when>
                    <c:otherwise>
                       <img style="height: 361px; width: 100%; display: block;" alt="" src="/helpzoo/resources/images/not_thumbnail.png" data-holder-rendered="true">
                    </c:otherwise>
                    
                 </c:choose>
                 
                  <p class="card-text mx-auto">${doList.dBoardTitle}</p>
                </div>
                </c:forEach>
             </c:otherwise>
             </c:choose>
            </div>
         </div>
            </div>
         </div>
                        <!--  ------------------------------ 페이지네이션 ----------------------------- -->
            <div class="row justify-content-center">
               <ul class="pagination">
                        <!-- 11페이지부터 -->      <!-- 기본값 : 10 -->
               <c:if test="${dInfo.currentPage > dInfo.pagingBarSize }">
                   <li>
                      <!-- 맨 처음으로(<<) -->         <!-- 1번 타입의 게시판 타입의 1페이지로 돌아가라 -->
                       <a class="page-link text-dark" href="${dInfo.boardType}?cp=1">&lt;&lt;</a>
                   </li>
                   <li>
                      <!-- 이전으로(<) -->
                      <!-- prev 생성식 : (현재페이지 -1) / 페이징바 사이즈(10) * 10-->
                      <!-- fmt 태그를 이용한 소수점 제거 -->
                      <fmt:parseNumber var="operand1"
                      value="${(dInfo.currentPage-1)/dInfo.pagingBarSize}" integerOnly="true"/>
                      <c:set var="prev" value="${operand1 * 10 }"/>
                      <!-- 현재 페이지가 15일때 15-1 / 10 -->      
                      <!-- 14/100  -->
                      <!-- 1.4 -->
                      <!-- 1 -->
                      <!-- 10 -->
                         <a class="page-link text-dark" href="${dInfo.boardType}?cp=${prev}">&lt;</a>
                   </li>
                </c:if>
                      <!-- 10개의 페이지 목록 -->
                      <c:forEach var="p" begin="${dInfo.startPage}" end="${dInfo.endPage}">
                         
                         <c:choose>
                            <c:when test="${p==dInfo.currentPage}">
                         <li><a class="page-link text-warning">${p}</a></li>
                            </c:when>
                            
                            <c:otherwise>
                         <li>
                            <a class="page-link text-dark" href="${dInfo.boardType}?cp=${p}">${p}</a>
                         </li>
                            </c:otherwise>
                         </c:choose>
                      </c:forEach>
                <!-- 다음 페이지로(>) -->
                <!-- next 생성식 : (현재페이지 + 9)/10 * 10 + 1 -->
                <c:if test="${dInfo.maxPage > dInfo.endPage}">
                   <!-- 다음 페이지 (>) -->
                   <li>
                      <fmt:parseNumber var="operand2"
                      value="${(dInfo.currentPage + dInfo.pagingBarSize-1) / dInfo.pagingBarSize}"
                      integerOnly="true"/>
                      <c:set var="next" value="${operand2 *dInfo.pagingBarSize +1 }"/>
                  <a class="page-link text-dark" href="${dInfo.boardType}?cp=${next}">&gt;</a>
                   </li>
                   
                   <!-- 맨 끝으로(>>) -->
                   <li>
                       <a class="page-link text-dark" href="${dInfo.boardType}?cp=${dInfo.maxPage}">&gt;&gt;</a>
                   </li>
                </c:if>
            </ul>
        </div>   
         <!-- 푸터 영역 -->
         <div class="row">
            <div class="col-md-12">
            <jsp:include page="/WEB-INF/views/common/footer.jsp" />
            </div>
         </div>
</body>
</html>