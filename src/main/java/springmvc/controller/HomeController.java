package springmvc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //use this annotation to make class controler
@RequestMapping("/hc")//we can also use this annotation on class but after this to access method
                      // we have to fire class url first than method url like "/hc/home"

public class HomeController {
	
    @RequestMapping(path ="/home",method = RequestMethod.GET ) //annotation use like url mappping if fire "/home" index page open
	public String home(Model model){//model is a class to transfer data or model to view and model in this is a object of that class. 
		System.out.println("this is home page");
		model.addAttribute("name", "pankaj");//method of model class.addAttribute
		model.addAttribute("id",12345);
		List<String> friends=new ArrayList<String>();
		friends.add("ram");
		friends.add("shyam");
		friends.add("kamal");
		model.addAttribute("f",friends);
		return "index";
	}
    
    @RequestMapping("/about")
    public String about(){
		System.out.println("this is about page");
		return "about";
	}
    
    @RequestMapping("/services")
    public String services(){
		System.out.println("this is services page");
		return "services";
	}
   //transfer data to view with help of ModelAndView class class and its  methods 
    @RequestMapping("/help")
    public ModelAndView help(){
		System.out.println("this is help page");
		//creating object of model and view
		ModelAndView modelAndView =new ModelAndView();
		//setting data
		modelAndView.addObject("name","Pankaj");
		modelAndView.addObject("id",1234567);
		LocalDateTime now = LocalDateTime.now();
		//formate date
		DateTimeFormatter formater =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String time=now.format(formater);
		modelAndView.addObject("time",time);//we change time variable to now if we want to print unformatted date time
		modelAndView.addObject("school","Hcps");
		modelAndView.addObject("phone",123456789);
		//marks
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		list.add(789);
		modelAndView.addObject("marks",list);
		//setting view name
		modelAndView.setViewName("help");
		
		return modelAndView;
	}
	
}
