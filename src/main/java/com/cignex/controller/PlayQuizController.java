package com.cignex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.model.QuizResponse;
import com.cignex.service.QuestionCategoryService;
import com.cignex.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/play")
public class PlayQuizController {
	@Autowired
	private QuestionCategoryService questionCategoryService;
	@Autowired
	private QuestionService questionService;

	@GetMapping("/category")
	private ModelAndView home(Model model) {
		List<QuestionCategory> list = questionCategoryService.getAllCategory();
		model.addAttribute("list", list);
		ModelAndView andView = new ModelAndView("play/Categorylist");
		return andView;
	}

	@GetMapping("/get")
	private String play(@RequestParam int id) throws JsonProcessingException {
		List<Question> question = questionService.getQuestionByCategory(id);
		System.out.println(question.size());
		List<String> ans=null;
		String ques=null;
		String ca=null;
		List<QuizResponse> quizResponse = new ArrayList<>();
		for(Question q:question) {
			ans=new ArrayList<>();
			ques=q.getTitle();
			ans.add(q.getAnswer1());
			ans.add(q.getAnswer2());
			ans.add(q.getAnswer3());
			ans.add(q.getAnswer4());
			ca=q.getCorrectAnswer();
			quizResponse.add(new QuizResponse(ques, ans, ca));
			System.out.println(quizResponse.size());
		}
		/*
		 * Map<Integer, List<Answer>> map = new HashMap<>(); int i = 1; for (Question q
		 * : question) { map.put(i, answerService.getQuestionsByid(q.getId())); i++; }
		 * map.forEach((key, val) -> { System.out.print(key + " "); val.forEach(a -> {
		 * System.out.println(a); }); });
		 */
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(quizResponse);
		return json;
	}

	@GetMapping("/test")
	public String getValue() {
		return "hello";
	}

}
