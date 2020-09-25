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
	
	.btn-outline-info{
	width: 50%;
	}
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
  	select {
	width: 200px;
	padding: .8em .5em;
	border: 1px solid #999;
	font-family: inherit;
	background: url('arrow.jpg') no-repeat 95% 50%;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	border-radius: 10px;
	}
	
	select::-ms-expand {
	    display: none;
	    border-radius: 10px;
	}
	
	#selectBox{
	margin-bottom: 10px;
	}
	
	table{
	text-align: center;
	}
	
	td {
        padding: 10px;
      }
	</style>
	
<!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->
<!-- <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script> -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<!-- <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script> -->
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
    		    		   end: new Date(${parseED}),
    		    		  /*  end: "${fundingED}" */
    		    		  color:"#"+Math.round(Math.random()*0xffffff).toString(16),
    		    		  textColor: "white"
    		    	   },
    	    		</c:forEach>
    	      ],
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
</head>
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Funding Schedule</h1>

          <!-- DataTales Example -->
          <div class="row">

            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Funding Calendar</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div id='calendar'></div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5" data-aos="fade-right">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Top 5</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
						<h3 align="center">급상승 펀딩 조회수 Top5</h3>
			                <h5></h5>
			                <table align="center" class="table">
			                    <thead class="thead-dark">
				                    <tr>
				                        <th>글번호</th>
				                        <th>제목</th>
				                        <th>작성자</th>
				                        <th>조회수</th>
			                        </tr>
			                    </thead>
			
			                    <tbody id="funding-topViews">
									
			                    </tbody>
			                </table>
                </div>
              </div>
              
             <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Top 5</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
						<h3 align="center">오늘 마감 달성률 Top5</h3>
			                <h5></h5>
			                <table align="center" class="table">
			                    <thead class="thead-dark">
				                    <tr>
				                        <th>글번호</th>
				                        <th>제목</th>
				                        <th>작성자</th>
				                        <th>달성률</th>
			                        </tr>
			                    </thead>
			
			                    <tbody id="funding-endtop">
									
			                    </tbody>
			                </table>
                </div>
              </div>
            </div>
            
          </div>
          
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Funding Table</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <select id="selectBox">
					<option value='Y'>진행중인 프로젝트</option>
					<option value='S'>성공한 프로젝트</option>
					<option value='N'>마감 & 삭제한 프로젝트</option>
				</select>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <button type="button" class="btn btn-outline-secondary" id="deleteFunding">삭제</button>
                  <thead>
                    <tr>
                  		<th>선택</th>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>글쓴이</th>
                      <th>펀딩 시작</th>
                      <th>펀딩 마감</th>
                      <th>목표 금액</th>
                      <th>현재 금액</th>
                      <th>달성률</th>
                      <th>수수료</th>
                    </tr>
                  </thead>
                  
                  <tfoot>
	                  <tr>
	                  <th>선택</th>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>글쓴이</th>
                      <th>펀딩 시작</th>
                      <th>펀딩 마감</th>
                      <th>목표 금액</th>
                      <th>현재 금액</th>
                      <th>달성률</th>
                      <th>수수료</th>
                    </tr>
                  </tfoot>
                  <!-- <tbody>
                  </tbody> -->
                </table>
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
     
     $(function(){
    	 topViews();
    	 
    	 // 일정시간(1분)마다 리스트 갱신.
    	 setInterval(function(){
    	topViews();
    	}, 60000);
     });
     
     function topViews(){
    	 $.ajax({
    		 url : "topViews",
    		 dataType: "json",
    		 success : function(map){
    			 
    			 console.log(map.list);
    			 console.log(map.list2);
    			 console.log(map.list2.length);
    			 
    			 $("#funding-topViews").html("");
    			 
    			 $.each(map.list, function(index, item){
 					
 					var $tr = $("<tr>"); // 행
 					var $td1 = $("<td>").text(item.fundingNo);
 					var $td2 = $("<td>").text(item.fundingTitle);
 					var $td3 = $("<td>").text(item.memberName);
 					var $td4 = $("<td>").text(item.readCount);
 					
 					$tr.append($td1, $td2, $td3, $td4);
 					$("#funding-topViews").append($tr);
 					
 				});
    			 
    			 if(map.list2.length != 0){
    				 
    				 $("#funding-endtop").html("");
    				 
	    			 $.each(map.list2, function(index, item){
	 					
	    				$("#funding-endtop").append($tr);
	 					var $tr = $("<tr>"); 
	 					var $td1 = $("<td>").text(item.fundingNo);
	 					var $td2 = $("<td>").text(item.fundingTitle);
	 					var $td3 = $("<td>").text(item.memberName);
	 					var $td4 = $("<td>").text(item.fees);
	 					
	 					$tr.append($td1, $td2, $td3, $td4);
	 					
	 					$("#funding-endtop").append($tr);
	 				});
    			 }else{
    				 
    				 $("#funding-endtop").html("");
    				 
    				 var $hr = $("<h3> 오늘 마감하는 펀딩이 없습니다.")
    				 var $tr = $("<tr>"); 
	 				 var $td1 = $("<td>").html("<h5> 오늘 마감하는 펀딩이 없습니다.</h5>").attr("colspan", "4");
	 				 $tr.append($td1);
    				 $("#funding-endtop").append($tr);
    			 }
    		 },error : function(){
    			 console.log("ajax 통신 실패");
    		 }
    			
    	 })
     }
      
     var listStatus = 'Y';
      
	  var dataTable;
	  
  	/* function callList(listStatus){ */
  	/* $(document).ready(function(){ */
  	// 문서가 다 로딩된 다음에
  		function callList(listStatus){
  			
  		console.log("listStatus : " + listStatus)
  		
  			dataTable = $("#dataTable").DataTable({
			  ajax : {
				  url : "${contextPath}/admin/funding/listAction",
				  type : "POST",
				  data : {"listStatus" : listStatus},
				  dataType : "JSON",
				  "dataSrc": function(json){
						console.log(json);
						var list = json;

						for ( var i=0 ; i < json.length ; i++ ) {
							json[i].checkBox = "<input type='checkbox' name='chk'>";
							json[i].calGoal = list[i].fundingGoal.toLocaleString();
							json[i].calCurrent = list[i].currentAmount.toLocaleString();
							json[i].calResult = (parseInt(list[i].currentAmount) / parseInt(list[i].fundingGoal) * 100).toFixed(2) + "%";
		  					json[i].calFees = list[i].fees.toLocaleString();
						}

						return json;
					}

			 	},
                columns : [
                    {data: "checkBox"},
                    {data: "fundingNo"},
                    {data: "fundingTitle"},
                    {data: "memberName"},
                    {data: "fundingSD"},
                    {data: "fundingED"},
                    {data: "calGoal"},
                    {data: "calCurrent"},
                    {data: "calResult"},
                    {data: "calFees"}
                ]
		  });
		} 
  	
  	
  	$("#selectBox").on("change", function(){
		  
		  var listStatus = $(this).val();
		  dataTable.destroy();
		  callList(listStatus);
		  
	  });
  	
  	  $(function(){
  		  console.log("listStatus : " + listStatus);
    	 callList(listStatus);
      })
      
      // 리스트 가져오기 레디함수
      
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
      
      $(document).on("click","#deleteFunding",function(e){
    	  										// 이벤트의 정보
    	  var table = $(this).parent().attr("id");
    	  										
    	  //console.log( $(this).parent().attr("id") );
    	  
    	  
    	  // console.log($("input[name=chk]:checked"));
    	  
/*     	  $("input[name=chk]:checked").each(function(index, item){
    		  console.log($(item).parent().next().text());
    	  }); */
    	  
    	  var checkArr = $("input[name=chk]:checked").parent().next("td");
    	  // 글 번호들이 담김
    	  console.log("Arr:"+checkArr);
    	  var boardNumbers = [];
    	  
   		for(var i=0 ; i<checkArr.length ; i++){
 			boardNumbers.push($(checkArr[i]).text());
 		}
   		console.log(boardNumbers);
    	  if(boardNumbers.length==0){
    		  alert("삭제할 게시물을 선택하세요.");
    	  }else{
			$.ajax({
				url : "deleteAction",
				data: { "fundingNo" : boardNumbers.join()},
				type: "POST",
				success : function(result){
					
					if(result > 0){
						
						swal({
							  title: "삭제 성공했습니다.",
							  icon: "success"
							});
					var currentStatus = $("#selectBox").val();
					
					dataTable.destroy();
					callList(currentStatus);
					
					}
				}
				
			});
    	  }
    	  
	 });
      
   
      </script>
</body>

</html>
