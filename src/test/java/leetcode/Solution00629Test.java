package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00629Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 0, 1),
                Arguments.of(3, 1, 2),
                Arguments.of(1000, 1000, 663677020)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kInversePairs(int n, int k, int expected) {
        int actual = new Solution00629().kInversePairs(n, k);
        assertEquals(expected, actual);
    }

}