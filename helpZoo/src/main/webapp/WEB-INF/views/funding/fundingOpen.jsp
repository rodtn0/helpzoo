<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
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

    <meta charset="UTF-8" />
    <title>프로젝트 오픈</title>

    <style>
      .helpZoo_project {
        padding: 3% 42% 6%;

        color: black;
      }

      .open_title {
        font-size: 2rem;
        font-weight: bold;
      }

      .project_open_introduce_container {
        padding: 0% 13% 0%;
      }

      .open_intent_message {
        font-size: 2rem;
        font-weight: bold;
        margin-bottom: 2%;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <div class="helpZoo_project"><span class="open_title">도와ZOO</span></div>

      <div class="project_open_introduce_container">
        <div class="open_intent_message">메이커 정보</div>
        안녕하세요 메이커님, 본격적으로 프로젝트 작성을 시작하기 전에 간단한
        정보를 입력하세요.

        <br />
        <br />
        메이커명
        <br />
        <input type="text" />

        <br />
        <br />
        개인 - 사업자 구분
        <br />
        <input type="text" />

        <br />
        <br />
        관리자 명
        <br />
        <input type="text" />

        <br />
        <br />
        관리자 이메일
        <br />
        <input type="text" />

        <br />
        <br />
        관리자 휴대폰 번호
        <br />
        <input type="text" />

        <br />

        (필수) 개인 정보 수집 동의 <br />
        (선택) 와디즈 메이커를 위한 유용한 뉴스레터 받기<br />

        <button
          type="button"
          class="btn btn-primary col-md-12 col-sm-12 col-xs-12 btn-lg funding_btn"
        >
          시작하기
        </button>
      </div>
    </div>
  </body>
</html>
