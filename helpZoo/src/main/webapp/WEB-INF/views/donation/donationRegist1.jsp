<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<title>기본 요건</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/regist.main.css" />
		<link rel='stylesheet prefetch' href='http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css'>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/formStyle.css">
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/popupStyle.css">
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/popupDefalut.css">

	
		
	</head>
<body>
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
											<h1>기본 요건</h1><br><br>

										</header>
										<p style="font-size: large;">펀딩 진행을 위한 기본 요건을 확인하고자 합니다. 심사 시 확인하는 중요한 정보이므로 반드시 정확한 정보를 입력하세요.
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
								<form id="registForm" name="validate" method="POST" >
								
									
									
									<label for="aaa" style="width: 3%; height: 30px;"></label>
									<div style="display: inline-block;">
										<input type="radio" id="aaa" name="abcd" value="first"  onchange="setDisplay()" checked> 아니요. 다른 곳에서 유통한 적이 없으며 와디즈를 통해 처음 선보이는 제품입니다.<br>
									</div><br>
									<label for="bbb" style="width: 3px;"></label>
									<input type="radio" id="bbb" name="abcd" value="second" onchange="setDisplay()"> 예, 다른 곳에서 유통한 적이 있습니다. 또는 현재 유통 중입니다.

									
									<div id="divId"><Br>리워드가 다른 판매처에서 유통된 적이 있다면 리워드로 제공할 수 없습니다.<br>
										기존에 유통하던 제품/서비스에 비해 개선된 점이 있다면 아래에 상세하게 작성해주세요.<br>
									</div><br>
									<textarea id="textarea"></textarea><br><br><br>
								
									
									
									
									

									
									
									<div class="" id="div3">
										<label for="plan">Q2. 현재까지 진행된 리워드의 준비 상태 및 앞으로의 계획을 구체적으로 설명해주세요.</label>
										<div style="font-size: small; margin-bottom: 20px;"><br>
											1) 리워드가 유형의 제품인 경우 제작 공정에 따른 현재 리워드의 제작 상태 및 제조 시설명과 일일 최대 생산<Br>&nbsp;&nbsp; 가능량을 포함한 앞으로의 생산 계획을 작성해주세요.<br>
											2) 공연, 영화, 전시 등 무형 서비스인 경우, 장소 대관, 촬영 일정 등의 현재 준비 상태 및 앞으로의 계획을 작성해주세요.<br>
										</div>
										<textarea style="width: 80%; height: 150px;" class="docPlan" name="docPlan" id="docPlan" placeholder="기부금 사용 계획에 대한 내용을 500자 이내로 기재해주세요."></textarea>	
										<span style="color:#aaa; text-align: right;" id="counter">(0 / 최대 500자)</span>
									</div><br><br><br>
									
									

									<div class="" id="div5">
										<label for="plan">Q3. 리워드의 전달 계획을 알려주세요.</label>
										<div style="font-size: small; margin-bottom: 20px;"><br>
											1) 리워드의 전달 방법(택배 or SMS 등)을 입력하고, 리워드 제작 및 전달 일정이 변동될 가능성이 있다면 사유를 알려주세요.<br>
											2) 발송 업체명 및 일일 최대 발송 가능량을 입력해주세요.<br>
											3) 공연, 영화, 전시 등 무형 서비스의 경우 좌석수, 일 최대 예약 가능 수량 등을 작성해주세요.<br>
										</div>
										<textarea style="width: 80%; height: 150px;" class="docPlan2" name="docPlan2" id="docPlan2" placeholder="기부금 사용 계획에 대한 내용을 500자 이내로 기재해주세요."></textarea>	
										<span style="color:#aaa; text-align: right;" id="counter2">(0 / 최대 500자)</span>
									</div><br><br><br>
						
							
									<div class="filebox">
										<label for="ex_file" class="open">약관 동의</label>
									</div>
							
									<div class="container">
								
										<div class="popup">
										<h2>약관 동의</h2>
										<div class="con">
											<table class="type1">
											<caption>
											<details class="hide">
												<summary>약관 동의</summary>
												<div>신청자이름, 연락처, 메모, 적용가능한혜택을 입력 또는 선택하는 표</div>
											</details>
											</caption>
											<colgroup>
											<col style="width: 111px">
											<col>
											</colgroup>
											<tbody>
											<tr>
											<th><label for="txt1">신청자이름<span>*</span></label></th>
											<td><input type="text" id="txt1" placeholder="이름을 입력해 주세요."></td>
											</tr>
											<tr>
											<th><label for="txt2">연락처<span>*</span></label></th>
											<td><input type="tel" id="txt2" placeholder="숫자만 입력해주세요."></td>
											</tr>
										
											<tr>
											<th>적용 가능한<br>혜택이 있나요?</th>
											<td>
												<ul>
												<li><input type="checkbox" id="chk1_1"><label for="chk1_1">T멤버십 회원이에요.</label></li>
												<li><input type="checkbox" id="chk1_2"><label for="chk1_2">지금 브로드밴드 인터넷을 쓰고 있어요.</label></li>
												<li><input type="checkbox" id="chk1_3"><label for="chk1_3">브로드밴드 인터넷을 신규 가입하여 결합하고 싶어요.</label></li>
												</ul>
											</td>
											</tr>
											</tbody>
											</table>
											<div class="agree">
											<input type="checkbox" id="chk1_4"><label for="chk1_4"><span>[필수]</span>개인정보 수집 및 이용 동의</label>
											<a href="#a" class="view">전문보기</a>
											</div>
										</div>
										<div class="txt_center">
											<input type="submit" id="submit" class="btn_typ1" name="validate2" onclick="val('delete');"></input>

										</div>
										<a href="#a" class="close">닫기</a>
										</div>
										<div class="dim"></div>


									</div>

									

						
















									1) 리워드가 유형의 제품인 경우 제작 공정에 따른 현재 리워드의 제작 상태 및 제조 시설명과 일일 최대 생산<Br>&nbsp;&nbsp; 가능량을 포함한 앞으로의 생산 계획을 작성해주세요.<br>
										2) 공연, 영화, 전시 등 무형 서비스인 경우, 장소 대관, 촬영 일정 등의 현재 준비 상태 및 앞으로의 계획을 작성해주세요.<br>
										1) 리워드가 유형의 제품인 경우 제작 공정에 따른 현재 리워드의 제작 상태 및 제조 시설명과 일일 최대 생산<Br>&nbsp;&nbsp; 가능량을 포함한 앞으로의 생산 계획을 작성해주세요.<br>
											2) 공연, 영화, 전시 등 무형 서비스인 경우, 장소 대관, 촬영 일정 등의 현재 준비 상태 및 앞으로의 계획을 작성해주세요.<br>
	
								  
										<br><br><br>
							  
								
										

							  
								  <fieldset>
									<legend>How did you hear about us?</legend>
									<label for="rdInternet">Internet</label>
									<input type="radio" id="rdInternet" value="Internet" name="referrer">
									<label for="rdTv">tv ads</label>
									<input type="radio" id="rdTv" value="tv ads" name="referrer">
									<label for="rdOther">Other</label>
									<input type="radio" id="rdOther" value="Other" name="referrer">
								  </fieldset> <br><br><br><br>
								

					




									


								  <input type="submit" id="submit" onclick="val('update');">Submint Form</input>
								</form>
							  </div>

							<!-- Section -->
									<script>
										function val(str){
											if(str == 'update'){
												validate.action="aaa";
											}
											if(str == 'delete'){
												validate.action=history.back();
											}		
										}
									</script>

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
									<li><a href="${contextPath}/donation/donationRegist2">새소식</a></li>
									<li><a href="${contextPath}/donation/donationRegist3">기부 현황</a></li>
								
									
									<li><a href="#">Maximus Erat</a></li>
									<li><a href="#">Sapien Mauris</a></li>
									<li><a href="#">Amet Lacinia</a></li>
								</ul>
							</nav>
						</div>
					</div>

			</div>
			<jsp:include page="../common/footer.jsp"/>
			<script src="${contextPath}/resources/donation/registJs/jquery.min.js"></script>
			<script src="${contextPath}/resources/donation/registJs/skel.min.js"></script>
			<script src="${contextPath}/resources/donation/registJs/util.js"></script>
			<script src="${contextPath}/resources/donation/registJs/regist.main.js"></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js'></script>
			<script src="${contextPath}/resources/donation/registJs/formScript1.js"></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
			<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js'></script>
</body>
</html>