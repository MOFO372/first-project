package com.example.demo.models;

public class Yeller {
	
	String yell; 
	
	public Yeller (String message) {
		yell = message;
	}
	
	public String caps() {
		return yell.toUpperCase();
	}

}