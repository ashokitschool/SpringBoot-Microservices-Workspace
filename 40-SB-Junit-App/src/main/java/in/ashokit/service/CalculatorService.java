package in.ashokit.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int add(int a, int b) {
		return a + b;
	}

	public boolean isEven(int number) {
		return number % 2 == 0;
	}

}
