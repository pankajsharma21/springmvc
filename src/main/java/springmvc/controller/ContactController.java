package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.Service.UserService;
import springmvc.model.User;

@Controller
public class ContactController {
	@Autowired
	private UserService userService; 
	
	/*
	 * we use @ModelAttribute on method if there is common data and we want to add
	 * on all the jsp pages OF SAME CONTROLLER 
	 * otherwise do one by one by model.addAttribute and this code is lenght
	 * by using this only now we can go on jsp pages and retrive by ${nameofattribute}
	 */
	@ModelAttribute
	public void commonDataForAllModel(Model model) {
		model.addAttribute("desc","this is description");
	//we can add as much common data we all 
		System.out.println("adding common data");
	}
/*
 * if we not use @modelAttribute for common data we should do this by model object on every method
    @RequestMapping("/contact")
	public String showForm(Model model) {
    	model.addAttribute("desc","this is description");
		return "contact";
	}
*/	
	
     @RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}
     
   //old approach request.getParameter to get data
    /*
     @RequestMapping(path = "/processform",method =RequestMethod.POST)
     public String handlerform(HttpServletRequest request) {
    	 String email = request.getParameter("email");
    	 System.out.println("the user email address is "+ email);
    	 return"";
     }
     */
   
     //@RequestParam annotation method of to get data data and send one bye one variable
/*      
     @RequestMapping(path = "/processform",method =RequestMethod.POST)
     public String handlerform(@RequestParam("email")String email,
    		 @RequestParam("userName") String userName,
    		 @RequestParam("password")String password,Model model) {
    	 System.out.println("user email"+email);
    	 System.out.println("user Name"+userName);
    	 System.out.println("user password"+password);
    	 //process if we want to store in data base or other
    	 
    	 model.addAttribute("email",email);
    	 model.addAttribute("userName",userName);
    	 model.addAttribute("password",password);
    	 
    	 return"success";
     }
   */ 
     
     
     //using requestparam wrapper the data in class or object then print and send or in this we wrapper in user class all data then print and save user object
 /*    
     @RequestMapping(path = "/processform",method =RequestMethod.POST)
     public String handlerform(@RequestParam("email")String email,
    		 @RequestParam("userName") String userName,
    		 @RequestParam("password")String password,Model model) {
             User user = new User();
             user.setEmail(email);
             user.setUserName(userName);
             user.setPassword(password);
             System.out.println(user);
    	 
    	 //process if we want to store in data base or other
    	 
    	 model.addAttribute("user",user);
    	 
    	 return"success";
     }
     
     */
     
     // Code using ModelAttribute
	/*
	 * @ModelAttribute by using this line of code reduce and all functionality is
	 * same as @request param & @Model it do work of both this attribute. it bind
	 * the form to java class and do all things.
	 */
     @RequestMapping(path = "/processform",method =RequestMethod.POST)
		     public String handlerform(@ModelAttribute User user,Model model) {
          System.out.println(user); //this is optional if we want to print on console
    	  if(user.getUserName().isBlank()) { //send redirect if condition is true
    		  
    		  return"redirect:/contact"; //send redirect if condition is true
    	  }
         //process if we want to store in data base or other
          int createdUser = this.userService.createUser(user);
          model.addAttribute("msg","User Created With Id"+createdUser);
    	 return"success";
     }

     
     
}
