<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.mailing{
		max-width: 800px;
		margin: auto;
	}
	
	.mail, .mailTitle, .mailContent, .submitBtn{
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<main class="mailing">
		
		<c:choose>
			<%-- 관리자 메일 전송 화면 --%>
			<c:when test="${loginMember.memberNo == 1}">
				<form method="post" action="sendMail">
					<div class="mail">
						<label>받는사람 이메일</label><br>
						<input type="email" name="email" size="60">
					</div>
					<div class="mailTitle">
						<label>이메일 제목</label><br>
						<input type="text" name="title" size="60">
					</div>
					<div class="mailContent">
						<label>이메일 내용</label><br>
						<textarea name="content" rows="20" cols="60"></textarea>
					</div>
					<div class="submitBtn">
						<button>메일 보내기</button>
					</div>
				</form>
			</c:when>
			
			<c:otherwise>
			<%-- 일반 사용자 구독 화면 --%>
				<p>
					<h1>HelpZoo</h1>
					<h2>${loginMember.memberName}님, 지금 구독을 신청해보세요!</h2>
					<h3>구독을 신청하고 고급정보를 빠르게 받아볼 수 있습니다.</h3>
					<h4>${loginMember.memberEmail}</h4>
				</p>
				
				<c:choose>
					<c:when test="${selMailing.mailStatus == 'Y'}">
						<div class="submitBtn">
							<button class="cancel">구독 취소하기</button>
						</div>
					</c:when>
					
					<c:when test="${selMailing.mailStatus == 'N'}">
						<div class="submitBtn">
							<button class="subscribe">구독하기</button>
						</div>
					</c:when>
					
					<c:otherwise>
						<form action="regSubscribe" method="post">
							<input type="number" name="memberNo" style="display:none" value="${loginMember.memberNo}">
							<input type="text" name="mailStatus" style="display:none" value="N">
							<div class="submitBtn">
								<button class="subscribe">구독하기</button>
							</div>
						</form>
					</c:otherwise>
				</c:choose>
				
			</c:otherwise>
		</c:choose>
		
	</main>

	<jsp:include page="../common/footer.jsp"/>
	
	<script>
	
	let mailing = {memberNo:"${selMailing.memberNo}",
				mailStatus:"${selMailing.mailStatus}"
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

					alert(result)
					
					location.reload();
					
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

					alert(result)
					
					location.reload();
					
				}, error : function() {
					console.log("ajax통신 실패");
				}
			});
		})		
	});
		
	</script>
</body>
</html>