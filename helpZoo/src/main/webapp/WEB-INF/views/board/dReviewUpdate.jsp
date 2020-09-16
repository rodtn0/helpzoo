<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부 후기 게시판</title>
</head>

<style>
	h3{
		padding : 30px 0px 0px 0px;
		color : black;
	}
	
	hr{
		color : black;
	}
	
	#reviewTitle{
		width : 100%;
		height : 40px;
		border : 1px solid #ebecef; 
		padding : 5px 10px 5px 10px;
		margin : 0px 0px 20px 0px;
	}
	
	
	#contentDiv{
		width : 100%;
		height : 400px;
		border : 1px solid #ebecef; 
		padding : 10px 10px 10px 10px;
	}
	
	#reviewContent{
	    width : 100%;
		height : 100%;
		padding : 10px 10px 10px 10px;
		resize : none;
		border : 1px solid #fff;
	}
	
	.card{
		width : 100%;
		height : 300px;
	}
	
	#imgBlock{
		margin : 0px 0px 30px 15px; 
	}
	
	#btnBlock{
		margin : 0px 0px 20px 0px;
	}
	
	#pNo, #pTitle{
		text-align : center;
	}

	#imgDiv{
			width : 200px;
			position : absolute;
			right : 0;
			left : 25%;
			top : 15%;
	}
	

</style>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
	
	<!-- http://localhost:8095/helpzoo/board/review/1/update/859 (수정 페이지)-->
	<!-- http://localhost:8095/helpzoo/board/review/1/updateAction/859 -->
	<form action="../updateAction/${dReviewView.reviewNo}?cp=${param.cp}" method="post" role="form"
		encType="multipart/form-data" onsubmit="return validate();">
		
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3>기부 후기 수정</h3>
				<hr>
			</div>
		</div>
		
			<div class="row">
				<div class="col-md-8">
					<input id="reviewTitle" name="reviewTitle" type="text" value="${dReviewView.reviewTitle}">
					
					<div id="contentDiv">
						<textarea id="reviewContent" name="reviewContent" cols="100">${dReviewView.reviewContent}</textarea>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
							<div class="card">
								<select id="selectProject" name="projectNo" onchange="selectProejct(this);">
									<c:if test="${!empty dInfo}">
										<c:set var="dInfo" value="${dInfo}"/>
											<option value="${dInfo.projectNo}" selected>${dInfo.projectTitle}</option>
									</c:if>  
									
								</select>
								
								<img id="imgDiv" name="projectImg" class="card-img-top" src="${contextPath}${dReviewView.filePath}/${dReviewView.fileChangeName}"/>
								<%-- <img id="imgDiv" class="card-img-top" alt="프로젝트 이미지가 존재하지않습니다." 
									<c:if test="${!empty fInfo[0].fileChangeName}">
									src="${contextPath}${fInfo[0].filePath}/${fInfo[0].fileChangeName}"}
									</c:if>/> --%>
								<div class="card-block">
									<h5 class="card-title" id="pNo">
										
									</h5>
									<h4 class="card-text" id="pTitle">
										
									</h4>
									<!-- <p>
										<a class="btn btn-primary" href="#">Action</a>
									</p> -->
								</div>
							</div>
					</div>
				</div>
			
			
			
			</div>
		
			<div class="row">
					<div class="col-md-8">
						<p>
						[이미지 첨부하기]
						</p>
						
					</div>
					<div class="col-md-4">
					</div>
				</div>
			</div>
			
			<!-- 기존 이미지를 서버에서 조회한 후
					레벨별로 이미지 출력에 필요한 src 경로를 담은 변수 4개를 생성할 예정.
				 -->
				<c:forEach var="at" items="${files}" varStatus="vs">
					<c:choose>
						<c:when test="${at.fileLevel == 0}">
							<c:set var="contentImgSrc1" value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
						</c:when>
						<c:when test="${at.fileLevel == 1}">
							<c:set var="contentImgSrc2" value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
						</c:when>
						<c:when test="${at.fileLevel == 2}">
							<c:set var="contentImgSrc3" value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
						</c:when>
						<c:when test="${at.fileLevel == 3}">
							<c:set var="contentImgSrc4" value="${contextPath}${at.filePath}/${at.fileChangeName}"/>
						</c:when>
					</c:choose>	
				</c:forEach>	
			
			<div class="row">
				<div class="col-md-8" id="imgBlock">
							<div class="row">
								<div class="col-md-3 boardImg" id="contentImgArea1">
									<img id="contentImg1" width="140" height="140" 
										<c:if test="${!empty contentImgSrc1}">src="${contentImgSrc1}"</c:if>/>
									<button type="button" class="deleteImg">삭제</button>
								</div>
								<div class="col-md-3 boardImg" id="contentImgArea2">
									<img id="contentImg2" width="140" height="140" 
										<c:if test="${!empty contentImgSrc2}">src="${contentImgSrc2}"</c:if>/>
									<button type="button" class="deleteImg">삭제</button>
								</div>
								<div class="col-md-3 boardImg" id="contentImgArea3">
									<img id="contentImg3" width="140" height="140"
										<c:if test="${!empty contentImgSrc3}">src="${contentImgSrc3}"</c:if>/>
									<button type="button" class="deleteImg">삭제</button>
								</div>
								<div class="col-md-3 boardImg" id="contentImgArea4">
									<img id="contentImg4" width="140" height="140"
										<c:if test="${!empty contentImgSrc4}">src="${contentImgSrc4}"</c:if>/>
									<button type="button" class="deleteImg">삭제</button>
								</div>
							</div>
				</div>
				
			</div>
			
				<div id="fileArea" class="col-md-3">
					<input type="file" id="img1" name="images" onchange="LoadImg(this, 1)">
					<input type="file" id="img2" name="images" onchange="LoadImg(this, 2)">
					<input type="file" id="img3" name="images" onchange="LoadImg(this, 3)">
					<input type="file" id="img4" name="images" onchange="LoadImg(this, 4)">
				</div>
				
		
			
			<div class="row">
				<div class="col-md-8">
					<div class="col-md-4" id="btnBlock">
						<button type="submit" class="btn btn-primary">
							수정 완료하기
						</button>
					</div>
				</div>
			</div>  
			
			
	
		</form>
