<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<title>기부 결제 페이지</title>
	<link rel="stylesheet" href="${contextPath}/resources/donation/paymentCss/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}/resources/donation/paymentCss/font-awesome.min.css">
	<!-- Main css -->
	<link rel="stylesheet" href="${contextPath}/resources/donation/paymentCss/style.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">

</head>
<body>
 <div class="preloader">
               <div class="sk-spinner sk-spinner-wordpress">
                    <span class="sk-inner-circle"></span>
               </div>
          </div>

          <!-- Navigation section  -->

          <!-- <div class="navbar navbar-default navbar-static-top" role="navigation">
               <div class="container">

                    <div class="navbar-header">
                         <!-- <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                              <span class="icon icon-bar"></span>
                              <span class="icon icon-bar"></span>
                              <span class="icon icon-bar"></span>
                         </button>
                         <a href="index.html" class="navbar-brand"><i class="fa fa-magnet"></i></a> -->
                    </div>
                    <div class="collapse navbar-collapse">
                         <!-- <ul class="nav navbar-nav navbar-right">
                              <li class="active"><a href="index.html">Projects</a></li>
                              <li><a href="about.html">Our Studio</a></li>
                              <li><a href="blog.html">Blog</a></li>
                              <li><a href="contact.html">Contact</a></li>
                         </ul> -->
                    </div>

          </div>
          </div> 

          <!-- Home Section -->

          <section id="home">
               <div class="container">
                    <div class="row">

                         <div class="col-md-12 col-sm-12">
                              <h2 class="align-center" style="margin-bottom: 0.4em;">슬픔이 가득한 물음표, 대답할 수 없는 온점(제목)</h2>
                              <h5 style="text-align: center;">by 화랑 (기부 단체)</h5>
                              <hr style="border: 1px solid black;">
                         </div>

                    </div>
               </div>
          </section>

          <!-- Portfolio Section -->
          <form id="donationOnce" name="donationOnce">
               <section id="portfolio" style="margin-top: -5%;">
                    <div class="container" style="border: 1px solid; height: 950px;">
                         <div class="row" style="margin-top: 10px;">

                              <div class="col-md-6" style="text-align: center;">
                                   <div class="aaa" style="background-color: beige; color:rgb(206, 187, 13) ; padding: 80px;  height: 200px; border: thick solid rgb(153, 153, 153); margin: auto;">
                                        <fieldset>
                                             <label for="radio-1" style="font-size:2em">결제 기부하기</label>
                                             <input type="radio" name="radio" id="radio-1" checked>
                                        </fieldset>

                                   </div>                           
                              </div>


                              <div class="col-md-6 " style="text-align: center;">
                                   <div class="bbb" style="padding: 80px; height: 200px; border: thick solid rgb(153, 153, 153);">
                                        <fieldset>
                                             <label for="radio-2" style="font-size:2em">정기 기부하기</label>
                                             <input type="radio" name="radio" id="radio-2" onclick="move()">
                                        </fieldset>
                                   </div>                              
                              </div>


                              <div class="row">
                                   <div class="col-md-12 col-sm-12">
                                        <h2 class="align-center" style="margin-top: 2.4em; text-align: center;">"기부자님의 소중한 마음으로 놀라운 변화가 일어납니다."</h2>
                                        <h5 style="text-align: center;">투명한 기부 후기로 그 변화를 소개하고 보답하겠습니다!</h5>
                                        <hr style="border: 1px solid black; width: 85%; margin-top: 70px;">
                                   </div>              
                              </div>
                              
                              <div class="row">
                                   <div class="col-md-6 " style="margin-left: 100px;">

                                        <strong class="tit" style="font-size: large;">결제 할 금액</strong> &nbsp;                             

                                        <input type="text" placeholder="10000" title="충전콩 금액" class="inp_num" name="charge" id="charge" maxlength="8"><span class="tx_won">원</span>
                                             &nbsp;   &nbsp;   
                                             <span class="sort_menu" >
                                                  <button class="btn_sort  jq_fix_amount" id="charge1" name="charge1" type="button" value="10000">1만원</button>
                                                  <button class="btn_sort jq_fix_amount" id="charge2" name="charge2" type="button" value="20000">2만원</button>
                                                  <button class="btn_sort jq_fix_amount" id="charge3" name="charge3" type="button" value="30000">3만원</button>
                                             </span>
                                             <br><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                                             <span class="tx2">* 기부를 원하는 금액을 입력한 후 <em>'기부하기'</em> 버튼을 눌러주세요!</span>
                                             <br><br><br><br><br>
                                             <div class="col-md-3" style="font-size: medium; line-height: 3em;">
                                                
                                                  결제 수단 <br>
                                             
                                             </div> 
                                             <div class="col-md-7" style="font-size: medium; line-height: 3em;" >
                                                
                                                  네이버페이 / 카카오페이
                                             </div>  
                                             <button style="margin-top: 150px;">모금함으로 돌아가기</button>
                                                        
                                   </div> 
                                   


                                   <div class="col-md-3 clo-sm-2" style="margin-left: 20px; width: 380px; " >
                                        <div class="dnt_area regular" style="border: 1px solid ; padding: 10px 10px 10px 10px; height: 300px;">
                                             <div class="commission_area" style="margin: 10px 0px 20px 0px;">
                                                  <strong class="cms_txt tit">결제수수료 없이 100% 기부</strong>
                                                  <p class="cms_txt">결제하신 금액은 기부시 별도 수수료 없이 <br><em class="point_txt">단체로 100% 기부</em>됩니다.</p>
                                             </div>
                                             <!-- <hr style="border: 1px solid; width: 100%;"> -->
                                             <div class="agree_area v2" style="border: 1px solid ; padding: 20px 20px 10px 10px;">
                                                  
                                                  <p>
                                                       <label for="jq_temporary_agree"><input type="checkbox" id="jq_temporary_agree" class="chk">유료이용약관동의</label>
                                                       <a href="#" onclick="viewClausePopup('happybean')" class="view">약관보기</a>
                                                  </p>
                                                  
                                                  <p>
                                                       <label for="isMktNotiReceiveAgreement" class="chk1">
                                                            <input id="isMktNotiReceiveAgreement" type="checkbox" class="chk">
                                                            <em class="emp">(선택)</em> 해피빈 마케팅 알림 수신에 동의합니다.
                                                       </label>
                                                  </p>                                            
                                             </div>

                                             <br>
                                        <a href="#" class="bt_dnt jq_donate">기부하기</a>
                                        </div>
                                   </div>                 
                              </div>
                              

                    

                              










                              
                         </div>
                    </div>
               </section>
          </form>
          <!-- Footer Section -->

          
          


          <!-- SCRIPTS -->

		<script src="${contextPath}/resources/donation/paymentJs/jquery.js"></script>
		<script src="${contextPath}/resources/donation/paymentJs/bootstrap.min.js"></script>
		<script src="${contextPath}/resources/donation/paymentJs/custom.js"></script>
		
		<script>


          $(function(){
          var box1 = $('.aaa');
          var box2 = $('.bbb');
          var radio_1 = $('#radio-1');
          var radio_2 = $('#radio-2');

          
          
          radio_1.click(function(){
               box1.css('background-color','beige');
               box1.css('color', 'rgb(206, 187, 13)');
               box2.css('background-color','');
               box2.css('color', '');
          });
          radio_2.click(function(){
               box2.css('background-color','beige');
               box2.css('color', 'rgb(206, 187, 13)');
               box1.css('background-color','');
               box1.css('color', '');

          });
          
          
          });





          </script>

          
          <script>
                                             
               $("#charge1, #charge2, #charge3").click(function(){

                    var charge3 = $(this).attr('value'); 
                    var charge2 = $(this).attr('value'); 
                    var charge1 = $(this).attr('value'); 

                    var inp_num = $('.inp_num');
                    inp_num.val(charge3);
                    inp_num.val(charge2);
                    inp_num.val(charge1);
               });
               
               function move(){
            	   location.href ="${contextPath}/donation/dPaymentMontly";
               }


          </script>
</body>
</html>