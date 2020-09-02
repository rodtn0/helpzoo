<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ê³µì§ì¬í­ ìì¸íì´ì§</title>
    <style>
        .header, .contents{
            margin: 0 auto;
            max-width: 800px;
        }

        /* ìì¸íì´ì§ í¤ë */
        .header .title{
            font-size: 22px;
            font-weight: 500;
        }

        .hr{
            border-bottom: 1px solid rgba(0,0,0,.1);
        }

        /* ìì¸íì´ì§ contents */
        .contents{
            padding-bottom: 30px;
        }

        /* ìì¸íì´ì§ íë¨ */
        .board-bottom{
            display: flex;
            background-color: #FAFAFA;
            padding: 20px 0 50px;
        }

        .board-bottom .toList{
            margin: 0 auto;
            padding: 0 24px;
            line-height: 2.8;
            font-size: 16px;
            background-color: white;
        }

        .info .user-info{
            font-size: 14px;
        }

    </style>
</head>

<body>
	<jsp:include page="../common/header.jsp"/>
    <main class="board notice">
        
        <!-- ìì¸íì´ì§ í¤ë -->
        <div class="header">
            <p class="title">[ê³µì§]në²ì§¸ ê³µì§ìëë¤.</p>
            <div class="info">
                <span class="user-info">admin
                <br>2020-09-02</span>
            </div>
        </div>

        <p class="hr"/>

        <!-- ìì¸íì´ì§ contents -->
        <div class="contents">
            ìì¸íì´ì§
        </div>
        
        <!-- ìì¸íì´ì§ íë¨ -->
        <div class="board-bottom">
            <button class="toList" onclick="history.back()">
                ëª©ë¡ì¼ë¡ ëìê°ê¸°
            </button>
        </div>
        
    </main>
   	<jsp:include page="../common/footer.jsp"/>
</body>
</html>