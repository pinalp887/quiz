package com.cignex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.model.User;
import com.cignex.service.UserService;

@RestController
@RequestMapping("/user")
@SessionAttributes({"name","id"})
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	private ModelAndView home(ModelAndView view) {
		User user=new User();
		view.addObject("user", user);
		view.setViewName("user/index");
		return view;
	}
	@GetMapping("/login")
	private ModelAndView login(ModelAndView model) {
		model.setViewName("user/login");
		return model;
	}
	@PostMapping("/login")
	private ModelAndView loginUser(@RequestParam("email") String email,@RequestParam("password") String password,ModelAndView model) {
		User user=userService.login(email, password);
		model.addObject("name", user.getFirstName());
		model.addObject("id", user.getId());
		
		model.setViewName("user/home");
		return model;
	}
	
	@GetMapping("/logout")
	private ModelAndView logoutUser(ModelAndView model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		model.setViewName("redirect:/user/login");
		return model;
	}
	@PostMapping("/save")
	private ModelAndView saveUser(@ModelAttribute("user") User user,ModelAndView model) {
		userService.save(user);
		model.setViewName("redirect:/user/list");
		return model;
	}
	
	@GetMapping("/list")
	private ModelAndView getAllUser(ModelAndView model) {
		List<User> list=userService.getAllUser();
		model.addObject("list", list);
		model.setViewName("user/list");
		return model;
	}
	
	@GetMapping("/view/{id}")
	private ModelAndView getUSer(@PathVariable("id") int id,ModelAndView model) {
		User user=userService.getUserById(id);
		model.addObject("user", user);
		model.setViewName("user/update");
		return model;
	}
	@GetMapping("/delete/{id}")
	private ModelAndView deleteUser(@PathVariable("id") int id,ModelAndView model) {
		userService.delete(id);
		model.setViewName("redirect:/user/list");
		return model;
	}
}
