<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 펀딩 후기 관리 페이지</title>
<style>
	table{
		cursor : pointer;
	}
	.tbody .odd:hover, .tbody .even:hover{
		background-color: lightgray;
	}
	
</style>
</head>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
		<main>

		<div class="card">
			<div class="card-header">
				<h1>펀딩 후기 관리 페이지</h1>
			</div>
			<div class="container-fluid">
				<div class="card-body">
					<div class="table-responsive">
			
						<table class="table table-striped" id="dataTable">
							<thead class="thead text-white bg-secondary mb-3">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>수정일</th>
									<th>게시물 상태</th>
								</tr>
							</thead>
							
							<tbody class="tbody">
								<c:choose>
									<c:when test="${empty fundingList}">
										<tr><td colspan="6">존재하는 게시물이 없습니다.</td></tr>
									</c:when>
									
									<c:otherwise>
										<c:forEach var="board" items="${fundingList}" varStatus="vs">
											<tr>
												<td>${board.reviewNo}</td>
												<td>${board.reviewTitle}</td>
												<td>${board.memberId}</td>
												<td>${board.reviewCreateDate}</td>
												<td>${board.reviewModifyDate}</td>
												<td>${board.reviewStatus}</td>
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
		
		</main>
	<jsp:include page="../../common/adfooter.jsp"/>
	<script src="${contextPath}/resources/js/demo/datatables-demo.js"></script>
	
	<script>
		$('.tbody td').on('click', function() {
			let boardNo =$(this).parent().children().eq(0).text();
    		
			console.log(boardNo);
    		
    		swal({
    				title : boardNo + "번 게시물을 삭제하겠습니까?",
    				icon : "warning",
    				buttons : {
    					cancel:{
    						text : "Cancel",
    						visible : true,
    						value : false
    					},
    					confirm : {
    						text : "OK",
    						value : true
    					}
    				}
    		}).then((result) =>{
    			if(result){
	    			location.href="${contextPath}/admin/board/delFunding/" + boardNo;
    			}
    		})
    		 
    	});
		
	</script>
</body>
</html>