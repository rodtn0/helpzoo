<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>기본 정보</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel='stylesheet prefetch' href='http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css'>
	<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/regist.main.css" />
	<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/formStyle.css">
</head>
<body>
	


		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.html" class="logo"><strong>기부 준비 > &nbsp;</strong>  각 현황</a>
								
									
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h1>기본 정보</h1>

										</header>
										<p style="font-size: 2ex;">펀딩 진행을 위한 기본 요건을 확인하고자 합니다. 심사 시 확인하는 중요한 정보이므로 반드시 정확한 정보를 입력하세요.
											답변 내용이 사실과 다른 경우, 약정 위반에 따른 불이익이 발생할 수 있습니다.<br>
											
											<Br>
											Q1. 리워드가 타 크라우드펀딩사 및 온라인 커머스, 자사 홈페이지 등 다른 판매처에서 유통된 적이 있거나 현재 유통 중인가요?</p>
										<ul class="actions">

										</ul>
									</div>
									<span class="image object" style="width: 40%;">
										
										
									</span>
								</section>

							<!-- Section -->
							<div class="container">
								<form>
								  <div id="progress">
									<div class="pct"><span>0</span>% 진행 완료</div>
								  </div><br><br>

								  

								  <div class="ui-widget" id="div1">
									<label for="location">Select Location</label>
									<select id="location" name="location">
									  <option  selected disabled hidden >지역을 선택해주세요</option>
									  <optgroup label="국내">
										<option value="Fort Worth">서울</option>
										<option value="Odessa">경기</option>
										<option value="Muleshoe">Muleshoe</option>
									  </optgroup>
									  <optgroup label="국외">
										<option value="Ardmore">Ardmore</option>
										<option value="Tulsa">Tulsa</option>
									  </optgroup>
									</select>
								  </div><br><br>

							  
								  <div class="ui-widget">
									<label for="organization">기관 명</label>
									<input type="text" id="organization" class="ui-corner-all ui-button" placeholder="기관명을 입력해주세요.">
								  </div><br><br>


								  <div class="ui-widget">
									<label for="donationTitle">프로젝트 제목</label>
									<input type="text" id="donationTitle" class="ui-corner-all ui-button" placeholder="프로젝트 제목을 입력해주세요.">
								  </div><br><br>


							  
								  <div class="ui-widget">
									<label for="experience">experience</label>
									<input type="text" id="experience">
								  </div><br><br>



								  <div class="ui-widget" >
									<label for="category">카테고리*</label>
									<select id="category" name="category">
									  <option  selected disabled hidden >카테고리를 선택해주세요</option>
									  <optgroup label="강아지">
										<option value="Fort Worth">서울</option>
										<option value="Odessa">경기</option>
										<option value="Muleshoe">Muleshoe</option>
									  </optgroup>
									  <optgroup label="고양이">
										<option value="Ardmore">Ardmore</option>
										<option value="Tulsa">Tulsa</option>
									  </optgroup>
									  <optgroup label="햄스터">
										<option value="Ardmore">Ardmore</option>
										<option value="Tulsa">Tulsa</option>
									  </optgroup>
									</select>
								  </div><br><br>

								  

							  
								  <div class="ui-widget"  >
									<label for="endDate">프로젝트 기간 설정</label>
									<input type="text" id="startDate" class="ui-corner-all ui-button" title="오늘을 기준으로 최대 2개월 기간 선택가능"> ~ 
									<input type="text" id="endDate" class="ui-corner-all ui-button" title="We ask for your age only for statistical purposes.">					
								  </div> <br><br>

							  
								  <fieldset>
									<legend>How did you hear about us?</legend>
									<label for="rdInternet">Internet</label>
									<input type="radio" id="rdInternet" value="Internet" name="referrer">
									<label for="rdTv">tv ads</label>
									<input type="radio" id="rdTv" value="tv ads" name="referrer">
									<label for="rdOther">Other</label>
									<input type="radio" id="rdOther" value="Other" name="referrer">
								  </fieldset> <br><br>





								  <button id="submit">Submint Form</button>
								</form>
							  </div>

							<!-- Section -->
								

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

						
							<!-- Section -->
							<nav id="menu">
								<header class="major">
									<h2>Menu</h2>
								</header>
								<ul>
									<li>
										<span class="opener">기부 준비</span>
										<ul>
											<a href="${contextPath}/donation/donationRegist1" >기본 요건</a>
											<a href="${contextPath}/donation/donationRegist2">기본 정보</a>
											<a href="${contextPath}/donation/donationRegist3">스토리 작성</a>

										
											

											<li><a href="#">위험요소 & 정책</a></li>
										</ul>
									</li>
									<li><a href="#">새소식</a></li>
									<li><a href="#">기부 현황</a></li>
								
									
									<li><a href="#">Maximus Erat</a></li>
									<li><a href="#">Sapien Mauris</a></li>
									<li><a href="#">Amet Lacinia</a></li>
								</ul>
							</nav>
							

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>
			<jsp:include page="../common/footer.jsp"/>
		<!-- Scripts -->
			<script src="${contextPath}/resources/donation/registJs/jquery.min.js"></script>
			<script src="${contextPath}/resources/donation/registJs/skel.min.js"></script>
			<script src="${contextPath}/resources/donation/registJs/util.js"></script>
			<script src="${contextPath}/resources/donation/registJs/regist.main.js"></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js'></script>
			<script src="${contextPath}/resources/donation/registJs/formScript2.js"></script>
			
</body>
</html>