<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
	<style>
	/*--------------------------------------------------------------
	# Header
	--------------------------------------------------------------*/
	#header {
	  height: 180px;
	  transition: all 0.5s;
	  z-index: 997;
	  transition: all 0.5s;
	  background: #fff;
	  box-shadow: 0 4px 10px -3px rgba(191, 191, 191, 0.5);
	}
	
	#header .logo h1 {
	  font-size: 28px;
	  margin: 0;
	  line-height: 1;
	  font-weight: 400;
	  letter-spacing: 3px;
	  text-transform: uppercase;
	}
	
	#header .logo h1 a, #header .logo h1 a:hover {
	  color: #fff;
	  text-decoration: none;
	}
	
	#header .logo img {
	  padding: 0;
	  margin: 0;
	  max-height: 40px;
	}
	
	@media (max-width: 992px) {
	  #header {
	    height: 70px;
	  }
	}
	
	/*--------------------------------------------------------------
	# Navigation Menu
	--------------------------------------------------------------*/
	/* Desktop Navigation */
	.nav-menu {
	  width: 100%;
	}
	
	.nav-menu, .nav-menu * {
	  margin: 0;
	  padding: 0;
	  list-style: none;
	}
	
	.nav-menu > ul > li {
	  position: relative;
	  white-space: nowrap;
	  float: left;
	}
	
	/* 네비 이름들을 둘러싸는 영역 */
	.nav-menu .nav-inner {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  /* padding : 15px; */
	}
	
	.nav-menu .nav-logo {
	  padding: 0 20px;
	}
	
	/* 각각의 내비 설정 (text-decoration: none;) */
	.nav-menu a {
	  display: block;
	  position: relative;
	  color: #151515;
	  padding: 15px 25px;
	  transition: 0.3s;
	  font-size: 15px;
	  text-transform: uppercase;
	  font-family: "Open Sans", sans-serif;
	  text-decoration: none;
	}
	
	/* 첫번째 네비 글자 색 지정 */
	.nav-menu a:hover, .nav-menu .active > a, .nav-menu li:hover > a {
	  color: #1abc9c;
	  text-decoration: none;
	}
	
	.nav-menu .drop-down ul {
	  display: block;
	  position: absolute;
	  left: 0;
	  top: calc(100% - 30px);
	  z-index: 99;
	  opacity: 0;
	  visibility: hidden;
	  padding: 10px 0;
	  background: #fff;
	  box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.25);
	  transition: ease all 0.3s;
	}
	
	.nav-menu .drop-down:hover > ul {
	  opacity: 1;
	  top: 100%;
	  visibility: visible;
	}
	
	.nav-menu .drop-down li {
	  min-width: 180px;
	  position: relative;
	}
	
	.nav-menu .drop-down ul a {
	  padding: 10px 20px;
	  font-size: 14px;
	  font-weight: 400;
	  color: #151515;
	}
	
	/* 두번째 탭 아래로 내렸을때 글자 색상 */
	.nav-menu .drop-down ul a:hover, .nav-menu .drop-down ul .active > a, .nav-menu .drop-down ul li:hover > a {
	  color: #1abc9c;
	}
	
	/* .nav-menu .drop-down > a:after {
	  content: "\ea99";
	  font-family: IcoFont;
	  padding-left: 5px;
	} */
	
	.nav-menu .drop-down .drop-down ul {
	  top: 0;
	  left: calc(100% - 30px);
	}
	
	.nav-menu .drop-down .drop-down:hover > ul {
	  opacity: 1;
	  top: 0;
	  left: 100%;
	}
	
	.nav-menu .drop-down .drop-down > a {
	  padding-right: 35px;
	}
	
	/* .nav-menu .drop-down .drop-down > a:after {
	  content: "\eaa0";
	  font-family: IcoFont;
	  position: absolute;
	  right: 15px;
	} */
	
	.align-items-center{
	 	align-items: center!impotant;
	}
	
	
	</style>
</head>
<body>
	<!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container">

      <!-- The main logo is shown in mobile version only. The centered nav-logo in nav menu is displayed in desktop view  -->
      <div class="logo d-block d-lg-none">
        <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>
      </div>

      <nav class="nav-menu d-none d-lg-block">
        <ul class="nav-inner">
          <li class="active"><a href="index.html">도와ZOO소개</a></li>
          <li class="drop-down"><a href="">펀딩해ZOO</a>
            <ul>
              <li><a href="#about">About Us</a></li>
              <li><a href="#team">Team</a></li>

              <li class="drop-down"><a href="#">Deep Drop</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
            </ul>
          </li>
          <li><a href="#services">기부해ZOO</a></li>

          <li class="nav-logo"><a href="main.jsp"><img src="/helpzoo/resources/images/도와주150.png" alt="" class="img-fluid"></a></li>

          <li><a href="#portfolio">리뷰해ZOO</a></li>
          <li><a href="#pricing">구독해ZOO</a></li>
          <li><a href="#contact">고객센터</a></li>
          <li><a href="#contact">마이페이지</a></li>

        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->

  <main id="main">
</body>
</html>