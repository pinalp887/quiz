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
		<form:form method="POST" action="/user/save" modelAttribute="user">

			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td>Position Apply For:</td>
				<td><form:input path="positionApplyFor" /></td>
			</tr>
			<tr>
				<td>Reference Name:</td>
				<td><form:input path="referenceName" /></td>
			</tr>
			<tr>
				<td>Reference Mobile Number:</td>
				<td><form:input path="referenceMobileNumber" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><form:input path="mobileNumber" /></td>
			</tr>
			<tr>
				<td>Notice Period:</td>
				<td><form:input path="noticePeriod" /></td>
			</tr>
			<tr>
				<td>CTCT( Cureent CTC) :</td>
				<td><form:input path="ctc" /></td>
			</tr>
			<tr>
				<td>ECTC ( Expected CTC) :</td>
				<td><form:input path="ectc" /></td>
			</tr>
			<tr>
				<td>Reason For Change :</td>
				<td><form:textarea path="reasonForChange" /></td>
			</tr>
			<tr>
				<td><input type="submit" type="submit" value="submit">
				</td>
			</tr>

		</form:form>
	</table>
</body>
</html>