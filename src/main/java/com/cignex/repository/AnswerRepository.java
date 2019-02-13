package com.cignex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.model.Answer;
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	@Query("Select a from Answer a where a.question.id = :id")
	List<Answer> findByQuestionId(@Param("id") int id);
}
