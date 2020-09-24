<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
<style>
	#dataTable{
		cursor :pointer;
	}
	#title:hover{
		color: red;
		font-weight: bold;
	}
	#createFAQ, #deleteFAQ{
	float: right;
    margin-left: 10px;
	}	
</style>
</head>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
	<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Question And Answer</h1>
          <p class="mb-4">관리자가 사용자 질문에 답변해주는 페이지입니다.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">FAQ Table</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                    	<th>선택</th>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>작성일</th>
                      <th>수정일</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                    <th>선택</th>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>작성일</th>
                      <th>수정일</th>
                      <th>조회수</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  
                  <c:choose>
                  	<c:when test="${empty faqList}">
                  		<tr><td colspan="6">존재하는 게시글이 없습니다.</td></tr>
                  	</c:when>
                  	
                  	<c:otherwise>
                  		<c:forEach var="board" items="${faqList}" varStatus="vs">
                  		<tr>
                  			<td><input type="checkbox" name="chk"></td>
                  			 <td>${board.boardNo}</td>
                  			 <td>${board.boardTitle}</td>
                  			 <td>${board.boardCreateDate}</td>
                  			 <td>${board.boardModifyDate}</td>
                  			 <td>${board.readCount}</td>
	                  	</tr>
                  		</c:forEach>
                  	</c:otherwise>
                  </c:choose>
                  
                  </tbody>
                  <a class="btn btn-outline-secondary" href="createFAQ" id="createFAQ"><i class="fas fa-pencil-alt"></i> FAQ 작성</a>
                  <button type="button" class="btn btn-outline-secondary" id="deleteFAQ">삭제</button>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
      
      <jsp:include page="../../common/adfooter.jsp"/>
      <!-- Page level custom scripts -->
	  <script src="${contextPath}/resources/js/demo/datatables-demo.js"></script>
		<script>
		$(function(){
			$("#deleteFAQ").on("click",function(){
				var checkArr = $("input[name=chk]:checked").parent().next("td");
				console.log(checkArr);
				
				var boardNumbers = [];
		   		for(var i=0 ; i<checkArr.length ; i++){
		 			boardNumbers.push($(checkArr[i]).text());
		 		}
		   		console.log(boardNumbers);
		   		
		   	 if(boardNumbers.length==0){
	    		  alert("삭제할 게시물을 선택하세요.");
	    	  }else{
	    		  $.ajax({
	    			  url : "deleteFAQ",
	    			  data : { "FAQNo" : boardNumbers.join() },
	    			  type : "POST",
	    			  success : function(result){
	    				  if(result > 0){
	    					  alert("삭제되었습니다.");
	    				  }
	    				  	location.reload();
	    			  },error : function(){
	    				  console.log("통신 실패");
	    			  }
	    		  })
	    	  }
			});
		});
		</script>
</body>

</html>
