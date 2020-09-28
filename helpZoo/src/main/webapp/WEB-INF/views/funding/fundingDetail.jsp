<%@page import="com.project.helpzoo.funding.dto.fundingOpen.FundingDetailViewDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.sql.Timestamp"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>detail</title>

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
      .funding_item_logo {
        background-image: url("photographer.jpg");

        filter: blur(8px);
        -webkit-filter: blur(8px);
        width: 100%;

        height: 180px;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
      }

      .funding_item_text {
        color: white;
        font-weight: bold;
        position: absolute;
        top: 24%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 2;
        width: 80%;
        text-align: center;
      }
      .co {
        margin-top: 3%;
      }

      .funding_detail_container {
        margin-top: 1.5%;
        padding: 1% 13% 1%;
        color: #000;
        font-weight: bold;
      }

      .funding_thumnail {
        width: 400px;
      }
      .funding_detail_context_container {
        padding: 1% 8% 11%;
      }

      .project_info {
        background-color: #7fcdcd;
        font-weight: bold;
        opacity: 0.6;
      }
      .funding_btn{
        background-color: #7fcdcd;
        border: 1px solid white;
        
      }

      .div{
          display: block;
          margin-top: 7%;
      }
      
      
    </style>
  </head>
  <body>
  <c:set var="endDay" value="${funding.endDay }" />

  
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
  
  <%
  
  
 FundingDetailViewDto dto = (FundingDetailViewDto)request.getAttribute("funding");
  
 Timestamp t1 = new Timestamp(System.currentTimeMillis());
 
  
 long nowTime = (dto.getEndDay().getTime() - t1.getTime() );
 
 long minute = (nowTime / 1000 ) /60 ; //minute
 long second = (nowTime / 1000 ) % 60 ; //second

 long day = nowTime/ (1000 * 60 * 60 * 24); // day
 
 long hour = nowTime/ (1000 * 60 * 60); //hour
 
 
	String displayTime = null;

 if(day>0){
	 displayTime = day + "일 ";
 }else if(hour>0){
	 displayTime = hour + "시간 ";
 }else {
	 displayTime = minute + "분" + second + "초";
 }
 
 
 
 %> 
  
  
    <div class="co">

      <img src="/helpZoo/resources/uploadImages/${funding.fileChangeName}" class="funding_item_logo" />


      <div class="funding_item_text">
        <p>${funding.category}</p>
        <h1> ${funding.fundingTitle}</h1>
      </div>
    </div>
    <hr />
    <div class="container funding_detail_container">
      <div class="row">
        <div class="col-lg-3 col-sm-3 col-md-3">스토리</div>
        <div class="col-lg-3 col-sm-3 col-md-3">펀딩안내</div>
        <div class="col-lg-3 col-sm-3 col-md-3">새소식</div>
        <div class="col-lg-3 col-sm-3 col-md-3">서포터</div>
      </div>
    </div>
    <hr />

    <div class="container funding_detail_context_container">
        <div class="row">
      <div class="col-lg-8 col-sm-8 col-md-8">

        <img src="/helpZoo/resources/uploadImages/${funding.fileChangeName}" class="funding_thumnail" />
 <br> <br> <br> <br> <br> <br> <br> <br>
        <br />
        <br />
       
       ${funding.fundingStroy}
       

        <div class="project_info">
     <small>     목표 금액 ${funding.goalAmount}원 펀딩기간 ${funding.startDay} &nbsp;&nbsp;~&nbsp;&nbsp;${funding.endDay} <br>100% 이상 모이면
          펀딩이 성공되는 프로젝트 이 프로젝트는 펀딩 마감일까지 목표 금액이
          100% 모이지 않으면 결제가 진행되지 않습니다.</small>
        </div>
      </div>
      <div class="col-lg-4 col-sm-4 col-md-4">
          
          
          
        <br>
        <h2>마감까지 <%=displayTime%> 일 남음.</h2>
        <br>
        <h3>${funding.achievementRate}%달성 </h3>
        <br>
        <h3>${funding.totalOrderAmount}원 펀딩 </h3>
        <br>
        
        <button type="button" class="btn btn-primary  col-md-12 col-sm-12 col-xs-12 btn-lg funding_btn">
            펀딩하기
         </button>

            <br>

      

          <br>
         <small>리워드 선택</small>


            <div class="rewardList">


            </div>

            

          <!--ajax로 동적로딩할 reward 들-->
       

         <!--ajax로 동적로딩할 reward 들-->
  







        </div>

    
    </div>
        </div>
    </div>

    <script>

    
    
    $(document)
	  .ajaxStart(function () {
	  })
	  .ajaxStop(function () {
	    
	    $(".rewardcard").click(function(){

	        
	        var url = "${contextPath}/fundingAttend/rewardChoice/"+${fundingNo};
	        
	        
	        location.href = url;
	        
	        
	        
	        

	     })
	    
	    
	  });
    
    
    
    
    
    
    
    
    
    
    
$(document).ready(function() {
		
		$.ajax({
			url:"${contextPath}/fundingApi/selectReward",
			dataType : "json",
            data :  { fundingNo : '${fundingNo}'},
			success : function(list) {
			
			$.each(list,function(index,item){
				
				
				console.log(item);
				
				
				var $card = $("<div class='card rewardcard' style='width: 18rem;'>");
                var $container = $("<div class='container'>");
                var $cardBody = $("<div class='card-body'>");
				var $cardText = $("<p class='card-text'>");

                var $price = $("<b class='div reward_price'>").html('<b>' +item.price + '</b> <small class="div"></small>');
                var $title = $("<b class='div reward_title'>").text(item.title);

                var $deliveryPrice = $("<small class='div delivery_price'>").html('<small class="div">배송비 <div></div>'+ item.deleveryPrice +  '</small>')
                var $deliveryDay = $("<small class='div delivery_day'>").html('<small class="div">리워드 발송 시작일<div></div>' + item.deliveryDay +  '</small> ')
                var $amount = $("<small class='reward_amount'>").text('제한수량' + item.rewardOriginAmount +'개  ' + '현재' + item.rewardAmount + '개 남음!');

                var $explain = $("<small class='div'>").text('한정수량으로 제공하는 리워드 입니다.')


                var $rewardList = $(".rewardList")

                $cardText.append($price, $title, $deliveryPrice, $deliveryDay, $amount, $explain);

                $container.append($cardText);

                $cardBody.append($container);

                $card.append($cardBody);

                $rewardList.append($card);

			
			
					
				
			});


			
				
				
			}, error : function(){
				console.log("ajax 통신 실패");
			}
				});
		
		
		
	});


    </script>

    
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
  </body>