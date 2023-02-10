package ru.clevertec.knyazev.homework02;

public class App {
	public static void main(String[] args) {
		boolean result = Utils.isAllPositiveNumbers("12", "79");

		if (result) {
			System.out.println("All gaved numbers are positive!");
		} else {
			System.out.println("Some or all gaved numbers are not positive!");
		}
	}
}