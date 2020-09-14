<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
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
      .form-control{
        margin-top: 0.8%;
      }
      input::-webkit-outer-spin-button,
      input::-webkit-inner-spin-button {
    /* display: none; <- Crashes Chrome on hover */
    -webkit-appearance: none;
    margin: 0; /* <-- Apparently some margin are still there even though it's hidden */
}

.upload-btn-wrapper {
  position: relative;
  overflow: hidden;
  display: inline-block;
  margin-top: 1%;
}

.btn {
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
.content_space{
  margin-top: 1%;
  font-size: 0.8rem;
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


    </style>


</script>



  </head>
  <body>
    <div class="project_create_top_bar">
      &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/helpZoo/resources/images/도와주60.png" />

      <span class="span"> <i class="fas fa-paw popoking"></i> &nbsp;도래미  </span>
      <div class="float-right project_create_top_bar_choice"> 
        <button type="button" class="btn btn-outline-primary">미리보기</button>&nbsp;&nbsp;&nbsp;

    나가기    &nbsp;&nbsp;&nbsp;&nbsp;
      </div>

      <br />
    </div>

    <div>
      <div class="funding_open_deail_container">
        <div class="row">
          <nav class="col-md-2 col-lg-2 col-sm-2   project_open_nav">
            <div class="project_open_no_intro  justify-content-center container">

              <small class="smallbox">펀딩</small> <small class="smallbox">펀딩 준비 작성 중</small>
              <br>
              <br>

              도와주의 <br />
              멋진 프로젝트 <br />
              <br>
              프로젝트 번호 82752
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
              <h1 class="title_msg">스토리 작성</h1>
              <br>
              <div>
                메이커님의 프로젝트를 소개해보세요. 스토리에는 메이커님의 진심과 목소리가 잘 녹여질 수 있도록 명확하고, 솔직하게,<br> 친근한 어투로 작성하세요
                <br>
                <br>
                소개 영상·사진 등록  <span class="star">*</span>
                <br>
                <div class="content_space">프로젝트 페이지 상단에 노출될 영상 또는 사진을 올려주세요.</div>
            </div>        

            <br>
            <br>

            <div class="form-check">
             <input class="form-check-input mint" type="radio" name="circulation" id="circulation" value="option1" >
              <label class="form-check-label" for="exampleRadios1">
                  &nbsp;   소개 영상
              </label>
            </div>
            <br>

            
            <div class="form-check">
            <input class="form-check-input mint" type="radio" name="circulation" id="circulation" value="option1" >
              <label class="form-check-label" for="exampleRadios1">
                  &nbsp;   소개 사진
              </label>
            </div>





                <br>
                <div class="upload-btn-wrapper">
                    <button class="btn"> <i class="fas fa-camera-retro"></i>&nbsp;등록하기</button>
                    <input type="file" name="myfile" />
                  </div>
                  <br>
                <small>  2MB 이하의 JPEG, JPG, GIF, PNG 파일<br>
                  사이즈 : 최소 630X400 픽셀 이상<br>
                  여러 장 등록 가능<br>
            </small>

                <br>
                <br>


        

                <div class="funding_open_question ">

                  프로젝트 요약 <span class="star">*</span>
  
                </div>  
                <small>
                  프로젝트 페이지 상단 및 지지서명 시 노출됩니다.
                  </small>
                  <br>
  
                <br>
  
                <div class="form-group">
                  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" 
                  placeholder="내용을 입력하세요."
                  ></textarea>
                  <small>100자 남음</small>
              </div>        
  








              스토리 광고 심의 동의 <span class="star">*</span><br> 
                <small>스토리 작성 전, 와디즈에서 제공하는 광고 심의 가이드라인을 반드시 확인하세요. 동의를 진행해야 스토리 작성이 가능합니다. <br>
                  오픈예정 스토리도 적용됩니다.</small>
                
                
            
             
              

                <br>  
                <br>

                
                프로젝트 스토리<span class="star">*</span><br>
                <small>진정성 있고 매력적인 스토리로 서포터의 마음을 움직여볼까요?</small>
                <input class="form-control form-control-lg" type="number" placeholder="제목 입력">



            
                <br>
                <br>
                <button
                type="button"
                class="btn btn-primary col-md-4 col-sm-4 col-xs-4 btn-lg funding_btn mintclick"
                onclick="location.href = '${contextPath}/funding/fundingOpenDetail' "
              >저장하기</button>



     <script>

                  var menubarFlag = true;

                  var menuBar = $("<div class='menu_box'></div>");

              var require = $("<a class='box funding_require' href='${contextPath}/funding/fundingOpenRequire' >기본 요건</a>");
              var fundingInfo = $("<a class='box funding_info' href='${contextPath}/funding/fundingOpenInfo'>기본 정보</a>");
              var story = $("<a class='box funding_story' href='${contextPath}/funding/fundingOpenStory'>스토리 작성</a>");
              var reward = $("<a class='box funding_reward_build' href='${contextPath}/funding/fundingOpenReward'>리워드 설계</a>");
              var makerInfo = $("<a class='box funding_maker_info' href='${contextPath}/funding/fundingOpenMakerInfo'>메이커 정보</a>");

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