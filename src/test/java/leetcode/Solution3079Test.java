package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution3079Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumOfEncryptedInt(int[] nums, int expected) {
        int result = new Solution3079().sumOfEncryptedInt(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumOfEncryptedIntViaString(int[] nums, int expected) {
        int result = new Solution3079().sumOfEncryptedIntViaString(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{1, 23, 13}, 67),
                Arguments.of(new int[]{11, 22, 33}, 66)
        );
    }
}