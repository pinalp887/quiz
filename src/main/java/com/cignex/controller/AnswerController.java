package com.cignex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.Answer;
import com.cignex.model.Question;
import com.cignex.service.AnswerService;
import com.cignex.service.QuestionService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;

	@GetMapping("/add")
	private ModelAndView addNew(ModelAndView model) {
		List<Question> list = questionService.getAllQuestion();
		model.addObject("list", list);
		Answer answer = new Answer();
		model.addObject("answer", answer);
		model.setViewName("answer/index");
		return model;
	}

	@PostMapping("/save")
	private Answer save(@RequestBody Answer answer) {
		answerService.save(answer);
		return answer;
	}

	@GetMapping("/list")
	private String getAll(Model model) {
		List<Answer> list = answerService.getAll();
		model.addAttribute("list", list);
		return "answer/list";
	}

	@GetMapping("/get/{id}")
	private String getAnswer(Model model, @PathVariable("id") int id) {
		Answer answer = answerService.getAnswerById(id);
		model.addAttribute("answer", answer);
		return "answer/update";
	}

	@GetMapping("/delete/{id}")
	private String delete(@PathVariable("id") int id) {
		answerService.delete(id);
		return "redirect:/answer/list";
	}
}
