<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>도와zoo 공지사항</title>
    <style>
        body li{
            list-style: none;
        }

        a {
            text-decoration:none;
            color: black;
        }

        .ui-header, .board-main{
            margin: 0 auto;
            max-width: 800px;

        }

        .ui-header .title{
            text-align: center;
            font-size: 48px;
            font-weight: 700;
        }

        /* 공지사항 타이틀 */
        .ui-header{
        }

        /* 공지 / 이벤트 네비게이션 */
        .ui-tabs ul{
            padding: 0;
        }

        .ui-tabs li{
            display: inline-block;
            padding: 20px 20px 0 20px;
        }

        .ui-tabs{
            text-align: center;
            border-bottom: 1px solid rgba(0,0,0,.1);
        }

        /* 게시판 리스트 */

        .board-main li{
            border-bottom: 1px solid rgba(0,0,0,.1);
            padding-top: 20px;
        }

        .board-main .info{
            padding-bottom: 20px;
        }
        
        .article .boardNo{
        	display: none;
        }
    </style>
</head>

<body>
	<jsp:include page="../common/header.jsp"/>
	    <main class="board wzui">
	
	        <!-- 공지사항 타이틀 -->
	        <div class="ui-header">
	            <h2 class="title">공지사항</h2>
	        </div>
	
	        <!-- 공지 / 이벤트 네비게이션 -->
	        <div class="ui-tabs">
	            <ul>
	                <li class="active">
	                    <a href="${contextPath}/notice/noticeList">공지사항</a>
	                </li>
	                <li>
	                    <a href="${contextPath}/event/eventList">이벤트</a>
	                </li>
	            </ul>
	        </div>
	
	        <!-- 게시판 리스트 -->
	        <div class="board-main">
	        	<c:choose>
	        		<c:when test="${empty noticeList}">
	        			<ul>
		        			<li>
			                    <a class="article">
			                        <em class="category">공지사항</em>
			                        <div class="info">
			                            <h3 class="title">공지사항이 없습니다.</h3>
			                            <span class="author">admin</span>
			                        </div>
			                    </a>
		        			</li>
	        			</ul>
	        		</c:when>
	        		
	        		<c:otherwise>
						<ul>
							<c:forEach var="notice" items="${noticeList}">
				                <li>
				                    <a class="article">
				                    	<span class="boardNo">${notice.boardNo}</span>
				                        <em class="category">${notice.boardName}</em>
				                        <div class="info">
				                            <h3 class="title">${notice.boardTitle}</h3>
				                            <span class="author">${notice.boardWriter}</span>
				                            <span class="created-at">${notice.boardCreateDate}</span>
				                        </div>
				                    </a>
				                </li>
							</c:forEach>
						</ul>
	        		</c:otherwise>
	        	</c:choose>
	        </div>
	        
	    </main>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
		/* var test = "${notice.boardNo}";
		$test.each(function(index, item) {
			console.log($(item.val()));
		}); */
		
		$(function() {
			$('.board-main .article').on('click', function() {
				
				var boardNo = $(this).parent().children().eq(0).text();
				
				console.log(boardNo.val());
				
			});
		});
		
	</script>
	
</body>
</html>