package leetcode;

/**
 * 273. Integer to English Words
 * <a href="https://leetcode.com/problems/integer-to-english-words">Web link</a>
 * Hard
 */

public class Solution00273 {

    private static final String[] ONES = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    private static final String[] TENS = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String[] TEENS = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};

    public String numberToWordsStructured(int num) {
        if (num == 0) {
            return "Zero";
        }

        final StringBuilder sb = new StringBuilder();
        if (num >= 1_000_000_000) {
            sb.append(numberToWordsStructured(num / 1_000_000_000));
            sb.append(" Billion ");
            num %= 1_000_000_000;
        }
        if (num >= 1_000_000) {
            sb.append(numberToWordsStructured(num / 1_000_000));
            sb.append(" Million ");
            num %= 1_000_000;
        }
        if (num >= 1_000) {
            sb.append(numberToWordsStructured(num / 1_000));
            sb.append(" Thousand ");
            num %= 1_000;
        }
        if (num >= 100) {
            sb.append(ONES[num / 100]);
            sb.append("Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(TENS[num / 10]);
            num %= 10;
        } else if (num >= 10) {
            sb.append(TEENS[num - 10]);
            num = 0;
        }
        if (num > 0) {
            sb.append(ONES[num]);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num < 1_000) {
            return get3DigitString(num, true, "");
        } else if (num < 1_000_000) {
            return lessThanMillion(num, true);
        } else if (num < 1_000_000_000) {
            return lessThanBillion(num, true);
        } else {
            return lessThanTrillion(num);
        }
    }

    private String lessThanTrillion(int num) {
        int last9Digits = num % 1_000_000_000;
        int first3Digits = num / 1_000_000_000;
        return get3DigitString(first3Digits, true, " Billion") +
               lessThanBillion(last9Digits, false);
    }

    private String lessThanBillion(int num, boolean firstSection) {
        int last6Digits = num % 1_000_000;
        int first3Digits = num / 1_000_000;
        return get3DigitString(first3Digits, firstSection, " Million") +
               lessThanMillion(last6Digits, false);
    }

    private String lessThanMillion(int num, boolean firstSection) {
        int last3Digits = num % 1000;
        int first3Digits = num / 1000;
        return get3DigitString(first3Digits, firstSection, " Thousand") +
               get3DigitString(last3Digits, false, "");
    }

    private String get3DigitString(int num, boolean firstSection, String suffix) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred > 0) {
            if (!firstSection) {
                sb.append(" ");
            }
            sb.append(lessThanTwenty(hundred)).append(" Hundred");
        }
        int lastTwoDigits = num % 100;
        if (lastTwoDigits == 0) {
            if (hundred > 0) {
                return sb
                        .append(suffix)
                        .toString();
            } else {
                if (firstSection) {
                    return "Zero";
                } else {
                    return "";
                }
            }
        }
        if (lastTwoDigits > 0) {
            if (hundred > 0 || !firstSection) {
                sb.append(" ");
            }
        }
        if (lastTwoDigits < 20) {
            return sb.append(lessThanTwenty(lastTwoDigits))
                    .append(suffix)
                    .toString();
        }
        sb.append(lessThanHundred(lastTwoDigits / 10 * 10));
        int lastOnes = lastTwoDigits % 10;
        if (lastOnes == 0) {
            return sb
                    .append(suffix)
                    .toString();
        }
        return sb.append(" ")
                .append(lessThanTwenty(lastOnes))
                .append(suffix)
                .toString();
    }

    private String lessThanHundred(int num) {
        return switch (num) {
            case 20 -> "Twenty";
            case 30 -> "Thirty";
            case 40 -> "Forty";
            case 50 -> "Fifty";
            case 60 -> "Sixty";
            case 70 -> "Seventy";
            case 80 -> "Eighty";
            case 90 -> "Ninety";
            default -> "";
        };
    }

    private String lessThanTwenty(int num) {
        return switch (num) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            case 13 -> "Thirteen";
            case 14 -> "Fourteen";
            case 15 -> "Fifteen";
            case 16 -> "Sixteen";
            case 17 -> "Seventeen";
            case 18 -> "Eighteen";
            case 19 -> "Nineteen";
            default -> "";
        };
    }

}