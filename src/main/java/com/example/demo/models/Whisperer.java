package com.example.demo.models;

public class Whisperer {
	
	String whisper; 
	
	public Whisperer (String word) {
		whisper = word; 
	}

	public String lower() { 
		return whisper.toLowerCase();
	}
}
