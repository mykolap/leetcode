package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02696Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minLength(String s, int expected) {
        int result = new Solution02696().minLength(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("ABFCACDB", 2),
                Arguments.of("ACBBD", 5)
        );
    }

}