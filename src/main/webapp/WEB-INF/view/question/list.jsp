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
			<td>question</td>
			<td>Answer 1</td>
			<td>Answer 2</td>
			<td>Answer 3</td>
			<td>Answer 4</td>
			<td>Correct Answer</td>
			<td>category</td>
			<td colspan="3" align="center">Action</td>
		</tr>
		<c:forEach items="${list }" var="l">
			<c:url  value="/question/get/${l.id }" var="editUrl"></c:url>
			<c:url value="/question/delete/${l.id }" var="deleteUrl"></c:url>
			<tr>
				<td>${l.id }</td>
				<td>${l.title}</td>
				<td>${l.answer1}</td>
				<td>${l.answer2}</td>
				<td>${l.answer3}</td>
				<td>${l.answer4}</td>
				<td>${l.correctAnswer}</td>
				<td>${l.qcategory.name }</td>
				<td ><a href="${editUrl }" >Edit</a></td>
				<td><a href="${deleteUrl }">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>