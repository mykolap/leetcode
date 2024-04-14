package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03110Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void scoreOfString(String s, int expected) {
        int result = new Solution03110().scoreOfString(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("hello", 13),
                Arguments.of("zaz", 50),
                Arguments.of("abc", 2),
                Arguments.of("aaa", 0),
                Arguments.of("z", 0)
        );
    }

}