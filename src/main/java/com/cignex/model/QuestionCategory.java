package com.cignex.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questionCategory")
public class QuestionCategory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "qcategory")
	private List<Question> list = new ArrayList<Question>();
	@OneToMany(mappedBy = "qcategory")
	private List<ResultQuiz> resultQuiz=new ArrayList<ResultQuiz>();

	
	/**
	 * @return the resultQuiz
	 */
	public List<ResultQuiz> getResultQuiz() {
		return resultQuiz;
	}

	/**
	 * @param resultQuiz the resultQuiz to set
	 */
	public void setResultQuiz(List<ResultQuiz> resultQuiz) {
		this.resultQuiz = resultQuiz;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuestionCategory() {
		super();
	}

	public QuestionCategory(int id, String name, List<Question> list) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
	}

}
