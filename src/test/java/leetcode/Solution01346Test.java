package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01346Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void checkIfExist(String arrStr, boolean expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        boolean result = new Solution01346().checkIfExist(arr);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[10,2,5,3]", true),
                Arguments.of("[7,1,14,11]", true),
                Arguments.of("[3,1,7,11]", false)
        );
    }

}