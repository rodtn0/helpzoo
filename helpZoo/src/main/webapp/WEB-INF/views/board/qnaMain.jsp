<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<style>
		@font-face {
		 font-family: 'NanumBarunGothic';
		 font-style: normal;
		 font-weight: 400;
		 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
		 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf') format('truetype');
		}
            
	
	.table tr *{
	font-family: 'NanumBarunGothic';
	font-size: 10pt;
	} 
	
            

	#paging {
		text-align:center;
		padding-left: 0px;
	}
	#paging li {
		display:inline;
		vertical-align:middle;
	}
	#paging li a {
		display:-moz-inline-stack;	/*FF2*/
		display:inline-block;
		vertical-align:top;
		padding:4px;
		margin-right:3px;
		width:30px !important;
		color:#000;
		font:bold 12px tahoma;
		border:1px solid #eee;
		text-align:center;
		text-decoration:none;
		width /**/:26px;	/*IE 5.5*/
	
	}
	#paging li a.now {
		color:#fff;
		background-color:#7fcdcd;
		border:1px solid #7fcdcd;;
	}
	#paging li a:hover, #paging li a:focus {
		color:#fff;
		border:1px solid #7fcdcd;
		background-color:#7fcdcd;
	}
	.btn{
	width: 80px;
    height: 34px;
    font-size: small !important;
	}
	
	.ec-common-rwd-image{
	width: 15px;
    height: 15px;
	}
	.ec-common-rwd-image2{
	width: 26px;
    height: 14px;
	}
	.ec-common-rwd-image3{
	width: 15px;
    height: 15px;
	}
	#list-table td{
		cursor :pointer;
	}
	#content:hover{
		color: red;
	}
	.search-box{
	  padding: 6px;
	  position: relative;
	  top: 50%;
	  left: 50%;
	  transform: translate(-50%,-50%);
	  height: 30px;
	  background-color: #fff;
	  border: 1px solid #51e3d4;
	  border-radius: 30px;
	  transition: 0.4s;
	  width:30px;
	  float: left;
	}
	.search-box:hover{
	  box-shadow: 0px 0px .5px 1px #51e3d4;
	  width: 282px;
	}
	.search-btn{
	  text-decoration: none;
	  float: right;
	  background-color: #fff;
	  border-radius: 50%;
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  color: #51e3d4;
	  height: 17px;
	  width: 15px;
	}
	.search-box:hover > .search-btn{
	  background-color: #fff;
	}
	.search-txt{
	  display: flex;
	  padding: 0;
	  width: 0px;
	  border:none;
	  background: none;
	  outline: none;
	  float: left;
	  font-size: 1rem;
	  line-height: 0px;
	  transition: .4s;
	}
	.search-box:hover > .search-txt{
	  width: 240px;
	  padding: 0 6px;
	}
	
	</style>
	
	
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>

	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
	<br>
		<div class="section-title" data-aos="fade-up" style="margin-top: 40px;">
	          <h2>Question And Answer</h2>
	    </div>
	</div>
	
