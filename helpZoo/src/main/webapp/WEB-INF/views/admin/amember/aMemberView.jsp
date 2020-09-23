<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 멤버 관리 페이지</title>
<style>
	table{
		cursor : pointer;
	}
	.tbody .odd:hover, .tbody .even:hover{
		background-color: lightblue;
	}
	
</style>
</head>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
		<main>

		<div class="card">
			<div class="card-header">
				<h1>멤버 관리 페이지</h1>
			</div>
			<div class="container-fluid">
				<div class="card-body">
					<div class="table-responsive">
			
						<table class="table table-striped" id="dataTable">
							<thead class="thead text-white bg-info mb-3">
								<tr>
									<th>멤버번호</th>
									<th>아이디</th>
									<th>이름</th>
									<th>전화번호</th>
									<th>이메일</th>
									<th>반려동물종류</th>
									<th>반려동물이름</th>
									<th>멤버상태</th>
									<th>멤버등급</th>
								</tr>
							</thead>
							
							<tbody class="tbody">
								<c:choose>
									<c:when test="${empty memberList}">
										<tr><td colspan="9">존재하는 계정이 없습니다.</td></tr>
									</c:when>
									
									<c:otherwise>
										<c:forEach var="board" items="${memberList}" varStatus="vs">
											<tr>
												<td>${board.memberNo}</td>
												<td>${board.memberId}</td>
												<td>${board.memberName}</td>
												<td>${board.memberPhone}</td>
												<td>${board.memberEmail}</td>
												<td>${board.memberPetType}</td>
												<td>${board.memberPetName}</td>
												<td>${board.memberStatus}</td>
												<td>${board.memberGrade}</td>
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
			let memberNo =$(this).parent().children().eq(0).text();
    		
			console.log(memberNo);
    		
    		swal({
    				title : "정말 " + memberNo + "번 계정을 정지시키겠습니까?",
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
	    			location.href="${contextPath}/admin/member/delMember/" + memberNo;
    			}
    		})
    		 
    	});
		
	</script>
</body>
</html>