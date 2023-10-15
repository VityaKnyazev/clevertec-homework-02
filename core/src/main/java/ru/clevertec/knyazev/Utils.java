package ru.clevertec.knyazev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Utils {
    private static final String VARARGS_ERROR = "Varargs numbers cant't be null";
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    private StringUtils stringUtils;

    public Utils() {
        this.stringUtils = new StringUtils();
    }

    public boolean isAllPositiveNumbers(String... numbers) {

        if (numbers == null) {
            logger.error(VARARGS_ERROR);
            return false;
        }

        return Stream.of(numbers)
                .allMatch(number -> stringUtils.isPositiveNumber(number));
    }

}
