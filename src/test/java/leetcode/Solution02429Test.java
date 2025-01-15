package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02429Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimizeXor(int num1, int num2, int expected) {
        assertEquals(expected, new Solution02429().minimizeXor(num1, num2));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 5, 3),
                Arguments.of(1, 12, 3)
        );
    }

}