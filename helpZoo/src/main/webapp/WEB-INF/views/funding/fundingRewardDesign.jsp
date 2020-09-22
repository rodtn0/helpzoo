<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="Cache-Control" content="No-Cache"> 
<meta http-equiv="Pragma" content="No-Cache"> 
    <title>타이틀</title>

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
      .project_create_top_bar {
        position: fixed;
        border: 1px solid #f0f0f0;
        width: 100%;
            z-index: 2;
        background-color: white;
      }
      .span {
        position: fixed;
        left: 50%;
        transform: translate(-50%, 0);
        top: 2%;
      }

      .project_create_top_bar_choice {
        left: 86.5%;
        top: 2%;
      }

      .project_open_nav {
        padding-right: 0%;
        border: 1px solid #f0f0f0 ;
        overflow: auto;
        position: fixed;
        z-index: 2;
      }

      .funding_open_deail_container {
        padding-top: 3%;
      }

      .project_open_ready {
        padding-top: 3.1%;

        margin-left: 3.4%;

        color:  #808080;
      }

      .temp_box2{
        font-size: 1.3rem;
        border: 1px solid #f0f0f0;
        border-left-color: #008080;
        border-left-width: 0.3rem;
        padding: 2%;
        font-weight: bold;
        
      }

      .popoking{
          font-size: 1.3rem;
      }

      .btn-outline-primary{
        color: #00a0a0;
        border-color: #00a0a0;
        font-size: 0.95rem;
        
  border-radius:1em;
  -moz-border-radius: 1.5em;
  -webkit-border-radius: 1.5em;

      }
      .btn-outline-primary:hover{

        background-color: #00a0a0;
        border-color:#00a0a0;
        color: white;

      }
      
      .span *{
        color: 	#808080;
      }
      
      .project_create_top_bar_choice{
        color: #808080;
        line-height: 3.5rem;
        font-size: 0.9rem;
        
      }

      .title_msg{
        color: black;
      }

      .project_open_no_intro{
        background: linear-gradient(to bottom, #00cc99 0%, #009999 100%);
        color: white;
        margin-top: 2%;

        padding-bottom: 8%;
        padding-top: 10%;
        padding-left: 10%;
        padding-right: 0%;
      }

      .smallbox{
        border: 1px solid white;
      }
      .funding_ready{
        
        padding-left: 7%;
        padding-top: 6.75%;
        padding-bottom: 6.75%;
        color:    #808080;
        font-weight: bold;
        font-size: 0.85rem;
      }

      .myStep{
        text-decoration: underline;
      }

      .temp_box{
        border: 2px solid #f0f0f0 ;
        padding :2%;
        padding-left: 3.5%;
        color : #202020

      }
      .mintclick{
        background-color: #00a0a0 ;
        border-style: none;
        opacity: 0.6;
      }
      .mintclick:hover{


        opacity: 1;
        background-color: #00a0a0 ;
      }
      .black{
        color: black;
      }

      .star{
          color: red;
      }



      .form-check-input{
        -webkit-transform: scale(2);
        
      }
      .form-group{
          margin-top: 1%;
      }

      .temp_box{
        line-height: 200%;
      }


      .upload-btn-wrapper {
      position: relative;
      overflow: hidden;
      display: inline-block;
      margin-top: 1%;
      border: 2px solid gray;
      color: gray;
      background-color: white;
      padding: 8px 20px;
      border-radius: 8px;
      font-size: 20px;
      font-weight: bold;
      }
      .upload-btn-wrapper input[type=file] {
        font-size: 100px;
        position: absolute;
        left: 0;
        top: 0;
        opacity: 0;
        
      }

      
.btn {

}

.fa-plus-square{
  font-size: 1.5rem;
}





      .funding_ready_menubar:hover{

        cursor: pointer;


      }
      .box{
        display: block;
        height: 20%;
        padding-left: 20%;
        font-size: 0.84rem;
        color: black;
        font-weight: bold;
        background-color: 				#F8F8F8;
        line-height: 390%;
        
      }
      .box:hover{
        text-decoration: none;
        color: black;
        cursor: pointer;
      }
      .menu_box{
        height: 300px;
      }

      .project_open_nav{

        width: 260px;
      }

      .run{
        background-color: white;
        border: white;
        color: #808080;
      }
      .run:hover{
        background-color: white;
        border: white;
        color: black;
      }

      .inline-block{
        display: inline-block;
      }



      .reward_form_container{
        padding: 10% 10% 10%;
      }


      .top_margin{
        margin-top: 1%;
      }

      input::-webkit-outer-spin-button,
      input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
    }


    .font_black{

      color: black;

      font-weight: bold;

    }





    </style>

