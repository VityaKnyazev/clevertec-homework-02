package ru.clevertec.knyazev.homework02;

import java.util.stream.Stream;

public class Utils {

	public static boolean isAllPositiveNumbers(String... numbers) {
		if (numbers.length > 0) {
			return Stream.of(numbers).allMatch(number -> StringUtils.isPositiveNumber(number));
		}
		
		return false;
	}

}