<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      
      <script>
      // 게시글 상세보기 기능 구현
      $(function(){
    	 $("##dataTable").on("click",function(){
    		 var boardNo =$(this).parent().children().eq(0).text();
    		 
    		 // helpzoo/
    		 var boardUrl = "${contextPath}/admin/qna/"+ boardNo;
    		 
    		 location.hrf = boardUrl;
    	 });
      });
      </script>

</body>

</html>
