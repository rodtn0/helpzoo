<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
      .div {
        width: 5em;
        height: 5em;
        border-radius: 50%;
        background-color: #20b2aa;
        border: 4px solid #fff;
        box-shadow: 0 0 0 5px #20b2aa;
        color: white;
        font-size: 0.9rem;
        padding-top: 1.57%;
      }

      .div2 {
        width: 5em;
        height: 5em;
        border-radius: 50%;
        border: 4px solid #fff;
        box-shadow: 0 0 0 5px#20b2aa;
        font-size: 0.9rem;
        font-weight: bold;
      }

      .container {
        padding: 5% 7.8% 5%;
      }

      h5 {
        display: inline;
      }
      .alert_funding {
        font-size: 0.8rem;
      }
      .fa-info-circle {
        color: #20b2aa;
      }

      .bmi {
        /*my additional class name -for card*/
        margin-left: 18%;
        margin-right: 18%;
        width: auto;
        margin-top: 6%;
      }

      .small {
        font-size: 0.8rem;
      }
      .card-text {
        padding-top: 2%;
        padding-bottom: 2%;
      }

      .littlebig {
        -webkit-transform: scale(2); /* Safari and Chrome */
        color: #7fcdcd;
      }

      .lasttt {
        margin-top: 7%;
      }

      .checkboxSmallSize{
        -webkit-transform: scale(1.2);
      }

      .info_card{


        width: 160px;
        height: 100px;

        background-color: 			#E8E8E8;
        margin-left: 20%;
      }

      .fa-user-circle{
        -webkit-transform: scale(2); 
        padding-top: 10%;
      }
      .smallicon{

        width: 28px;

      }
      .col{
      }

      .add_Money{
        margin-top: 1%;
      }

      .mintclick{
        margin-left: 35%;
          background-color:  #20b2aa;
        border-color: white;
      }
      
       .size_size{
        width: 200px;

        display: none;
      }

      .fofofofo{
      margin-left: 40%;
      }
      
      
    </style>
  </head>
  <body>
  
  
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
 		
 		<h1 class="fofofofo"> 결제에 성공하였습니다.</h1>




        <div class="card text-center bmi">
          <div class="card-header">
          
        <c:forEach var="itemPrice" items="${orderRewardView.price}">
         ${itemPrice}원 <br>
           </c:forEach>
          </div>
          <div class="card-body">
            <h5 class="card-title">
              

		 <c:forEach var="itemRewardName" items="${orderRewardView.rewardName}">
         ${itemRewardName} <br>
           </c:forEach>

           <br>
           
           
           <c:forEach var="itemAmount" items="${orderRewardView.amount}">
         ${itemAmount}개 <br>
      		
           </c:forEach>
      
      
           
            </h5>
            
              <div class="size_size">
                <br>
            </div>
            
            
          </div>
        </div>






    

      <h5 class="fofofofo"> 총 ${orderRewardView.totalAmount} 원 결제에 성공하였습니다.</h5>



      <button onclick="location.href ='${contextPath}'">메인으로 돌아가기</button>



    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    






  </body>
</html>
