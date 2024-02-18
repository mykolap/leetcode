package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01624Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aa", 0),
                Arguments.of("abca", 2),
                Arguments.of("cbzxy", -1),
                Arguments.of("cabbac", 4),
                Arguments.of("mgntdygtxrvxjnwksqhxuxtrv", 18)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxLengthBetweenEqualCharactersBruteforce(String s, int expected) {
        int actual = new Solution01624().maxLengthBetweenEqualCharactersBruteforce(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxLengthBetweenEqualCharactersMap(String s, int expected) {
        int actual = new Solution01624().maxLengthBetweenEqualCharactersMap(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxLengthBetweenEqualCharactersArray(String s, int expected) {
        int actual = new Solution01624().maxLengthBetweenEqualCharactersArray(s);
        assertEquals(expected, actual);
    }

}