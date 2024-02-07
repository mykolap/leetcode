package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00451Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("trreee", "eeerrt"),
                Arguments.of("cccaa", "cccaa"),
                Arguments.of("Aaaabb", "aaabbA")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void frequencySort(String s, String expected) {
        assertEquals(expected, new Solution00451().frequencySortArray(s));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void frequencySortMap(String s, String expected) {
        assertEquals(expected, new Solution00451().frequencySortMap(s));
    }

}