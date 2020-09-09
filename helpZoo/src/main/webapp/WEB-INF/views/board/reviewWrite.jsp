<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩 후기 게시판</title>
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
	
	
	#reviewContent{
		width : 100%;
		height : 400px;
		border : 1px solid #ebecef; 
		padding : 10px 10px 10px 10px;
	}
	
	#reviewContent textarea{
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

	

</style>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3>펀딩 후기 게시판</h3>
				<hr>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-8">
				<input id="reviewTitle" type="text" placeholder="제목을 입력해주세요." >
				
				<div id="reviewContent">
					<textarea placeholder="내용을 입력해주세요." cols="100"></textarea>
				</div>
			</div>
			<div class="col-md-4">
				<div class="row">
						<div class="card">
							<img class="card-img-top" alt="Bootstrap Thumbnail First" src="https://www.layoutit.com/img/people-q-c-600-200-1.jpg" />
							<div class="card-block">
								<h5 class="card-title">
									펀딩 프로젝트
								</h5>
								<p class="card-text">
									프로젝트명
								</p>
								<p>
									<a class="btn btn-primary" href="#">Action</a>
								</p>
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
				<div class="col-md-3">
					<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
				</div>
				<div class="col-md-3">
					<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
				</div>
				<div class="col-md-3">
					<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
				</div>
				<div class="col-md-3">
					<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
				</div>
			</div>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-md-8">
			<div class="col-md-4" id="btnBlock">
				<a class="btn btn-primary" href="${contextPath}/board/writeView/1/upload">
					후기 올리기
				</a>
			</div>
		</div>
	</div>
	
	
</div>


<jsp:include page="../common/footer.jsp"/>
</body>
</html>