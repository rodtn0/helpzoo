<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

	.container *{font-size: 13px;}
	
	.well {
	    min-height: 20px;
	    padding: 19px;
	    margin-bottom: 20px;
	    background-color: #f5f5f5;
	    border: 1px solid #e3e3e3;
	    border-radius: 4px;
	    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
	    box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
	}

	.btn{
	width: 70px;
    height: 30px;
    font-size: small !important;
	}
	
	.deleteImg {
	display: block !important;
    margin: 10px auto;
	}

</style>
<script src="https://kit.fontawesome.com/13be1766f6.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="../../common/adheader.jsp"/>
<div class="container-fluid">
		<h1 class="h3 mb-2 text-gray-800">Frequency Answer and Question</h1>
			<hr>
			<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Answer Table</h6>
            </div>
            <div class="card-body">
			
			<form action="insertAction" method="post" role="form"
			encType="multipart/form-data" onsubmit="return validate();">

				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">제목</label> 
					<input type="text" class="form-control" id="title" name="boardTitle" size="70"
					autocomplete="off" style= "height: 27px;">
				</div>

				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">작성자</label>
					<h5 class="my-0" id="writer">${loginMember.memberId}</h5>
				</div>


				<div class="form-inline mb-2">
					<label class="input-group-addon mr-3 insert-label">작성일</label>
					<h5 class="my-0" id="today">
						<jsp:useBean id="now" class="java.util.Date" />
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
					</h5>
				</div>  

				<hr>

				<div class="form-group">
					<div>
						<label>내용</label>
					</div>
<textarea class="form-control" id="content1" name="boardContent" rows="10" style="resize: none;"></textarea>
				</div>

				<hr class="mb-4">

				<div class="text-center">
					<button type="submit" class="btn btn-info"><i class="fas fa-file-signature"></i> 등록</button>
					<button type="reset" class="btn btn-info" onclick="history.back()"><i class="fas fa-window-close"></i> 취소</button>
					<%-- <a class="btn btn-primary float-right" href="${header.referer}">목록으로</a> --%>
				</div>
			</form>
		</div>
		</div>
		<hr>
</div>


	<jsp:include page="../../common/adfooter.jsp"/>

	<script>
		
		// 유효성 검사
		function validate() {
			
			if ($("#title").val().trim().length == 0) {
				alert("제목을 입력해 주세요.");
				$("#title").focus();
				return false;
				
			}

			if ($("#content1").val().trim().length == 0) {
				
				alert("내용을 입력해 주세요.");
				$("#content1").focus();
				return false;
				
			}
		}
	</script>
</body>
</html>