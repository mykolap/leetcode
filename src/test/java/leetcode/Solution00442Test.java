package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00442Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findDuplicates(int[] nums, List<Integer> expected) {
        List<Integer> result = new Solution00442().findDuplicates(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(2, 3)),
                Arguments.of(new int[]{1, 1, 2}, List.of(1)),
                Arguments.of(new int[]{1}, List.of())
        );
    }

}