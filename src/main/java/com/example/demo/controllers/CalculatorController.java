package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.Adder;
import com.example.demo.models.Calculator;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping("/calculate") //portion specific to the form at the end of the URL
public class CalculatorController {
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("output", "enter some numbers, foo.");
		return "math/calculator";
	}
		
	
	@PostMapping("calculate-something") 
	public String makeAChoice(double submittedNumberOne, double submittedNumberTwo, String mathChoice, Model dataForView) {
		
		if(mathChoice.equals("+")) {
			Calculator calculatorAdd = new Calculator(submittedNumberOne, submittedNumberTwo);
			double additionVar = calculatorAdd.addition();
			dataForView.addAttribute("output", additionVar);
		}	
		
		else if (mathChoice.equals("-")) {
			Calculator calculatorSubtract = new Calculator(submittedNumberOne, submittedNumberTwo);
			double subtractionVar = calculatorSubtract.subtraction();
			dataForView.addAttribute("output", subtractionVar);			
		}
		
		else if (mathChoice.equals("*")) {
			Calculator calculatorMultiply = new Calculator(submittedNumberOne, submittedNumberTwo);
			double multiplicationVar = calculatorMultiply.multiplication();
			dataForView.addAttribute("output", multiplicationVar); 			
		}
		
		else if(mathChoice.equals("/")) {
			Calculator calculatorDivide = new Calculator(submittedNumberOne, submittedNumberTwo);
			double divisionVar = calculatorDivide.division();
			dataForView.addAttribute("output", divisionVar);	
		}
		
		else if(mathChoice.equals("%")) {
			Calculator calculatorMod= new Calculator(submittedNumberOne, submittedNumberTwo);
			double modVar = calculatorMod.mod();
			dataForView.addAttribute("output", modVar);
		}
		
		else {
			Calculator calculatorExponent = new Calculator(submittedNumberOne, submittedNumberTwo);
			double exponentVar = calculatorExponent.exponent();
			dataForView.addAttribute("output", exponentVar);
		}
	
		return "math/calculator";				
	}


}
