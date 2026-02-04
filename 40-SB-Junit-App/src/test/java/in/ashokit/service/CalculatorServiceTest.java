package in.ashokit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceTest {

	@Autowired
	private CalculatorService service;

	@Test
	public void testAdd_1() {

		int actualResult = service.add(10, 20);
		int expectedResult = 30;

		Assertions.assertEquals(actualResult, expectedResult);
	}

	@ParameterizedTest
	@CsvSource({ "10, 20, 30", "5,  5,  10", "0,  5,  5", "-1, 2,  1" })
	void testAdd_2(int a, int b, int expectedResult) {
		int actualResult = service.add(a, b);
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testIsEven_1() {
		boolean isEven = service.isEven(10);
		Assertions.assertTrue(isEven);
	}

	@Test
	public void testIsEven_2() {
		boolean isEven = service.isEven(23);
		Assertions.assertEquals(isEven, false);
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10, 12, 14, 16 })
	public void testIsEven_3(int num) {
		boolean isEven = service.isEven(num);
		Assertions.assertTrue(isEven);
	}

	@ParameterizedTest
	@ValueSource(ints = { 3, 5, 7, 11, 13, 17, 23 })
	public void testIsEven_4(int num) {
		boolean isEven = service.isEven(num);
		Assertions.assertFalse(isEven);
	}

}
