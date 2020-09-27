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
  
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="https://raw.githubusercontent.com/anseki/eager-image-loader/master/eager-image-loader.min.js"></script> 
  

    <style>
    
    #title {
  background-color: #ff4c68;
}
.title_message {
  margin-top: 9rem;
  margin-bottom: 4rem;
  font-family: "Montserrat-Black";
  font-size: 3.5rem;
  line-height: 1.5;
  font-weight: 900;
  color: white;
}
.container-fluid {
  padding: 3% 15% 12%;
}
.navbar {
  font-size: 1.5rem;
  padding: 0%;
}
.navbar-brand {
  font-size: 3.2rem;
  font-weight: 700;
  padding: 0%;
}
.nav-item {
  margin-right: 24%;
}
.tindog-img {
  margin-top: 6rem;
  transform: Rotate(25deg);
  position: absolute;
}
.introduce-tindog {
  height: 20rem;
  align-content: center;
  text-align: center;
}
.introduce-tindog i {
  font-size: 3rem !important;
  margin-bottom: 1rem;
  color: #ff4c68;
  opacity: 0.8;
}
.introduce-tindog i:hover {
  opacity: 1;
}

#testimonials {
  text-align: center;
  background-color: #ef8172;
  color: #fff;
}

.testimonial-image {
  width: 10%;
  border-radius: 100%;
  margin: 2%;
}

#press {
  background-color: #ef8172;
  text-align: center;
}

.press-logo {
  width: 15%;
  margin: 20px 20px 50px;
}

.carousel-item {
  padding: 7% 15%;
}

.pricing-column {
  padding: 3% 2%;
}

#pricing {
  padding: 100px;
  text-align: center;
}

#features {
  padding: 7% 15%;
  background-color: #fff;
  position: relative;
  z-index: 1;
}

@media (max-width: 1028px) {
  #title {
    text-align: center;
  }

  .tindog-img {
    position: static;
    transform: rotate(0);
  }
}
    
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
        width: 100px;
        height: 100px;
        
        
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
        
        font-size: 180%
      }
      
      
      
      
      .card{
      
   cursor: pointer;
      	
      }
	
	
	
@keyframes ldio-fh2riys9cfu {
    0%    { transform: translate(2px,2px) }
   33.33% { transform: translate(102px,2px) }
   66.66% { transform: translate(42px,102px) }
  100%    { transform: translate(2px,2px) }
}


.ldio-fh2riys9cfu > div {
  transform: scale(0.8);
  transform-origin: 100px 100px;
}

.ldio-fh2riys9cfu > div > div {
  animation: ldio-fh2riys9cfu 1s linear infinite;
  position: absolute
}

.ldio-fh2riys9cfu > div > div div:nth-child(1) {
  width: 72px;
  height: 72px;
  border-radius: 50%;
  border: 12px solid #e90c59;
  background: #46dff0
}

.ldio-fh2riys9cfu > div > div div:nth-child(2) {
  width: 17px;
  height:  51px;
  transform: rotate(-45deg);
  background: #e90c59;
  border-radius: 0 0 8px 8px;
  position: absolute;
  top: 68px;
  left: 85px
}
.loadingio-spinner-magnify-6i1erl5311d {
  width: 200px;
  height: 200px;
  display: inline-block;
  overflow: hidden;
  background: #ffffff;
}
.ldio-fh2riys9cfu {
  width: 100%;
  height: 100%;
  position: relative;
  transform: translateZ(0) scale(1);
  backface-visibility: hidden;
  transform-origin: 0 0; /* see note above */

  
}
.ldio-fh2riys9cfu div { box-sizing: content-box; }
/* generated by https://loading.io/ */



 #searchBtn{
   cursor: pointer;
 }
 
.card-deck{

	margin-top : 2%
}


.imageSize{

width:100%;
height: 500px !important;
}

.carouselExampleControls{
height: 500px !important;
}

.row{
  line-height: 120%;
}

em{
  margin-left: 60%;
}

.carousel-item{
  height: 50%;
  width: 100%;
}

