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
	<%-- <table>
		<tr>
		
			<td>
			<c:forEach items="${map }" var="map">
				key is ${map.key }
				<c:forEach items="${map.value }" var="info">
					in fo is ${info.id }
					 ${info.question.questions }
				</c:forEach>
			</c:forEach>
			</td>
		</tr>
	</table> --%>
	<div id="res"><</div>
	<button name="get" id="get">get</button>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#get").click(function(event){
			event.preventDefault();
			getAll();
		});
		function getAll(){
			$.ajax({
				type:'GET',
				url:'play/get/1',
				sucess:function(result){
					
				},
				error:function(e){
					$('#res').html("<strong>Errrorr</strong>");
					console.log("ERROR "+e);
				}
			});
		}
	});
</script>
</html>