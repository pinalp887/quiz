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
	<table border="1px">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Category</td>
			<td colspan="2" align="center">Action</td>
		</tr>
		<c:forEach items="${list }" var="l">
			<c:url  value="/AddCategoryapi/get/${l.id }" var="editUrl"></c:url>
			<c:url value="/AddCategoryapi/delete/${l.id }" var="deleteUrl"></c:url>
			<tr>
				<td>${l.id }</td>
				<td>${l.name }</td>
				<td>${l.qcategory }</td>
				<td><a href="${editUrl }">Edit</a></td>
				<td><a href="${deleteUrl }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>