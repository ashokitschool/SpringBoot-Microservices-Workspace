package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		PersonService personService = context.getBean(PersonService.class);

		// personService.savePersonWithPassport();

		// personService.getPerson(1); // parent + child

		// personService.getPassport(1); // child + parent

		// personService.deletePerson(1); // parent + child

		personService.deletePassport(1); // child + parent
	}
}
