<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>hello welcome !!</h1>
	<table>
		<form:form action="/question/save" modelAttribute="question"
			method="POST">
			<form:hidden path="id"/>
			<tr>
				<td>Question :</td>
				<td><form:input path="questions" /></td>
			</tr>
			<tr>
				<td>Answer :</td>
				<td><form:input path="answer" /></td>
			</tr>
			<tr>
				<td>category:</td>
				<td><select name="qcategory">
						<c:forEach items="${list }" var="l">
							<option value="${l.id }">${l.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</form:form>
	</table>
</body>

</html>