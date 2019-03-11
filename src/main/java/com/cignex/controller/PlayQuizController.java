package com.cignex.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.OptionResponse;
import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.model.QuizResponse;
import com.cignex.service.QuestionCategoryService;
import com.cignex.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/play")
@SessionAttributes({"name"})
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
	private List<QuizResponse> play(@RequestParam int id) throws JsonProcessingException {
		List<Question> question = questionService.getQuestionByCategory(id);
		String ques = null;
		String ca = null;
		List<QuizResponse> quizResponse = new ArrayList<>();
		List<OptionResponse> opResponse = null;
		OptionResponse optionResponse = null;
		int totalQuestion = 0;
		for (Question q : question) {
			String coorect = "false";
			String coorect2 = "false";
			String coorect3 = "false";
			String coorect4 = "false";
			optionResponse = new OptionResponse();
			opResponse = new ArrayList<OptionResponse>();
			ques = q.getTitle();
			if (q.getCorrectAnswer().equals(q.getAnswer1())) {
				coorect = "true";
			} else if (q.getCorrectAnswer().equals(q.getAnswer2())) {
				coorect2 = "true";
			} else {
				System.out.println("try  ");
			}
			opResponse.add(new OptionResponse(q.getAnswer1(), coorect));
			opResponse.add(new OptionResponse(q.getAnswer2(), coorect2));
			if (!q.getAnswer3().equals("")) {
				if (q.getCorrectAnswer().equals(q.getAnswer3())) {
					coorect3 = "true";
				} else if (q.getCorrectAnswer().equals(q.getAnswer4())) {
					coorect4 = "true";
				} else {
					System.out.println("try  ");
				}
				opResponse.add(new OptionResponse(q.getAnswer3(), coorect3));
				opResponse.add(new OptionResponse(q.getAnswer4(), coorect4));
			}

			
			
			ca = q.getCorrectAnswer();
			totalQuestion++;
			quizResponse.add(new QuizResponse(ques, opResponse, ca));
		}
		return quizResponse;
	}

	@GetMapping("/test")
	public String getValue() {
		return "hello";
	}

}
