package com.cignex.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "result")
public class ResultQuiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition="longblob",name="result")
	private String[] result;
	@ManyToOne
	private User user;
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
