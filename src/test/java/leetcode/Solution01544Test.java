package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01544Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void makeGood(String s, String expected) {
        String result = new Solution01544().makeGood(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("leEeetcode", "leetcode"),
                Arguments.of("abBAcC", ""),
                Arguments.of("s", "s")
        );
    }

}