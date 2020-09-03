<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

	.container *{font-size: 13px;}
	.well {
	    min-height: 20px;
	    padding: 19px;
	    margin-bottom: 20px;
	    background-color: #f5f5f5;
	    border: 1px solid #e3e3e3;
	    border-radius: 4px;
	    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
	    box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
	}

	.btn{
	width: 70px;
    height: 30px;
    font-size: small !important;
	}
	
</style>
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../common/header.jsp"/>
<div class="container">

<div class="container pb-5 mb-5 mt-5">
			<div class="well" style="font-size: 30px;">
				<h1>질문과 답변 글쓰기</h1>
			</div>

			<hr>
			<form action="insertAction" method="post" role="form"
			encType="multipart/form-data" onsubmit="return validate();">

				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">제목</label> 
					<input type="text" class="form-control" id="title" name="qnaTitle" size="70"
					autocomplete="off" value ="${loginMember.memberId }님의 질문입니다." style= "height: 27px;"
					disabled>
				</div>

				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">작성자</label>
					<h5 class="my-0" id="writer">${loginMember.memberId}</h5>
				</div>


				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">작성일</label>
					<h5 class="my-0" id="today">
						<jsp:useBean id="now" class="java.util.Date" />
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
					</h5>
				</div>  

				<hr>

				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">업로드<br>이미지</label>
					<div class="mr-2 boardImg" id="contentImgArea1">
						<img id="contentImg1" width="150" height="150">
					</div>

					<div class="mr-2 boardImg" id="contentImgArea2">
						<img id="contentImg2" width="150" height="150">
					</div>

					<div class="mr-2 boardImg" id="contentImgArea3">
						<img id="contentImg3" width="150" height="150">
					</div>
				</div>


				<!-- 파일 업로드 하는 부분 -->
				<div id="fileArea">
					<!--  multiple 속성
						- input 요소 하나에 둘 이상의 값을 입력할 수 있음을 명시 (파일 여러개 선택 가능)
					 -->
					<!-- <input type="file" id="img1" name="thumbnail" onchange="LoadImg(this,1)">  -->
					<input type="file" id="img1" name="images" onchange="LoadImg(this,1)">
					<input type="file" id="img2" name="images" onchange="LoadImg(this,2)"> 
					<input type="file" id="img3" name="images" onchange="LoadImg(this,3)">
				</div>

				<div class="form-group">
					<div>
						<label for="content">내용</label>
					</div>
					<textarea class="form-control" id="content" name="qnaContent"
						rows="10" style="resize: none;"></textarea>
				</div>


				<hr class="mb-4">

				<div class="text-center">
					<button type="submit" class="btn btn-info"><i class="fas fa-file-signature"></i> 등록</button>
					<button type="reset" class="btn btn-info" href="${header.referer}"><i class="fas fa-window-close"></i> 취소</button>
					<%-- <a class="btn btn-primary float-right" href="${header.referer}">목록으로</a> --%>
				</div>

			</form>
		</div>

	</div>

	<jsp:include page="../common/footer.jsp"/>

	<script>

		// 유효성 검사
		function validate() {
			if ($("#title").val().trim().length == 0) {
				alert("제목을 입력해 주세요.");
				$("#title").focus();
				return false;
			}

			if ($("#content").val().trim().length == 0) {
				alert("내용을 입력해 주세요.");
				$("#content").focus();
				return false;
			}
		}
		
		 // 이미지 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
	    $(function () {
	      $("#fileArea").hide();

/* 	      $("#titleImgArea").click(function () {
	        $("#img1").click();
	      }); */
	      
	      $("#contentImgArea1").click(function () {
	        $("#img1").click();
	      });
	      $("#contentImgArea2").click(function () {
	        $("#img2").click();
	      });
	      $("#contentImgArea3").click(function () {
	        $("#img3").click();
	      });

	    });

	    // 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
	    function LoadImg(value, num) {
	      if (value.files && value.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) { // e: function (e)"은 이벤트 처리 기능
	        							// 이벤트시 오브젝트가 작성 됨. "e"는 객체 핸들러입니다
	          switch (num) {
	            case 1:
	              $("#contentImg1").attr("src", e.target.result);
	              				// e.target -> 이벤트가 발생한 요소 그 자체
	              break;
	            case 2:
	              $("#contentImg2").attr("src", e.target.result);
	              break;
	            case 3:
	              $("#contentImg3").attr("src", e.target.result);
	              break;
	          }
	        }
	        reader.readAsDataURL(value.files[0]);
	      }
	    }
		
	</script>
</body>
</html>