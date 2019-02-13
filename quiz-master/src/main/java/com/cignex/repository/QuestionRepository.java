package com.cignex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cignex.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	@Query(value="select * from Question q where q.qcategory= :id",nativeQuery=true)
	List<Question> findByQcategory(@Param("id") int id);


	
	
}
