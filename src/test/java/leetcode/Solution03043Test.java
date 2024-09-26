package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03043Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestCommonPrefix(String arr1Str, String arr2Str, int expected) {
        int[] arr1 = ArrayUtils.stringToIntArray(arr1Str);
        int[] arr2 = ArrayUtils.stringToIntArray(arr2Str);
        int actual = new Solution03043().longestCommonPrefix(arr1, arr2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,10,100]", "[1000]", 3),
                Arguments.of("[1,2,3]", "[4,4,4]", 0)
        );
    }

}