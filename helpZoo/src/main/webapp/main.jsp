<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>도와주(HelpZoo)</title>
	
	<style>
		#main{
			height : 800px;
		}
	</style>
</head>
<body>
	<jsp:include page="WEB-INF/views/common/header.jsp"/>
	<div id="main">
	
		<h1>
			Hello world!?
		</h1>
	
		<P>  The time on the server is ${serverTime}. </P>
	
	</div>
	
	<jsp:include page="WEB-INF/views/common/footer.jsp"/>
</body>
</html>
