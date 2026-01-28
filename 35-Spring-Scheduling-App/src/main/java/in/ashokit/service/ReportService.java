package in.ashokit.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Scheduled(cron = "0 0 9 * * *, zone=Asia/Kolkata")
	public void report() throws Exception {

		System.out.println("report() method executed :: " + LocalDateTime.now());

		// logic to generate report
	}

}
