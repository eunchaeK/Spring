<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  contentType="text/html;charset=utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>year=<%= request.getParameter("year") %></h1>
	<P> ${mydate.year}년 ${mydate.month}월 ${mydate.day}일은 ${yoil}요일입니다. </P>
</body>
</html>
