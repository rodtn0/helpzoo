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
	#dataTable{
		cursor :pointer;
	}
	#title:hover{
		color: red;
		font-weight: bold;
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
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Answer Table</h6>
            </div>
            <div class="card-body">
            <div id="top">
      <div id="top-1">
      <a id="a1">- 지출 조회 -</a> 
      <table id="list">
          <tr>
            <td><a class="Year-Month"><span name="year"></span>-01</a><td>
            <td><a class="Year-Month"><span name="year"></span>-02</a><td>
            <td><a class="Year-Month"><span name="year"></span>-03</a><td>
          </tr>
          <tr>
            <td><a class="Year-Month"><span name="year"></span>-04</a><td>
            <td><a class="Year-Month"><span name="year"></span>-05</a><td>
            <td><a class="Year-Month"><span name="year"></span>-06</a><td>
          </tr>
          <tr>
            <td><a class="Year-Month"><span name="year"></span>-07</a><td>
            <td><a class="Year-Month"><span name="year"></span>-08</a><td>
            <td><a class="Year-Month"><span name="year"></span>-09</a><td>
          </tr>
          <tr>
            <td><a class="Year-Month"><span name="year"></span>-10</a><td>
            <td><a class="Year-Month"><span name="year"></span>-11</a><td>
            <td><a class="Year-Month"><span name="year"></span>-12</a><td>
          </tr>
        </table> 
        <!-- 페이징 바 -->
         <a id ="month-prev">&lt;</a> 
          
              <a id ="month-next">&gt;</a>
      </div>		     
      <!-- 도넛차트 -->      
      <div id="top-2">
        <div id="dounut-chart"></div>
      </div>
    </div>
              <div class="table-responsive">
              	<div id="chart-area"></div>
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
    		var yymm = yy+"/"+ mm; //20/06
    		
    		// hidden보내는구역
    		$("#yymm-result").val(yymm);
    		
    		var mEx = getMonthExpense(yymm); // 도넛 출력 //월지출
    		var mAvg = getMonthAvg(yymm); 
    		var aAvg = getAgeAvg(yymm);
    		var femaleAvg = getFemaleAvg(yymm);
    		var maleAvg = getMaleAvg(yymm);
    		
    		var AllmonthAvg = getAllMonthExpense(yy);
    		var AllmonthMe = getAllMonthMe(yy); 
    		
    		monthExpenseCompare(mEx, mAvg); // 달별 비교
    		monthAgeCompare(aAvg,mEx); //달별/나이대 비교
    		monthGenderCompare(maleAvg,mEx,femaleAvg); // 성별 비교
    		AllMonthExpense(AllmonthAvg, AllmonthMe);
    		
    		
    		
    	}).on("mouseenter",function(){
    		  $(this).parent().css("cursor","pointer");
    		  $(this).parent().css("color","#007bff");
    		  
    	}).on("mouseleave",function(){
    	  	  $(this).parent().css("color","black");
    	});
    	
    // 도넛
    
      var container = document.getElementById('chart-area');
      var data = {
          categories: ['Browser'],
          series: [
              {
                  name: 'Chrome',
                  data: 46.02
              },
              {
                  name: 'IE',
                  data: 20.47
              },
              {
                  name: 'Firefox',
                  data: 17.71
              },
              {
                  name: 'Safari',
                  data: 5.45
              },
              {
                  name: 'Opera',
                  data: 3.10
              },
              {
                  name: 'Etc',
                  data: 7.25
              }
          ]
      };
      var options = {
          chart: {
              width: 700,
              height: 700,
              title: 'Usage share of web browsers',
              format: function(value, chartType, areaType, valuetype, legendName) {
                  if (areaType === 'makingSeriesLabel') { // formatting at series area
                      value = value + '%';
                  }

                  return value;
              }
          },
          series: {
              radiusRange: ['40%', '100%'],
              showLabel: true
          },
          tooltip: {
              suffix: '%'
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
      </script>

</body>

</html>
