<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Inner Page - Knight Bootstrap Template</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">

  
  
  
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  
  <c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>
  
  <!-- Favicons -->
  
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
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
</head>

<body>

	<!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container">

      <!-- The main logo is shown in mobile version only. The centered nav-logo in nav menu is displayed in desktop view  -->
      <div class="logo d-block d-lg-none">
        <a href="index.html"><img src="/helpzoo/resources/images/도와주100.png" alt="" class="img-fluid"></a>
      </div>

      <nav class="nav-menu d-none d-lg-block">
        <ul class="nav-inner">
          <li><a href="${contextPath}/member/funding">펀딩하기</a></li>
          <li><a href="${contextPath}/member/donation">기부하기</a></li>
           <li class="drop-down"><a href="${contextPath}/board/review">후기게시판</a>
            <ul>
              <li><a href="${contextPath}/board/fundingReview">펀딩 후기게시판</a></li>
              <li><a href="${contextPath}/board/donationReview">기부 후기게시판</a></li>
            </ul>
          </li>

          <li class="nav-logo active"><a href="main.jsp"><img src="/helpzoo/resources/images/도와주100.png" alt="" class="img-fluid" id="logo"></a></li>

		  <li class="drop-down"><a href="${contextPath}/notice">공지</a>
            <ul>
              <li><a href="${contextPath}/notice">공지사항</a></li>
              <li><a href="${contextPath}/event">이벤트</a></li>
            </ul>
          </li>
          <li class="drop-down"><a href="${contextPath}/service/faq">고객센터</a>
            <ul>
              <li><a href="${contextPath}/service/faq">FAQ</a></li>
              <li><a href="${contextPath}/service/qna">Q&A</a></li>
            </ul>
          </li>
          <li><a href="${contextPath}/subscribe">구독하기</a></li>
          <li><a href=" ${contextPath}/member/mypage">마이페이지</a></li>

        </ul>
      </nav><!-- .nav-menu -->
		
    </div>
		<span><a href="${contextPath}/member/login" class="btn-get-started scrollto">로그인</a></span>
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