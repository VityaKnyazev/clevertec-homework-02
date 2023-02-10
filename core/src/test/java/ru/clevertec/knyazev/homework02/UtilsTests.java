package ru.clevertec.knyazev.homework02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilsTests {
	@Test
	public void whenIsAllPositiveNumbers() {
		String number1 = "0.00001";
		String number2 = "15";
		String number3 = "01.568882";
		
		String number4 = "0.00";
		String number5 = "-0.00";
		String number6 = "+0.00";
		String number7 = "-0.25811";
		String number8 = "-0.25811";
		String number9 = "0.25811d";
		String number10 = null;
		String number11 = "";
		String number12 = "  ";
				
		boolean result1 = Utils.isAllPositiveNumbers(number1, number2, number3);
		boolean result2 = Utils.isAllPositiveNumbers(number4, number5, number6, number7, number8, number9, number10, number11, number12);
		boolean result3 = Utils.isAllPositiveNumbers(number1, number2, number3, number9);
		
		assertAll(() -> {
			assertEquals(true, result1);
			assertEquals(false, result2);
			assertEquals(false, result3);
		});
	}
	
	@Test
	public void whenIsAllPositiveNumbersOnNullInput() {
		String number = null;
		
		assertEquals(false, Utils.isAllPositiveNumbers(number));
	}
	
	@Test
	public void whenIsAllPositiveNumbersOnEmptyInput() {
		
		assertEquals(false, Utils.isAllPositiveNumbers());
	}
}