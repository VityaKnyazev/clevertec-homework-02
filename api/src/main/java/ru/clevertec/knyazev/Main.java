package ru.clevertec.knyazev;

public class Main {

    private static final Utils utils = new Utils();

    public static void main(String[] args) {

        String[] numbers = {"12", "79"};

        System.out.println("Is all positive numbers? " +
                            utils.isAllPositiveNumbers(numbers));
    }

}