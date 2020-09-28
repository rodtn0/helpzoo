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
      
      
    </style>
  </head>
  <body>
  
  
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
  
    <div class="container">
      <div class="d-flex justify-content-around">
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />



        <div class="div">
          &nbsp;&nbsp;&nbsp;리워드 <br />&nbsp;&nbsp;&nbsp;&nbsp;선택
        </div>
        <div class="div2"><br />결제 예약</div>
        <div class="div2"><br />소문 내기</div>
      </div>
      <div class="alert_funding">
        <h5>리워드 선택</h5>
        펀딩해주시는 금액에 따라 감사의 의미로 리워드를 제공해 드립니다.
        <div class="float-right">
          <small>
            <i class="fas fa-info-circle"></i>펀딩하기는 쇼핑하기가 아닙니다!
            자세히 알아보세요.</small
          >
        </div>


        <form action="${contextPath}/fundingAttend/pay/${fundingNo}" method="POST">
        <c:forEach var="item" items="${rewardList}">


        <div class="card text-center bmi">
          <div class="card-header">
            <input type="checkbox" class="float-left littlebig" data-price="${item.price}" data-id="${item.id}" data-title="${item.title}"/> ${item.price}원
            펀딩합니다.
          </div>
          <div class="card-body">
            <h5 class="card-title">
              
              <c:choose>

          <c:when test="${item.seq eq 1}"> <c:set var="bird" value="얼리버드"/>  </c:when>

          <c:when test="${item.seq eq 2}"><c:set var="bird" value="슈퍼버드"/> </c:when>

          <c:when test="${item.seq eq 3}"> <c:set var="bird" value="울트라버드"/> </c:when>

          <c:when test="${item.seq eq 4}"> <c:set var="bird" value="울트라오메가버드"/> </c:when>

           </c:choose>



              ${bird} ${item.title} (${item.rewardAmount}개 남음)
           
           
            </h5>
            <p class="card-text small">
              ${item.content}
              <br />
            </p>
            ${item.deleveryPrice} | 리워드 제공 예상일 : ${item.deliveryDay} 예정
            
            
              <div class="size_size">
                수량 : 
                <input type="hidden" value="${item.id}" name="id">
                <input type="hidden" value="${item.title}" name="title">
                <input type="hidden" value="${item.price}" name="price">
                <input type="number" class="form-control form-control-sm d-flex justify-content-center" id="colFormLabelSm" name="amount">
                <br>
            </div>
            
            
          </div>
        </div>


      </c:forEach>








        </div>



        <br><br>
        <br>
        <div class="d-flex justify-content-around">
        [차세대 유산균]포스트 바이오틱스 반려동물 유산균 POST TRUST+에 <span class="final_amount"></span> 원을 펀딩합니다.

      </div>

      


      <br>

  <button
      type="submit"
      class="btn btn-primary col-md-4 col-sm-4 col-xs-4 btn-lg funding_btn mintclick "

    

    > 다음단계로</button>


    </form>
      </div>


    </div>

    
    
    
    
    <script>

      var final_amount = $(".final_amount");


        $('.littlebig').change(function(){

          price = $(this).data("price");
          
          
          if($(this).prop("checked")){

            $(this).parent().parent().children().children().last("div").show();


            
            $(this).parent().parent().children().children().last("div").children().change(function(){

              console.log ($(this).val()*price);


             var beforeValue = $(".final_amount").text();

             $(".final_amount").text('');
             $(".final_amount").text(  $(".final_amount").text() + ($(this).val()*price)      );

              var totalPrice = $(this).val()*price;


            })

            

          





          }else{

            price = $(this).data("price");

            amount = $(this).parent().parent().children().children().last("div").children().val();



            $(".final_amount").text(  $(".final_amount").text() - (amount*price)      );
            
          var itemid =   $(this).data("id");


            $(".final_amount").data("id", itemid )



            $(this).parent().parent().children().children().last("div").hide();

            $(this).parent().parent().children().children().last("div").children().val("");

            
          }

        })






        function goToPay(){

          var finalAmount = $(".final_amount").text();

          location.href="${contextPath}/fundingAttend/pay/" + ${fundingNo}  +"/?finalAmount="  + finalAmount;

        }








    </script>

    
    
    
    
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    













  </body>
</html>
