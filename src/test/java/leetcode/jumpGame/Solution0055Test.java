package leetcode.jumpGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0055Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, true),
                Arguments.of(new int[]{3, 2, 1, 0, 4}, false),
                Arguments.of(new int[]{0}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canJump(int[] nums, boolean expected) {
        boolean actual = new Solution0055().canJump(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canJumpDirect(int[] nums, boolean expected) {
        boolean actual = new Solution0055().canJumpDirect(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canJumpBruteforce(int[] nums, boolean expected) {
        boolean actual = new Solution0055().canJumpBruteforce(nums);
        assertEquals(expected, actual);
    }

}