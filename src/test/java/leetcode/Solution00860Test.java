package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00860Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lemonadeChange(String billsStr, boolean expected) {
        int[] bills = ArrayUtils.stringToIntArray(billsStr);
        final boolean result = new Solution00860().lemonadeChange(bills);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,5,5,10,20]", true),
                Arguments.of("[5,5,10]", true),
                Arguments.of("[10,10]", false),
                Arguments.of("[5,5,10,10,20]", false)
        );
    }

}