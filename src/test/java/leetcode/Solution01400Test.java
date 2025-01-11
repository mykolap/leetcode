package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01400Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canConstruct(String s, int k, boolean expected) {
        boolean result = new Solution01400().canConstruct(s, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("annabelle", 2, true),
                Arguments.of("leetcode", 3, false),
                Arguments.of("true", 4, true)
        );
    }

}