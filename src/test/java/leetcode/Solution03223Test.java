package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03223Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumLength(String s, int expected) {
        int result = new Solution03223().minimumLength(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abaacbcbb", 5),
                Arguments.of("aa", 2)
        );
    }

}