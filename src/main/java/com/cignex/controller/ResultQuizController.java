package com.cignex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.ResultQuiz;
import com.cignex.service.QuizResultService;

@RestController
@RequestMapping("/history")
public class ResultQuizController {
	@Autowired
	private QuizResultService quizResultService;

	@PostMapping("/save")
	private ResultQuiz save(@RequestBody ResultQuiz quiz) {
		return quizResultService.save(quiz);
	}

	@GetMapping("/list")
	private ModelAndView getAll(ModelAndView model) {
		List<ResultQuiz> list = quizResultService.getAll();
		model.addObject("list", list);
		model.setViewName("result/list");
		return model;
	}

	@GetMapping("/get/{id}")
	private ModelAndView getDataById(@PathVariable("id") int id, ModelAndView model) {
		ResultQuiz quiz=quizResultService.getQuizResult(id);
		model.addObject("quiz", quiz);
		return model;
	}
	@GetMapping("/result/{id}")
	private String getResult(@PathVariable("id") int id,ModelAndView model) {
		String quiz=quizResultService.getResultById(id);
		return quiz;
	}
}
