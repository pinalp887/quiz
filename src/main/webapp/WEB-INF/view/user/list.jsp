<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<td>id</td>
			<td>firstName</td>
			<td>lastName</td>
			<td>positionApplyFor</td>
			<td>referenceName</td>
			<td>referenceMobileNumber</td>
			<td>email</td>
			<td>password</td>
			<td>mobileNumber</td>
			<td>noticePeriod</td>
			<td>ctc</td>
			<td>ectc</td>
			<td>reasonForChange</td>
		</tr>
		<c:forEach items="${list }" var="l">
		<c:url value="/user/view/${l.id }" var="view">
		</c:url>
		<c:url value="/user/delete/${l.id }" var="delete">
		</c:url>
			<tr>
				<td>${l.id }</td>
				<td>${l.firstName }</td>
				<td>${l.lastName }</td>
				<td>${l.positionApplyFor }</td>
				<td>${l.referenceName }</td>
				<td>${l.referenceMobileNumber }</td>
				<td>${l.email }</td>
				<td>${l.password }</td>
				<td>${l.mobileNumber }</td>
				<td>${l.noticePeriod }</td>
				<td>${l.ctc }</td>
				<td>${l.ectc }</td>
				<td>${l.reasonForChange }</td>
				<td><a href="${view }">Edit</a></td>
				<td><a href="${delete }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>