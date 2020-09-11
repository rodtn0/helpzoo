<%@page import="com.project.helpzoo.funding.dto.FundingDetailViewDto"%>
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
        top: 17%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 2;
        width: 80%;
        text-align: center;
      }
      .co {
        margin-top: 2%;
      }

      .funding_detail_container {
        margin-top: 1.5%;
        padding: 0% 45% 0%;
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
    </style>
  </head>
  <body>
  <c:set var="endDay" value="${funding.endDay }" />

  
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
  
  <%
  
  
 FundingDetailViewDto dto = (FundingDetailViewDto)request.getAttribute("funding");
  
 Timestamp t1 = new Timestamp(System.currentTimeMillis());
 
  
 long nowTime = (t1.getTime() - dto.getEndDay().getTime());
 
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
      <img src="/helpZoo/resources/images/dodo5.jpg" class="funding_item_logo" />

      <div class="funding_item_text">
        <p>사료 / 식이용품</p>
        <h1>찹쌀같은 식감! 최고의 강아지 사료! 에어 코듀라 스페셜사료</h1>
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
        <img src="/helpZoo/resources/images/dodo5.jpg" class="funding_thumnail" />
        <br />
        <br />
       
       ${funding.fundingStroy}
       

        <div class="project_info">
          목표 금액 ${funding.goalAmount }원 펀딩기간 ${funding.startDay}-${funding.endDay}100% 이상 모이면
          펀딩이 성공되는 프로젝트 이 프로젝트는 펀딩 마감일까지 목표 금액이
          100% 모이지 않으면 결제가 진행되지 않습니다.
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
        <h3>391명의 서포터</h3>
        <br>
        
        <button type="button" class="btn btn-primary  col-md-12 col-sm-12 col-xs-12 btn-lg funding_btn">
            펀딩하기
         </button>

            <br>

         <button type="button" class="btn btn-primary">
            <i class="fas fa-heart"></i>      ${funding.like}
            </button>
            <button type="button" class="btn btn-primary">
                <i class="far fa-comment-dots"></i>  문의

           </button>
           <button type="button" class="btn btn-primary">

                    공유하기
           </button>

           <hr>
           <br>
           메이커 정보

           <div class="card" style="width: 18rem;">
            <img src="/helpZoo/resources/images/dodo5.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <p class="card-text">${funding.makerName }</p>
            </div>
          </div>


          <br>
         리워드 정보

          <div class="card" style="width: 18rem;">
           <img src="/helpZoo/resources/images/dodo5.jpg" class="card-img-top" alt="...">
           <div class="card-body">
             <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
           </div>
         </div>

         <br>
         메이커 정보

         <div class="card" style="width: 18rem;">
          <img src="/helpZoo/resources/images/dodo5.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
          </div>
        </div>




        </div>

    
    </div>
        </div>
    </div>
    
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
  </body>