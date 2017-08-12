package com.example.demo.models;

public class Calculator {

	double firstNum;
	double secondNum; 
	
	public Calculator (double numberOne, double numberTwo) {
		firstNum = numberOne;
		secondNum = numberTwo;
	}
	
	public double addition() {
		double sum; 
		sum = firstNum + secondNum; 
		return sum;
	}
	
	public double subtraction() {
		 double difference; 
		 difference = firstNum - secondNum; 
		 return difference; 
	}
	
	public double multiplication() {
		double product;
		product = firstNum * secondNum; 
		return product; 
	}
	
	public double division() {
		double quotient; 
		quotient = firstNum / secondNum; 
		return quotient;
	}
	
	public double mod() {
		double remainder;
		remainder = firstNum % secondNum; 
		return remainder;
	}
	
	public double exponent() {
		double exponent;
		exponent = Math.pow(firstNum, secondNum);
		return exponent; 
	}
}
