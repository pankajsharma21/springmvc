package springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {
	//first and smallest way to redirect
	/*
	@RequestMapping("/one")
	public String one() {
		System.out.println("this is handler one /one");
		
		return "redirect:/enjoy";    //this redirect to enty control and enoy view page 
	}
	*/
	
	//Second way to redirect using RedirectView
	
/*	@RequestMapping("/one")
	public RedirectView one() {
		System.out.println("this is handler one /one");
		RedirectView redirectView =new RedirectView();
		redirectView.setUrl("enjoy"); //redirect by this using realtive url in this 
		return redirectView; 
	}
*/	
	@RequestMapping("/enjoy")
	public String two() {
		System.out.println("this is handler two [enjoy] ");
		return "contact";
	}

	
	//third way to redirect using HtttpServletRespons but we not use this because old way and why we use spring mvc if we use this
/*
 * code is incomplete see on web to complete no need so incomplete	
	@RequestMapping("/one")
	public String one(HttpServletResponse response) {
		System.out.println("this is handler one /one");
		
	try {
		response.sendRedirect("/enjoy");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return ""; 
	}
	
	*/
}
