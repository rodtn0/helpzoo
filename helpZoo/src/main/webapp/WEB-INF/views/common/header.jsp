<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>도와ZOO</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">
  
     <!-- core tag 추가 -->
    <!-- c:set은 변수 선언 -->
    <!-- context Path를 프로젝트 전체에서 간단히 사용할 수 있도록 변수 선언 -->
  <c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>
  
  <!-- Favicons -->
  
  
  <link href="${contextPath}/resources/assets/img/favicon.png" rel="icon">
  <link href="${contextPath}/resources/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${contextPath}/resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="${contextPath}/resources/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${contextPath}/resources/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Knight - v2.1.0
  * Template URL: https://bootstrapmade.com/knight-free-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  
   <!-- CSS -->
   <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
   
      <!-- sweetalert : alert창을 꾸밀 수 있게 해주는 라이브러리 https://sweetalert.js.org/ -->
     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<style>
	* {
 	font-family: "LotteMartDream";
	}
</style>

<body>
	<!-- sweetalert -->
		<c:if test="${!empty msg}">
		<script>
			swal({
				title : "${msg}",
				icon : "${status}",
				text : "${text}"});
		</script>
		<c:remove var="msg"/>
	</c:if>
	
	<!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container">

      <!-- The main logo is shown in mobile version only. The centered nav-logo in nav menu is displayed in desktop view  -->
      <div class="logo d-block d-lg-none">
        <a href="index.html"><img src="/helpzoo/resources/images/도와주100.png" alt="" class="img-fluid"></a>
      </div>

      <nav class="nav-menu d-none d-lg-block">
        <ul class="nav-inner">
          <li><a href="${contextPath}/funding/fundingMain">펀딩하기</a></li>
          <li><a href="${contextPath}/donation/donationMain">기부하기</a></li>
           <li class="drop-down"><a href="${contextPath}/board/review">후기게시판</a>
            <ul>
              <li><a href="${contextPath}/board/review/1">펀딩 후기게시판</a></li>
              <li><a href="${contextPath}/board/review/2">기부 후기게시판</a></li>
            </ul>
          </li>

          <li class="nav-logo active"><a href="${contextPath}"><img src="/helpzoo/resources/images/도와주100.png" alt="" class="img-fluid" id="logo"></a></li>

		  <li class="drop-down"><a href="${contextPath}/notice">공지</a>
            <ul>
				<li><a href="${contextPath}/notice/noticeList">공지사항</a></li>
				<li><a href="${contextPath}/event/eventList">이벤트</a></li>
            </ul>
          </li>
          <li class="drop-down"><a href="${contextPath}/faq/faqList">고객센터</a>
            <ul>
              <li><a href="${contextPath}/faq/faqList">FAQ</a></li>
              <li><a href="${contextPath}/qna/qnaList">Q&A</a></li>
            </ul>
          </li>
          <li><a href="${contextPath}/subscribe">구독하기</a></li>
          	<li><a href=" ${contextPath}/mypage/updateMember">마이페이지</a></li>
        </ul>
      </nav><!-- .nav-menu -->
    </div>
      	<c:choose>
      		<c:when test="${ empty sessionScope.loginMember}">
           <a class="nav-link" href="${contextPath}/member/login">로그인</a>
           </c:when>
           <c:otherwise>
            <a class="nav-link" href="${contextPath}/mypage/updateMember">${loginMember.memberName}</a>
             <a class="nav-link" href="${contextPath}/member/logout">Logout</a>
           </c:otherwise>
      	</c:choose>	
  </header><!-- End Header -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="${contextPath}/resources/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${contextPath}/resources/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="${contextPath}/resources/assets/vendor/php-email-form/validate.js"></script>
  <script src="${contextPath}/resources/assets/vendor/jquery-sticky/jquery.sticky.js"></script>
  <script src="${contextPath}/resources/assets/vendor/venobox/venobox.min.js"></script>
  <script src="${contextPath}/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${contextPath}/resources/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="${contextPath}/resources/assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="${contextPath}/resources/assets/js/main.js"></script>

</body>

</html>