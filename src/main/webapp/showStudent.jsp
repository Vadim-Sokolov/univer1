<%@page import="com.foxminded.univer.models.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${user.userInfo.name}
	<%
		request.getAttribute("student");
	%>
</body>
</html>