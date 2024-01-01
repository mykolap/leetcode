package leetcode.findTheDuplicateNumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0287Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 2, 2}, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 2}, 3),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 1, 2}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findDublicateBruteforce(int[] nums, int expected) {
        int actual = new Solution0287().findDuplicateBruteforce(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findDuplicateArray(int[] nums, int expected) {
        int actual = new Solution0287().findDuplicateArray(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findDuplicateSet(int[] nums, int expected) {
        int actual = new Solution0287().findDuplicateSet(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findDuplicateFloyd(int[] nums, int expected) {
        int actual = new Solution0287().findDuplicateFloyd(nums);
        assertEquals(expected, actual);
    }

}