</div>


<script>
	var deleteImages = []; //삭제될 이미지 정보를 담을 배열
	
	// 이미지 삭제 버튼의 수만큼 배열을 만들고 모두 false로 초기화
	for(var i=0 ; i<$(".deleteImg").length ; i++){
		deleteImages.push(false);
	}
	
	//이미지 삭제 버튼 동작
	$(".deleteImg").on("click", function(event){
		// event 매개변수 : 이벤트와 이벤트가 발생한 객체에 대한 모든 정보가 담겨있음.
		event.stopPropagation(); // 삭제버튼 -> 이미지 클릭 -> file태그 클릭 == 이벤트 버블링
								 // 이벤트 버블링을 멈춤(삭제)
		
		// img 태그 삭제 후 재생성
		//--------------------------------------
		// 현재 선택한 요소의 이전 요소 선택
		// console.log($(this).prev());
		var $el = $(this).prev();
		
		// 이미지 태그 삭제
		// img 태그의 src 속성을 제거 (x)
		// $el.removeAttr("src"); -> 이미지 영역은 남지만 이미지가 엑스박스로 뜸
		
		// 이미지 태그 자체를 삭제 시키고, 그 자리에 새로운 이미지 태그를 추가
		var $img = $("<img>", {id : $el.attr("id"), width : $el.css("width"), height : $el.css("height")});
		
		$el.remove();
		$(this).before($img); // before() : 이전 위치에 요소 삽입.
		
		// 삭제된 이미지의 인덱스와 일치하는 deleteImages 배열의 요소 값을 true로 변경
		console.log($(".deleteImg").index(this));
		// $(".deleteImg").index(this) : 
			//클래스가 deleteImg인 요소들 중 현재 요소(this)의 인덱스 순서를 반환 
			
		deleteImages[$(".deleteImg").index(this)] = true;
		console.log(deleteImages);
		
		// input type="file" 태그에 있는 value값 초기화
		$("#img"+($(".deleteImg").index(this) +1)).val("");
		// input type="file" 태그의 value 값은 readonly(읽기 전용)이므로
		// 파일 선택 버튼 시 나타나는 윈도우로만 값을 선택할 수 있음
		// --> 임의로 value 값을 수정하는 것은 불가능
		// 단, 초기화는 가능(jquery만)
	});
	
	

	 
	

	// 유효성 검사
	function validate() {
		if ($("#reviewTitle").val().trim().length == 0) {
			alert("제목을 입력해 주세요.");
			$("#reviewTitle").focus();
			return false;
		}
	
		if ($("#reviewContent").val().trim().length == 0) {
			alert("내용을 입력해 주세요.");
			$("#reviewContent").focus();
			return false;
		}
		
		// deleteImages 배열을 input 태그로 만들어 form 태그 내부에 추가하여
		// 서버로 데이터 전달
		for(var i=0; i<deleteImages.length ; i++){
			var $deleteImage = $("<input>", {type : "hidden", 
											 name : "deleteImages",
											 value : deleteImages[i]});
			// form태그 제일 마지막 자식으로 추가
			$("form").append($deleteImage);
			
		}
	}
	
	
	function selectProejct(element){
		var projectNo = $(element).val();
		//console.log(projectNo); 선택된 프로젝트 번호 찍어보기
		//console.log(${fInfo}); 가져와진 정보 모두 찍어보기
		
		//var fInfo = JSON.parse("${fInfo}");
		var dInfo = ${dInfo};
		for(var i=0 ; i<dInfo.length ; i++){
			if(dInfo[i].projectNo == projectNo){ // 위에 선언된 변수 projectNo와 반복했을때 i번째인 projectNo가 같다면
				//console.log(fInfo[i].filePath + "/" + fInfo[i].fileChangeName);
				var path = "${contextPath}"+dInfo[i].filePath + "/" + dInfo[i].fileChangeName;
				var pName = dInfo[i].projectTitle;
				var pNo = dInfo[i].projectNo;
				var mId = dInfo[i].memberId;
				console.log(path);
				console.log(pName);
				console.log(pNo);
				console.log(mId);
				
				$("#pNo").text(pNo);
				$("#pTitle").text(pName);
				
				// img태그의 src 가져오기
				//var imgSrc = $("#imgDiv").prop("src");
				//console.log(imgSrc);
				
				//var imgSrc2 = imgSrc.append(path);
				//console.log(imgSrc2);
				
				// 이미지 태그의 src경로를 imgSrc2로 바꿔줌
				$("#imgDiv").attr("src", path);
				
				break;
				
			}
		}
		
	}
	
	// 이미지 공간 눌렀을때 파일 첨부하는 창 뜨게하는 함수
	$(function(){
		$("#fileArea").hide();
		
		$("#contentImgArea1").on("click", function(){
			$("#img1").click();
		});
		$("#contentImgArea2").on("click", function(){
			$("#img2").click();
		});
		$("#contentImgArea3").on("click", function(){
			$("#img3").click();
		});
		$("#contentImgArea4").on("click", function(){
			$("#img4").click();
		});
	
	});
	
	// 첨부한 파일들 미리보기를 가능하게하는 함수
	function LoadImg(value, num){
		if (value.files && value.files[0]) {
	        var reader = new FileReader();

	        reader.onload = function (e) {
	          switch (num) {
	            case 1:
	              $("#contentImg1").attr("src", e.target.result);
	              break;
	            case 2:
	              $("#contentImg2").attr("src", e.target.result);
	              break;
	            case 3:
	              $("#contentImg3").attr("src", e.target.result);
	              break;
	            case 4:
	              $("#contentImg4").attr("src", e.target.result);
	              break;
	          }
	        }

	        reader.readAsDataURL(value.files[0]);
	      }
		
	} 
		
	
	
</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>