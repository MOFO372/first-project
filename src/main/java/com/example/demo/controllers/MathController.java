package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.Adder;

@Controller
@RequestMapping("/math")
public class MathController {
	
	@GetMapping("adder") 
	public ModelAndView mathMethod(){
		
		ModelAndView mv = new ModelAndView("helloworld/tryagain"); 
		return mv;
	}
	

	//http://localhost:8080/Math/adder POST
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();

		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}

}
