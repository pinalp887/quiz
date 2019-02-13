package com.cignex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.service.QuestionCategoryService;
import com.cignex.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionCategoryService questionCategoryService;

	@GetMapping("/home")
	private ModelAndView home(ModelAndView model) {
		Question question = new Question();
		model.addObject("question", question);
		List<QuestionCategory> list = questionCategoryService.getAllCategory();
		model.addObject("list", list);
		model.setViewName("question/index");
		return model;
	}

	@PostMapping("/save")
	private String save(@RequestBody Question question) {
		System.out.println(question.getQuestions());
		//System.out.println(question.getQcategory());
		//questionService.save(question);
		return "km";
	}

	@GetMapping("/list")
	private String getAll(Model model) {
		List<Question> list = questionService.getAllQuestion();
		model.addAttribute("list", list);
		return "question/list";
	}

	@GetMapping("/get/{id}")
	private String getQuestion(@PathVariable("id") int id, Model model) {
		Question question = questionService.getQuestionById(id);
		model.addAttribute("question", question);
		List<QuestionCategory> list = questionCategoryService.getAllCategory();
		model.addAttribute("list", list);
		return "question/update";
	}

	@GetMapping("/delete/{id}")
	private String delete(@PathVariable("id") int id) {
		questionService.delete(id);
		return "redirect:/question/list";
	}

}
