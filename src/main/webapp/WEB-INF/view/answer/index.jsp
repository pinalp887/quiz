<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>hello welcome !!</h1>

	<form id="saveForm">
		<table>
			<tr>
				<td>category:</td>
				<td><select name="question" id="question">
						<c:forEach items="${list }" var="l">
							<option value="${l.id }">${l.questions }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Answer :</td>
				<td><input name="answers" id="answers" /></td>
			</tr>
			<tr>
				<td>Value :</td>
				<td><select name="ans" id="ans">
						<option value="0">0</option>
						<option value="1">1</option>
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
				answers : $('#answers').val(),
				ans : $('#ans').val(),
				question : {
					id : $('#question').val(),
					}
			}
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/answer/save",
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
			answer: $('#answers').val("");
		}
	});
</script>
</html>