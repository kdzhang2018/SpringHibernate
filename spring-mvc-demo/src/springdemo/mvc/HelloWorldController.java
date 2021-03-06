package springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// show initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// process the HTML form
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		String result = "Yo! " + theName;
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// process the HTML form
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		theName = theName.toUpperCase();
		String result = "Version 3 Hey! " + theName;
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