<link rel="stylesheet" href="${contextPath}/resources/pickdate/themes/default.css">
<link rel="stylesheet" href="${contextPath}/resources/pickdate/themes/default.date.css">


  </head>
  <body>
    <div class="project_create_top_bar">
      &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/helpZoo/resources/images/도와주60.png" />

      <span class="span"> <i class="fas fa-paw popoking"></i> &nbsp;${makerName}  </span>
      <div class="float-right project_create_top_bar_choice"> 
        <button type="button" class="btn btn-outline-primary">미리보기</button>&nbsp;&nbsp;&nbsp;

    나가기    &nbsp;&nbsp;&nbsp;&nbsp;
      </div>

      <br />
    </div>

    
    
<script src="${contextPath}/resources/pickdate/js/picker.js"></script>
<script src="${contextPath}/resources/pickdate/js/picker.date.js"></script>
<script src="${contextPath}/resources/pickdate/js/legacy.js"></script>
<script src="${contextPath}/resources/pickdate/js/ko_KR.js"></script>
    


    <div>
      <div class="funding_open_deail_container">
        <div class="row">
          <nav class="col-md-2 col-lg-2 col-sm-2   project_open_nav">
            <div class="project_open_no_intro  justify-content-center container">

              <small class="smallbox">펀딩</small> <small class="smallbox">펀딩 준비 작성 중</small>
              <br>
              <br>

              ${makerName}의 <br />
              멋진 프로젝트 <br />
              <br>
              프로젝트 번호 ${fundingNo}
              <br>
            </div>




            <div class="funding_ready container align-middle funding_ready_menubar">
            펀딩준비 <i class="fas fa-chevron-up float-right menuopen"></i>
          </div>
          <div class="funding_ready container">
            새소식  <i class="fas fa-lock float-right"></i>
          </div> <div class="funding_ready container">
            오픈 예정 현황 <i class="fas fa-lock float-right"></i>
          </div> <div class="funding_ready container">
            펀딩 현황 <i class="fas fa-lock float-right"></i>
          </div> <div class="funding_ready container">
            결제 현황 <i class="fas fa-lock float-right"></i>
          </div> <div class="funding_ready container">
            펀딩・발송 관리 <i class="fas fa-lock float-right"></i>
          </div> <div class="funding_ready container">
            수수료 관리 <i class="fas fa-lock float-right"></i>
          </div>
          </nav>


     <!-- 빈공간 만들기용 -->
            <div class="col-md-2 col-lg-2 col-sm-2">
  
          </div>

          <div class="col-md-9 col-lg-9 col-sm-9">
            <div class="container project_open_ready">
              <h1 class="title_msg">리워드 설계</h1>
              <br>
              <div>
                서포터에게 제공할 리워드 내용을 입력하세요. 서포터가 쉽게 펀딩할 수 있는 저렴한 리워드부터 서포터의 보다 빠른 펀딩<br>을 유도할 수 있는 얼리버드 리워드까지 다양한 리워드를 구성하세요.
                <br>
                <br>


                <br>
                <div class="temp_box container"> 
               
                  




     <small>  <b>리워드 설계 조건</b> <br><br>
       
       
     <span class="list">  정렬 순서</span>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  혜택이 높은 순으로 나오도록 정렬 순서를 등록하세요. <br>

     <span class="list">  제한 수량    </span>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;  &nbsp;    생산 및 제공할 수 있는 리워드의 총 수량으로 해당 수량이 모두 펀딩되면 더 이상 펀딩 불가합니다. <br>

     <span class="list">  발송 시작일    </span>    &nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;   프로젝트 종료일 이후부터 3개월 이내로 설계 가능합니다.   <br>
     
    </small>
       

    </div>
    <br>

    <div class="upload-btn-wrapper">
      <button class="btn " data-toggle="modal" data-target="#exampleModal"> <i class="fas fa-plus"></i>&nbsp; 추가하기</button>

    </div>




  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="container reward_form_container">
        <div class="modal-header">
          <h3 class="modal-title font_black" id="exampleModalLabel">리워드 추가</h3>
        </div>
        
        <br>
        <br>
        <form action="${contextPath}/funding/fundingOpenReward/${fundingNo}" method="POST">
          <div class="row">
            <div class="col-md-2 col-lg-2 col-sm-2 top_margin">
         <label class="font_black"> 금액 </label>
              </div>
              <div class="col-md-10 col-lg-10 col-sm-10">
                <div class="input-group">

                <input class="form-control form-control-lg" type="number" placeholder="제목 입력"  aria-label="Amount (to the nearest dollar)"
                name="price"
                >

                <div class="input-group-append">
                  <span class="input-group-text">원</span>
                </div>
              </div>



          </div>

          </div>




          <br>
          <br>

          <div class="row">
            <div class="col-md-2 col-lg-2 col-sm-2">
         <label class="font_black"> 리워드명 </label>
              </div>
              <div class="col-md-10 col-lg-10 col-sm-10">
         <input class="form-control form-control-lg" type="text" placeholder="타이틀 입력 ex) [얼리버드]기본 리워드"  name="title"
          >
          

          </div>

          </div>
          
          <br>
          <br>

          <div class="row">
            <div class="col-md-2 col-lg-2 col-sm-2">
         <label class="font_black"> 상세설명 </label>
              </div>
              <div class="col-md-10 col-lg-10 col-sm-10">
                <textarea   placeholder="제공하는 리워드가 무엇인지 간략하게 제시해 주세요." class="form-control"  rows="3" 
              
                 name ="content"
                > </textarea>
                <small>500자</small>

          </div>

          </div>
          
          <br>
          <br>

         


          <div class="row">
            <div class="col-md-2 col-lg-2 col-sm-2">
         <label class="font_black"> 배송료 </label>
              </div>

              <div class="col-md-10 col-lg-10 col-sm-10">
                <div class="input-group">

                <input class="form-control form-control-lg" type="number" placeholder="제목 입력"  aria-label="Amount (to the nearest dollar)" value="0"
                name="deleveryPrice"
                >

                <div class="input-group-append">
                  <span class="input-group-text">원</span>
                </div>
              </div>
              <small>(배송비가 없는 경우, 0원 입력)</small>


          </div>


          </div>
          
          <br>
          <br>


          <div class="row">
            <div class="col-md-2 col-lg-2 col-sm-2">
         <label class="font_black"> 제한수량 </label>
              </div>
              <div class="col-md-10 col-lg-10 col-sm-10">
                <div class="input-group">

                <input class="form-control form-control-lg" type="number" placeholder="수량 입력"  aria-label="Amount (to the nearest dollar)"
                name="rewardAmount"
                >

                <div class="input-group-append">
                  <span class="input-group-text">개</span>
                </div>
              </div>

          </div>

          </div>
          
          <br>
          <br>

          <div class="row">
            <div class="col-md-2 col-lg-2 col-sm-2">
         <label class="font_black"> 발송시작일 </label>
              </div>
              <div class="col-md-10 col-lg-10 col-sm-10">
     
          <input
          id="input_01"
          class="datepicker form-control form-control-lg"
          name="deliveryDay"
          type="text">
          
          





          </div>

          </div>
          
          <br>
          <br>




        <br>
         <br>
         
         
     			
     			
     
     
     
     

        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">확인</button>

        </form>




          </div>
        </div>
      </div>
    </div>
  </div>













                <br>
                <br>
                <br>
                <br>
                <br>
                <button
                type="button"
                class="btn btn-primary col-md-4 col-sm-4 col-xs-4 btn-lg funding_btn mintclick"
                onclick="location.href = '${contextPath}/funding/fundingOpenDetail?fundingNo=${fundingNo}' "
              >저장하기</button>



     <script>
     
     			
     $('.datepicker').pickadate({
   	  monthsFull:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
   	  weekdaysShort:["일","월","화","수","목","금","토"],
   	  today: "오늘",
   	  clear: '취소',
   	  formatSubmit: 'yyyymmdd',
   	  format:"yyyymmdd"
   	})
     			
     
     
     

                  var menubarFlag = true;

                  var menuBar = $("<div class='menu_box'></div>");

                  var require = $("<a class='box funding_require' href='${contextPath}/funding/fundingOpenRequire/${fundingNo}' >기본 요건</a>");
                  var fundingInfo = $("<a class='box funding_info' href='${contextPath}/funding/fundingOpenInfo/${fundingNo}'>기본 정보</a>");
                  var story = $("<a class='box funding_story' href='${contextPath}/funding/fundingOpenStory/${fundingNo}'>스토리 작성</a>");
                  var reward = $("<a class='box funding_reward_build' href='${contextPath}/funding/fundingOpenReward/${fundingNo}'>리워드 설계</a>");
                  var makerInfo = $("<a class='box funding_maker_info' href='${contextPath}/funding/fundingOpenMakerInfo/${fundingNo}'>메이커 정보</a>");

                    $(".funding_ready_menubar").on("click", function() {
                      console.log( $( this ).text() );
                      console.log("haha");

                      
                      if(menubarFlag){
                      $(".funding_ready_menubar i").remove();

                      $(".funding_ready_menubar").append("<i class='fas fa-chevron-down float-right'></i>")
                     
                    
                      
                        
                        menuBar.append(require,fundingInfo,story,reward,makerInfo)


                        $(".funding_ready_menubar").after(menuBar);
                        






                      menubarFlag = false;



                      }
                      else{

                        $(".funding_ready_menubar i").remove();

                      $(".funding_ready_menubar").append("<i class='fas fa-chevron-up float-right'></i>")

                      menuBar.remove();


                        
                      menubarFlag = true;


                      }






                    });



                </script>


					 <script type="text/javascript">
       
  
  
  var $input = $( '.datepicker' ).pickadate({
            formatSubmit: 'yyyy/mm/dd',
            // min: [2015, 7, 14],
            container: '#container',
            // editable: true,
            closeOnSelect: false,
            closeOnClear: false,
        })
        
        var picker = $input.pickadate('picker')
        // picker.set('select', '14 October, 2014')
        
    
        
      
        
    </script>





          </div>
        </div>
      </div>
    </div>
  </body>
</html>