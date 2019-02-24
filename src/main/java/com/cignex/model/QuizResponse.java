package com.cignex.model;

import java.util.ArrayList;
import java.util.List;

public class QuizResponse {

	private String q;
	private String correct;
	private List<OptionResponse> optionResponse = new ArrayList<OptionResponse>();


	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public List<OptionResponse> getOptionResponse() {
		return optionResponse;
	}

	public void setOptionResponse(List<OptionResponse> optionResponse) {
		this.optionResponse = optionResponse;
	}

	
	public QuizResponse(String q, List<OptionResponse> optionResponse, String correct) {
		super();
		this.q = q;
		this.correct = correct;
		this.optionResponse = optionResponse;
	}

	public QuizResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuizResponse [q=" + q + ", correct=" + correct + ", optionResponse=" + optionResponse + "]";
	}
	

}
