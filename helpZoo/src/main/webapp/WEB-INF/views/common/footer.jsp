<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	/*--------------------------------------------------------------
	# Footer
	--------------------------------------------------------------*/
		#footer {
		  /* background: url("../img/footer-bg.jpg") center center no-repeat; */
		  background-color: #1abc9c;
		  color: #fff;
		  font-size: 14px;
		  position: relative;
		}
		
		#footer::before {
		  content: "";
		  position: absolute;
		  left: 0;
		  right: 0;
		  top: 0;
		  bottom: 0;
		  background: rgba(0, 0, 0, 0.5); /* 0.5:투명도 */
		  z-index: 1;
		}
		
		/* footer패딩 조절로 높이 줄이기 */
		#footer .footer-top {
		  position: relative;
		  z-index: 2;
		  text-align: center;
		  padding: 20px 0;
		}
		
		#footer .footer-top .footer-logo img {
		  height: 200px;
		}
		
		#footer .footer-top h3 {
		  font-size: 36px;
		  font-weight: 700;
		  color: #fff;
		  position: relative;
		  font-family: "Poppins", sans-serif;
		  padding: 30px 0 0 0;
		  margin-bottom: 0;
		}
		
		#footer .footer-top p {
		  font-size: 15;
		  font-style: italic;
		  margin: 30px 0 0 0;
		  padding: 0;
		}
		
	/* 	#footer .footer-top .footer-newsletter {
		  text-align: center;
		  font-size: 15px;
		  margin-top: 30px;
		}
		
		#footer .footer-top .footer-newsletter form {
		  background: #fff;
		  padding: 6px 10px;
		  position: relative;
		  border-radius: 50px;
		  box-shadow: 0px 2px 15px rgba(0, 0, 0, 0.1);
		  text-align: left;
		}
		
		#footer .footer-top .footer-newsletter form input[type="email"] {
		  border: 0;
		  padding: 4px 8px;
		  width: calc(100% - 100px);
		}
		
		#footer .footer-top .footer-newsletter form input[type="submit"] {
		  position: absolute;
		  top: 0;
		  right: -1px;
		  bottom: 0;
		  border: 0;
		  background: none;
		  font-size: 16px;
		  padding: 0 20px;
		  background: #7cc576;
		  color: #fff;
		  transition: 0.3s;
		  border-radius: 50px;
		  box-shadow: 0px 2px 15px rgba(0, 0, 0, 0.1);
		}
		
		#footer .footer-top .footer-newsletter form input[type="submit"]:hover {
		  background: #5ab652;
		}
		
		#footer .footer-top .social-links {
		  margin-top: 30px;
		}
		
		#footer .footer-top .social-links a {
		  font-size: 18px;
		  display: inline-block;
		  background: #7cc576;
		  color: #fff;
		  line-height: 1;
		  padding: 8px 0;
		  margin-right: 4px;
		  border-radius: 50%;
		  text-align: center;
		  width: 36px;
		  height: 36px;
		  transition: 0.3s;
		}
		
		#footer .footer-top .social-links a:hover {
		  background: #5ab652;
		  color: #fff;
		  text-decoration: none;
		} */
		
		#footer .footer-bottom {
		  border-top: 1px solid rgba(0, 0, 0, 0.1);
		  z-index: 2;
		  position: relative;
		  padding-top: 40px;
		  padding-bottom: 40px;
		}
		
		#footer .copyright {
		  text-align: center;
		}
		
		#footer .credits {
		  text-align: center;
		  font-size: 13px;
		  padding-top: 5px;
		}
	
	</style>
</head>
<body>

<!-- ======= Footer ======= -->
  <footer id="footer">

    <div class="footer-top">

    	<div class="container">

        <div class="row justify-content-center">
          <div class="col-lg-6">
            <a href="#header" class="scrollto footer-logo"><img src="/helpzoo/resources/images/도와주400.png" alt=""></a>
            <h3>HelpZoo</h3>
            <p>도와ZOO(주)</p>
            <span>서울특별시 중구 남대문로 120</span><br>
            <span>Tel : 1661-8282 /</span>
            <span>사업자 번호 : 123-45-56789</span>
          </div>
        </div>

		<!-- 메일주소 적는 란  -->
        <!--  <div class="row footer-newsletter justify-content-center">
          <div class="col-lg-6">
            <form action="" method="post">
              <input type="email" name="email" placeholder="Enter your Email"><input type="submit" value="Subscribe">
            </form>
          </div>
        </div> -->

		<!-- sns -->
        <!-- <div class="social-links">
          <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
          <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
          <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
          <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
          <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
        </div> -->

      </div>
    </div> 
    

    <div class="container footer-bottom clearfix">
      <div class="copyright">
        &copy; Copyright <strong><span>helpzoo</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/knight-free-bootstrap-theme/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->
</body>
</html>