<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>

	<h1>hello welcome !!</h1>

	<form id="saveForm">
		<table>
			<tr>
				<td>NAME:</td>
				<td><input name="name" id="name" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit" id="add"></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		$(document).ready(function() {
			window.setInterval(function() {
				console.log("This text is display after every 5 second");
			}, 5000);
			$('#saveForm').click(function(event) {
				event.preventDefault();

			});

			$('#add').click(function() {
				save();
			});

			function save() {
				var formData = {
					name : $('#name').val(),
					qcategory : $('#qcategory').val()
				}
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/AddCategoryapi/save",
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
				name: $('#name').val("");
				qcategory: $('#qcategory').val("");
			}
		});
	</script>
</body>


</html>