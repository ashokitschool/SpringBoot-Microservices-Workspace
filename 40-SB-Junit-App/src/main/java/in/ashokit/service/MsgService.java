package in.ashokit.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {

	public String getWelcomeMsg() {

		String msg = "Welcome to Ashok IT";

		return msg;
	}

	public void sendEmail() {
		// SMTP Logic Here
		System.out.println("Email Sent ::: SendEmail() real method called....");
	}

}
