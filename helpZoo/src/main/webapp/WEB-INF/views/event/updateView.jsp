<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                
                <label class="imagesLabel" data-aos="zoom-in">이미지</label><br>
                <div class="images">
	                
	                <div class="boardImg" id="titleImgArea">
	                    <img id="titleImg" class="contentImg" src="https://placehold.it/150/7fcdcd/ffffff/?text=Thumbnail">
	                    <button data-aos="zoom-in" class="deleteImg" type="button"><i class="fas fa-times"></i> 삭제</button>
	                </div>

	                <div class="boardImg" id="contentImgArea1">
	                    <img id="contentImg1" class="contentImg" src="https://placehold.it/150/7fcdcd/ffffff/?text=Image1">
	                    <button data-aos="zoom-in" class="deleteImg" type="button"><i class="fas fa-times"></i> 삭제</button>
	                </div>

	                <div class="boardImg" id="contentImgArea2">
	                    <img id="contentImg2" class="contentImg" src="https://placehold.it/150/7fcdcd/ffffff/?text=Image2">
	                    <button data-aos="zoom-in" class="deleteImg" type="button"><i class="fas fa-times"></i> 삭제</button>
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
		}
		
		// 이미지 클릭시 insert 창
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
		
		// 이미지 미리보기
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
				}
				
				reader.readAsDataURL(value.files[0]);
			}
		}
		
		// 이미지 삭제 기능
		
		let deleteImages = []; // 삭제될 이미지 담을 배열 선언
		
		for(let i=0; i<$('.deleteImg').length; i++){
			deleteImages.push(false);
		}
		
		// 이미지 삭제버튼 동작
		$('.deleteImg').on('click', function() {
			event.stopPropagation();
			
			console.log($(this).prev());
			let $el = $(this).prev();
			
			let $img = $("<img>", {id:$el.attr("id"),
									width:$el.css('width'),
									height:$el.css('height')});
			
			$el.remove();
			$(this).before($img);
			
			console.log($('.deleteImg').index(this));
			
			deleteImages[$('.deleteImg').index(this)] = true;
			console.log(deleteImages);
			
			$('#img' + ($('.deleteImg').index(this)+1)).val("");
			
		});
		
	
	</script>
</body>
</html>