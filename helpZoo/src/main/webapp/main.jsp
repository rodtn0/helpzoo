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
<body>
  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <a href="index.html" class="hero-logo" data-aos="zoom-in"><img src="assets/img/hero-logo.png" alt=""></a>
      <h1 data-aos="zoom-in">Welcome To Knight Studios</h1>
      <h2 data-aos="fade-up">We are team of talanted designers making websites with Bootstrap</h2>
      <a data-aos="fade-up" href="#logo" class="btn-get-started scrollto">Get Started</a>
    </div>
  </section><!-- End Hero -->
  
	<jsp:include page="WEB-INF/views/common/header.jsp"/>
	<div id="main">
	
		<h1>
			Hello world!?s
		</h1>
	
		<P>  The time on the server is ${serverTime}. </P>
	
	</div>
	
	<jsp:include page="WEB-INF/views/common/footer.jsp"/>
</body>
</html>
