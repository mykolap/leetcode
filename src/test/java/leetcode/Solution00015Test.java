package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00015Test {

    static Stream<Arguments> getThreeSumArgs() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4},
                        List.of(
                                List.of(-1, -1, 2),
                                List.of(-1, 0, 1)
                        )),
                Arguments.of(new int[]{0, 1, 1},
                        List.of()),
                Arguments.of(new int[]{0, 0, 0},
                        List.of(
                                List.of(0, 0, 0)
                        )),
                Arguments.of(new int[]{-4, 2, 2},
                        List.of(
                                List.of(-4, 2, 2)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("getThreeSumArgs")
    void threeSumBrutforce(int[] nums, List<List<Integer>> expected) {
        Assertions.assertEquals(expected, new Solution00015().threeSumBrutforce(nums));
    }

    @ParameterizedTest
    @MethodSource("getThreeSumArgs")
    void threeSum(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, new Solution00015().threeSum(nums));
    }

}