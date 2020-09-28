<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>타이틀</title>
<meta http-equiv="expires" content="-1" >
<meta http-equiv="Cache-Control" content="No-Cache"> 

<meta http-equiv="Pragma" content="No-Cache"> 
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
      
      .funding_ready_menu_bar{
      	
      color: #00a0a0 ;
      	
      }
      
      
      .span{
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







      <!-- 하단에 추가해될 파일들-->

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
      
       .smallMint{
      	color :  #00a0a0 ;

      	font-size: small;
      	
      }
      
    </style>
  </head>
  <body>
    <div class="project_create_top_bar">
      &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/helpzoo/resources/images/도와주60.png" />

      <span class="span"> <i class="fas fa-paw popoking"></i> &nbsp;${makerName}  </span>
      <div class="float-right project_create_top_bar_choice"> 
        <button type="button" class="btn btn-outline-primary">미리보기</button>&nbsp;&nbsp;&nbsp;

        <button type="button" class="btn btn-primary run" data-toggle="modal" data-target="#exampleModal">
          나가기
        </button>   &nbsp;&nbsp;&nbsp;&nbsp;
      </div>

      <br />
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">정말 나가시겠습니까?</h5>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal" >취소</button>
            <button type="button" class="btn btn-primary" onclick="location.href='/'">확인</button>
          </div>
        </div>
      </div>
    </div>









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




            <div class="funding_ready container align-middle funding_ready_menubar" >
            펀딩준비  <i class="fas fa-chevron-up float-right menuopen"></i>
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



<!--빈공간 만들기용-->
          <div class="col-md-2 col-lg-2 col-sm-2">
  
          </div>










          <div class="col-md-9 col-lg-9 col-sm-9">
            <div class="container project_open_ready">
              <h1 class="title_msg">펀딩준비 </h1>
              <br>
              <div>
              본격적으로 펀딩을 오픈하기 위해 프로젝트에 대한 6가지 메뉴의 필수항목을 작성하세요.
                <br>
                <br>
                <div class="temp_box container"> 
                  프로젝트 준비 상태    <small class="myStep float-right">지금 나의 단계는? </small>
                  
                  <br>
                  <br>

                  <i class="fas fa-paw popoking"></i>    펀딩 준비 &nbsp; <small class="smallMint">${allSatis} </small>	 <br>
     <small>   필수 항목을 모두 작성 후 저장하기 버튼을 클릭해주세요. 작성 중 > 작성 완료 상태로 변경되어야 최종 제출이 가능합니다. </small>
                </div>

                <br>
                <div class="temp_box2 title_msg container">
                  기본 요건  &nbsp; 	<small class="smallMint">	${OpenRequire} </small>
                  <div class="btn btn-outline-secondary float-right" onclick="location.href='${contextPath}/funding/fundingOpenRequire/${fundingNo}'">작성하기</div>

                </div>

                
               

                
                <br>
                <div class="temp_box2 title_msg container">
                  기본 정보 	&nbsp;	<small class="smallMint"> ${OpenInfoStatus} </small>
                  <div class="btn btn-outline-secondary float-right" onclick="location.href='${contextPath}/funding/fundingOpenInfo/${fundingNo}'">작성하기</div>

                </div>
                <br>
                <div class="temp_box2 title_msg container">
                  스토리 작성	&nbsp;	 <small class="smallMint"> ${OpenStory} </small>
                  <div class="btn btn-outline-secondary float-right" onclick="location.href='${contextPath}/funding/fundingOpenStory/${fundingNo}'">작성하기</div>

                </div>
                <br>
                <div class="temp_box2 title_msg container">
                  리워드 설계	&nbsp;	<small class="smallMint">${OpenReward} </small>
                  <div class="btn btn-outline-secondary float-right" onclick="location.href='${contextPath}/funding/fundingOpenReward/${fundingNo}'">작성하기</div>

                </div>

                <br>
                <div class="temp_box2 title_msg container" onclick="location.href='${contextPath}/funding/fundingOpenMakerInfo/${fundingNo}'">
                  메이커 정보	&nbsp;	<small class="smallMint">${OpenMakerInfo} </small>
                  <div class="btn btn-outline-secondary float-right">작성하기</div>

                </div>

                <br>
                <br>
                <button
                type="button"
                class="btn btn-primary col-md-4 col-sm-4 col-xs-4 btn-lg funding_btn mintclick"
                onclick="location.href ='${contextPath}/funding/fundingOpenSubmit/${fundingNo}'"
 <c:if test="${allSatis ne '작성 완료'}">
	disabled
</c:if>
              >제출하기</button>



	<br>
	<br>
	<br>
	<br>
	
	


                <!--jsp 파일에 추가해야될 sciprt-->
                <script>

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














          </div>
        </div>
      </div>
    </div>
  </body>
</html>