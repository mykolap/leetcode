package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution01122Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void relativeSortArray(String arr1Str, String arr2Str, String expectedStr) {
        int[] arr1 = ArrayUtils.stringToIntArray(arr1Str);
        int[] arr2 = ArrayUtils.stringToIntArray(arr2Str);
        int[] expected = ArrayUtils.stringToIntArray(expectedStr);
        int[] result = new Solution01122().relativeSortArray(arr1, arr2);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,3,1,3,2,4,6,7,9,2,19]", "[2,1,4,3,9,6]", "[2,2,2,1,4,3,3,9,6,7,19]"),
                Arguments.of("[28,6,22,8,44,17]", "[22,28,8,6]", "[22,28,8,6,17,44]")
        );
    }

}