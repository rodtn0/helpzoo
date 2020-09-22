<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 멤버 관리 페이지</title>
</head>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
		<main>

		<div class="card">
			<div class="card-header">
				<h1>멤버 관리 페이지</h1>
			</div>

			<div class="card-body">
		
				<table class="table table-striped">
					<thead class="thead text-white bg-info mb-3">
						<tr>
							<th><input type="checkbox"></th>
							<th>글번호</th>
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
					
					<tbody class="">
						<c:choose>
							<c:when test="${empty memberList}">
								<tr><td colspan="9">존재하는 계정이 없습니다.</td></tr>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="board" items="${memberList}" varStatus="vs">
									<tr>
										<td><input type="checkbox"></td>
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
		
		</main>
	<jsp:include page="../../common/adfooter.jsp"/>
</body>
</html>