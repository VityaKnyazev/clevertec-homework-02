package ru.clevertec.knyazev.homework02;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringUtils {
	public static final Logger logger = Logger.getLogger("StringUtils");

	private StringUtils() {

	}

	/**
	 * Check if the input string is a positive number.
	 *
	 * <pre>
	 * isPositiveNumber(null)   = false
	 * isPositiveNumber("")     = false
	 * isPositiveNumber("  ")   = false
	 * isPositiveNumber("123")  = true
	 * isPositiveNumber("12 3") = false
	 * isPositiveNumber("\u0967\u0968\u0969")  = false
	 * isPositiveNumber("ab2c") = false
	 * isPositiveNumber("12-3") = false
	 * isPositiveNumber("12.3") = true
	 * isPositiveNumber("0.0") = false
	 * isPositiveNumber("-0.0") = false
	 * isPositiveNumber("0.0d") = false
	 * isPositiveNumber("001.01") = true
	 * </pre>
	 * 
	 * 
	 * @param numberStr input sting for checking
	 * @return true - if input string is a positive number. Otherwise - false
	 */
	public static boolean isPositiveNumber(String numberStr) {

		if (org.apache.commons.lang3.StringUtils.isNotEmpty(numberStr)) {
			if (org.apache.commons.lang3.StringUtils.contains(numberStr, ".")) {
				String[] parts = numberStr.split("\\.");

				if (parts.length != 2) {
					return false;
				}

				if ((!org.apache.commons.lang3.StringUtils.isNumeric(parts[0]))
						|| (!org.apache.commons.lang3.StringUtils.isNumeric(parts[1]))) {
					return false;
				}
			} else {
				if (!org.apache.commons.lang3.StringUtils.isNumeric(numberStr)) {
					return false;
				}
			}
			try {
				Double number = Double.valueOf(numberStr);
				if (number.compareTo(0.0d) == 1) {
					return true;
				}
			} catch (NumberFormatException e) {
				logger.log(Level.WARNING, "Can't convert string to number of type double! " + e.getMessage());
			}
		}

		return false;
	}
}
