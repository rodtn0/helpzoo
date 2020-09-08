<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>DowaZoo</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
      integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
      crossorigin="anonymous"
    ></script>

    <link
    rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
    integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
    crossorigin="anonymous"
  />

    <style>
      body {
        font-family: "IBMPlexSansKR-Text";
      }

      .funding-pageSelector {
        font-weight: bold;

        color: #666;
        font-size: 1.1rem;
      }

      @font-face {
        font-family: "IBMPlexSansKR-Text";
        src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Text.woff")
          format("woff");
        font-weight: normal;
        font-style: normal;
      }

      .carousel-item {
        height: 20rem;
        width: 100%;
      }

      .container {
      }
      .circleImg {
        border-radius: 50%;
      }
      .img-container {
        margin-top: 1.5%;
      }

      .category-wrap{
        text-align: center;
      }

      .category-context{
        margin-top: 6%;
        margin-left: 7%;
      }

      .search_all {
      }

      .select_all {
        
        font-size: 1.4rem;
        font-weight: bold;
      }

      .funding_menu{
        margin-top: 2%;
        margin-bottom: 2%;
      }

      .now{
        color: black;
      }


    </style>

  
  </head>
  <body>
  
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
    <div class="container">
      <div class="row funding-pageSelector">
        <div class="col-lg-2 col-sm-2 col-md-2 funding_menu"></div>

        <div class="col-lg-2 col-sm2 col-md-2 funding_menu"> <span class="now">펀딩 홈</span></div>
        <div class="col-lg-2 col-sm-2 col-md-2 funding_menu">카테고리</div>
        <div class="col-lg-2 col-sm-2 col-md-2 funding_menu">오픈예정</div>
        <div class="col-lg-2 col-sm-2 col-md-2 funding_menu">글로벌</div>

        <div class="col-lg-2 col-sm-2 col-md-2 funding_menu"></div>
      </div>
    </div>

    <div
      id="carouselExampleControls"
      class="carousel slide"
      data-ride="carousel"
    >
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="d-block w-100" alt="..." />
        </div>
        <div class="carousel-item">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="d-block w-100" alt="..." />
        </div>
        <div class="carousel-item">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="d-block w-100" alt="..." />
        </div>
      </div>
      <a
        class="carousel-control-prev"
        href="#carouselExampleControls"
        role="button"
        data-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a
        class="carousel-control-next"
        href="#carouselExampleControls"
        role="button"
        data-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>

    <div class="img-container container category-wrap">
      <div class="row">
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2 ">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
      </div>
    </div>

    <br />
    <br />





<script>







</script>





    <div class="container">
      <div class="sight_all">
        <span class="select_all">
        전체 보기
      </span>
        <div class="float-right"> 

          <i class="fas fa-search search_all"></i>
          &nbsp; &nbsp; &nbsp; 
          전체 
          &nbsp;
          <i class="fas fa-caret-down">
            &nbsp;&nbsp;

          </i> 추천순&nbsp;
          <i class="fas fa-caret-down"></i
          >
        </span>
      </div>
      <br />

      <hr />
    </div>
    
  
              
    <div class="card-deck">
      <div class="card">
        <img src="${contextPath}/resources/images/dodo5.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">도와주 도와주</h5>
          <p class="card-text">봄날의 피부가 청춘 것이다. 위하여, 남는 불러 군영과 장식하는 갑 보라. 열매를 있는 낙원을 아름다우냐? 주며, 물방아 용감하고 생명을 것은 말이다. 그들은 용감하고 뜨고, 발휘하기 넣는 안고, 얼음 청춘에서만 뿐이다. 우는 용기가 있으며, 몸이 품으며, 뛰노는 그들에게 보라. 뭇 할지라도 피가 과실이 무엇을 .</p>
          <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
      </div>
      
      
      <div class="card">
        <img src="${contextPath}/resources/images/dodo5.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">도와주 도와주</h5>
          <p class="card-text">봄날의 피부가 청춘 것이다. 위하여, 남는 불러 군영과 장식하는 갑 보라. 열매를 있는 낙원을 아름다우냐? 주며, 물방아 용감하고 생명을 것은 말이다. 그들은 용감하고 뜨고, 발휘하기 넣는 안고, 얼음 청춘에서만 뿐이다. 우는 용기가 있으며, 몸이 품으며, 뛰노는 그들에게 보라. 뭇 할지라도 피가 과실이 무엇을 심장의 오직 청춘 봄바</p>
          <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
      </div>
      
      
      
      <div class="card">
        <img src="${contextPath}/resources/images/dodo5.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">도와주 도와주</h5>
          <p class="card-text">봄날의 피부가 청춘 것이다. 위하여, 남는 불러 군영과 장식하는 갑 보라. 열매를 있는 낙원을 아름다우냐? 주며, 물방아 용감하고 생명을 것은 말이다. 그들은 용감하고 뜨고, 발휘하기 넣는 안고, 얼음 청춘에서만 뿐이다. 우는 용기가 있으며, 몸이 품으며, 뛰노는 그들에게 보라. 뭇 할지라도 피가 과실이 무엇을 .</p>
          <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        </div>
      </div>
    </div>
    
    
    <div id="cocoacard">
    
    </div>
    


	
	
	<script>

	
	$(document).ready(function() {
		
		$.ajax({
			url:"${contextPath}/fundingApi/selectList",
			dataType : "json",
			success : function(list) {
				console.log(list);
			
			$.each(list,function(index,item){
				
				var $cardDeck = $("<div class='card-deck'>"); // 행
				var $tempImg = $("<img src='${contextPath}/resources/images/dodo5.jpg' class='card-img-top' alt='...'>")
				var $card = $("<div class='card'>");
				var $cardBody = $("<div class='card-body'>")
				var $cardTitle = $("<h5 class='card-title'>").text(item.fundingTitle);
				var $cardStory = $("<p class='card-text'>").text(item.fundingSummary);
				var $cardSmallForm = $("<p class='card-text'>")
				var $cardSmallCategory = $("<small class='text-muted'>").text(item.category)
				var $cardSmallAchievement = $("<small class='text-muted'>").text("달성률 : " + item.achievementRate + "%")
				var $cardSmallOrderAmount = $("<small class='text-muted'>").text("총 참여금액 :  " + item.totalOrderAmount)
				
				
				$cardSmallForm.append($cardSmallCategory,$cardSmallAchievement,$cardSmallOrderAmount)
				
				$cardBody.append($cardTitle,$cardStory,$cardSmallForm)
				
				$card.append($tempImg,$cardBody);

					if(index%3 == 0){				
						$cardDeck.append($card);
					}
				
					
					
					
				$("#cocoacard").append($cardDeck)
				
				
			});
				
				
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
				});
		
		
		
	});

	
	
	
	</script>
	


   
   
   <ul id="list-guestbook">
    </ul>
   
   
<script type="text/javascript">
</script>
	
	
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

  </body>
</html>