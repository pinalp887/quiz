package com.cignex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.Answer;
import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.service.AnswerService;
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
	@Autowired
	private AnswerService answerService;

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
		Map<Integer, List<Answer>> map = new HashMap<>();
		int i = 1;
		for (Question q : question) {
			map.put(i, answerService.getQuestionsByid(q.getId()));
			i++;
		}
		map.forEach((key, val) -> {
			System.out.print(key + " ");
			val.forEach(a -> {
				System.out.println(a);
			});
		});
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		json = mapper.writeValueAsString(map);
		return json;
	}

	@GetMapping("/test")
	public String getValue() {
		return "hello";
	}

}
