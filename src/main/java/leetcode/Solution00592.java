package leetcode;

import java.math.BigInteger;

/**
 * 592. Fraction Addition and Subtraction
 * <a href="https://leetcode.com/problems/fraction-addition-and-subtraction">Web link</a>
 * Medium
 */

public class Solution00592 {

    public String fractionAdditionBigDecimal(String expression) {
        BigInteger numeratorSum = BigInteger.ZERO;
        BigInteger commonDenominator = BigInteger.ONE;
        int index = 0;
        int length = expression.length();

        while (index < length) {
            int sign = 1;

            // Determine the sign of the current fraction
            if (expression.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if (expression.charAt(index) == '+') {
                index++;
            }

            // Extract the numerator
            int start = index;
            while (index < length && Character.isDigit(expression.charAt(index))) {
                index++;
            }
            BigInteger numerator = new BigInteger(expression.substring(start, index)).multiply(BigInteger.valueOf(sign));

            // Move past the '/' character
            index++;

            // Extract the denominator
            start = index;
            while (index < length && Character.isDigit(expression.charAt(index))) {
                index++;
            }
            BigInteger denominator = new BigInteger(expression.substring(start, index));

            // Calculate the new common denominator (LCM of current and new denominator)
            BigInteger lcm = commonDenominator.multiply(denominator).divide(commonDenominator.gcd(denominator));

            // Adjust the numerators to the new common denominator and add them
            numeratorSum = numeratorSum.multiply(lcm.divide(commonDenominator)).add(numerator.multiply(lcm.divide(denominator)));
            commonDenominator = lcm;
        }

        // Simplify the fraction
        BigInteger gcd = numeratorSum.gcd(commonDenominator);
        numeratorSum = numeratorSum.divide(gcd);
        commonDenominator = commonDenominator.divide(gcd);

        return numeratorSum + "/" + commonDenominator;
    }

    public String fractionAddition(String expression) {
        int numeratorSum = 0;
        int commonDenominator = 1;
        int index = 0;

        while (index < expression.length()) {
            int currentNumerator = 0;
            int currentDenominator = 0;
            boolean isNegative = false;

            // Determine the sign of the current fraction
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                isNegative = expression.charAt(index) == '-';
                index++;
            }

            // Extract the numerator
            while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                currentNumerator = currentNumerator * 10 + (expression.charAt(index) - '0');
                index++;
            }
            if (isNegative) currentNumerator *= -1;

            // Skip the '/' character
            index++;

            // Extract the denominator
            while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                currentDenominator = currentDenominator * 10 + (expression.charAt(index) - '0');
                index++;
            }

            // Add fractions together using common denominator
            numeratorSum = numeratorSum * currentDenominator + currentNumerator * commonDenominator;
            commonDenominator *= currentDenominator;
        }

        // Reduce the fraction
        BigInteger gcd = BigInteger.valueOf(numeratorSum).gcd(BigInteger.valueOf(commonDenominator));
        numeratorSum /= gcd.intValue();
        commonDenominator /= gcd.intValue();

        return numeratorSum + "/" + commonDenominator;
    }

}