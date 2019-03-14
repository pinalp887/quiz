package com.cignex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.model.ResultQuiz;
import com.cignex.repository.QuizResult;

@Service("quizService")
public class QuizResultService {
	@Autowired
	private QuizResult quizResult;

	public ResultQuiz save(ResultQuiz resultQuiz) {
		return quizResult.save(resultQuiz);
	}

	public List<ResultQuiz> getAll() {
		return quizResult.findAll();
	}

	public ResultQuiz getQuizResult(int id) {
		return quizResult.findById(id).get();
	}

	public void delete(int id) {
		quizResult.deleteById(id);
	}
	
	public ResultQuiz getResultById(int id) {
		return quizResult.getResultById(id);
	}
}
