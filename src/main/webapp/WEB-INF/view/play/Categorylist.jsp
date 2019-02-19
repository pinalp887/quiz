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
	<div>
		<select id="id">
			<option>--</option>
			<c:forEach items="${list }" var="l">

				<option value="${l.id }">${l.name }</option>
			</c:forEach>
		</select>
	</div>
	<button name="get" id="get">get</button>
	<button name="play" id="play">Play</button>
	
	<div id="p"></div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#get").click(function(event) {
			event.preventDefault();
				getAll();
			//getdata();
		});
		var v=null;
		$('#id').change(function() {
			 v = $(this).val();
		});
		var jsonString=null;
		function getAll() {
			var formData={
					id:v,
			}
			$.ajax({
				type : 'GET',
				url : '/play/get?id='+formData.id,
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					jsonString=$.parseJSON(result);
				},
				error : function(e) {
					$('#res').html("<strong>Errrorr</strong>");
					console.log("ERROR " + e);
				}
			});
		}
		$("#play").click(function(event) {
			event.preventDefault();
				play();
			//getdata();
		});
		function play(){
			var count=1;
			$.each(jsonString,function(k,v){
				var quiz=$("<div class='s"+count+"'>");
				quiz.html("<ul><li>"+v.q+"</li>");
				$('#p').append(quiz);
				var ans=v.a;
				for(i in ans){
				//	if(ans.hasOwnProperty(i)){
						console.log(ans[i]);
						//quiz.html("<li><input type='radio' name='option"+i+"' id='option"+i+"'>"+ans[i]+"</li>");
						//$('#p').append(quiz);
				//	}
				}
				//quiz.html("<button>next</button>");
				//$('#p').append(quiz);
				/* $.each(v,function(c,b){
					//console.log(b+" "+a);
					var quiz=$("<tr>");
					quiz.html("<td>"+b+"</td>");
					$('#p').append(quiz);
					
				}); */
			});
		}
	});
</script>
</html>