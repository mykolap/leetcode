package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03081Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimizeStringValue(String s, String expected) {
        String result = new Solution03081().minimizeStringValue(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("???", "abc"),
                Arguments.of("a?a?", "abac"),
                Arguments.of("abcdefghijklmnopqrstuvwxy??", "abcdefghijklmnopqrstuvwxyaz")
        );
    }
}