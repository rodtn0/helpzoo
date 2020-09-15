<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>

	<style>
	/* The Modal (background) */
	.searchModal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 10; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0,0,0); /* Fallback color */
	background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	/* Modal Content/Box */
	.search-modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 70%; /* Could be more or less, depending on screen size */
	}
	
/* 	.fc-ltr .fc-h-event.fc-not-end, .fc-rtl .fc-h-event.fc-not-start{
	background-color: #7fcdcd !important;
	border-color: #7fcdcd !important;
	}
	.fc-ltr .fc-h-event.fc-not-start, .fc-rtl .fc-h-event.fc-not-end{
	background-color: #7fcdcd !important;
	border-color: #7fcdcd !important;
	} */
	
	.btn-outline-info{
	width: 50%;
	}
	</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script>

function myfunction(){
	var colorCode = "#"+ Math.round(Math.random() * 0xffffff).toString(16);
	document.getElementByClass(".fc-rtl").style.color=colorCode;
}
	
  document.addEventListener('DOMContentLoaded', function() {
	
    var calendarEl = document.getElementById('calendar');
    
    var calendarObj = {
    	      plugins: [ 'interaction', 'dayGrid' ],
    	      header: {
    	        left: 'prevYear,prev,next,nextYear today',
    	        center: 'title',
    	        right: 'dayGridMonth,dayGridWeek,dayGridDay'
    	      },
    	      navLinks: true, // can click day/week names to navigate views
    	      editable: true,
    	      eventLimit: true, // allow "more" link when too many events
    	      displayEventTime: false,
    	      events: [ 
    	    	  <c:forEach var="fun" items="${funding}">
    		    	  <fmt:formatDate var="fundingSD" value="${fun.fundingSD}" pattern="yyyy-MM-dd"/>
    		    	  
    		    	  <fmt:parseNumber var="parseED" value="${fun.fundingED.time + (1000*60*24*24)}" integerOnly="true"/>
    		    	  
    		    	  /* <fmt:formatDate var="fundingED" value="${fun.fundingED}" pattern="yyyy-MM-dd"/> */
    		    	   {
    		    		   id : "${fun.fundingNo}",
    		    		   title: "${fun.fundingNo}"+". "+"${fun.fundingTitle}",
    		    		   start: "${fundingSD}",
    		    		   end: new Date(${parseED})
    		    		  /*  end: "${fundingED}" */
    		    	   },
    	    		</c:forEach>
    	      ], eventColor : "#7fcdcd",
    	      	  eventClick: function(info) {
    	      	
    	          var eventFullDate = info.event.start;
    	            
    	          var eventYear = eventFullDate.getFullYear() // 선택된 이벤트 연도
    	          var eventMonth = eventFullDate.getMonth() + 1; // 선택된 이벤트 월
    	          var eventDate = eventFullDate.getDate(); // 선택된 이벤트 일
    	          var eventDay = eventFullDate.getDay(); 
    	          
    	          console.log(eventDay);
    	          console.log(eventDate);
    	          console.log(eventMonth);
    	          console.log(eventYear);
    	          console.log(info.event.end);
    	          
    	          var eventNo = info.event.id;
    	          var eventTitle = info.event.title;
    	          var eventStart = moment(info.event.start).format("YYYY-MM-DD");
    	          var eventEnd = moment(info.event.end).format("YYYY-MM-DD")
    	          
    	           $("#modal").show();
    			
    	           $('#fundingNo').val(eventNo);
    	           $('#fundingSD').val(eventStart);
    	           $('#fundingED').val(eventEnd);
    	           $('#fundingTitle').text(eventTitle);
    	           
    	       }
    	      
    	    };
    
    var calendar = new FullCalendar.Calendar(calendarEl, calendarObj);

    calendar.render();
    
    putCal(calendarObj);
  });
  
   function closeModal() {
       $('.searchModal').hide();
       };
 
   var cal;   
       
   function putCal(calendarObj){
	   cal = calendarObj;
   }
  
   
/*    $("#deleteBtn").on("click", function(){
	  
	   var fundingNo = $("input[name='fundingNo']").val();
	   
	   $.ajax
   }); */
       
  
</script>
<style>
    body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }
