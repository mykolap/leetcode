package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02053Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kthDistinct(String arrStr, int k, String expected) {
        String[] arr = ArrayUtils.stringToStringArray(arrStr);
        String actual = new Solution02053().kthDistinct(arr, k);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"d\",\"b\",\"c\",\"b\",\"c\",\"a\"]", 2, "a"),
                Arguments.of("[\"aaa\",\"aa\",\"a\"]", 1, "aaa"),
                Arguments.of("[\"a\",\"b\",\"a\"]", 3, "")
        );
    }

}