<%-- 	<div style="text-align:center; min-height:320px;">
		<img class="d-block w-100" src="<%=request.getContextPath()%>/resources/images/QNA배너.png">
	</div> --%>
	<br>
	<div class="container table" data-aos="fade-up">
		<table class="table table-sm mb-4" id="list-table">
		  <thead>
		    <tr>
		      <th scope="col">글번호</th>
		      <th scope="col">제목</th>
		      <th scope="col">글쓴이</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody>
		  <!-- else if -->
		  	<c:choose>
		  		<c:when test="${empty qnaList }">
		  			<tr><td colsepan="4"> 존재하는 게시글이 없습니다.</td></tr>
		  		</c:when>
		  		
		  	<c:otherwise>
		  		<c:forEach var="qnaBoard" items="${qnaList}" varStatus="vs">
			    <tr>
       			<jsp:useBean id="now" class="java.util.Date"/>
       			<%-- Date now = new Date(); (현재시간) --%>
       			<fmt:formatDate var="today" value="${now}" pattern="yyyy-MM-dd"/>
       			<fmt:formatDate var="createDate" value="${qnaBoard.qnaCreateDate}" pattern="yyyy-MM-dd"/>
       			<fmt:formatDate var="createTime" value="${qnaBoard.qnaCreateDate}" pattern="hh:mm:ss"/>
       			<input type="hidden" name="qnaNo" value="${qnaBoard.qnaNo}">
			      <th scope="row">${pInfo.listCount-( (pInfo.currentPage-1) * pInfo.limit)-vs.index}</th>
			      <td id="content">
			      
			      <c:if test="${qnaBoard.groupLayer == 1 }">
					<img class="ec-common-rwd-image3" src="<%=request.getContextPath()%>/resources/images/답글1.png">	      
			      </c:if>
			      
			      <c:choose>
			      	<c:when test="${today == createDate}">
			      	<img class="ec-common-rwd-image" src="<%=request.getContextPath()%>/resources/images/lock.png"> ${qnaBoard.qnaTitle}
			      	<img class="ec-common-rwd-image2" src="<%=request.getContextPath()%>/resources/images/lastnew.png">
			      	</c:when>
			      	<c:otherwise>
			      	<img class="ec-common-rwd-image" src="<%=request.getContextPath()%>/resources/images/lock.png"> ${qnaBoard.qnaTitle}
	         		</c:otherwise>
			      </c:choose>
			      </td>
			      <td>${qnaBoard.qnaWriter}</td>
 	              <td>
        						
         			<c:choose>
         					
	         			<c:when test="${today == createDate}">
	         			${createTime}
	         			</c:when>
	         			<c:otherwise>
	         			${createDate}
	         			</c:otherwise>
         						
         			</c:choose>
				</td>
				<td>${qnaBoard.readCount}</td>
         	</tr>
         </c:forEach>
        </c:otherwise>
       </c:choose>
	</tbody>
   </table>
    <div class="search-box mt-3">
      <input type="text" class="search-txt" name="id" placeholder="본인 아이디를 입력해주세요.">
      <a class="search-btn" id="searchBtn" href="#">
        <i class="fas fa-search"></i>
      </a>
    </div>
   	<c:if test="${!empty loginMember }">
   	<a class="btn btn-info float-right" href="insert"><i class="fas fa-pencil-alt"></i> 글쓰기</a>
   	</c:if>
   	<br><br>
   	
    <ul id="paging">
   		<c:if test="${pInfo.currentPage > pInfo.pagingBarSize }">
	        <li>
	        	<!-- 맨 처음으로(<<) -->
	        <a href="?cp=1">&lt;&lt;</a></li>
	        	<!-- 이전으로(<) -->
	        	<!-- prev 생성 식 : (현재 페이지 -1) / 페이징바 사이즈(10) * 10-->
	            <!-- el은 자료형이 없어서 나눌 때(4/10) int로 처리 되어 0이 아니라 0.4로 나옴 -->
	            <!-- fmt태그를 이용한 소수점 제거 -->
	        <fmt:parseNumber var="operand1" 
	         value="${(pInfo.currentPage-1)/pInfo.pagingBarSize}"
	         integerOnly="true"/>
	         <c:set var="prev" value="${operand1 * 10}"/>
	        <li><a href="?cp=${prev}">&lt;</a></li>
   		</c:if>
   		
   		<!-- 10개의 페이지 목록 -->
   		<c:forEach var="p" begin="${pInfo.startPage}" end="${pInfo.endPage}">
   			<c:choose>
   			<c:when test="${p==pInfo.currentPage}">
	        <li><a class="now">${p}</a></li>
	        </c:when>
	        <c:otherwise>
	        <li><a href="?cp=${p}">${p}</a></li>
	        </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    
	    <!-- next 생성식 : (현재 페이지 + 9 ) /10 * 10 + 1-->
        <c:if test="${pInfo.maxPage > pInfo.endPage }">
	       <li>
	       	<fmt:parseNumber var="operand2" value="${(pInfo.currentPage + pInfo.pagingBarSize-1) / pInfo.pagingBarSize}" integerOnly="true"/>
	       	<c:set var="next" value="${operand2 * pInfo.pagingBarSize + 1 }"/>
        	<a href="?cp=${next}">&gt;</a>
        	</li>
        	
        	<!-- 맨 끝으로(>>) -->
	        <li>
	        <a href="?cp=${pInfo.maxPage}">&gt;&gt;</a>
	        </li>  
	  </c:if> 
    </ul>
</div>

	<jsp:include page="../common/footer.jsp"/>
	
	<script>
	// 게시글 상세보기 기능 구현
	$(function(){
		$("#list-table td").on("click",function(){
			var id= $(this).parent().children().eq(3).text();
			
			if(${ empty loginMember.memberId }){
				alert("로그인 후 조회하세요.");
			}else{
				var loginId = "${loginMember.memberId}";
			
				console.log(id);
				console.log(loginId);
				
				// 글 번호
				var qnaNo = $(this).parent().children().eq(0).val();
				
				var questionId = "";
				// ajax에서 멤버 아이디를 가져와야됨.
				// QNA번호를 보내서
				
				$.ajax({
					url : "${contextPath}/qna/identification",
					async : false, // 화면 로딩 시 동기식
					data : {"qnaNo" : qnaNo},
					success : function(memberId){ 
						
						questionId = memberId;
						
						if(id == loginId || loginId == "admin" || loginId == questionId){
							// 글 번호
							
							var qnaUrl= "${contextPath}/qna/" + qnaNo + "?cp=${pInfo.currentPage}";
							
							location.href = qnaUrl;
							
						}else{
							alert("회원이 작성하신 글이 아닙니다.");
						}
					}
				})
			}
		});
	});
	
	// -----------------검색 버튼 동작 --------------------
	$("#searchBtn").on("click",function(){
		
		var searchUrl = "";
		var $id = $("input[name='id']");
		
		if($id.val().trim().length==0){
			alert("검색할 아이디를 입력하세요.");
		}else{
			searchUrl = "search?id=" +$id.val();
			location.href = searchUrl;
		}
	});
	
	//------------------검색창 엔터 이벤트 -------------------
	$("input[name='id']").on("keyup",function(event){
		if(event.keyCode==13){
			$("#searchBtn").click();
		}
	})
	
	
</script>
</body>
</html>