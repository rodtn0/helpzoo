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
        border: 1px solid wheat;
        width: 100%;
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
        padding-top: 3%;
        border: 1px solid peachpuff;
        overflow: auto;
        position: relative;
        z-index: -1;
      }

      .funding_open_deail_container {
        padding-top: 3%;
      }

      .project_open_ready {
        padding-top: 3%;
      }

      .temp_box2{
        font-size: 2rem;
        border: 1px solid peachpuff;
      }
    </style>
  </head>
  <body>
    <div class="project_create_top_bar">
      &nbsp; &nbsp; <img src="도와주60.png" />

      <span class="span">도래미</span>
      <div class="float-right project_create_top_bar_choice">
        <button type="button" class="btn btn-primary">미리보기</button>
        <button type="button" class="btn btn-primary">임시저장</button>

        나가기
      </div>

      <br />
    </div>

    <div>
      <div class="funding_open_deail_container">
        <div class="row">
          <nav class="col-md-2 col-lg-2 col-sm-2 project_open_nav">
            <div class="project_open_no_intro d-flex justify-content-center">
              도와주의 <br />
              멋진 프로젝트 <br />
              프로젝트 번호 82752
            </div>
            펀딩준비<br />
            새소식<br />
            펀딩준비<br />
            새소식<br />
            펀딩준비<br />
            새소식<br />
          </nav>

          <div class="col-md-9 col-lg-9 col-sm-9">
            <div class="container project_open_ready">
              <h1>펀딩준비</h1>
              <div>
              본격적으로 펀딩을 오픈하기 위해 프로젝트에 대한 6가지 메뉴의 필수항목을 작성하세요.
                <br>
                <br>
                <div class="temp_box"> 
                  프로젝트 준비 상태지금 나의 단계는?<br>

         펀딩 준비 작성 중
        필수 항목을 모두 작성 후 저장하기 버튼을 클릭해주세요. 작성 중 > 작성 완료 상태로 변경되어야 최종 제출이 가능합니다.
                </div>

                <br>
                <div class="temp_box2">
                  기본 요건 
                  <div class="btn btn-primary float-right">작성하기</div>

                </div>

                
                <br>
                <div class="temp_box2">
                  기본 요건 
                  <div class="btn btn-primary float-right">작성하기</div>

                </div>

                
                <br>
                <div class="temp_box2">
                  기본 요건 
                  <div class="btn btn-primary float-right">작성하기</div>

                </div>
                <br>
                <div class="temp_box2">
                  기본 요건 
                  <div class="btn btn-primary float-right">작성하기</div>

                </div>
                <br>
                <div class="temp_box2">
                  기본 요건 
                  <div class="btn btn-primary float-right">작성하기</div>

                </div>
                <br>
                <div class="temp_box2">
                  기본 요건 
                  <div class="btn btn-primary float-right">작성하기</div>

                </div>

          </div>
        </div>
      </div>
    </div>
  </body>
</html>