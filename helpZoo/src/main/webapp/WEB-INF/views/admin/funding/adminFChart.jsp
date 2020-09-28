<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://uicdn.toast.com/tui.chart/latest/tui-chart.min.js"></script>
	<link rel="stylesheet" href="https://uicdn.toast.com/tui.chart/latest/tui-chart.min.css">
    <link rel='stylesheet' type='text/css' href='https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.43.0/codemirror.css'/>
    <link rel='stylesheet' type='text/css' href='https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.43.0/addon/lint/lint.css'/>
    <link rel='stylesheet' type='text/css' href='https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.43.0/theme/neo.css'/>
<style>
	#wrapper1{width: 100%; height: 100%;}
	
	#top{width: 100%; height: 50%;}
	    #top-1{width:30%; height: 100%; text-align: center; float: left;}
	    #top-2{width:70%; height: 100%; padding-left: 30px; float: left;}
	      	#date-area{width: 100%; height: 15%;}
	      	#chart-area{ width: 100%; height: 85%;}   
	  
    #md{width: 100%; height: 50%; clear:both !important;}
      #middle-1{width: 50%; height: 50%; float: left;}
      #middle-2{width: 50%; height: 50%; float: left;}


      #bottom{width: 100%; height: 35%; text-align:center;}

      #btn-area{width: 800px; height: 150px; text-align: center;}
      #btn-area>button{margin-top: 30px;}
      
      #post-expense-area {
      	display: inline-block;
      }
      
	  #list{margin-top:20px; margin-left: auto; margin-right: auto; text-align: center;}
      td{width: 100px;}
      td>a{ font-size: 15px; text-decoration: none; color: black; }
      
      #top-1>#a1{font-size: 15px; margin-top: 70px;}
      #month-prev{margin-right: 30px;}
/*       #month-prev{font-size: 18px; margin-top: 12px; margin-left: 90px;}
      #month-next{font-size: 18px; margin-top: 12px; margin-left: 80px;} */
      
      #expense{font-family: "NEXON Lv2 Gothic Bold";
    			margin: auto;}
    			
    #paging{text-align: center; margin-top: 20px;}
</style>
</head>

