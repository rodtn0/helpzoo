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
			<h1  data-aos="fade-up" style="font-family:Recipekorea;">
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
							<tr class="table-success">
								<th>
									No.
								</th>
								<th>
									프로젝트명
								</th>
								<th>
									만료일
								</th>
								<th>
									조회수
								</th>
								
							</tr>
						</thead>
						<tbody id="funding-rank">
							
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
			<h1 data-aos="fade-up" class="float-right" style="font-family:Recipekorea;">
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
							<tr class="table-danger">
								<th>
									No.
								</th>
								<th>
									프로젝트명
								</th>
								<th>
									만료일
								</th>
								<th>
									조회수
								</th>
							</tr>
						</thead>
						<tbody id="donation-rank">
							
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
			<h1 data-aos="fade-up" style="font-family:Recipekorea;">
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
			<h1 data-aos="fade-up" class="float-right mb-4" style="font-family:Recipekorea;">
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
	
<script>

	$(function(){
		topViews1(1);
		topViews2(2); // 함수 호출
		
		// 일정 시간(1분)마다 리스트 갱신
		setInterval(function(){
			topViews1(1);
			topViews2(2);
		}, 60000);
	});
	
	// 비동기식으로 펀딩 실시간 랭킹 조회
	function topViews1(type){
		$.ajax({
			url : "board/topViews/" + type,
			dataType : "json",
			success : function(list1){
				console.log(list1);
				
				$("#funding-rank").html(""); // 리스트 갱신을 위해 이전 내용 삭제
				
				$.each(list1, function(index, item){
					
					var $tr = $("<tr>"); // 행
					var $td1 = $("<td>").text(item.id);
					var $td2 = $("<td>").text(item.title);
					var $td3 = $("<td>").text(item.endDay);
					var $td4 = $("<td>").text(item.readCount);
					
					$tr.append($td1, $td2, $td3, $td4);
					$("#funding-rank").append($tr);
					
				});
				
				
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
			
		});
		
	}
	
	// 비동기식으로 기부 실시간 랭킹 조회
	function topViews2(type){
		$.ajax({
			url : "board/topViews/" + type,
			dataType : "json",
			success : function(list2){
				console.log(list2);
				
				$("#donation-rank").html(""); // 리스트 갱신을 위해 이전 내용 삭제
				
				$.each(list2, function(index, item){
					
					var $tr = $("<tr>"); // 행
					var $td1 = $("<td>").text(item.dBoardNo);
					var $td2 = $("<td>").text(item.dBoardTitle);
					var $td3 = $("<td>").text(item.dBoardEndDate);
					var $td4 = $("<td>").text(item.dBoardReadCount);
					
					$tr.append($td1, $td2, $td3, $td4);
					$("#donation-rank").append($tr);
					
				});
				
				
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
			
		});
		
	}


</script>
</body>
</html>
