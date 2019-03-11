<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>hello welcome !!</h1>
	<form id="saveForm">
		<table>
			<tr>
				<td>category:</td>
				<td><select name="qcategory" id="qcategory">
						<c:forEach items="${list }" var="l">
							<option value="${l.id }">${l.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>Question :</td>
				<td><input name="title" id="title" /></td>
			</tr>
			<tr id="ans" class="ans">
				<td>Answer 1 :</td>
				<td><input name="answer1" id="answer1" class="a" /></td>
				<!-- <td><button type="button" class="new" id="new">+</button></td> --> 
			</tr>
			 <tr id="ans2" class="ans">
				<td>Answer 2:</td>
				<td><input name="answer2" id="answer2" class="a" /></td>
				<!-- <td><button type="button" class="new" id="new">+</button></td> -->
			</tr>
			<tr id="ans3" class="ans">
				<td>Answer 3 :</td>
				<td><input name="answer3" id="answer3" class="a" /></td>
			 	<td><button type="button" class="new" id="new3">-</button></td> 
			</tr>
			<tr id="ans4" class="ans">
				<td>Answer 4 :</td>
				<td><input name="answer4" id="answer4" class="a" /></td>
			 	<td><button type="button" class="new" id="new4">-</button></td> 
			</tr>

			<tr>
			<td>Correct Answer :</td>
				<td><select id="correctAnswer">
				</select></td>
			</tr>
		<!-- 	Text: <input type="text" id = "txtText" />
    Value: <input type="text" id = "txtValue" />
     <input type="button" id = "btnAdd" value = "Add" /> -->
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
		$('#new3').click(function(){
			$('#ans3').hide();
		});
		$('#new4').click(function(){
			$('#ans4').hide();
		});
		 $(function () {
	            $("#btnAdd").click(function () {
	                var option = $("<option />");
	                option.html($("#txtText").val());
	                option.val($("#txtValue").val());
	                $("#correctAnswer").append(option);
	            });
	        });
		var count = 2;
		$('#new').click(function() {
			
			var div = $("<td>");
			
			if (count <= 4) {
				div.html("<td> Answer " + count + ":</td><td><input name='answer"+count+"' class='a"+count+"' id='answer"+count+"'></td><td><button type='button' id='remove"+count+"'>-</button></td>");
				$('#ans').append(div);
				count++;
			} else {
				alert("you can generate maximum 4 text boxes");
			}
		});
		
		$('#add').click(function() {
			save();
		});
		
		$('#answer1').change(function(){
			var option=$('<option />');
			option.html($('#answer1').val());
			option.val($('#answer1').val());
			$('#correctAnswer').append(option);
		});
		
		$('#answer2').change(function(){
			var option=$('<option />');
			option.html($('#answer2').val());
			option.val($('#answer2').val());
			$('#correctAnswer').append(option);
		});
		
		$('#answer3').change(function(){
			var option=$('<option />');
			option.html($('#answer3').val());
			option.val($('#answer3').val());
			$('#correctAnswer').append(option);
		});
		
		$('#answer4').change(function(){
			var option=$('<option />');
			option.html($('#answer4').val());
			option.val($('#answer4').val());
			$('#correctAnswer').append(option);
		});
		
		
		
		function addInDropdown(){
			$('.a'+count).change(function(){
				var options=$('<option>');
				options.html($('.a'+count).val());
				options.val($('.a'+count).val());
				options.append('</option>');
				$('#correctAnswer').append(options);
			});
		}
		 
		function save() {
			var formData = {
				title : $('#title').val(),
				answer1:$('#answer1').val(),
				answer2:$('#answer2').val(),
				answer3:$('#answer3').val(),
				answer4:$('#answer4').val(),
				correctAnswer:$('#correctAnswer').val(),
				qcategory : {
					id : $('#qcategory').val(),
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
			title : $('#title').val("");
		correctAnswer:$('#correctAnswer').html("");
		answer1:$('#answer1').val("");
		answer2:$('#answer2').val("");
		answer2:$('#answer2').val("");
		answer3:$('#answer3').val("");
		answer4:$('#answer4').val("");
		}
	});
</script>
</html>