package com.cignex.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "question")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String questions;
	@ManyToOne
	@JoinColumn(name = "qcategory")
	private QuestionCategory qcategory;
	@OneToMany(mappedBy = "question")
	private List<Answer> answer = new ArrayList<Answer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public QuestionCategory getQcategory() {
		return qcategory;
	}

	public void setQcategory(QuestionCategory qcategory) {
		this.qcategory = qcategory;
	}

	public Question() {
	}

	public Question(int id, String questions, QuestionCategory qcategory, List<Answer> answer) {
		super();
		this.id = id;
		this.questions = questions;
		this.qcategory = qcategory;
		this.answer = answer;
	}

}
