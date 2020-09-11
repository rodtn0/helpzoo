<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>도와주(HelpZoo)</title>
	
	<style>
		#main{
			height : 800px;
		}
	</style>
</head>
<body style="overflow-x:hidden; overflow-y:auto;">
  <!-- ======= Hero Section ======= -->
  <section id="hero">
  	<img src="/helpzoo/resources/images/helpzoomainImg.jpg" alt="" width="100%">
    <div class="hero-container">
      <a href="index.html" class="hero-logo" data-aos="zoom-in"><!-- <img src="/helpzoo/resources/images/도와주400.png" alt=""> --></a>
      <h1 data-aos="zoom-in">Welcome To HelpZoo</h1>
      <h2 data-aos="fade-up">Crowdfunding and donations for animals</h2>
      <a data-aos="fade-up" href="#logo" class="btn-get-started scrollto">Get Started</a>
    </div>
  </section><!-- End Hero -->
  
	<jsp:include page="WEB-INF/views/common/header.jsp"/>
	<div class="row justify-content-md-center">
		<h1> 도와주(ZOO)</h1>
	</div>
	
	<jsp:include page="WEB-INF/views/common/footer.jsp"/>
</body>
</html>
