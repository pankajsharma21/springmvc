

//this is for Interceptor example so we have not to create new
package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController2 {

	@RequestMapping("/home2")
	public String home() {
		return "home";
	}
	
	//handling for request
	@RequestMapping("/welcome2")
	public String welcome(@RequestParam("user") String name,Model m) {
	System.out.println(name);
	m.addAttribute("name",name);
	return "welcome";
	
	}
	}

