package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00881Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numRescueBoats(String peopleStr, int limit, int expected) {
        Solution00881 solution = new Solution00881();
        final int[] people = ArrayUtils.stringToIntArray(peopleStr);
        int output = solution.numRescueBoats(people, limit);
        assertEquals(expected, output);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numRescueBoatsBucketSort(String peopleStr, int limit, int expected) {
        Solution00881 solution = new Solution00881();
        final int[] people = ArrayUtils.stringToIntArray(peopleStr);
        int output = solution.numRescueBoatsBucketSort(people, limit);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                /*
                Arguments.of("[1, 2]", 3, 1),
                Arguments.of("[3, 2, 2, 1]", 3, 3),
                Arguments.of("[3, 5, 3, 4]", 5, 4),
                Arguments.of("[3, 5, 3, 4]", 6, 3),
                Arguments.of("[3, 5, 3, 3, 4]", 6, 4),
                Arguments.of("[2,2]", 6, 1),

                 */
                Arguments.of("[3,8,4,9,2,2,7,1,6,10,6,7,1,7,7,6,4,4,10,1]", 10, 11)
        );
    }
}