<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Funding Chart</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Funding Chart</h6>
            </div>
            <div class="card-body">
            	<div id="wrapper1">
	            	<div id="top">
			             <div id="top-1">
				               <a id="a1"> <i class="fas fa-won-sign"></i> 월별 조회 </a> 
					             <table id="list">
					             		<tr>
					             			<td><a class="Year-Month"><span name="year"></span>-01</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-02</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-03</a></td>
					             		</tr>
					             		<tr>
					             			<td><a class="Year-Month"><span name="year"></span>-04</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-05</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-06</a></td>
					             		</tr>
					             		<tr>
					             			<td><a class="Year-Month"><span name="year"></span>-07</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-08</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-09</a></td>
					             		</tr>
					             		<tr>
					             			<td><a class="Year-Month"><span name="year"></span>-10</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-11</a></td>
					             			<td><a class="Year-Month"><span name="year"></span>-12</a></td>
					             		</tr>
					             </table>
				             	<!-- 페이징 바 -->
				             	<div id="paging">
				             	 <a id ="month-prev"><i class="fas fa-angle-left"></i></a> 
		                         <a id ="month-next"><i class="fas fa-angle-right"></i></a>
		                        </div> 
			             </div>		 
			             
			             <!-- 월별 그래프 -->      
			             <div id="top-2">
				             <div id="date-area">
				             <a style="font-size: 25px; font-weight: bold;" id="YYMM-text"></a>
				          	 </div>
			             	<div id="chart-area"></div>
			             </div>
			     </div>
		             
		     <div id="md">
		             <!-- 도넛 -->
	             <div id="middle-1">
	                  <div id="chart-age"></div>
	              </div>
	              <div id="middle-2">
	              	<div id="chart-area2"></div>
	              </div>
		     </div>
		             
            </div>
              
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
     <script type='text/javascript' src='https://uicdn.toast.com/tui.chart/latest/raphael.js'></script>
	<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/core-js/2.5.7/core.js'></script>
	<script src='${contextPath}/resources/dist/tui-chart.js'></script>
      <!-- End of Main Content -->
      <jsp:include page="../../common/adfooter.jsp"/>
      
      <script>
      $(".Year-Month").click(function(){
    		var YYMM = $(this).text();
    		$("#YYMM-text").text(YYMM);
    				
    		//에이젝스		
    		//var yyyymm = $("#YYMM-text").val(); //ex) 2020-06
    		var yy = YYMM.substring(2,4); //20
    		var mm = YYMM.substring(5,7); //06
    		var yymm = yy+"-"+ mm;
    		
    		var mFee = getMonthFees(yy); // ajax로 값 불러오기
    		monthFees(mFee); // 집어 넣기
    		var mCategory = getMonthCategory(yymm);
    		monthCategory(mCategory);
    		var mSuccess = getMonthSuccess(yymm);
    		monthSuccess(mSuccess);
    		
    	}).on("mouseenter",function(){
    		  $(this).parent().css("cursor","pointer");
    		  $(this).parent().css("color","#007bff");
    		  
    	}).on("mouseleave",function(){
    	  	  $(this).parent().css("color","black");
    	});
    	
	// 그래프
	function monthFees(mFee){
	     var container = document.getElementById('chart-area');
			container.innerHTML = "";
	     	console.log(mFee);
	     	
	     	var edList = [];
	     	for(var i=0; i<mFee.length ; i++){
	     		//console.log(mFee[i].fundingED.lastIndexOf('-'));
	     		//console.log(mFee[i].fundingED.substring(0, mFee[i].fundingED.lastIndexOf('-')));
	     		
	     		edList.push(mFee[i].fundingED.substring(0, mFee[i].fundingED.lastIndexOf('-')));
	     	}
	     	
	     	var feesList = [];
	     	for(var i=0; i<mFee.length ; i++){
	     		feesList.push(mFee[i].fees);
	     	}
	     	
	     	console.log(edList);
	     	console.log(feesList);
			var data = {
			    categories: edList,
			    
			    series: [
			        {
			            name: 'Fees',
			            data: feesList
			        }
			    ]
			};
			var options = {
			    chart: {
			        width: 800,
			        height: 340,
			        title: '펀딩 월별 수수료',
			    },
			    yAxis: {
			        title: 'Price',
			        min: 500000,
			        max: 15000000
			    },
			    xAxis: {
			        title: 'Month',
			        pointOnColumn: true,
			        dateFormat: 'MMM',
			        tickInterval: 'auto'
			    },
			    series: {
			        showDot: false,
			        zoomable: true
			    }
			};
			var theme = {
			    series: {
			        colors: [
			            '#83b14e', '#458a3f', '#295ba0', '#2a4175', '#289399',
			            '#289399', '#617178', '#8a9a9a', '#516f7d', '#dddddd'
			        ]
			    }
			};
			// For apply theme
			// tui.chart.registerTheme('myTheme', theme);
			// options.theme = 'myTheme';
			var chart = tui.chart.lineChart(container, data, options);
	   	}
	
	function monthCategory(mCategory){
		var container = document.getElementById('chart-age');
		container.innerHTML = "";
	 	console.log(mCategory);
	 	
	 	if(mCategory.length != 0){
	 	
		 	var amountList = [];
		 	for(var i=0; i<mCategory.length ; i++){
		 		var amount = {};
		 		amount.name = mCategory[i].category;
		 		amount.data = mCategory[i].proportion;
		 		
		 		amountList.push(amount);
		 	}
		 	
		 	// 1. 장난감 2. 사료 3. 운동기구. 4. 옷 5. 간식
			var data = {
			    categories: ['Browser'],
			    series: amountList
			};
			var options = {
			    chart: {
			        width: 500,
			        height: 500,
			        title: '펀딩 카테고리별 매출',
			        format: function(value, chartType, areaType, valuetype, legendName) {
			            if (areaType === 'makingSeriesLabel') { // formatting at series area
			                value = value+ '원';
			            }
		
			            return value;
			        }
			    },
			    series: {
			        radiusRange: ['40%', '100%'],
			        showLabel: true
			    },
			    tooltip: {
			        suffix: '원'
			    },
			    legend: {
			        align: 'bottom'
			    }
			};
			var theme = {
			    series: {
			        series: {
			            colors: [
			                '#83b14e', '#458a3f', '#295ba0', '#2a4175', '#289399',
			                '#289399', '#617178', '#8a9a9a', '#516f7d', '#dddddd'
			            ]
			        },
			        label: {
			            color: '#fff',
			            fontFamily: 'sans-serif'
			        }
			    }
			};
		
				// For apply theme
		
				tui.chart.registerTheme('myTheme', theme);
				options.theme = 'myTheme';
			
				tui.chart.pieChart(container, data, options);
	 	}
	 	else{
	 		container.innerHTML = "<h2>데이터가 없습니다.</h2>";	
	 	}
	}
	
	function monthSuccess(mSuccess){
		var container = document.getElementById('chart-area2');
		container.innerHTML = "";
		console.log(mSuccess)
		console.log(mSuccess.length)
		if(!(mSuccess[0].fundingFailure == 0 && mSuccess[0].fundingProgress == 0 && mSuccess[0].fundingSuccess == 0)){
			
		var data = {
		    categories: ['Browser'],
		    series: [
		        {
		            name: '실패한 펀딩',
		            data: mSuccess[0].fundingFailure
		        },
		        {
		            name: '진행중인 펀딩',
		            data: mSuccess[0].fundingProgress
		        },
		        {
		            name: '성공한 펀딩',
		            data: mSuccess[0].fundingSuccess
		        }
		    ]
		};
		var options = {
		    chart: {
		        width: 500,
		        height: 500,
		        title: '펀딩 성공률'
		    },
		    tooltip: {
		        suffix: '건'
		    }
		};
		var theme = {
		    series: {
		        colors: [
		            '#83b14e', '#458a3f', '#295ba0', '#2a4175', '#289399',
		            '#289399', '#617178', '#8a9a9a', '#516f7d', '#dddddd'
		        ]
		    }
		};
		
		tui.chart.pieChart(container, data, options);
		
	}else{
		container.innerHTML = "<h2>데이터가 없습니다.</h2>";
	}
}
		
		
	// 월별 함수
	function getMonthFees(yy){
		var result;
		$.ajax({
			type: "POST",
			url : "MonthFee",
			data : {"yy" : yy},
			async : false,
			dataType: "json",
			success : function(json){
				console.log(json);
				result = json;
			},error : function(){
				console.log("ajax 통신 실패");
			}
		});
		
		return result;
	}
	
	function getMonthCategory(yymm){
		var result;
		$.ajax({
			type: "POST",
			url : "MonthCategory",
			data : {"yymm" : yymm},
			async : false,
			dataType: "json",
			success : function(json){
				console.log(json);
				result = json;
			},error : function(){
				console.log("ajax 통신 실패");
			}
		});
		
		return result;
	}
	
	function getMonthSuccess(yymm){
		var result;
		$.ajax({
			type: "POST",
			url : "MonthSuccess",
			data : {"yymm" : yymm},
			async : false,
			dataType: "json",
			success : function(json){
				console.log(json);
				result = json;
			},error : function(){
				console.log("ajax 통신 실패");
			}
		});
		
		return result;
	}
	
	// 오늘 날짜 출력 
	var today = new Date();
	$(function(){
		var month = (today.getMonth()+1);
		var thisyear =  today.getFullYear();
	
		var str = thisyear + "-"
				+ (month < 10 ? "0" + month : month);
		$("#YYMM-text").text(str);
		$("span[name='year']").text(thisyear);

		// 바로 시작하게 하기
		$(".Year-Month").each(function(index, item){
			if($(item).text() == str){
				$(item).click();
			}
		});
	});

	//페이징 바
	var year = today.getFullYear();
	
	$("#month-next").on('click',function(){
		year++;
		$("span[name='year']").text(year); 
		
		if(year>today.getFullYear()){
			alert("다음 년도가 존재하지 않습니다.");
			year=year-1;
		$("span[name='year']").text(year); 
		}
		
	}).on("mouseenter",function(){
	  	  $(this).css("cursor","pointer");
		  $(this).css("color","#7fcdcd");
	  	  
  	}).on("mouseleave",function(){
    	  $(this).css("color","black");
      });
	
	
	$("#month-prev").on('click',function(){
		year--;
		$("span[name='year']").text(year); 
		
		if(year<today.getFullYear()-2){
			alert("3년 간의 기록만 조회 가능합니다.");
			year=year+1;
		$("span[name='year']").text(year); 
		}
		
	}).on("mouseenter",function(){
	  	  $(this).css("cursor","pointer");
		  $(this).css("color","#7fcdcd");
  	}).on("mouseleave",function(){
  	  $(this).css("color","black");
    });
      </script>

</body>

</html>