.bababa{

	font-size: 250% !important;
}


    </style>

  
  </head>
  <body>
  
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
    <div class="container">
      
    </div>

     <section id="testimonials">
      <div
        id="carouselExampleControls"
        class="carousel slide"
        data-ride="carousel"
      >
      
        <div class="carousel-inner" style=" width:100%; height: 500px !important;">
          
          <div class="carousel-item active">
            
            <h2 class="navbar-brand bababa">
              
              <div class="row">
             
                
                <div class="col-lg-12 col-sm-12">
                 저희 강아지는 몸이 연약했어요.
                </div>
                <div class="col-lg-12 col-sm-12">하지만 헬프주에서 강아지 운동기구를 구입하자, 훨씬 건강해졌어요.</div>
                <div class="col-lg-12">헬프 주 , 정말 추천드려요. </div>
              </div>
            </h2>
            <img
            class="testimonial-image"
            src="${contextPath}/resources/images/images.jpg"
            alt="dog-profile"
          />
            <em>부산, 해수욕장 김이삭</em>
          </div>
          <div class="carousel-item">
            <h2 class="navbar-brand bababa">
              <div class="row">
                <div class="col-lg-12 col-sm-12">
                 저는 항상 주인님의 음식을 뺏어먹고 싶었어요.
                </div>
                <div class="col-lg-12 col-sm-12">
                 하지만 헬프주를 만나고, 주인님이 제 간식을 뺏어먹으려 해요.
                </div>
                <div class="col-lg-12">제가 만나본 가장 맛있고 건강한 간식이에요.</div>
              </div>
            </h2>
            <img
              class="testimonial-image"
              src="${contextPath}/resources/images/dodo5.jpg"
              alt="dog-profile"
            />
            <em>김멍멍, 서울 강동구</em>
          </div>
          <div class="carousel-item">
            <h2 class="navbar-brand bababa">
              <div class="row">
                <div class="col-lg-12 col-sm-12">
                  제 애인이 추천해줘서 이용해 봤어요.
                </div>
                <div class="col-lg-12 col-sm-12">그때 산 장난감 으로 오늘도 신나게 놀았어요.</div>
                <div class="col-lg-12">헬프주 덕분에 오늘도 행복해요.</div>
              </div>
            </h2>
            <img
              class="testimonial-image"
              src="${contextPath}/resources/images/웰시코기.jpg"
              alt="dog-profile"
            />
            <em>경기도 인천, 김웰시</em>
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

      
    </section>












    <div class="img-container container category-wrap">
      <div class="row">
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/dodo5.jpg" class="circleImg" />
          <div class="category-context">전체보기</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2 ">
          <img src="${contextPath}/resources/images/사료.jpg" class="circleImg" />
          <div class="category-context">사료</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/장난감.jpg" class="circleImg" />
          <div class="category-context">장난감</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/옷.jpg" class="circleImg" />
          <div class="category-context">옷</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/간식.jpg" class="circleImg" />
          <div class="category-context">간식</div>
        </div>
        <div class="col-lg-2 col-sm-2 col-md-2">
          <img src="${contextPath}/resources/images/기타.jpg" class="circleImg" />
          <div class="category-context">기타</div>
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

          <i class="fas fa-search search_all" id="searchBtn"></i> &nbsp;
          <input type="text" name="sVal" class="form-control" style="width:25%; display: inline-block;">
          &nbsp; &nbsp; &nbsp; 

          
          





          <select name="sKey2" class="form-control" style="width:100px; display: inline-block;">
          	  <option value="time">최신순</option>
              <option value="readCount">인기순</option>
              <option value="totalAmount">모금액순</option>
              <option value="endDay">마감임박순</option>
          </select>

        </span>
      </div>
      <br />

      <hr />
    </div>
    

   
  



                  
                  
                  <c:forEach var="funding"  varStatus="status" items="${fundingList}">
                    
                    <c:if test="${status.index %3 eq 0}">
                      <div class='card-deck'>
                      </c:if>

      <div class='card' >
		
		<input type="hidden" value="${funding.fundingNo}">
	
        <c:set var="src" value="${contextPath}/resources/uploadImages/${funding.fileChangeName}"/>
        <img src="${src}" class='card-img-top' alt='...'>

      <div class='card-body'>

        <h5 class='card-title'>
        ${funding.fundingTitle}
          </h5>

          <p class='card-text'>

            ${funding.fundingSummary}
          </p>
          <small class='text-muted' >
          
      카테고리 :       ${funding.category} <br>

          </small>
          <small class='text-muted'>
            달성률 : ${funding.achievementRate}% &nbsp;&nbsp;
          </small>

          <small class='text-muted'>

       합계금액 :        ${funding.totalOrderAmount}

          </small>


        </div>
      </div>

      <c:if test="${status.index %3 eq 2}">
    </div>
        </c:if>




    </c:forEach>








	  <%-- 검색 파라미터가 포함된 url 생성작업 --%> 
	      <c:url var="searchParameter" value="${pInfo.boardType}">
	      	<c:if test="${!empty paramValues.ct }">
	      		<c:forEach var="ctName" items="${paramValues.ct}">
	      			<c:param name="ct" value="${ctName}"/>
	      		</c:forEach>
	      	</c:if>
	      	
	      	<c:if test="${!empty param.sVal }">
	      		<c:param name="sKey" value="${param.sKey}"/>
	      		<c:param name="sVal" value="${param.sVal}"/>
	      	</c:if>
	      	
	      
	      </c:url>
	      
	     <%--------- 검색 파라미터가 있을 경우 / 없을 경우 url 가공  -----------%>
	    <!--  검색 파라미터가 있을 경우 : search/1?ct=운동&ct=영화&sKey=tit&sVal=test&cp=2
	     검색 파라미터가 없는 경우 : list/1?cp=2
	   -->   
	    <c:choose>
	    	<%-- 검색 조건이 존재하는 경우(파라미터 cp가 쿼리스트링 제일 마지막에 추가될 수 있도록 '&' 기호 추가.) --%>
	    	<c:when test="${!empty paramValues.ct || !empty param.sVal}">
	    		<c:set var="url" value="&cp="/>
	    		<c:set var="listUrl" value="../search/${url}${pInfo.currentPage}" scope="session"/>

	    	</c:when>
	   
	   		<%-- 검색 조건이 존재하지 않는 경우 (파라미터 cp가 쿼리스트링 제일 앞에 추가될 수 있도록 '?' 기호 추가 --%>
	   		<c:otherwise>
	   			<c:set var="url" value="?cp="/>	
				<c:set var="listUrl" value="../selectList/${url}${pInfo.currentPage}" scope="session"/>
					   		
	   		</c:otherwise>
	   
	    
	    </c:choose>
	    
	    
	     
	     
	     
	     
	     
	     
		<div class="my-4">
            <ul class="pagination">
            	<c:if test="${pInfo.currentPage > pInfo.pagingBarSize}">	
            		
            		
	                <li>
	                	<!-- 맨 처음으로(<<) -->
	                    <a class="page-link text-primary" href="${url}1">&lt;&lt;</a>
	                </li>
	                
	                <li>	
	                	<!-- 이전으로(<) -->
	                	<!--  prev 생성 식 : 현제페이지 -1 / 페이징바 사이즈(10) * 10 -->
	                	<!--  fmt 태그를 이용한 소수점 제거 -->
	                	<fmt:parseNumber var="operand1" value="${(pInfo.currentPage-1)/pInfo.pagingBarSize}" integerOnly="true"/>
	               		
	               		<c:set var ="prev" value="${operand1 * 10 }"/>
	               	
	              
                   		<a class="page-link text-primary" href="${url}${prev}">&lt;</a>
	                </li>
                </c:if>
                
                <c:forEach var="p" begin="${pInfo.startPage}" end="${pInfo.endPage}">
                
                	<c:choose>
                		<c:when test="${p==pInfo.currentPage}">
                			<li><a class="page-link">${p}</a></li>
                			</c:when>
                			
                			<c:otherwise>
	                		<li>
	                			<a class="page-link text-primary" href="?cp=${p}">${p}</a>
		                	</li>
		                	</c:otherwise>
		            </c:choose>	
                </c:forEach>
                
                
                <!-- 다음 페이지로(>) -->
                <!--  next 생성 식 : (현재 페이지 + (pInfo.pagingBarSize-1) ) /10 * 10 + 1  -->
                <c:if test="${pInfo.maxPage > pInfo.endPage}">
                
               
	                <li>
	                <fmt:parseNumber var="operand2" value="${(pInfo.currentPage +(pInfo.pagingBarSize-1))/10 }" integerOnly="true"/>
                	<c:set var="next" value="${operand2 * 10 + 1}"/>
            
						<a class="page-link text-primary" href="${url}${next}">&gt;</a>
	                </li>
	                
	                <!-- 맨 끝으로(>>) -->
	                <li>
	                    <a class="page-link text-primary" href="${url}${pInfo.maxPage}">&gt;&gt;</a>
	                </li>
	            </c:if>
	                
	                
                
            </ul>
        </div>	








    </div>


	
	
	<script>
	
	
	
	
	 $(".card").click(function(){

	        var a =  $(this).children().first().val();
	        
	       
	        
	        var url = "${contextPath}/funding/fundingView/"+a;
	        
	        
	        location.href = url;
	        
	        
	        
	        

	     });
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		//-------------------------------------------         검색버튼 동작                       -------------------------------------------------
		
		$("#searchBtn").on("click", function(){
			// 검색 값에 따라 url을 조합하여 저장할 변수
			var searchUrl = "";
			
			
			// 검색에 필요한 요소 (카테고리, 검색 조건, 검색어)
			var $ct = $("input[name='ct']:checked");
			var $sKey = $("select[name='sKey']");
			var $sVal = $("input[name='sVal']");
			
			// 1) 검색에 필요한 카테고리 또는 검색어가 입력되었는지 확인
			// - 입력이 되지 않은 경우 -> 해당 게시판 첫 페이지로 돌아가는 url 생성
			// - 하나라도 입력된 경우 -> 검색 url 생성 (쿼리스트링 조합 작업 필요)
		
			
			
			
			
			
			// 선택한 카테고리의 개수가 0이고, 입력된 검색어의 길이가 0인 경우
			// == 카테고리 체크 X, 검색어 입력 X 상태로 검색버튼을 클릭한 경우
			// -> 해당 게시판의 첫 페이지로 이동
			if($ct.length == 0 && $sVal.val().trim().length == 0){
				searchUrl = "";
				
			}
			// 카테고리가 체크 되었거나 검색어가 입력된 경우. 또는 둘 다.
			else{
				searchUrl = "../search?"
			
				// 카테고리가 체크된 경우
				if($ct.length != 0){
					// $ct 배열에 반복 접근 하여 쿼리스트링에 추가
					$ct.each(function(index, item){
						// ct=운동&ct=영화
						if(index!=0){ searchUrl +="&";}
						searchUrl += "ct=" + $(item).val();
						
					});
					
					// 카테고리 반복 접근이 끝난 후
					// 검색어가 있을 경우 쿼리스트링을 이어서 작성할 수 있도록 '&' 기호 추가
					if($sVal.val().trim().length!= 0) searchUrl += "&";
					
					
				}
				
				if($sVal.val().trim().length != 0){
					searchUrl += "sKey=" + $sKey.val() + "&sVal=" + $sVal.val();
				}
				
				
				
			}
				
			// 데이터 형태 확인
			
			console.log($ct.val())
			console.log($sKey.val())
			console.log($sVal.val())
			
			
			// 2) location.href를 통해 검색 요청 전달
			location.href = searchUrl;	
		
		
		});


    $("#searchBtn").hover().css('cursor', 'Pointer')
		
		
		
		
		
		// -------------------------------- 검색 값 유지 --------------------------------------------
		$(function(){
			
			var sKey = "${param.sKey}";
			var sVal = "${param.sVal}";
			
			// EL 구문에서 값이 없을 경우 ""(빈문자열)이 반환됨
			
			if(sKey != "" && sVal != "") {
				// 검색어 세팅
				$("input[name='sVal']").val(sVal);
				
				// 검색 조건 세팅
				$("select[name='sKey'] > option").each(function(index, item){
					if($(item).val() == sKey){
						$(item).prop("selected", true);
						
					}
				});
				
			}
			
			// 카테고리(체크박스) 값 세팅
			// script 태그 내에 EL/JSTL 사용하기
			
			// HTML, JS, jQuery, Scriptlet(Java), EL/JSTL
			// 서버 동작 지 JSP 파일 코드 해석 순서
			// 1) Java , 2) EL/JSTL , 3) HTML , 4)JS/jQuery
			
			// EL/JSTL 구문은 JS/jQuery 보다 해석이 빠르므로
			// JS구문 내에 EL/JSTL 구문을 작성하여 혼용할 수 있다.
			<c:forEach var="ctName" items="${paramValues.ct}">
				$("input[name='ct']").each(function(index, item){
					
					if($(item).val() == "${ctName}"){
						$(item).prop("checked",true);
					}
					
					
				});
			</c:forEach>
			
			
			
		});
		
		
		
		
		
		
		
		
		
		//--------------------------- 검색창 엔터 이벤트 ----------------------------------
		
		$("input[name='sVal']").on("keyup", function(event){
			//console.log(event.keyCode); // 키업 이벤트가 발생할 경우 입력한 키코드가 출력됨.
			
			if(event.keyCode == 13) {
				$("#searchBtn").click(); // 검색 버튼 클릭
			}
			
		});
		
	
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	</script>
											
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

  </body>
</html>