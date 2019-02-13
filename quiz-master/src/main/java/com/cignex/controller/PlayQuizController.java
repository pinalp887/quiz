package com.cignex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.service.QuestionCategoryService;
import com.cignex.service.QuestionService;

@RestController
@RequestMapping("/play")
public class PlayQuizController {
	@Autowired
	private QuestionCategoryService questionCategoryService;
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/choose")
	private ModelAndView home(Model model) {
		List<QuestionCategory> list=questionCategoryService.getAllCategory();
		model.addAttribute("list",list);
		ModelAndView andView=new ModelAndView("play/Categorylist");
		return andView;
	}
	
	@GetMapping("/get/{id}")
	private String play(@PathVariable("id") int id) {
		//Question question=questionService.getQuestionByCategory(name);
		List<Question> question=questionService.getQuestionByCategory(id);
		question.stream().forEach(i->System.out.println(i.getQuestions()));
		return "";
	}
	
}
