package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.ashokit.constants.AppConstants;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = "group_ashokit_order")
	public void getKafkaMsgs(String order) {
		System.out.println("*** Msg Recieved from Kafka ***");
		System.out.println(order);
	}

}
