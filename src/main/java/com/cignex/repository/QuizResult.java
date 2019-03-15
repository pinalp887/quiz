package com.cignex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.model.ResultQuiz;

@Repository("quizResult")
public interface QuizResult extends JpaRepository<ResultQuiz, Integer> {
	@Query(value = "SELECT result from ResultQuiz where id= :id")
	String getResultById(@Param("id") int id);
}
