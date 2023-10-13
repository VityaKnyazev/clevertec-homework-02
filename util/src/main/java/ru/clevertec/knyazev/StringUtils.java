package ru.clevertec.knyazev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class StringUtils implements NumberUtils {
    private static final String ERROR_NUMBER_FORMAT = "Error in number format";
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    @Override
    public boolean isPositiveNumber(String number) {

        if (number == null) {
            return false;
        }

        try {
            BigDecimal num = new BigDecimal(number);

            if (num.signum() == 1) {
                return true;
            }

        } catch (NumberFormatException e) {
            logger.error(String.format("%s: %s", ERROR_NUMBER_FORMAT, e.getMessage()), e);
        }

        return false;

    }

}
