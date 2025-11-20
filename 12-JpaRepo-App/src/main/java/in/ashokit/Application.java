package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		UserService bean = context.getBean(UserService.class);

		// bean.getUserswithSort();

		// bean.getUserswithPagination();

		// bean.qbe();

		bean.saveUsers();
	}

}
