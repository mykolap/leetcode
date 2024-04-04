package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01614Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxDepth(String s, int expected) {
        int result = new Solution01614().maxDepth(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1", 0),
                Arguments.of("(1+(2*3)+((8)/4))+1", 3),
                Arguments.of("(1)+((2))+(((3)))", 3),
                Arguments.of("1+(2*3)/(2-1)", 1)
        );
    }

}