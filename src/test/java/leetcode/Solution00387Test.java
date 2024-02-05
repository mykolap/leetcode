package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00387Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("leetcode", 0),
                Arguments.of("loveleetcode", 2),
                Arguments.of("aabb", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void firstUniqCharArray(String s, int expected) {
        assertEquals(expected, new Solution00387().firstUniqCharArray(s));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void firstUniqMap(String s, int expected) {
        assertEquals(expected, new Solution00387().firstUniqMap(s));
    }

}