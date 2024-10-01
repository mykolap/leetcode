package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01497Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canArrange(String arrStr, int k, boolean expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        boolean result = new Solution01497().canArrange(arr, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4,5,10,6,7,8,9]", 5, true),
                Arguments.of("[1,2,3,4,5,6]", 7, true),
                Arguments.of("[1,2,3,4,5,6]", 10, false),
                Arguments.of("[-10,10]", 2, true),
                Arguments.of("[-1,-1,-1,-1,2,2,-2,-2]", 3, false)
        );
    }

}