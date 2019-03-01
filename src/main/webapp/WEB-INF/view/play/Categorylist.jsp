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

	<div id="res"></div>
	<div>
		<select id="id">
			<option>--</option>
			<c:forEach items="${list }" var="l">

				<option value="${l.id }">${l.name }</option>
			</c:forEach>
		</select>
	</div>
	<!-- <button name="get" id="get">get</button> -->
	<button name="play" id="play">Play</button>
	<button name="result" id="result">Result</button>
	<div id="quizArea">
	</div>
	<div id="results">
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$("#play").hide();
		$("#get").click(function(event) {
			event.preventDefault();
			//getAll();
			//getdata();
		});
		var v = null;
		$('#id').change(function() {
			v = $(this).val();
			getAll();
			$("#play").show(function(){
				$("#play").css("color","red");
			});
		});
		var jsonString = null;
		function getAll() {
			var formData = {
				id : v,
			}
			$.ajax({
				type : 'GET',
				url : '/play/get?id=' + formData.id,
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					jsonString = result;
					setUpQuiz();
				},
				error : function(e) {
					$('#res').html("<strong>Errrorr</strong>");
					console.log("ERROR " + e);
				}
			});
		}
		$("#play").click(function(event) {
			event.preventDefault();
			playQuiz();
		});
		function setUpQuiz() {
			var count = 1; 
			var totalQuestions=1;
			var totalQuestionHtml=$('<div class="q'+count+'">Question <span class="current">'+count+'</span> of<span>'+totalQuestions+'</span>');
			$.each(jsonString, function(k, v) {
				var create=$('<div id="p'+count+'">');
				$("#quizArea").append(create);
				if(count > 1){
					$('#p'+count).hide();
				}
			
				var questionHtml=$('<li class="question'+count+'" id="question'+count+'"></li>');
				questionHtml.append('<div class="q'+count+'">Question <span class="current">'+count+'</span> of<span>'+totalQuestions+'</span>');
						questionHtml.append('<h3>'+count+'.'+v.q+'</h3>');
						questionHtml.append('<h6 hidden>'+v.correct+'</h6>');
						$('#p'+count).append(questionHtml);
				
				var ans = v.optionResponse;
				var answerHTML = $('<ul class="answer"></ul>');
				for (i in ans) {
					if (ans.hasOwnProperty(i)) {
						answer=ans[i];
						var input='<input id="answer'+count+'" name="answer'+count+'" type="radio" class="answerr" value='+answer.correct+'>';
						var label='<label for="answer'+count+'">' + answer.option + '</label>';
						
						var answerContent=$('<div></div>').append(input).append(label);
						answerHTML.append(answerContent);
						$('#p'+count).append(answerHTML);
					}	
				}
				count++;
				totalQuestions++;
			});
			var nextButton='<input type="submit" id="next" value="Next">';
			var previousButton='<input type="submit" id="previous" value="Previous">';
			$('#quizArea').append(previousButton);
			$('#quizArea').append(nextButton);
			$('#previous').hide();
		}
		
		var map = new Map(); 
		var playCount=1;
		var q=0;
		var resultResponseArray=[];
		function playQuiz(){
			
			$('.answerr').change(function(){
				//alert($(this).val());
				
				var q=playCount;
					var ans=$(this).val();
				map.set(q,ans);
				//console.log(map);
			});
			$('#next').click(function(){
				//alert(playCount);
				$('#p'+playCount).fadeOut(300);
				var qu=$(this).parent().find('h3')[q];
				var ar=$(this).parent().find('ul.answer')[q];
				var t=$(this).parent().find('h6')[q].textContent;
				var res={"question":qu,"answers":ar,"correct":t};
				resultResponseArray.push(res);
				playCount++;
				q++;
				$('#p'+playCount).fadeIn(500);
				
				if(playCount > 1){
					$('#previous').show();
				}
			});
			$('#previous').click(function(){
				$('#p'+playCount).fadeOut(300);
				resultResponseArray.splice(resultResponseArray.length-1);
				playCount--;
				$('#p'+playCount).fadeIn(500);
				if(playCount <= 1){
					$('#previous').hide();
				}
			});
		}
		var results=0;
		var trueCount=0;
		var falseCount=0;
		function result(){
			for(const [key,value] of map.entries()){
				if(value=="true"){
					trueCount++;
				}else{
					falseCount++;
				}
				results++;
			}
			var resultCreate='<h3> correct Answers are '+trueCount+' out of '+results+'</h3>';
			$('#results').append(resultCreate);
			$.each(resultResponseArray,function(key,value){
				
				$('#quizArea').hide();
				$('#results').append(value.question);
				$('#results').append(value.answers);
				$('#results').append(value.correct);
				console.log(value.answers);
			});
		}
		
		$('#result').click(function(){
			event.preventDefault();
			result();
		});
		
	});
</script>
</html>