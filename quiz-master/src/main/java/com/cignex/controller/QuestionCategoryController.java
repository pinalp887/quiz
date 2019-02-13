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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.QuestionCategory;
import com.cignex.service.QuestionCategoryService;

@RestController
@RequestMapping("/AddCategoryapi")
public class QuestionCategoryController {
	@Autowired
	private QuestionCategoryService categoryService;

	@GetMapping("/home")
	private ModelAndView home(ModelAndView view) {
		view.setViewName("questionCategory/index");
		return view;
	}

	@PostMapping("/save")
	private QuestionCategory saveQuestion(@RequestBody QuestionCategory category, ModelAndView view) {
		System.out.println(category.getName());
		System.out.println(category.getQcategory());
		categoryService.insert(category);
		return category;
	}
	
	@PostMapping("/update")
	private QuestionCategory updateQuestion(@ModelAttribute QuestionCategory category, ModelAndView view) {
		System.out.println(category.getName());
		System.out.println(category.getQcategory());
		categoryService.insert(category);
		return category;
	}

	@GetMapping("/list")
	private ModelAndView getAllQuestion(ModelAndView model) {
		List<QuestionCategory> list = categoryService.getAllCategory();
		model.addObject("list", list);
		model.setViewName("questionCategory/list");
		return model;
	}

	@GetMapping("/get/{id}")
	private ModelAndView getCategoryById(@PathVariable int id, ModelAndView view) {
		QuestionCategory category = categoryService.getCategoryById(id);
		view.addObject("category", category);
		view.setViewName("questionCategory/update");
		return view;
	}

	@GetMapping("/delete/{id}")
	private ModelAndView deleteCategory(@PathVariable("id") int id,ModelAndView view) {
		categoryService.delete(id);
		view.setViewName("redirect:/AddCategoryapi/list");
		return view;
	}
}
