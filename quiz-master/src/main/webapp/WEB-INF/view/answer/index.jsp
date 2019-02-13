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
		<form:form action="/answer/save" modelAttribute="answer"
			method="POST">
			
			<tr>
				<td>Answer :</td>
				<td><form:input path="answers" /></td>
			</tr>
			<tr>
				<td>Value :</td>
				<td>
					<form:select path="value">
						<form:option value="0">0</form:option>
						<form:option value="1">1</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>category:</td>
				<td><select name="question">
						<c:forEach items="${list }" var="l">
							<option value="${l.id }">${l.questions }</option>
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