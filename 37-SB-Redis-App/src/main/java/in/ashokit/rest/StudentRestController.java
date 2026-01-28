package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Student;
import in.ashokit.repo.StudentRepo;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepo srepo;

	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		srepo.save(student);
		return "Student Saved";
	}
	
	public void m1() {
		// read data from db
		// store in redis
	}

	@GetMapping("/students")
	public Iterable<Student> getAllStudents() {
		return srepo.findAll();
	}

}
