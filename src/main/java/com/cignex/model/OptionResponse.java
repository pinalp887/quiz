package com.cignex.model;

public class OptionResponse {

	private String option;
	private String correct;
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public OptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OptionResponse(String option, String correct) {
		super();
		this.option = option;
		this.correct = correct;
	}
	public OptionResponse(String option) {
		super();
		this.option = option;
	}
	
	
}
