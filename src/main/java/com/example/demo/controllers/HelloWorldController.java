package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("message-path") //URL to which the form submits
	public ModelAndView messageMethod( //name of the method
			@RequestParam(required=false, defaultValue="«silence»") String submittedMessage) { //submitted message from the form
		Yeller goat = new Yeller(submittedMessage); //waiting for an instance of Yeller to fill the variable, sets it equal to the parameter from the user
		String allCaps = goat.caps();		//converts to upper case and stores in a variable
		
		
		ModelAndView mv = new ModelAndView("helloworld/message"); //specifies what view you want to use (found in message.html file within templates folder)
		//full path: src/main/resources/templates/helloworld/message.html; must specify path below templates
		mv.addObject("title", title);
		mv.addObject("message", allCaps); //message is what you look for (the key found in template), then find the associated value of allCaps
		return mv;
	}
	 

	@GetMapping("whisper-path")
	public ModelAndView whisper(
			@RequestParam(required=false, defaultValue="«shhhhh»") String whisper) {
		Whisperer noob = new Whisperer(whisper);
		String allLow = noob.lower();		
		
		
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		mv.addObject("title", title);
		mv.addObject("whisper", allLow);
		return mv;
	}
	
	@GetMapping("say-something") 
		public String makeAChoice(String submittedMessage, String speechChoice, Model dataForView) {
			
		//if speechChoice is yell
			if(speechChoice.equals("yell")) {
				//make submitted message LOUD
				Yeller yellerVar = new Yeller(submittedMessage);
				String allCaps = yellerVar.caps();
				dataForView.addAttribute("output", allCaps);
			}	
			
			//otherwise 
			else {
				//make submittedMessage quiet
				Whisperer whisperVar = new Whisperer(submittedMessage);
				String allLow = whisperVar.lower();
				dataForView.addAttribute("output", allLow);
				
			}
						
			return "helloworld/mixed-messages";				
		}
	
	}
	

	

 
