<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>기부 상세페이지</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<link rel="stylesheet" href="${contextPath}/resources/donation/detailCss/mainDetail.css" />
</head>
<body>
	<jsp:include page="../common/header.jsp"/>

	<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="#">Future Imperfect</a></h1>
						<nav class="links">
							<ul>
								<li><a href="#">Lorem</a></li>
								<li><a href="#">Ipsum</a></li>
								<li><a href="#">Feugiat</a></li>
								<li><a href="#">Tempus</a></li>
								<li><a href="#">Adipiscing</a></li>
							</ul>
						</nav>
						<nav class="main">
							<ul>
								<li class="search">
									<a class="fa-search" href="#search">Search</a>
									<form id="search" method="get" action="#">
										<input type="text" name="query" placeholder="Search" />
									</form>
								</li>
								<li class="menu">
									<a class="fa-bars" href="#menu">Menu</a>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Menu -->
					<section id="menu">

						<!-- Search -->
							<section>
								<form class="search" method="get" action="#">
									<input type="text" name="query" placeholder="Search" />
								</form>
							</section>

						<!-- Links -->
							<section>
								<ul class="links">
									<li>
										<a href="#">
											<h3>Lorem ipsum</h3>
											<p>Feugiat tempus veroeros dolor</p>
										</a>
									</li>
									<li>
										<a href="#">
											<h3>Dolor sit amet</h3>
											<p>Sed vitae justo condimentum</p>
										</a>
									</li>
									<li>
										<a href="#">
											<h3>Feugiat veroeros</h3>
											<p>Phasellus sed ultricies mi congue</p>
										</a>
									</li>
									<li>
										<a href="#">
											<h3>Etiam sed consequat</h3>
											<p>Porta lectus amet ultricies</p>
										</a>
									</li>
								</ul>
							</section>

						<!-- Actions -->
							<section>
								<ul class="actions vertical">
									<li><a href="#" class="button big fit">Log In</a></li>
								</ul>
							</section>

					</section>

				<!-- Main -->
					<div id="main">

						<!-- Post -->
							<article class="post">
								<header>
									<div class="title">
										<h2 class="percentage" style="margin-bottom: 5px;">18%</h2>
										<progress value="15" max="100"></progress>
										<p style="font-size: 13px; margin-top: 15px;"><b>2020.10.01~2020.12.31</b><span> 까지</span></p>
										<p class="targetAmount"><h1>170,000<span>원</span></h1><br></p>
										<p class="totalAmount" style="font-size: larger;" ><span style="font-size: 15px;">목표 금액 <br> : </span>1,000,000,000<span>원</span></p>
									</div>
									
									
								</header>
								
								<a href="${contextPath}/donation/dPaymentOnec" class="image featured"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" />모금함 기부하기</a>

								<h3>모금단체</h3>
								<h2>목포이랜드노인복지관</h2>
								<span><a href="#" style="font-size: small;">단체 안내</a></span>
								<table style="font-size: small; margin-top: 5px;">
									<tbody>
										<tr>
											<td>해피로그 가입</td>
											<td>2013<span>년</span></td>
										</tr>
										<tr>
											<td>총 모금액</td>
											<td>1,000,000<span>원</span></td>
										</tr>
										<tr>
											<td>필수 모금후기 등록률</td>
											<td>91<span>%</span></td>
										</tr>
										<tr>
											<td>현재 정기기부자</td>
											<td>7<span>명</span></td>
										</tr>
										<tr>
											<td>재정정보 공개</td>
											<td>2019<span>년</span></td>
										</tr>

									</tbody>
								</table>
						
								
							</article>

						<!-- Post -->
							<article class="post" style="height: 100%;">
								<header style="border: none;">
									<div class="title">
										<h2>오늘의 추천</h2>
										<p>외로움을 견디는 어르신에게 추석이 쓸쓸함이아닌 온정이길</p>
									</div>
								</header>
								<a href="#" class="image featured" style="margin-top: -5em;"><img src="${contextPath}/resources/donation/testImg/pic02.jpg" alt="" /></a>
								<Br>
								<header style="border: none;">
									<div class="title">

										<p>외로움을 견디는 어르신에게 추석이 쓸쓸함이아닌 온정이길</p>
									</div>
								</header>
								<a href="#" class="image featured" style="margin-top: -5em;"><img src="${contextPath}/resources/donation/testImg/pic02.jpg" alt="" /></a>
								<Br>
								<header style="border: none;">
									<div class="title">
										<p>장기화 된 코로나19로 지친 독거어르신들을 위한 식료품</p>
									</div>
								</header>
								<a href="#" class="image featured" style="margin-top: -5em;"><img src="${contextPath}/resources/donation/testImg/pic02.jpg" alt="" /></a>
								<div class="title" style="text-align: center; padding-top: 300px;">
									<h2>기부 실천..</h2>
									<p>감사합니다.</p>
								</div>
								
							</article>

						
					
					</div>



				<!-- Sidebar -->
					<section id="sidebar" >

						<!-- Intro -->
							<section id="intro">
								<a href="#" class="logo"><img src="${contextPath}/resources/donation/testImg/logo.jpg" alt="" /></a>
								<header>
									<p>카테고리</p>
									<h2>모두가 행복한 추석이 난 두려워요.</h2>
									<p>Another fine responsive site template by <a href="#">HTML5 UP</a></p>
								</header>
							</section>

						<!-- Mini Posts -->
							<section>
								<div class="mini-posts">

									<!-- Mini Post -->
										<article class="mini-post">
											<header>
												<h3>Vitae sed condimentum</h3>
												<p>모두가 먹고 살기 바빴던 그 시절에 모든것이 부족했습니다. 먹을 것도 입을 것도 부족했지만, 이제는 나라도 발전하고 세상도 좋아져서 어르신들은 나라에서 도움도 많이 주고 살기 편해졌다고 말씀하십니다. 그러나 일손이 부족하다는 이유로, 맏이가 아니라는 이유로, 동생들 먼저 뒷바라지 하느라 책과는 가까이 지낼 수 없던 어린 시절이 지나서도 글자를 읽고 쓰지 못하고 있습니다. 책은 커녕 휴대폰의 우리 딸 문자도 식당의 메뉴판도 읽기 힘들어 주변에 묻고 다니는 것이 부끄럽기도 합니다. 내가 글만 알았어도 지금보다는 더 편하게 살았을텐데라며 어르신들은 아쉬움을 가지고 살아갑니다.</p>
												<time class="published" datetime="2015-10-20">October 20, 2015</time>
												<a href="#" class="author"><img src="${contextPath}/resources/donation/testImg/avatar.jpg" alt="" /></a>
											</header>
											<a href="#" class="image"><img src="${contextPath}/resources/donation/testImg/pic04.jpg" alt="" /></a>
										</article>

										<section id="two" class="wrapper style2">
											<header>
												<h2>Vestibulum Convallis</h2>
												<p>vehicula urna sed justo bibendum</p>
											</header>
											<div class="content">
												<div class="gallery">
													<div>
														<div class="image fit flush">
															<a href="images/pic03.jpg"><img src="${contextPath}/resources/donation/testImg/pic03.jpg" alt="" /></a>
														</div>
													</div>
													<div>
														<div class="image fit flush">
															<a href="images/pic01.jpg"><img src="${contextPath}/resources/donation/testImg/pic01.jpg" alt="" /></a>
														</div>
													</div>
													<div>
														<div class="image fit flush">
															<a href="images/pic04.jpg"><img src="${contextPath}/resources/donation/testImg/pic04.jpg" alt="" /></a>
														</div>
													</div>
													<div>
														<div class="image fit flush">
															<a href="images/pic05.jpg"><img src="${contextPath}/resources/donation/testImg/pic05.jpg" alt="" /></a>
														</div>
													</div>
												</div>
											</div>
										</section>
					

									<!-- Mini Post -->
							
									

									
										<section id="three" class="wrapper">
											<div class="spotlight">
												<div class="image flush"><img src="${contextPath}/resources/donation/testImg/pic06.jpg" alt="" /></div>
												<div class="inner">
													<h3>Viverra Hendrerit</h3>
													<p>Curabitur eget semper ante. Morbi eleifend ultricies est, a blandit diam vehicula vel. Vestibulum porttitor nisi quis viverra hendrerit. Suspendisse vel volutpat nibh, vel elementum lacus. Maecenas commodo pulvinar dui, at cursus metus imperdiet vel.</p>
												</div>
											</div>
											<div class="spotlight alt">
												<div class="image flush"><img src="${contextPath}/resources/donation/testImg/pic07.jpg" alt="" /></div>
												<div  class="inner">
													<h3>Curabitur Eget</h3>
													<p>Curabitur eget semper ante. Morbi eleifend ultricies est, a blandit diam vehicula vel. Vestibulum porttitor nisi quis viverra hendrerit. Suspendisse vel volutpat nibh, vel elementum lacus. Maecenas commodo pulvinar dui, at cursus metus imperdiet vel.</p>
												</div>
											</div>
											<div class="spotlight">
												<div class="image flush"><img src="${contextPath}/resources/donation/testImg/pic08.jpg" alt="" /></div>
												<div class="inner">
													<h3>Morbi Eleifend</h3>
													<p>Curabitur eget semper ante. Morbi eleifend ultricies est, a blandit diam vehicula vel. Vestibulum porttitor nisi quis viverra hendrerit. Suspendisse vel volutpat nibh, vel elementum lacus. Maecenas commodo pulvinar dui, at cursus metus imperdiet vel.</p>
												</div>
											</div>
											<div style="margin-top: 100px;">
												<a href="#" class="button">모금함 기부하기</a>
											</div>
										</section>
					


								</div>
							</section>

							

						<!-- About -->
							<section class="blurb">
								<h2>기부 리뷰 확인 공간</h2>
								<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod amet placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at phasellus sed ultricies.</p>
								<ul class="actions">
									<li><a href="#" class="button">페이징 처리 예정</a></li>
								</ul>
							</section>

						<!-- Footer -->
							<jsp:include page="../common/footer.jsp"/>


					</section>

			</div>

		<!-- Scripts -->
			<script src="${contextPath}/resources/donation/detailJs/jquery.min.js"></script>
			<script src="${contextPath}/resources/donation/detailJs/skel.min.js"></script>
			<script src="${contextPath}/resources/donation/detailJs/util.js"></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js'></script>
			<script src="${contextPath}/resources/donation/detailJs/main.js"></script>



</body>
</html>