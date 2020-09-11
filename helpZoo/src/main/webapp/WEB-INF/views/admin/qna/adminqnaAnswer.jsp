<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<style>
/*댓글*/
.replyWrite>table {
	width: 90%;
}

#replyContentArea {
	width: 90%;
}

#replyContentArea>textarea {
	resize: none;
	width: 100%;
}

#replyBtnArea {
	width: 100px;
	text-align: center;
}

.rWriter {
	display : inline-block;
	margin-right: 30px;
	vertical-align: top;
	font-weight: bold;
	font-size: 1.2em;
}

.rDate {
	display : inline-block;
	font-size: 0.5em;
	color: gray;
}

#replyListArea {
	list-style-type: none;
}

.rContent, .btnArea{
	display: inline-block;
	box-sizing: border-box;
}

.rContent {
	height: 100%;
	width : 100%;
	word-break:normal;
}

hr{
    clear: both;
}

.replyUpdateContent{
	resize: none;
	width: 70%;
}


/* 답글 */
.reply2-li{
	padding-left: 50px;  
}

.reply2Area{
	padding-top : 30px;
	width : 80%;
}

.reply2Content{
	resize: none;  
	width : 100%; 
}

.answer{
font-size: 40px;

}
.btnAnswer{
	width: 70px;
	height: 70px;
}
</style>
<div id="replyArea">
	<!-- 댓글 작성 부분 -->
<c:choose>
	<c:when test="${empty answerBoard}">
	<div class="replyWrite">
		<table align="center">
			<tr>
				<td id="replyContentArea"><textArea rows="3" id="replyContent"></textArea>
				</td>
				<td id="replyBtnArea">
					<button class="btn btn-outline-info btnAnswer" id="addAnswer"><i class="fas fa-paw answer"></i></button>
				</td>
			</tr>
		</table>
	</div>
	</c:when>

	<c:otherwise>
	<!-- 댓글 출력 부분 -->
	<div class="replyList mt-10">
		<ul id="replyListArea">
		<li class="reply-row" id="21">
			<div>
				<a class="rWriter idSelect">${answerBoard.qnaWriter}</a>
				<p class="rDate">작성일 : ${answerBoard.qnaCreateDate}</p>
			</div>
			<p class="rContent">${answerBoard.qnaContent}</p>
		</ul>
	</div>
	</c:otherwise>
</c:choose>
</div>

<script>
	
	$("#addAnswer").on("click",function(){
		
		var qnaContent = $("#replyContent").val();
		var Writer = "${board.qnaWriter}";
		var Content = $("#board-content").text();
		
		if(qnaContent.trim().length == 0){
			alert("답글 작성 후 클릭해주세요.");
			
		}else{
			var url = "${contextPath}/admin/qna/${board.qnaNo}/answer";
			
			console.log(url);
			
			$.ajax({
				url : url,
				type : "POST",
				data: {"qnaContent" : qnaContent,
						"Writer" : Writer,
						"Content" : Content},
				dataType : "text",
				success : function(result){
					alert(result);
					location.reload();
				},error : function(){
					console.log("통신 실패");
				}
			});
		}
	});
</script>