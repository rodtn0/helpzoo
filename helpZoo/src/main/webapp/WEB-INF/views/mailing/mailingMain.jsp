<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/mailing.css" rel="stylesheet" />
<title>도와zoo 구독하기</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<main class="board zoo">
		
		<!--  -->
		<div class="ui-header">
			<h1 data-aos="fade-down" class="title">구독하기</h1>
		</div>
		
		<!-- 공지 / 이벤트 / 구독메일 네비게이션 -->
		<div class="ui-tabs">
			<ul>
				<li><a href="${contextPath}/notice/noticeList">공지사항</a></li>
				<li><a href="${contextPath}/event/eventList">이벤트</a></li>
				<li class="active"><a href="${contextPath}/subscribe/mailing">구독하기</a></li>
			</ul>
		</div>
		
		<!-- 게시판 리스트 -->
		<div class="board-main">
			
			<div class="img">
				<img data-aos="fade-up" alt="" src="/helpzoo/resources/images/HelpZoo구독하기.png">
			</div>
		
			<c:choose>
				<%-- 관리자 메일 전송 화면 --%>
				<c:when test="${loginMember.memberNo == 1}">
				
					<form method="post" action="sendMail">
						<div class="mailTitle">
							<label data-aos="fade-up" data-aos-delay="100">메일 제목</label><br>
							<input type="text" name="title" size="60">
						</div>
						<div class="mailContent">
							<label data-aos="fade-up" data-aos-delay="200">메일 내용</label><br>
							<textarea name="content" rows="20" cols="60"></textarea>
						</div>
						<div class="submitBtn">
							<button class="sendBtn" data-aos="zoom-in">메일 보내기</button>
						</div>
					</form>
				</c:when>
				
				<%-- 일반 사용자 구독 화면 --%>
				<c:otherwise>
					<c:choose>
						<c:when test="${selMailing.mailStatus == 'Y'}">
							<div class="submitBtn">
								<a data-aos="zoom-in" class="cancel">구독 취소하기</a>
							</div>
						</c:when>
						
						<c:otherwise>
							<div class="submitBtn">
								<a data-aos="zoom-in" class="subscribe">구독하기</a>
							</div>
						</c:otherwise>
					</c:choose>
					
				</c:otherwise>
			</c:choose>
		
		</div>
		
	</main>

	<jsp:include page="../common/footer.jsp"/>
	
	<script>
	
	let mailing = {
			memberNo:"${loginMember.memberNo}"
		,	mailStatus:"${selMailing.mailStatus}"
	}
	
	console.log(mailing);
	
	// 구독하기
	$(function() {
		
		$('.subscribe').on('click', function() {
			
			$.ajax({
				url : "${contextPath}/subscribe/subscribeAction",
				data : mailing,
				type : "post",
				traditional : true,
				success : function(result) {
					
					if(result > 0){
						swal({
							icon : "success",
							title : "구독을 신청하셨습니다.",
							buttons:{
								confirm:{
									text:"OK",
									value : true
								}
							}
						}).then((result)=>{
							if(result){
								location.reload();
							}
						})
					}else{
						swal({
							icon : "error",
							title : "구독 신청에 실패했습니다.",
							buttons:{
								confirm:{
									text:"OK",
									value : true
								}
							}
						}).then((result)=>{
							if(result){
								location.reload();
							}
						})
					}
					
				}, error : function() {
					console.log("ajax통신 실패");
				}
				
			});
		})		
	});
	
	// 구독 취소하기
	$(function() {
		$('.cancel').on('click', function(selMailing) {
			
			$.ajax({
				url : "${contextPath}/subscribe/subscribeCancel",
				data : mailing,
				type : "post",
				success : function(result) {

					if(result > 0){
						swal({
							icon : "success",
							title : "구독을 취소하셨습니다.",
							buttons:{
								confirm:{
									text:"OK",
									value : true
								}
							}
						}).then((result)=>{
							if(result){
								location.reload();
							}
						})
					}else{
						swal({
							icon : "error",
							title : "구독 취소에 실패했습니다.",
							buttons:{
								confirm:{
									text:"OK",
									value : true
								}
							}
						}).then((result)=>{
							if(result){
								location.reload();
							}
						})
					}
					
					//location.reload();
					
				}, error : function() {
					console.log("ajax통신 실패");
				}
			});
		})		
	});
		
	</script>
</body>
</html>