package com.cignex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.repository.QuestionCategoryRepository;

@Service
public class QuestionCategoryService {
	@Autowired
	private QuestionCategoryRepository questionCategoryRepository;
	
	public QuestionCategory insert(QuestionCategory QuestionCategory) {
		return questionCategoryRepository.save(QuestionCategory);
	}
	
	public List<QuestionCategory> getAllCategory(){
		return questionCategoryRepository.findAll();
	}
	
	public QuestionCategory getCategoryById(int id) {
		return questionCategoryRepository.findById(id).get();
	}
	
	public void delete(int id) {
		questionCategoryRepository.deleteById(id);
	}
	
}
