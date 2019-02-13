<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form id="saveForm">
		<table>

			<tr>
				<td>Question :</td>
				<td><input name="questions" id="questions" /></td>
			</tr>

			<tr>
				<td>category:</td>
				<td><select name="qcategory" id="qcategory">
						<c:forEach items="${list }" var="l">
							<option value="${l.id }">${l.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" id="add"></td>
			</tr>

		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#saveForm').click(function(event) {
			event.preventDefault();
		});

		$('#add').click(function() {
			save();
		});

		function save() {
			var formData = {
				questions : $('#questions').val(),
				qcategory : {
						id:$('#qcategory').val(),
					}
			}
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/question/save",
				accept : 'text/plain',
				data : JSON.stringify(formData),
				success : function(result) {
					console.log(result);
				},
				error : function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});
			reset();
		}

		function reset() {
			name: $('#questions').val("");
		}
	});
</script>
</html>