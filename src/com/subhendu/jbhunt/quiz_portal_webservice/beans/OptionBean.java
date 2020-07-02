package com.subhendu.jbhunt.quiz_portal_webservice.beans;

public class OptionBean {
	private String text;
	private boolean correct;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public OptionBean(String text, boolean correct) {
		super();
		this.text = text;
		this.correct = correct;
	}
	public OptionBean() {
		super();
	}
	public OptionBean(String text, int indicator) {
		super();
		this.text = text;
		this.correct = indicator==1;
	}
	@Override
	public String toString() {
		return "OptionBean [text=" + text + ", correct=" + correct + "]";
	}
	
	

}
