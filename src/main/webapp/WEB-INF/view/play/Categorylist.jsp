<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<h1 align="center">Please Select the category</h1>

	<%-- <c:forEach items="${list }" var="l">
	${l.name }
	
	<c:url value="/play/get/${l.id}" var="getId"></c:url>
	<a href="${getId }">SELECT</a>
</c:forEach> --%>
	<div id="res"></div>
	<button name="get" id="get">get</button>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#get").click(function(event) {
			event.preventDefault();
			getAll();
			getdata();
		});

		function getdata() {
			$.ajax({
				type : 'GET',
				url : '/play/test',
				success : function(result) {
					console.log(result);
				}
			});
		}

		function getAll() {
			$.ajax({
				type : 'GET',
				url : '/play/get?id=1',
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					var obj=jQuery.parseJSON(result);
					$.each(obj, function(key, value) {
						console.log(key+"  "+value);
					});

				},
				error : function(e) {
					$('#res').html("<strong>Errrorr</strong>");
					console.log("ERROR " + e);
				}
			});
		}
	});
</script>
</html>