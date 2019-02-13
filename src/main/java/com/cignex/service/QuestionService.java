package com.cignex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cignex.model.Question;
import com.cignex.model.QuestionCategory;
import com.cignex.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	public Question save(Question question) {
		return questionRepository.save(question);
	}

	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	public Question getQuestionById(int id) {
		return questionRepository.findById(id).get();
	}

	public void delete(int id) {
		questionRepository.deleteById(id);
	}

	public List<Question> getQuestionByCategory(int id) {
		return questionRepository.findByQcategory(id);
	}

	
}
