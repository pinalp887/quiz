<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Please Select the category</h1>

<c:forEach items="${list }" var="l">
	${l.name }
	
	<c:url value="/play/get/${l.id}" var="getId"></c:url>
	<a href="${getId }">SELECT</a>
</c:forEach>
</body>
</html>