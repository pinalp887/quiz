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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "questionCategory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionCategory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String qcategory;
	@OneToMany(mappedBy = "qcategory")
	private List<Question> list = new ArrayList<Question>();

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

	public String getQcategory() {
		return qcategory;
	}

	public void setQcategory(String qcategory) {
		this.qcategory = qcategory;
	}

	public QuestionCategory() {
		super();
	}

	public QuestionCategory(int id, String name, String qcategory, List<Question> list) {
		super();
		this.id = id;
		this.name = name;
		this.qcategory = qcategory;
		this.list = list;
	}

}
