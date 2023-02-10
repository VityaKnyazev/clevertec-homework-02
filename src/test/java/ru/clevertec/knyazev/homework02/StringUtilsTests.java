package ru.clevertec.knyazev.homework02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringUtilsTests {
	@Test
	public void whenIsPositiveNumber() {
		final String number1 = "165";
		final String number2 = "0.658";
		final String number3 = "0.000000000000000000001";
		final String number4 = "-0.0";
		final String number5 = "0.0";
		final String number6 = "0.658d";
		final String number7 = "0,658";
		final String number8 = "-165";
		final String number9 = "-00.658";
		final String number10 = "--00.658";
		final String number11 = "-00,658";
		final String number12 = "-00d658";
		final String number13 = "10 658";
		final String number14 = "\u0967\u0968\u0969";
		
		assertAll(() -> {
			assertTrue(StringUtils.isPositiveNumber(number1));
			assertTrue(StringUtils.isPositiveNumber(number2));
			assertTrue(StringUtils.isPositiveNumber(number3));
		});
		
		assertAll(() -> {
			assertFalse(StringUtils.isPositiveNumber(number4));
			assertFalse(StringUtils.isPositiveNumber(number5));
			assertFalse(StringUtils.isPositiveNumber(number6));
			assertFalse(StringUtils.isPositiveNumber(number7));
			assertFalse(StringUtils.isPositiveNumber(number8));
			assertFalse(StringUtils.isPositiveNumber(number9));
			assertFalse(StringUtils.isPositiveNumber(number10));
			assertFalse(StringUtils.isPositiveNumber(number11));
			assertFalse(StringUtils.isPositiveNumber(number12));
			assertFalse(StringUtils.isPositiveNumber(number13));
			assertFalse(StringUtils.isPositiveNumber(number14));
		});
	}
	
	@Test
	public void whenIsPositiveNumberOnNullInput() {
		final String number = null;
		
		assertEquals(false, StringUtils.isPositiveNumber(number));
	}
	
	@Test
	public void whenIsPositiveNumberOnEmptyInput() {
		final String number1 = "";
		final String number2 = " ";
		final String number3 = "  ";
		
		assertEquals(false, StringUtils.isPositiveNumber(number1));
		assertEquals(false, StringUtils.isPositiveNumber(number2));
		assertEquals(false, StringUtils.isPositiveNumber(number3));
	}
	
	@Test
	public void whenIsPositiveNumberAndPartsLengthNotEqualsTwo() {
		final String number = "0.25.56";
		
		assertEquals(false, StringUtils.isPositiveNumber(number));
	}
}