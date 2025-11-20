package in.ashokit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.bindings.User;

@Controller
public class UserController {
	
	
	@PostMapping("/user")
	@ResponseBody
	public String addUser(@RequestBody User user) {
		
		System.out.println(user);
		
		return "User Added";
	}

	@GetMapping("/user")
	@ResponseBody
	public User getUser() {

		User u = new User();
		u.setId(101);
		u.setName("Ashok");
		u.setGender("Male");
		u.setPhno(797979799l);

		return u;
	}
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {

		User u1 = new User();
		u1.setId(101);
		u1.setName("Ashok");
		u1.setGender("Male");
		u1.setPhno(797979799l);
		
		User u2 = new User();
		u2.setId(102);
		u2.setName("Raju");
		u2.setGender("Male");
		u2.setPhno(56779799l);

		return Arrays.asList(u1, u2);
	}

}
