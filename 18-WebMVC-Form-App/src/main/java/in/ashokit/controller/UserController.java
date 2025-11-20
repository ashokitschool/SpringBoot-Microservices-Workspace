package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.dto.User;

@Controller
public class UserController {

	@GetMapping("/")
	public String index(Model model) {

		User userObj = new User();

		model.addAttribute("user", userObj);

		return "index";
	}

	@PostMapping("/saveUser")
	public String handleSubmitBtn(User user, Model model) {

		System.out.println(user);

		model.addAttribute("msg", user.getUname() + " added successfully..!!");

		return "success";
	}

}
