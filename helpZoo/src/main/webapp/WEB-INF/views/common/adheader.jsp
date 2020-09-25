<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Tables</title>

  <c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>

<!--  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->
  <!-- Custom fonts for this template -->
  <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  
	<%-- <script src="${contextPath}/resources/assets/vendor/jquery/jquery.min.js"></script> --%>
 	<!-- sweetalert : alert창을 꾸밀 수 있게 해주는 라이브러리 https://sweetalert.js.org/ -->
 	
 	
 	<!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->
 	<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
 	<script src="${contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
 	<script src="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  
  <!-- 달력 -->
	<link href='${contextPath}/resources/packages/core/main.css' rel='stylesheet' />
	<link href='${contextPath}/resources/packages/daygrid/main.css' rel='stylesheet' />
	<link href='${contextPath}/resources/packages/list/main.css' rel='stylesheet' />
	<script src='${contextPath}/resources/packages/core/main.js'></script>
	<script src='${contextPath}/resources/packages/interaction/main.js'></script>
	<script src='${contextPath}/resources/packages/daygrid/main.js'></script>
	<script src='${contextPath}/resources/packages/list/main.js'></script>
	<script src='${contextPath}/resources/packages/google-calendar/main.js'></script>
  <!-- 달력 여기까지 -->
  <style>
  .bg-gradient-primary{
	  background-color: #1fcdcd !important;
	  background-image: none !important;
  }
  
  .bannerImg{
  	float: left;
  }
  
  </style>
</head>

<body id="page-top">
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
	
  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath}">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-cat"></i><i class="fas fa-dog"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Help<sup> ZOO</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Interface
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Funding & Donation</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Funding</h6>
            <a class="collapse-item" href="${contextPath}/admin/funding/main"> <i class="fas fa-fw fa-table"></i> Schedule</a>
            <a class="collapse-item" href="${contextPath}/admin/funding/chart"><i class="fas fa-fw fa-chart-area"></i> Chart</a>
            <h6 class="collapse-header">Donation</h6>
            <a class="collapse-item" href="${contextPath}/admin/donation/main"> <i class="fas fa-fw fa-table"></i> Schedule</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-users"></i>
          <span>community</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="${contextPath}/admin/board/aFundingList">펀딩후기</a>
            <a class="collapse-item" href="${contextPath}/admin/board/aDonationList">기부후기</a>
            <a class="collapse-item" href="${contextPath}/admin/faq/faqList">FAQ</a>
            <a class="collapse-item" href="${contextPath}/admin/qna/qnaList">Q&A</a>
            <a class="collapse-item" href="${contextPath}/admin/board/aNoticeList">공지사항</a>
            <a class="collapse-item" href="${contextPath}/admin/board/aEventList">이벤트</a>
            <a class="collapse-item" href="${contextPath}/subscribe/mailing">구독메일 보내기</a>
            <a class="collapse-item" href="${contextPath}/admin/member/aMemberList">멤버관리</a>
          </div>
        </div>
      </li>



      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
			<img class="bannerImg" alt="" src="/helpzoo/resources/images/관리자.png"> 관리자 : ${loginMember.memberId}님 환영합니다.
        </nav>
        <!-- End of Topbar -->