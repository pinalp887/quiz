package com.cignex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.model.Answer;
import com.cignex.repository.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public List<Answer> getAll(){
		return answerRepository.findAll();
	}
	
	public Answer getAnswerById(int id) {
		return answerRepository.findById(id).get();
	}
	public void delete(int id) {
		answerRepository.deleteById(id);
	}
}
