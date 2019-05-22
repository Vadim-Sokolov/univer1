<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="prefix" value="${pageContext.request.contextPath}" />
</head>
<body>
	<a href="${prefix}/">Back</a>
	<br>
	<a href="${prefix}/save">Save</a>
	<a href="${prefix}/delete">Delete</a>
	<a href="${prefix}/find">Find</a>
	<a href="${prefix}/showAll">Show All</a>
</body>
</html>