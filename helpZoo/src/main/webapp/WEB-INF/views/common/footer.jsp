<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>
	<link rel="stylesheet" href="${contextPath}/resources/assets/css/style.css">
	
	<style>
	/* #footer{
		background : #fff;
		color : #7fcdcd;
	} */
	</style>
</head>
<body>
<!-- ======= Footer ======= -->
  <footer id="footer">

    

    <div class="container footer-bottom clearfix">
      <div class="information">
	      <h3><strong>도와ZOO(주)</strong></h3>
	            <span>서울특별시 중구 남대문로 120</span><br>
	            <span>Tel : 1661-8282 /</span>
	            <span>사업자 번호 : 123-45-56789</span>
	      </div>
	      <br>
      <div class="copyright">
        &copy; Copyright <strong><span>helpzoo</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/knight-free-bootstrap-theme/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->
</body>
</html>