package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.ashokit.constants.AppConstants;
import in.ashokit.model.Order;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public String placeOrder(Order order) {

		// logic to place the order

		// publish msg to kafka
		kafkaTemplate.send(AppConstants.TOPIC_NAME, order);

		return "Msg published to Kafka Topic";
	}

}
