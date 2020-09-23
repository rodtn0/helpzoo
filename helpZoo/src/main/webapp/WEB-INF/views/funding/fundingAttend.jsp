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


        <c:forEach var="item" items="${rewardList}">


        <div class="card text-center bmi">
          <div class="card-header">
            <input type="checkbox" class="float-left littlebig" data-name="${item.price}" /> ${item.price}원
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
                수량 : <input type="number" class="form-control form-control-sm d-flex justify-content-center" id="colFormLabelSm" placeholder="col-form-label-sm">
                <br>
            </div>
            
            
          </div>
        </div>


      </c:forEach>






        <div class="card text-center lasttt">
          <div class="card-body">
            <h5 class="card-title">공개여부 (선택)</h5>
            <p class="card-text small">
              서포터 목록에 서포터 이름과 펀딩 금액이 공개됩니다. 조용히
              펀딩하고 싶으시다면, 비공개로 선택해주세요. 커뮤니티, 새소식 댓글
              작성 시에는 비공개 여부와 상관없이 펀딩 참여자 표시가 노출됩니다.
              <br />
            </p>
            <div class="checkboxSmallSize">
            <input type="checkbox" ><label class=>이름 비공개</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" ><label class=>펀딩금액 비공개</label>
            <br>
            <br>
            <hr>

            <div class="info_card float-left">

              
              이름/금액 공개 예시

              <br>
              <br>

              <svg class="smallicon" xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 50 50" viewBox="0 0 50 50"><path fill="#F06562" d="M40.3159,33.7859H9.6841l2.6864-8.1367c0.4089-1.2371,1.5683-2.0756,2.8675-2.0756h19.524
                c1.3044,0,2.4586,0.8385,2.8675,2.0756L40.3159,33.7859z"/><rect width="7.247" height="10.212" x="21.382" y="23.574" fill="#DFDFDF"/><path fill="#EF4C4A" d="M21.6159 23.7154c.0112-.0349.0296-.0678.042-.1024h-.9026c-.0405.0362-.0844.0651-.1246.1024-.9698.8932-1.8528 2.0723-3.2156 3.4913l2.0927 1.1535-2.2713 1.3679 2.9298 4.0578h3.2616l-1.8834-8.034C21.3863 25.073 21.4067 24.3636 21.6159 23.7154zM30.4921 28.3602l2.0978-1.1535c-1.3679-1.4139-2.2509-2.5981-3.2157-3.4913-.059-.0547-.1233-.0978-.183-.1503h-.8688c.019.0507.0452.0991.0617.1503.2144.6482.2348 1.3577.0715 2.0366l-1.8834 8.034h3.2616l2.9349-4.0578L30.4921 28.3602z"/><path fill="#EEC06E" d="M28.2658,17.8461v4.6996c0,1.9183-1.4178,3.4728-3.1676,3.4728h-0.1944
                c-1.7498,0-3.1677-1.5544-3.1677-3.4728v-4.6996H28.2658z"/><path fill="#FBD178" d="M32.9145,12.2163c0,0.6625-0.0569,1.3147-0.1605,1.941c-0.7402,4.3996-3.9286,7.7071-7.7537,7.7071
                s-7.0135-3.3075-7.7537-7.7071c-0.1035-0.6263-0.1605-1.2785-0.1605-1.941c0-2.6709,0.8903-5.0829,2.3292-6.8324
                c1.4337-1.7391,3.4058-2.8158,5.5849-2.8158s4.1512,1.0766,5.5849,2.8158C32.0242,7.1334,32.9145,9.5455,32.9145,12.2163z"/><path fill="#545554" d="M19.3028,4.0864c-0.2901-0.6367-0.1228-1.4229,0.314-1.9695s1.1043-0.8731,1.7896-1.0144
                S22.8,0.9892,23.4974,1.0461c1.1501,0.0937,2.2939,0.2639,3.4215,0.5091c1.1455,0.249,2.2833,0.579,3.3198,1.1266
                s1.9725,1.3255,2.5739,2.3317c0.7485,1.2522,0.932,2.7683,0.8698,4.2258c-0.0928,2.1759-0.7467,4.281-1.8082,6.1826
                c-0.1913-1.702-0.3827-3.4039-0.574-5.1059c-0.0686-0.6099-0.1461-1.2455-0.4845-1.7576
                c-0.3862-0.5844-1.0647-0.9212-1.7512-1.0606s-1.3943-0.1069-2.0948-0.1042c-1.3917,0.0054-2.7838-0.1097-4.1558-0.343
                c-0.9681-0.1646-2.277-0.6486-3.1003,0.1662c-0.3715,0.3677-0.4855,0.9149-0.5823,1.4285c-0.4233,2.2457-0.8467,4.4915-1.27,6.7372
                c-1.1777-2.4214-1.7167-5.1225-1.5116-7.8073c0.0645-0.8445,0.2084-1.7089,0.6513-2.4308
                C17.4438,4.4224,18.4578,4.0281,19.3028,4.0864z"/><path fill="#FBD178" d="M17.1116,12.8196c0.0236,0.454,0.0633,0.9034,0.1351,1.3377c0.7402,4.3997,3.9286,7.7071,7.7537,7.7071
                c3.8251,0,7.0136-3.3074,7.7538-7.7071c0.0718-0.4343,0.1115-0.8837,0.135-1.3377H17.1116z"/><ellipse cx="32.533" cy="12.773" fill="#FBD178" rx="1.625" ry="2.098"/><ellipse cx="17.469" cy="12.773" fill="#FBD178" rx="1.625" ry="2.098"/><path fill="#919191" d="M41.338,49.0004H8.662l-2.1497-2.6717c-0.2516-0.3127-0.029-0.7776,0.3724-0.7776h36.2306
                c0.4014,0,0.624,0.4649,0.3724,0.7776L41.338,49.0004z"/><path fill="#CCCBCB" d="M40.5102,28.6672H9.5607c-0.4767,0-0.8632,0.3864-0.8632,0.8632v19.47h32.6759v-19.47
                C41.3734,29.0536,40.9869,28.6672,40.5102,28.6672z"/><path fill="#919191" d="M25.0301,36.0234c-1.5349,0-2.8051,1.2703-2.8051,2.8051c0,1.5454,1.2702,2.8157,2.8051,2.8157
                c1.5455,0,2.8157-1.2703,2.8157-2.8157C27.8459,37.2936,26.5756,36.0234,25.0301,36.0234z"/></svg>

                홍길동님
                105,000원 참여하셨습니다

            </div>

            <div class="info_card float-left">

              이름/금액 비공개 예시
              <br>
              <br>
              <i class="far fa-user-circle"></i> 익명의 서포터
              펀딩으로 참여하셨습니다
          </div>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          
          </div>
          </div>
        </div>


        <div class="card text-center lasttt">
          <div class="card-body">
            <h5 class="card-title">후원금 더하기 (선택)</h5>
            <p class="card-text small">
              후원금을 더하여 펀딩할 수 있습니다. 추가 후원금을 입력하시겠습니까? 
              <br>
              <div class="row">
                <div class="col">
                  <input type="number" class="form-control" placeholder="0">
                </div>
                 <span class="add_Money"> 원을 추가로 후원합니다.</span>
              </div>
      


          
          </div>
          </div>
        </div>



        <br><br>
        <br>
        <div class="d-flex justify-content-around">
        [차세대 유산균]포스트 바이오틱스 반려동물 유산균 POST TRUST+에 <span class="final_amount"></span> 원을 펀딩합니다.

      </div>

      <br>

  <button
      type="button"
      class="btn btn-primary col-md-4 col-sm-4 col-xs-4 btn-lg funding_btn mintclick "
      onclick="goToPay()"

    > 다음단계로</button>

      </div>


    </div>

    
    
    
    
    <script>

      var final_amount = $(".final_amount");


        $('.littlebig').change(function(){

          price = $(this).data("name");
          
          
          if($(this).prop("checked")){

            $(this).parent().parent().children().children().last("div").show();


            
            $(this).parent().parent().children().children().last("div").children().change(function(){

              console.log ($(this).val()*price);


             var beforeValue = $(".final_amount").text();

             $(".final_amount").text('');
             $(".final_amount").text(  $(".final_amount").text() + ($(this).val()*price)      );

              var totalPrice = $(this).val()*price;


            })

            

            console.log($(this).data("name"));

            console.log($(this).parent().parent().children().children().last("div").children().val());
              
          





          }else{

            price = $(this).data("name");

            amount = $(this).parent().parent().children().children().last("div").children().val();



            $(".final_amount").text(  $(".final_amount").text() - (amount*price)      );
            



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
