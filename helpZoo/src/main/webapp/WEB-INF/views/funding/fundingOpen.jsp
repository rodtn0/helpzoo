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
        padding: 2% 45% 6%;

        color: black;
      }

      .open_title {
        font-size: 1.5rem;
        font-weight: bold;
      }

      .project_open_introduce_container {
        padding: 0% 12% 0%;
      }

      .open_intent_message {
        font-size: 2rem;
        font-weight: bold;
        margin-bottom: 2%;
      }

      input {
        margin-top: 1.1%;
      }

      .star {
        color: red;
      }

      .fa-check-circle {
        font-size: 1.5rem;
        color: #c0c0c0;
      }

      .hiddencheck {
        display: none;
      }

      .infogray {
        color: #696969;
      }

      .popoking {
        font-size: 2rem;
      }

      .certificationCheck {
        color: #00a0a0;
      }

      .mintclick {
        background-color: #00a0a0;
        border: none;
      }

      .mintclick:hover {
        background-color: #008080;
      }
    </style>
  </head>

  <!--
        color: #51fcc5;-->
  <body>
    <div class="container">
      <div class="helpZoo_project"><span class="open_title">도와ZOO</span></div>

      <div class="project_open_introduce_container">
        <form action="${contextPath}/funding/fundingOpenDetail"></form>
        <div class="open_intent_message">메이커 정보</div>
        안녕하세요 메이커님, 본격적으로 프로젝트 작성을 시작하기 전에 간단한
        정보를 입력하세요.

        <br />
        <br />
        메이커(기업)명 <span class="star">*</span>
        <br />
        <div class="input-group input-group-lg">
          <div class="input-group-prepend"></div>
          <input
            type="text"
            class="form-control"
            aria-label="Large"
            aria-describedby="inputGroup-sizing-sm"
          />
        </div>

        <br />
        <br />
        개인 · 사업자 구분 <span class="star">*</span>
        <br />
        <div class="input-group input-group-lg">
          <div class="input-group-prepend"></div>
          <input
            type="text"
            class="form-control"
            aria-label="Large"
            aria-describedby="inputGroup-sizing-sm"
          />
        </div>

        <br />
        <br />
        관리자 명 <span class="star">*</span>
        <br />
        <div class="input-group input-group-lg">
          <div class="input-group-prepend"></div>
          <input
            type="text"
            class="form-control"
            aria-label="Large"
            aria-describedby="inputGroup-sizing-sm"
            placeholder="김관리"
            readonly
          />
        </div>

        <br />
        <br />
        관리자 이메일 <span class="star">*</span>
        <br />
        <div class="input-group input-group-lg">
          <div class="input-group-prepend"></div>
          <input
            type="text"
            class="form-control"
            aria-label="Large"
            aria-describedby="inputGroup-sizing-sm"
            placeholder="jjisanle@gmail.com"
            readonly
          />
        </div>
        <small class="infogray"
          >관리자명과 이메일 주소는 로그인 아이디와 연동되어 있으므로 변경을
          원할 경우 회원 정보 설정에서 변경하세요.</small
        >
        <br />
        <br />
        관리자 휴대폰 번호 <span class="star">*</span>
        <br />
        <div class="input-group input-group-lg">
          <div class="input-group-prepend"></div>
          <input
            type="text"
            class="form-control"
            aria-label="Large"
            aria-describedby="inputGroup-sizing-sm"
          />
        </div>
        <small class="certificationCheck"> 인증을 완료한 회원입니다 </small>
        <br />
        <br />
        <br />

        <i class="fas fa-check-circle" onclick="collectAsign();">
          								<input type="checkbox" class="hiddencheck" name="collectAsign" />
        </i>

        (필수) 개인 정보 수집 동의 <br />
        <br />
        <br />

        <small class="infogray">
          <i class="fas fa-paw popoking"></i> &nbsp;지금 시작하면 도와Zoo에서
          제공하는 가이드를 보내드립니다!</small
        >

        <br />

        <br />

        <button
          type="button"
          class="btn btn-primary col-md-5 col-sm-5 col-xs-5 btn-lg funding_btn mintclick"
          onclick="location.href = '${contextPath}/funding/fundingOpenDetail' "
        >
          시작하기
        </button>
      </div>

      <script>
        var flag = false;

        function collectAsign() {
          if (!flag) {
            $(".fa-check-circle").css("color", "#00a0a0");

            flag = true;
          } else {
            $(".fa-check-circle").css("color", "#c0c0c0");

            flag = false;

          }

          
        }
      </script>
    </div>
  </body>
</html>
