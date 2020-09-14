<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>스토리 작성</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/regist.main.css" />
		<link rel='stylesheet prefetch' href='http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css'>
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/formStyle.css">
		<script src="https://cdn.ckeditor.com/ckeditor5/22.0.0/classic/ckeditor.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/popupStyle.css">
		<link rel="stylesheet" href="${contextPath}/resources/donation/registCss/popupDefalut.css">
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
											<h1>스토리 작성</h1>

										</header>
										<p style="font-size: large;">메이커님의 프로젝트를 소개해보세요.
											<br> 스토리에는 메이커님의 진심과 목소리가 잘 녹여질 수 있도록 명확하고, 솔직하게, 친근한 어투로 작성하세요.
											
										
							
									</div>
									<span class="image object" style="width: 40%;">
										
										
									</span>
								</section>

							<!-- Section -->
							<div class="container">
								<form>
									


									<h4><b>소개 영상·사진 등록*</b></h4>
									프로젝트 페이지 상단에 노출될 영상 또는 사진을 올려주세요.
									<br><br>

									<div class="filebox">
										<label for="ex_file">등록 하기</label>
										<input type='file' id="ex_file" /><br><br>
										2MB 이하의 JPEG, JPG, GIF, PNG 파일<br>
										사이즈 : 최소 630X400 픽셀 이상
										
									</div>
									<div>
										<img id="mainImg" />
									</div>
									

									<br><br><br><br><br><br>


									<div class="" id="div3">
										<label for="plan">프로젝트 요약*</label>
										<textarea style="width: 90%; height: 100px;" class="docPlan" name="docPlan" id="docPlan" placeholder="기부금 사용 계획에 대한 내용을 300자 이내로 기재해주세요."></textarea>	
										<span style="color:#aaa; text-align: right;" id="counter">(0 / 최대 300자)</span>
									</div>




									<section id="banner">
										<div class="content">
									
											<p style="font-size: small;">
												스토리 광고 심의 동의
												스토리 작성 전, 와디즈에서 제공하는 광고 심의 가이드라인을 반드시 확인하세요. 동의를 진행해야 스토리 작성이 가능합니다. 오픈예정 스토리도 적용됩니다.
												<br><br>
												공통 표시·광고 가이드라인<br>
												식품 표시·광고 가이드라인<br>
												화장품 표시·광고 가이드라인<br>
												건강보조기구 표시·광고 가이드라인<br>
												<b><a class="open">팝업열기</a></b>
											
											
											<ul class="actions">
												동의 완료 / 동의 시간 / 동의 내용 보기(팝업)<br>

												아이디 / 이메일
											</ul>
										</div>
										<span class="image object" style="width: 40%;">
											
											
										</span>


										
									</section>




									<div class="container">
									<form>
								   
								  
									  <div class="popup">
										<h2>간편 상담 신청</h2>
										<div class="con">
										  <table class="type1">
										  <caption>
											<details class="hide">
											  <summary>스토리 광고 동의</summary>
											  <div>신청자이름, 연락처, 메모, 적용가능한혜택을 입력 또는 선택하는 표</div>
											</details>
										  </caption>
										  <colgroup>
										  <col style="width: 111px">
										  <col>
										  </colgroup>
										  <tbody>
										  <tr>
											<th><label for="txt1">신청자이름</label><span>*<em class="hide">필수입력</em></span></th>
											<td><input type="text" id="txt1" placeholder="이름을 입력해 주세요."></td>
										  </tr>
										  <tr>
											<th><label for="txt2">연락처</label><span>*<em class="hide">필수입력</em></span></th>
											<td><input type="tel" id="txt2" placeholder="숫자만 입력해주세요."></td>
										  </tr>
										  <tr>
											<th><label for="txt3">메모</label><em>(0/300 byte)</em></th>
											<td><textarea id="txt3" placeholder="궁금하신 점이나 렌탈 계약 진행 시 SK매직이 고민해야 할 부분이 있다면 메모로 남겨 주세요. 예) 평일 오후 2시~3시 사이에 연락주세요."></textarea></td>
										  </tr>
										  <tr>
											<th>적용 가능한<br>혜택이 있나요?</th>
											<td>
											  <ul>
											  <li><input type="checkbox" id="chk1_1"><label for="chk1_1">광고 이용을 동의합니다</label></li>
											  <li><input type="checkbox" id="chk1_2"><label for="chk1_2">HELPZOO 약관에 동의합니다</label></li>
											  <li><input type="checkbox" id="chk1_3"><label for="chk1_3">HELPZOO 약관에 동의합니다</label></li>
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
										  <button id="submit" class="btn_typ1">Submint Form</button>
								  
										</div>
										<a href="#a" class="close">닫기</a>
									  </div>
									  <div class="dim"></div>
								  
								  
									</form>
								  </div>











									


	

									<div class="" id="div3">
										<label for="plan">기부금 사용 계획을 작성해주세요</label>
										<textarea style="width: 90%; height: 200px;" class="docPlan" name="docPlan" id="docPlan" placeholder="기부금 사용 계획에 대한 내용을 300자 이내로 기재해주세요."></textarea>	
										<span style="color:#aaa; text-align: right;" id="counter">(0 / 최대 300자)</span>
									</div><br><br><br>



									<div class="" id="div3">
									프로젝트 스토리<br>
									진정성 있고 매력적인 스토리로 서포터의 마음을 움직여볼까요?<br>
									스토리 필수 항목을 누락할 경우 오픈이 지연될 수 있으며, 제 3자의 지식재산권을 침해할 경우 프로젝트가 중단/취소될 수 있습니다.
									</div><br>

									<textarea name="content" id="editor"><br>필수 항목이 누락되거나 미비할 경우, 오픈 승인이 어렵습니다. 
										<br>아래 내용을 꼼꼼히 확인해 주시고, 스토리 필수항목은 프로젝트의 성격에 맞게 자유롭게 배치해주세요.<br><br>

										<h2>1. 메이커 소개</h2>
										<ul>
											<li>“안녕하세요” 라는 인사와 함께 간단한 자기소개를 넣어주세요. 브랜드/팀명은 무엇이고, 이번 프로젝트에서 어떤 역할을 담당하는 지 소개해보세요.</li>
											
											<li>메이커님의 얼굴을 확인할 수 있는 실물사진은 필수 항목입니다. 일러스트나 뒷모습, 선글라스 착용 등 얼굴이 가려진 사진은 사용 불가합니다.<br></li>
											
										</ul>

										<h2>2. 프로젝트 진행 동기 및 목적</h2>
										<ul>
											<li>와디즈에서 펀딩을 하게 된 동기, 펀딩을 통해 이루고자 하는 목표와 함께, 목표금액은 무엇을 기준으로 설정하셨는 지도 함께 얘기해주세요.</li>
											
											<li>펀딩 종료 후, 펀딩금액을 어떻게 사용하실 지와 더불어 앞으로의 계획을 알려주세요.</li>
											<li>(TIP) 현재 리워드는 어디까지 완성되었나요? 현재 리워드의 제작 진행 상황과 함께, 펀딩 이후의 계획도 같이 밝혀주시면 신뢰감을 주실 수 있답니다.<br></li>
										</ul>
											
										
										<h2>3. 리워드 소개와 상세정보</h2>
										<ul>
											<li>리워드의 이름은 무엇이고, 어떤 용도로 사용하는 제품/서비스인가요?</li>
											
											<li>리워드 품목에 따라 서포터가 꼭 알아야 할 상세 스펙 (특징, 사양, 사용법, 인증서, 주의사항 등)을 빠짐없이 넣어주세요.</li>
											<li>리워드를 직접 보고 펀딩할 수 없으므로 서포터분들이 참고할 수 있는 사진, 영상과 같은 시각 자료를 넣어주세요.<br></li>
										</ul>
							
										<h2>4. 리워드 리스트</h2>
										<ul>
											<li>리워드 탭에 추가해두신 리워드의 구성과 가격, 명칭 한눈에 들어올 수 있도록 리스트를 넣어주세요. 아래와 같이, 표를 이용해도 좋습니다.</li>											
										</ul>
								
										

										<table >
											<thead >
												<tr >	
												  <th >리워드명</th>
												  <th >구성</th>
												  <th >가격</th>
												  <th >가격혜택</th>
												</tr>
											  </thead>
											  <tbody >
												<tr>
												  <th>[패밀리버드] 와디즈텀블러	</th>
												  <td>와디즈 텀블러*4개, 코스터*4개</td>
												  <td>35,000원</td>
												  <td>12%</td>
												</tr>
												<tr >
												  <th >[커플버드] 와디즈텀블러</th>
												  <td >와디즈 텀블러*4개, 코스터*4와디즈 텀블러*2개, 코스터*2개	</td>
												  <td >20,000원	</td>
												  <td >10%</td>
												</tr>
												<tr>
												  <th >[솔로버드] 와디즈텀블러	</th>
												  <td >와디즈 텀블러*1개</td>
												  <td >10,000원	</td>
												  <td >8%</td>
												</tr>
											  </tbody>
										</table>
										<br>
										
										<h2>5. 프로젝트 일정</h2>
										<ul>
											<li>아이디어가 처음 나온 날, 샘플을 처음 제작한 날 등 프로젝트를 처음 준비하기 시작한 시점부터 적어주세요. 프로젝트 시작/마감일, 리워드 발송일은 물론, 향후 일정까지 포함해주세요.</li>											
											<li>아이디어 구상시점 : Ο월 Ο일 </li>
											
											<li>와디즈 펀딩 시작일 : 현재 </li>
											<li>와디즈 펀딩 마감일 : Ο월 Ο일</li>
											<li>리워드 제작 시작일 : Ο월 Ο일</li>
											<li>리워드 발송 시작일 : Ο월 Ο일<br></li>

										</ul>
								
										
										<h2>6. FAQ</h2>
										<ul>
											<li>메이커님의 프로젝트만의 강점을 한 번 더 강조해 주시거나 서포터가 궁금해 할만한 내용을 적어주세요.</li>											
											<li>Q. 펀딩과 쇼핑은 무엇이 다른가요?  </li>
											
											<li>Q. 프로젝트의 후원금은 어떻게 사용하실 계획인가요? </li>
											<li>Q. 리워드의 가장 큰 강점은 무엇인가요?</li>
											<li>Q. 해당 프로젝트에 펀딩 시, 서포터가 꼭 알아야 하는 점이 있나요?<br></li>
											
										
										</ul> 

									</textarea>
									

									<br>

									




								  <button id="submit">저장 하기</button>
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
			<script src="${contextPath}/resources/donation/registJs/formScript3.js"></script>


</body>
</html>