</style>
</head>
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Question And Answer</h1>
          <p class="mb-4">관리자가 사용자 질문에 답변해주는 페이지입니다.</p>

          <!-- DataTales Example -->
          <div class="row">

            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Earnings Overview</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div id='calendar'></div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Revenue Sources</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  
                </div>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      
          <div id="modal" class="searchModal">
      <div class="search-modal-content">
        <div class="page-header">
          <h1>프로젝트 날짜 수정</h1>
        </div>
      <div class="row">
        <div class="col-sm-12">
          <div class="row">
            <div class="col-sm-12">
              <h2 id='fundingTitle'></h2>
            </div>
          </div>
        </div>
      </div>
      <hr>
    <form action="updateAction" method="post">
    <input type='hidden' id='fundingNo' name='fundingNo'>
        펀딩 Start : <input type='date' id='fundingSD' name='fundingSD'/>
    <br>
        펀딩 End : <input type='date' id='fundingED' name='fundingED'/>
    <br>
    <div>
		<button type="button" class="btn btn-outline-info" id="updateBtn">수정</button>
		<button type="button" class="btn btn-outline-info" id="deleteBtn">삭제</button>
	</div>
    </form>
	    <div style="cursor:pointer; background-color:#DDDDDD; text-align: center; padding-bottom:10px; padding-top: 10px;" onClick="closeModal();">  
	      <span class="pop_bt modalCloseBtn" style="font-size: 13pt;">닫기</span>
	        </div>
	      </div>
	    </div>

      <jsp:include page="../../common/adfooter.jsp"/>
      
      <script>
      $("#updateBtn").on("click",function(){
   	   var fundingNo = $("input[name='fundingNo']").val();
   	   var fundingSD = $("input[name='fundingSD']").val();
   	   var fundingED = $("input[name='fundingED']").val();
   	   
   	   console.log(fundingNo);
   	   console.log(fundingSD);
   	   console.log(fundingED);
   	   
   	   $.ajax({
   		   url : "${contextPath}/admin/funding/updateAction",
   		   type: "POST",
   		   data : {"fundingNo" : fundingNo, "fundingSD" : fundingSD,
   			   		"fundingED" : fundingED},
   			dataType: "text",
   		   success : function(result){
   			   console.log(result);
   			   if(result=="1"){
   				   alert("수정 성공");
   				   console.log(cal);
   				   console.log(cal.events);
   				   
   				   for(var i=0 ; i<cal.events.length ; i++){
   					   if(cal.events[i].id == fundingNo){
   						cal.events[i].start = fundingSD;
   						//cal.events[i].end = fundingED;
   						cal.events[i].end = new Date(Date.parse(fundingED) + (1000*60*24*24));
   					 	
   						var calendarEl = document.getElementById('calendar');
   					 	calendarEl.innerHTML = "";
   					 	
   						var calendar = new FullCalendar.Calendar(calendarEl, cal);

   					    calendar.render();
   					    
   					    break;
   					   }
   				   }
   				   
   					$('.searchModal').hide();
   			   }else{
   				   alert("수정 실패");
   			   }
   			   
   		   },error : function(){
   				console.log("통신 실패");
   			}
   	   })
      });
      
      $("#deleteBtn").on("click",function(){
    	  var fundingNo = $("input[name='fundingNo']").val();
    	  
    	  $.ajax({
    		  url : "${contextPath}/admin/funding/deleteAction",
    		  type: "POST",
    		  data : {"fundingNo" : fundingNo},
    		  success : function(result){
    			  if(result=="1"){
    				  
    				  alert("삭제 성공");
    				  
    				  for(var i=0 ; i<cal.events.length ; i++){
    					  
      					   if(cal.events[i].id == fundingNo){
      						cal.events[i].id == "";
      						cal.events[i].title = "";
      						cal.events[i].start = "";
        					cal.events[i].end = "";
        					
	    				  	var calendarEl = document.getElementById('calendar');
	    				  
	 					 	calendarEl.innerHTML = "";
	 					 	
	 						var calendar = new FullCalendar.Calendar(calendarEl, cal);
	
	 					    calendar.render();
	 					    
	 					   break;
       					   }
    				  	}
				    	
				    	$('.searchModal').hide();
				    	
    				  }else{
    					  alert("삭제 실패");
    				  }
    			  },error : function(){
    				  console.log("통신 실패");
    			  }
    		  });
    	  });
      </script>
</body>

</html>
