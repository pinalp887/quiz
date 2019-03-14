package com.cignex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class ResultQuiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "longblob", name = "result")
	private String[] result;
	private int totalMarks;
	private int totalTime;
	private int totalQuestion;
	private int rightQuestion;
	private int wrongQuestion;
	@ManyToOne
	private User user;
	@ManyToOne
	@JoinColumn(name = "category")
	private QuestionCategory qcategory;

	/**
	 * @return the qcategory
	 */
	public QuestionCategory getQcategory() {
		return qcategory;
	}

	/**
	 * @param qcategory the qcategory to set
	 */
	public void setQcategory(QuestionCategory qcategory) {
		this.qcategory = qcategory;
	}

	/**
	 * @return the totalMarks
	 */
	public int getTotalMarks() {
		return totalMarks;
	}

	/**
	 * @param totalMarks the totalMarks to set
	 */
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	/**
	 * @return the totalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * @return the totalQuestion
	 */
	public int getTotalQuestion() {
		return totalQuestion;
	}

	/**
	 * @param totalQuestion the totalQuestion to set
	 */
	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	/**
	 * @return the rightQuestion
	 */
	public int getRightQuestion() {
		return rightQuestion;
	}

	/**
	 * @param rightQuestion the rightQuestion to set
	 */
	public void setRightQuestion(int rightQuestion) {
		this.rightQuestion = rightQuestion;
	}

	/**
	 * @return the wrongQuestion
	 */
	public int getWrongQuestion() {
		return wrongQuestion;
	}

	/**
	 * @param wrongQuestion the wrongQuestion to set
	 */
	public void setWrongQuestion(int wrongQuestion) {
		this.wrongQuestion = wrongQuestion;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the result
	 */
	public String[] getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String[] result) {
		this.result = result;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
