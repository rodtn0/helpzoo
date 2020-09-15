<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/resources/css/noticeInsertView.css" rel="stylesheet"/>
<title>이벤트 수정</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div class="insertViewMain">
		
            <h3 class="noticeTitleH3" data-aos="fade-down">이벤트 수정</h3>
            
            <form class="insertViewForm" action="updateEvent?cp=${param.cp}" method="post"
            	encType="multipart/form-data" onsubmit="return validate();">
                
                <hr>

                <div>
                    <br>
                    <label class="titleLabel" for="title" data-aos="zoom-in">제목</label>
                    <input type="text" id="title" name="boardTitle" value="${board.boardTitle}">
                    <br>
                </div>
                
                <!-- 기존 이미지 배치 -->
                <c:forEach var="at" items="${files}" varStatus="vs">
                	<c:choose>
                		<c:when test="${at.fileLevel == 0}">
	                		<c:set var="titleImgSrc"
	                			value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
                		</c:when>

                		<c:when test="${at.fileLevel == 1}">
	                		<c:set var="contentImgSrc1"
	                			value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
                		</c:when>

                		<c:when test="${at.fileLevel == 2}">
	                		<c:set var="contentImgSrc2"
	                			value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
                		</c:when>

                	</c:choose>
                </c:forEach>
                
                
                <label class="imagesLabel" data-aos="zoom-in">이미지</label><br>
                <div class="images">
	                
	                <div class="boardImg" id="titleImgArea">
	                    <img id="titleImg" class="contentImg"
	                    	<c:choose>
	                    		<c:when test="${!empty titleImgSrc}">src="${titleImgSrc}"</c:when>
	                    		<c:otherwise>src="https://placehold.it/150/7fcdcd/ffffff/?text=Thumbnail"</c:otherwise>
	                    	</c:choose>>
	                    <button data-aos="zoom-in" class="deleteImg" type="button"><i class="fas fa-times"></i>삭제</button>
	                </div>

	                <div class="boardImg" id="contentImgArea1">
	                    <img id="contentImg1" class="contentImg"
	                    	<c:choose>
	                    		<c:when test="${!empty contentImgSrc1}">src="${contentImgSrc1}"</c:when>
	                    		<c:otherwise>src="https://placehold.it/150/7fcdcd/ffffff/?text=Image1"</c:otherwise>
	                    	</c:choose>>
	                    <button data-aos="zoom-in" class="deleteImg" type="button"><i class="fas fa-times"></i>삭제</button>
	                </div>

	                <div class="boardImg" id="contentImgArea2">
	                    <img id="contentImg2" class="contentImg"
	                    	<c:choose>
	                    		<c:when test="${!empty contentImgSrc2}">src="${contentImgSrc2}"</c:when>
	                    		<c:otherwise>src="https://placehold.it/150/7fcdcd/ffffff/?text=Image2"s</c:otherwise>
	                    	</c:choose>>
	                    <button data-aos="zoom-in" class="deleteImg" type="button"><i class="fas fa-times"></i>삭제</button>
	                </div>
                </div>
                
                <div id="fileArea">
                	<input type="file" id="img1" name="thumbnail" onchange="LoadImg(this,1)"> 
					<input type="file" id="img2" name="images" onchange="LoadImg(this,2)">
					<input type="file" id="img3" name="images" onchange="LoadImg(this,3)">
                </div>

                <div>
                    <br>
                    <label class="contentLabel" for="content" data-aos="fade-up">내용</label>
                    <textarea name="boardContent" id="content">${board.boardContent}</textarea>
                    <br>
                </div>


                <div class="btn">
                    <br>
                    <button data-aos="zoom-in" type="submit" class="insertBtn" id="insertBtn">수정</button>
                    <input type="button" data-aos="zoom-in" class="insertBtn" id="toListBtn" onclick="history.back()" value="취소">
                	<!-- <a data-aos="zoom-in" class="toListBtn" onclick="history.back()">목록으로</a> -->
                </div>

            </form>
        </div>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
	
		// 유효성 검사
		function validate() {
			
			if($('#title').val().trim().length == 0){
				alert("제목을 입력해 주세요.");
				$('#title').focus();
				return false;
			}
			
			if($('#content').val().trim().length == 0){
				alert("내용을 입력해 주세요.");
				$('#content').focus();
				return false;
			}
			
			// deleteImages 배열을 input태그로 만들어 form태그 내부에 추가하여
			// 서버로 데이터 전달
			for(let i=0; i<deleteImages.length; i++){
				let $deleteImage = $('<input>', {type:"hidden",
												name : "deleteImages",
												value : deleteImages[i]});
				// form 태그 제일 마지막 자식으로 추가
				$('form').append($deleteImage);
			}
			
		}
		
		// 이미지 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
		$(function() {
			$('#fileArea').hide();
			
			$('#titleImgArea').click(function() {
				$('#img1').click();
			});
			
			$('#contentImgArea1').click(function() {
				$('#img2').click();
			});
			
			$('#contentImgArea2').click(function() {
				$('#img3').click();
			});
		});
		
		// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
		function LoadImg(value, num) {
			if(value.files && value.files[0]){
				let reader = new FileReader();
				
				reader.onload = function(e) {
					switch (num) {
					case 1:
						$('#titleImg').attr('src', e.target.result);
						break;
					case 2:
						$('#contentImg1').attr('src', e.target.result);
						break;
					case 3:
						$('#contentImg2').attr('src', e.target.result);
						break;
					}
					
					// 이미지가 업로드 된 경우 삭제 이미지 목록(deleteImages)에서
			        // 해당 index값을 false로 변경
					deleteImages[num-1] = false;
					console.log(deleteImages);
					
				}
				
				reader.readAsDataURL(value.files[0]);
			}
		}
		
		// 이미지 삭제 기능
		
		let deleteImages = []; // 삭제될 이미지 담을 배열 선언
		
		// 이미지 삭제 버튼의 수 만큼 배열요소를 만들고 모두 false로 초기화
		for(let i=0; i<$('.deleteImg').length; i++){
			deleteImages.push(false);
		}
		
		// 이미지 삭제버튼 동작
		$('.deleteImg').on('click', function() {
			// event 매개변수 : 이벤트와 이벤트가 발생한 객체에 대한 모든 정보가 담겨있음.
			event.stopPropagation(); // 삭제버튼 -> 이미지 클릭 -> file태그 클릭 == 이벤트 버블링
									// 이벤트 버블링을 멈춤(삭제)
			
			// 현재 선택한 요소의 이전 요소 선택하기
			console.log($(this).prev());
			let $el = $(this).prev();
			
			// 이미지 태그 자체를 삭제시키고, 그 자리에 새로운 이미지 태그를 추가
			let $img = $("<img>", {id:$el.attr("id"),
									width:$el.css('width'),
									height:$el.css('height')});
			
			$el.remove();
			$(this).before($img); // before() : 이전 위치에 요소 삽입.
			
			console.log($('.deleteImg').index(this));
			
			deleteImages[$('.deleteImg').index(this)] = true;
			console.log(deleteImages);
			
			$('#img' + ($('.deleteImg').index(this)+1)).val("");
			
		});
		
	
	</script>
</body>
</html>