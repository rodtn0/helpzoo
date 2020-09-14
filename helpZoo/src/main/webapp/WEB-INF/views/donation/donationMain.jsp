<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="${contextPath}/resources/donation/mainCss/donation-main.css">
	<link rel="stylesheet" href="${contextPath}/resources/donation/mainCss/main-1.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<body class="is-preload">
	<jsp:include page="../common/header.jsp"/>

	<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
							<!-- 		<a  class="logo"><strong>Editorial</strong> by HTML5 UP</a>		
									<ul class="icons">
										<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
										<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
									</ul>	 -->				
								</header>

							
								<div class="slider">
									<section id="section1" >I am a slide.</section>
									<section id="section2">I am another slide.</section>
									<section id="section3">I am another slide.</section>
									<section id="section4">I am another slide.</section>
								</div>

							<!-- Section -->
								<section>
									
									<div class="features-1">
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>전체테마</h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>강아지 </h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>고양이 </h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>장애 동물 </h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>동물 프로젝트 </h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>버려진 동물 </h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>무슨 동물 </h4>
												</div>
											</span>
										</article>
										<article>
											<span class="icon fa-gem">
												<div class="content">
													<h4>무슨 동물 </h4>
												</div>
											</span>
										</article>
									</div>
								</section>


								<div style="float: right; margin-top: 15px; font-size: small;"> 기준 : 건</div>

								<section class="counters">
									<div class="container">
										<ul class="clearfix">
											<li>
												<span class="icon client">client</span>
												<h3 data-rate="3587"></h3>
												<h4>강이지 후원</h4>

											</li>
											<li>
												<span class="icon coffee">coffee</span>
												<h3 data-rate="207"></h3>
												<h4>고양이 후원</h4>

											</li>
											<li>
												<span class="icon post">post</span>
												<h3 data-rate="2500"></h3>
												<h4>햄스터 후원</h4>

											</li>
											<li>
												<span class="icon like">like</span>
												<h3 data-rate="873"></h3>
												<h4>명</h4>

											</li>
											<li>
												<span class="icon launched">launched</span>
												<h3 data-rate="900"></h3>
												<h4>원</h4>
											</li>						
										</ul>
									</div>
								</section><!--//counters -->


				


								<!-- Section -->
								<section>
									<div style="display: inline;">
										<h4 style="display: inline-block; margin-left: 15px" >모금함 000개</h4>
									</div>
									<div class="sortList" >
										<fieldset>
											
											<select name="sort" id="sort" onchange="sortList()">
												<option value="1">추천 순</option>
												<option value="2">최신 순</option>
												<option value="3">모금액 많은 순</option>
												<option value="4">모금률 높은 순</option>
												<option value="5">종료임박 순</option>
											</select>

										</fieldset>
									  </div><br><br>
								
									
									<div class="posts">
										<article>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
											<ul class="actions">
												<li class="li"><a href="${contextPath}/donation/donationDetail" class="button">상세페이지 테스트</a></li>
											</ul>
										</article>
										<article>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
											<ul class="actions">
												<li class="li"><a href="${contextPath}/donation/donationRegist1" class="button">등록페이지 테스트</a></li>
											</ul>
										</article>
										<article>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
											<ul class="actions">
												<li class="li"><a href="#" class="button">More</a></li>
											</ul>
										</article>
										<article>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
											<ul class="actions">
												<li class="li"><a href="#" class="button">More</a></li>
											</ul>
										</article>
										<article>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
											<ul class="actions">
												<li class="li"><a href="#" class="button">More</a></li>
											</ul>
										</article>
											<article>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
											<ul class="actions">
												<li class="li"><a href="#" class="button">More</a></li>
											</ul>
										</article>
										
										
									</div>
								</section>



								

						</div>
					</div>

					

			</div>
			<jsp:include page="../common/footer.jsp"/>

		<!-- Scripts -->
			<script src="${contextPath}/resources/donation/mainJs/jquery.min.js"></script>
			<script src="${contextPath}/resources/donation/mainJs/browser.min.js"></script>
			<script src="${contextPath}/resources/donation/mainJs/breakpoints.min.js"></script>
			<script src="${contextPath}/resources/donation/mainJs/util.js"></script>
			<script src="${contextPath}/resources/donation/mainJs/main.js"></script>
			<script src="${contextPath}/resources/donation/mainJs/dMainScript.js"></script>
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
			<script src="http://malsup.github.com/jquery.cycle2.js"></script>
			<script src="http://malsup.github.io/jquery.cycle2.carousel.js"></script>
			<script>$.fn.cycle.defaults.autoSelector = '.cycle-slideshow';</script>
	
	
			<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

</body>
</html>