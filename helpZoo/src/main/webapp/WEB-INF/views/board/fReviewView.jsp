<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

	<style>
		#postImg{
			width : 300px;
			height : 300px;
		}
		
		#moveBtn{
			margin: 20px 0px 0px 125px;
			border : 1px #7fcdcd;
			background-color:  #7fcdcd;
		}
		
		.card{
			width : 100%;
		}
		
	
	</style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>펀딩 참여 후기 페이지</title>

  <c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>
  <!-- Bootstrap core CSS -->
  <link href="${contextPath}/resources/reviewViewCss/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${contextPath}/resources/reviewViewCss/css/blog-post.css" rel="stylesheet">

	
</head>

<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body style="padding-top : 0px;">
	<jsp:include page="../common/header.jsp"/>


  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <!-- Post Content Column -->
      <div class="col-lg-8">

        <!-- Title -->
        <h2 class="mt-4">${fReviewView.reviewTitle}</h2>

        <!-- Author -->
        <p class="lead">
          by
          <a>${fReviewView.memberId}</a>
        </p>

        <hr>

        <!-- Date/Time -->
        <p>작성일 : ${fReviewView.reviewCreateDate} / 수정일 : ${fReviewView.reviewModifyDate}</p>
        <p>조회수 : ${fReviewView.readCount}</p>

        <hr>

        <!-- 이미지 란 -->
        <c:if test="${!empty files}">
        	<div class="carousel slide m-3" id="carousel-325626">
	        	<c:forEach var="files" items="${files}">
	        		<c:set var="src" value="${contextPath}${files.filePath}/${files.fileChangeName}"/>
	        		<img id="postImg" class="img-fluid rounded" src="${src}" alt="">
				</c:forEach>
			</div>
		</c:if>
        <hr>

        <!-- Post Content -->

        <p style="height : 310px;">${fReviewView.reviewContent}</p>



        <!-- Comments Form -->
       <div class="card my-4" style="border-top-width: 0px;">
       
          <!-- <h5 class="card-header">Leave a Comment:</h5>
          <div class="card-body">
            <form>
              <div class="form-group">
                <textarea class="form-control" rows="3"></textarea>
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>
          </div> -->
        </div>

        <!-- Single Comment -->
        <div class="media mb-4">
          <!-- <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
          <div class="media-body">
            <h5 class="mt-0">Commenter Name</h5>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
          </div> -->
        </div>

       <!--  Comment with nested comments -->
        <div class="media mb-4">
         <!--  <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
          <div class="media-body">
            <h5 class="mt-0">Commenter Name</h5>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

            <div class="media mt-4">
              <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
              <div class="media-body">
                <h5 class="mt-0">Commenter Name</h5>
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
              </div>
            </div>

            <div class="media mt-4">
              <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
              <div class="media-body">
                <h5 class="mt-0">Commenter Name</h5>
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
              </div>
            </div>

          </div> -->
        </div>

      </div>

      <!-- Sidebar Widgets Column -->
      <div class="col-md-4">

        <!-- Search Widget -->
        <!-- <div class="card my-4">
          <h5 class="card-header">Search</h5>
          <div class="card-body">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-secondary" type="button">Go!</button>
              </span>
            </div>
          </div>
        </div> -->

        <!-- Categories Widget -->
        <div class="card my-4">
          <h5 class="card-header">참여한 펀딩 프로젝트</h5>
          <div class="card-body">
            <div class="row">
               	<div class="card">
               		<c:if test="${!empty fReviewView.filePath}">
	               		<c:set var="src" value="${contextPath}${fReviewView.filePath}/${fReviewView.fileChangeName}"/>
						<img class="card-img-top" alt="" src="${src}" />
					</c:if>
					
					<c:if test="${empty fReviewView.filePath}">
	               		<c:set var="src" value="${contextPath}/resources/uploadImages/NoImage.png"/>
						<img class="card-img-top" src="${src}" />
					</c:if>
					
					<br>
					
					<div class="card-block">
						<h5 class="card-title" style="text-align:center; font-family:Recipekorea;">
							${fReviewView.projectTitle}
						</h5>
						
						<p>
							<a class="btn btn-primary" href="${contextPath}/funding/fundingView/${fReviewView.projectNo}" id="moveBtn">이동하기</a>
						</p>
					</div>
				</div>
              
            </div>
          </div>
        </div>
        
        <div id="buttonArea">
        	<c:if test="${fReviewView.memberId == sessionScope.loginMember.memberId}">
        		<!-- http://localhost:8095/helpzoo/board/review/1/858?cp=1 -->
        		<!-- http://localhost:8095/helpzoo/board/review/1/update/${fReviewView.reviewNo}?cp=1-->
				<a class="btn btn-primary" href="update/${fReviewView.reviewNo}?cp=${param.cp}">수정</a>
				<button id="deleteBtn" class="btn btn-primary">삭제</button>
			</c:if>
						<!-- http://localhost:8095/helpzoo/board/review/1/881?cp=1 -->
						<!-- http://localhost:8095/helpzoo/board/review/1 -->
				<a class="btn btn-primary" href="../1" style="background-color:#7fcdcd; border:none;" >목록으로</a>
				<a class="btn btn-primary" id="likeBtn" style="background-color: pink; border:none;">도움이 됐어요 <i class="fas fa-heart"></i>&nbsp;&nbsp;</a>
		</div>


      </div>

    </div>
    <!-- /.row -->

  </div>
  
   <br><br>
  <!-- /.container -->

  <!-- Footer -->
  <!-- <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    /.container
  </footer> -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="../common/footer.jsp"/>
	
<script>
	$("#deleteBtn").on("click", function(){
		if(confirm("정말 삭제하시겠습니까?")){
			// http://localhost:8095/helpzoo/board/review/1/859?cp=1
			// http://localhost:8095/helpzoo/board/review/1/deleteReview/510
			location.href =	"deleteReview/${fReviewView.reviewNo}";	
		}
		
	});
	
	// 상세페이지 접속했을 때 
	$(function(){
		$.ajax({
		url: "../../likeReview/${fReviewView.reviewNo}",
		success : function(likeCount){
			$span = $("<span>");
			
			$span.text(likeCount);
			$("#likeBtn").append($span);      
			
		}, error : function(){
			console.log("ajax 통신 실패");
		}
	  });
	});
	
	// 클릭했을때 비동기로 숫자 카운트
	$("#likeBtn").on("click", function(){
		if(${sessionScope.loginMember.memberId == null}){
			swal({
				  icon: "success",
				  title : "로그인 후 이용하세요!"
				});
		}else{
			$.ajax({
				url: "../../likeCount/${fReviewView.reviewNo}",
				dataType : "json",
				success : function(result){
					
					
					var originNo = $("#likeBtn").children().text();
					
					$("#likeBtn").children().text(parseInt(originNo)+1);
					
					
				}, error : function(){
					//console.log("ajax 통신 실패");
					
					$.ajax({
						url : "../../likeDelete/${fReviewView.reviewNo}",
						dataType : "json",
						success : function(result){
							var originNo = $("#likeBtn").children().text();
							$("#likeBtn").children().text(parseInt(originNo)-1);
						}, error : function(){
							console.log("ajax 통신 실패");
						}
						
					});
				}
			});
		}
		
	});
</script>
</body>

</html>
