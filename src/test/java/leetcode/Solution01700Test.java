package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01700Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countStudents(int[] students, int[] sandwiches, int expected) {
        int result = new Solution01700().countStudents(students, sandwiches);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countStudentsNoQueue(int[] students, int[] sandwiches, int expected) {
        int result = new Solution01700().countStudentsNoQueue(students, sandwiches);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}, 0),
                Arguments.of(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}, 3),
                Arguments.of(new int[]{1, 0, 0, 0, 1, 1}, new int[]{1, 0, 0, 0, 1, 1}, 0),
                Arguments.of(new int[]{1, 0, 0, 0, 1, 1}, new int[]{0, 1, 0, 1, 0, 1}, 0)
        );
    }

}