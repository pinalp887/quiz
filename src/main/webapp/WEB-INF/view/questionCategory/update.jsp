<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form:form action="/AddCategoryapi/update" modelAttribute="category"
			method="POST">
			<form:hidden path="id"/>
			<tr>
				<td>NAME:</td>
				<td><form:input path="name" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>