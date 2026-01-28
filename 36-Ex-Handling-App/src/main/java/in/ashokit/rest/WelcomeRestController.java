package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		int i = 10 / 0;
		return "Welcome to REST API";
	}

	@GetMapping("/test")
	public String test() {
		String s = null;
		return s.toUpperCase();
	}
}
