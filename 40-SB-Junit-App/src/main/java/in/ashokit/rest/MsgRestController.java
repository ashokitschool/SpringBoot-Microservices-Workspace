package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.MsgService;

@RestController
public class MsgRestController {

	@Autowired
	private MsgService msgService;

	@GetMapping("/welcome")
	public String welcomeMsg() {

		String welcomeMsg = msgService.getWelcomeMsg();

		System.out.println("Injected Service Bean :: " + msgService.getClass().getName());

		if (welcomeMsg != null && !welcomeMsg.equals("")) {
			msgService.sendEmail();
			return welcomeMsg.toUpperCase();
		}
		return null;
	}
}
