<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<td>ID</td>
			<td>User Name</td>
			<td>Quiz Name</td>
			<td>Total Question</td>
			<td>Right Question</td>
			<td>Wrong Question</td>
			<td>Total Time Taken</td>
			<td>Total Marks</td>
			<td colspan="2" align="center">Action</td>
		</tr>
		<c:forEach items="${list }" var="l">
			<%-- <c:url value="/history/get/${l.id }" var="get"></c:url> --%>
			<c:url value="/history/delete/${l.id }" var="delete"></c:url>
			<tr>
				<td>${l.id }</td>
				<td>${l.user.firstName }${l.user.lastName }</td>
				<td>${l.qcategory.name }</td>
				<td>${l.totalQuestion }</td>
				<td>${l.rightQuestion }</td>
				<td>${l.wrongQuestion }</td>
				<td>${l.totalTime }Sec.</td>
				<td>${l.totalMarks }</td>
				<td><button class="c" id="c1" value=${l.id }>Click</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		var t=0;
		$('.c').click(function(){
				t =$(this).val();
				alert(t);
				getData();
		});
		
		function getData(){
			var data={
					id:t,
			}
			$.ajax({
				type : 'GET',
				url : '/result/' + data.id,
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					console.log(result);
				},
				error : function(e) {
					$('#res').html("<strong>Errrorr</strong>");
					console.log("ERROR " + e);
				}
			})
		}
	});
</script>
</html>