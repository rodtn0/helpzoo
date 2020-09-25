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
	
	/* .card{
		width : 100%;
		height : 300px;
	} */
	
	#imgBlock{
		margin : 0px 0px 30px 15px; 
	}
	
	#btnBlock{
		margin : 0px 0px 20px 0px;
	}
	
	#pNo, #pTitle{
		text-align : center;
	}
	
	

	

</style>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
	
	<form action="../writeViewAction/2" method="post" role="form"
		encType="multipart/form-data" onsubmit="return validate();">
		
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3>기부 후기 작성</h3>
				<hr>
			</div>
		</div>
		
			<div class="row">
				<div class="col-md-8">
					<input id="reviewTitle" name="reviewTitle" type="text" placeholder="제목을 입력해주세요.">
					
					<div id="contentDiv">
						<textarea id="reviewContent" name="reviewContent" placeholder="내용을 입력해주세요." cols="100"></textarea>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
							
								<select id="selectProject" name="projectNo" onchange="selectProejct(this);">
									<option selected>리뷰할 프로젝트를 선택해주세요.</option>
									<c:if test="${!empty dInfo}">
										<c:forEach var="dInfo" items="${dInfo}">
											<option value="${dInfo.projectNo}">${dInfo.projectTitle}</option>
										</c:forEach>
									</c:if>  
									
								</select>
							<div class="card my-4" style="width:100%;">
							<h5 class="card-header">참여한 기부 프로젝트</h5>
							<div class="card-body">
							<div class="card">
								<img id="imgDiv" name="projectImg" class="card-img-top" />
								<div class="card-block">
									<h5 class="card-title" id="pNo" style="padding-top: 5px;">
										
									</h5>
									<h4 class="card-text" id="pTitle">
										
									</h4>
									<br>
									<!-- <p>
										<a class="btn btn-primary" href="#">Action</a>
									</p> -->
								</div>
							</div>
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
			
			<div class="row">
				<div class="col-md-8" id="imgBlock">
					<div class="row">
						<div class="col-md-3 boardImg" id="contentImgArea1">
							<img id="contentImg1" width="140" height="140"/>
						</div>
						<div class="col-md-3 boardImg" id="contentImgArea2">
							<img id="contentImg2" width="140" height="140"/>
						</div>
						<div class="col-md-3 boardImg" id="contentImgArea3">
							<img id="contentImg3" width="140" height="140"/>
						</div>
						<div class="col-md-3 boardImg" id="contentImgArea4">
							<img id="contentImg4" width="140" height="140"/>
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
							후기 올리기
						</button>
					</div>
				</div>
			</div>  
			
			
	
		</form>
</div>


<script>


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
		
		$("#contentImg1").on("click", function(){
			$("#img1").click();
		});
		$("#contentImg2").on("click", function(){
			$("#img2").click();
		});
		$("#contentImg3").on("click", function(){
			$("#img3").click();
		});
		$("#contentImg4").on("click", function(){
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