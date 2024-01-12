package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01704Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("book", true),
                Arguments.of("textbook", false),
                Arguments.of("MerryChristmas", false),
                Arguments.of("AbCdEfGh", true)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void halvesAreAlike(String s, boolean expected) {
        boolean result = new Solution01704().halvesAreAlike(s);
        assertEquals(expected, result);
    }

}