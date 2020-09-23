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
		
		p{
			color :  #7fcdcd;
		}
		
		.eventImg img{
			width : 290px;
			height : 496px;
		}
		
		.table tr, .pointerDiv{
			cursor : pointer;
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
					<div class="row pointerDiv">
						<div class="col-md-4 funding fDiv">
							
						</div>
						<div class="col-md-4 funding fDiv">
							
						</div>
						<div class="col-md-4 funding fDiv">
							
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
									Title
								</th>
								<th>
									EndDate
								</th>
								<th>
									Views
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
									Title
								</th>
								<th>
									EndDate
								</th>
								<th>
									Views
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
					<div class="row pointerDiv">
						<div class="col-md-4 dDiv">
							
						</div>
						<div class="col-md-4 dDiv">
							
						</div>
						<div class="col-md-4 dDiv">
							
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
				<div class="col-md-8" data-aos="fade-up">
					<h4>
						#급상승 프로젝트
					</h4>
					<br>
					<div class="row pointerDiv">
						<div class="col-md-6 increaseF">
							
						</div>
						<div class="col-md-6 increaseF">
							
						</div>
						<div class="col-md-6 increaseF">
							
						</div>
						<div class="col-md-6 increaseF">
							
						</div>
					</div>
					
					
					
				</div>
				
				<div class="col-md-4" data-aos="fade-left">
					<h3>
						Event!
					</h3>
					<br>
					<div>
						<div class="eventImg">
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
					<div>
						<div class="eventImg">
						</div>
					</div>
				</div>
				<div class="col-md-8" data-aos="fade-up">
					<h4>
						#급상승 프로젝트
					</h4>
					<br>
					<div class="row pointerDiv">
						<div class="col-md-6 increaseD">
							
							<p> </p>
						</div>
						<div class="col-md-6 increaseD">
							
						</div>
						<div class="col-md-6 increaseD">
							
						</div>
						<div class="col-md-6 increaseD">
							
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
		
		randomBoard1(1);
		randomBoard2(2);
		
		increaseBoard1(1);
		increaseBoard2(2);
		
		eventImg();
		
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
					
					var $a = $("<a>").attr("href", "${contextPath}/funding/fundingView/"+item.id).css({"color" : "black"});
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
	
	/* 펀딩 랜덤 조회 */
	function randomBoard1(type){
		console.log(type);
		$.ajax({
			url : "board/random/" + type,
			dataType : "json",
			success : function(list1){
				
				var fDiv = $(".fDiv");
				$.each(list1, function(index, item){
					
					$(fDiv[index]).html("");
					
					var $img = $("<img>");
					var $h5 = $("<h5>").text(item.fundingTitle).css("padding-top", "20px");
					var $a = $("<a>").attr("href", "${contextPath}/funding/fundingView/"+item.fundingNo).css({"color" : "black"});
					
					console.log(item.fundingTitle);
					
					$img.attr("src", "${contextPath}" + item.filePath + "/" + item.fileChangeName).addClass("rounded");
					$a.append($img);
					$a.append($h5);
					$(fDiv[index]).append($a).css({"text-align" : "center"});
					
					
				});
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
		
			
		});
	}
	
	/* 기부 랜덤 조회 */
	function randomBoard2(type){
		console.log(type);
		$.ajax({
			url : "board/random/" + type,
			dataType : "json",
			success : function(list2){
				
				var dDiv = $(".dDiv");
				$.each(list2, function(index, item){
					
					$(dDiv[index]).html("");
					
					var $img = $("<img>");
					var $h5 = $("<h5>").text(item.dBoardTitle).css("padding-top", "20px");
					
					console.log(item.dBoardTitle);
					
					$img.attr("src", "${contextPath}" + item.dFilePath + "/" + item.dFileChangeName).addClass("rounded");
					$(dDiv[index]).append($img);
					
					$(dDiv[index]).append($h5).css({"text-align" : "center"});
					
					
				});
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
		
			
		});
	}
	
	
	/* 급상승 펀딩 프로젝트 조회 */
	function increaseBoard1(type){
		$.ajax({
			url: "board/increase/" + type,
			dataType: "json",
			success : function(list1){
				console.log(list1);
				
				var increaseF = $(".increaseF");
				$.each(list1, function(index, item){
					
					$(increaseF[index]).html("");
					
					var $img = $("<img>");
					var $h5 = $("<h5>").text(item.fundingTitle);
					var $p = $("<p>").text(item.achievementRate + " %");
					var $a = $("<a>").attr("href", "${contextPath}/funding/fundingView/"+item.fundingNo).css({"color" : "black"});
					
					$img.attr("src", "${contextPath}" + item.filePath + "/" + item.fileChangeName).addClass("rounded");
					$a.append($img);
					$a.append($h5);
					$(increaseF[index]).append($a);
					$(increaseF[index]).append($p);
					
				});
			}, error : function(){
				console.log("ajax 통신 실패");
			}
		});
		
	}
	
	
	/* 급상승 기부 프로젝트 조회 */
	function increaseBoard2(type){
		$.ajax({
			url: "board/increase/" + type,
			dataType: "json",
			success : function(list2){
				console.log(list2);
				
				var increaseD = $(".increaseD");
				$.each(list2, function(index, item){
					
					$(increaseD[index]).html("");
					
					var $img = $("<img>");
					var $h5 = $("<h5>").text(item.dBoardTitle);
					var $p = $("<p>").text(item.achivement + " %");
					
					
					$img.attr("src", "${contextPath}" + item.dFilePath + "/" + item.dFileChangeName).addClass("rounded");
					$(increaseD[index]).append($img);
					$(increaseD[index]).append($h5);
					$(increaseD[index]).append($p);
					
				});
			}, error : function(){
				console.log("ajax 통신 실패");
			}
		});
		
	}
	
	
	/* 이벤트 이미지 조회 */
	function eventImg(){
		$.ajax({
			url : "board/event",
			dataType : "json",
			success : function(list){
				
				var eventImg = $(".eventImg");
				$.each(list, function(index, item){
					
					$(eventImg[index]).html("");
					
					var $img = $("<img>");
					var $a = $("<a>").attr("href", "${contextPath}/event/" + item.boardType + "/" + item.parentBoardNo).css({"color" : "black"});
					$img.attr("src", "${contextPath}" + item.filePath + "/" + item.fileChangeName);
					
					$a.append($img);
					$(eventImg[index]).append($a);
					
				});
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
			
		});
		
	}


</script>
</body>
</html>
