package com.cignex.model;

import java.util.ArrayList;
import java.util.List;

public class QuizResponse {

	private String q;
	private List<String> a=new ArrayList<String>();
	private String correct;
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public List<String> getA() {
		return a;
	}
	public void setA(List<String> a) {
		this.a = a;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public QuizResponse(String q, List<String> a, String correct) {
		super();
		this.q = q;
		this.a = a;
		this.correct = correct;
	}
	public QuizResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
