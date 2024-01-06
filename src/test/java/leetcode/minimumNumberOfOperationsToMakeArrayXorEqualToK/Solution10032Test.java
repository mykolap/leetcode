package leetcode.minimumNumberOfOperationsToMakeArrayXorEqualToK;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution10032Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 4}, 1, 2),
                Arguments.of(new int[]{2, 0, 2, 0}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(int[] A, int k, int expected) {
        assertEquals(expected, new Solution10032().minOperations(A, k));
    }

}