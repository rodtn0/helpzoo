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
		
		.rounded{
			width : 200px;
			height : 200px;
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
	
	
	<!-- 메인 구조 시작 -->

<div class="container">	
	
	<div class="container-fluid">
	
	<!-- 펀딩 영역 -->
	<section id="about" class="about">
	
	<div class="row">
		<div class="col-md-12">
			<h1  data-aos="fade-up">
				도와ZOO 펀딩
			</h1>
			
			<br>
			<div class="row">
				<div class="col-md-8" data-aos="fade-right">
					<h4>
						펀딩 프로젝트, 이런 것도 있어요!
					</h4>
					<br>
					<div class="row">
						<div class="col-md-4 funding">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded">
							<h5 class="mt-3">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-4 funding">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded">
							<h5 class="mt-3">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-4 funding">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded">
							<h5 class="mt-3">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
				</div>
				<div class="col-md-4" data-aos="fade-left">
					<h4>
						실시간 펀딩 랭킹
					</h4>
					<br>
					<table class="table">
						<thead>
							<tr>
								<th>
									#
								</th>
								<th>
									Product
								</th>
								<th>
									Payment Taken
								</th>
								<th>
									Status
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Default
								</td>
							</tr>
							<tr class="table-active">
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Approved
								</td>
							</tr>
							<tr class="table-success">
								<td>
									2
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									02/04/2012
								</td>
								<td>
									Declined
								</td>
							</tr>
							<tr class="table-warning">
								<td>
									3
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									03/04/2012
								</td>
								<td>
									Pending
								</td>
							</tr>
							<tr class="table-danger">
								<td>
									4
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									04/04/2012
								</td>
								<td>
									Call in to confirm
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
			</div>
		</div>
	</div>
	</section>
	
	<!-- 기부 영역 -->
	<section id="services" class="services">
	<div class="row">
		<div class="col-md-12">
			<h1 data-aos="fade-up" class="float-right">
				도와ZOO 기부
			</h1>
			<br>
			<div class="row" style="clear:both;">
				<div class="col-md-4" data-aos="fade-right">
					<h4>
						실시간 기부 랭킹
					</h4>
					<br>
					<table class="table">
						<thead>
							<tr>
								<th>
									#
								</th>
								<th>
									Product
								</th>
								<th>
									Payment Taken
								</th>
								<th>
									Status
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Default
								</td>
							</tr>
							<tr class="table-active">
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Approved
								</td>
							</tr>
							<tr class="table-success">
								<td>
									2
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									02/04/2012
								</td>
								<td>
									Declined
								</td>
							</tr>
							<tr class="table-warning">
								<td>
									3
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									03/04/2012
								</td>
								<td>
									Pending
								</td>
							</tr>
							<tr class="table-danger">
								<td>
									4
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									04/04/2012
								</td>
								<td>
									Call in to confirm
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-8" data-aos="fade-left">
					<h4>
						기부 프로젝트, 이런 것도 있어요!
					</h4>
					<br>
					<div class="row">
						<div class="col-md-4">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded">
							<h5 class="mt-3">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-4">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded">
							<h5 class="mt-3">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-4">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="rounded">
							<h5 class="mt-3">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	</section>
	
	<!-- 크라우드펀딩 트렌드 -->
	<section id="featured" class="featured">
	<div class="row">
		<div class="col-md-12">
			<h1 data-aos="fade-up">
				크라우드 펀딩 트렌드
			</h1>
			<br>
			<div class="row">
				<div class="col-md-4" data-aos="fade-up">
					<h4>
						#급상승 프로젝트
					</h4>
					<br>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" >
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
					<div class="row" >
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
				</div>
				<div class="col-md-4" data-aos="fade-up">
					<h4>
						오늘 가장 많이 #좋아한 프로젝트
					</h4>
					<br>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
				</div>
				<div class="col-md-4" data-aos="fade-left">
					<h3>
						Event!
					</h3>
					<br>
					<div class="card">
						<h5 class="card-header">
							Card title
						</h5>
						<div class="card-body">
							<p class="card-text">
								Card content
							</p>
						</div>
						<div class="card-footer">
							Card footer
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	
	<!-- 기부 트렌드 -->
	 <section>
	<div class="row">
		<div class="col-md-12">
			<h1 data-aos="fade-up" class="float-right mb-4">
				기부 트렌드
			</h1>
			<br>
			<div class="row" style="clear:both;">
				<div class="col-md-4" data-aos="fade-right">
					<h4>
						Event!
					</h4>
					<br>
					<div class="card">
						<h5 class="card-header">
							Card title
						</h5>
						<div class="card-body">
							<p class="card-text">
								Card content
							</p>
						</div>
						<div class="card-footer">
							Card footer
						</div>
					</div>
				</div>
				<div class="col-md-4" data-aos="fade-up">
					<h4>
						#급상승 프로젝트
					</h4>
					<br>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
				</div>
				<div class="col-md-4" data-aos="fade-up">
					<h4>
						오늘 가장 많이 #좋아한 프로젝트
					</h4>
					<br>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
						<div class="col-md-6">
							<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg">
							<h5 class="mt-2">
								h3. Lorem ipsum dolor sit amet.
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	
</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
	
	
	
	
	
	<jsp:include page="WEB-INF/views/common/footer.jsp"/>
</body>
</html>
