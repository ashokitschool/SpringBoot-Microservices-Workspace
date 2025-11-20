package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/msg")
public class MsgController {

	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {

		System.out.println("getWelcomeMsg() method called...");

		ModelAndView mav = new ModelAndView();

		// data to display in view
		mav.addObject("msg", "Welcome to Spring Web MVC");

		// logical view name
		mav.setViewName("index");

		return mav;
	}

	@GetMapping("/greet")
	public String getGreetMsg(Model model) {

		System.out.println("Model impl class : " + model.getClass().getName());

		model.addAttribute("msg", "Good Morning..!!");

		return "index"; // logical view name
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String testMsg() {
		return "This is my Text Msg coming from controller method";
	}
}
