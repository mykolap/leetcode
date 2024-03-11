package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00791Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void customSortString(String order, String s, String expected) {
        String result = new Solution00791().customSortString(order, s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("cba", "abcd", "cbad"),
                Arguments.of("cba", "abc", "cba"),
                Arguments.of("cba", "a", "a"),
                Arguments.of("cba", "", ""),
                Arguments.of("", "abc", "abc"),
                Arguments.of("", "", "")
        );
    }

}