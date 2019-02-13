package com.cignex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("/home")
	private String home() {
		return "index";
	}
	/*
	 * @GetMapping("/home") private ModelAndView home(ModelAndView andView) {
	 * andView=new ModelAndView("index"); return andView; }
	 */
}
