package com.cignex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.model.QuestionCategory;
@Repository
public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Integer> {
	

}
