package com.tech.transformers.loan.optimizer.util;

import com.tech.transformers.loan.optimizer.constants.Constants;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class LoanUtils {
    public static Boolean isGreaterThan(BigDecimal val1, BigDecimal val2){
        return val1.compareTo(val2)>0;
    }


    public static BigDecimal getEligibleEmiValue(BigDecimal annualIncome, BigDecimal existingEmi){
        BigDecimal possibleEmi = LoanUtils.isGreaterThan(annualIncome, BigDecimal.ZERO)
                ? divideInRoundingMode(annualIncome, Constants.TWENTY_FOUR) : BigDecimal.ZERO; // (50% of Monthly In hand Salary)

        return possibleEmi.subtract(existingEmi); // 100 - 30
    }

    public static BigDecimal divideInRoundingMode(BigDecimal value, BigDecimal divisor) {
        return value.divide(divisor, 2, RoundingMode.HALF_UP);
    }
}
