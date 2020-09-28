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

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Qustion Table</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>글쓴이</th>
                      <th>작성일</th>
                      <th>조회수</th>
                      <th>답변여부</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>글번호</th>
                      <th>제목</th>
                      <th>글쓴이</th>
                      <th>작성일</th>
                      <th>조회수</th>
                      <th>답변여부</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  
                  <c:choose>
                  	<c:when test="${empty qnaList}">
                  		<tr><td colspan="6">존재하는 질문이 없습니다. </td></tr>
                  	</c:when>
                  	
                  	<c:otherwise>
                  		<c:forEach var="board" items="${qnaList}" varStatus="vs">
                  		<tr>
                  			 <td>${board.qnaNo}</td>
                  			 <td id="title">${board.qnaTitle}</td>
                  			 <td>${board.qnaWriter}</td>
                  			 <td>${board.qnaModifyDate}</td>
                  			 <td>${board.readCount}</td>
                  			 <c:choose>
	                  			 <c:when test="${board.qnaAnswer > 1}">
	                  			 	<td>Yes <i class="far fa-circle"></i></td>
	                  			 </c:when>
	                  			 <c:otherwise>
	                  			 	<td>No <i class="fas fa-times"></i></td>
	                  			 </c:otherwise>
	                  		</c:choose>
	                  	</tr>
                  		</c:forEach>
                  	</c:otherwise>
                  </c:choose>
                  
                  </tbody>
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
      // 게시글 상세보기 기능 구현
      // 동적
      // ajax로 (비동기식)으로 페이징 처리!!
    	 $(document).on("click","#dataTable td",function(){
    		 var qnaNo =$(this).parent().children().eq(0).text();
    		 console.log(qnaNo);
    		 // helpzoo/
    		 var boardUrl = "${contextPath}/admin/qna/"+ qnaNo;
    		 
    		 location.href = boardUrl;
    	});
      </script>

</body>

</html>
