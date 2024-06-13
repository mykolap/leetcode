package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02037Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minMovesToSeat(String seatsStr, String studentsStr, int expected) {
        int[] seats = ArrayUtils.stringToIntArray(seatsStr);
        int[] students = ArrayUtils.stringToIntArray(studentsStr);
        int result = new Solution02037().minMovesToSeat(seats, students);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,1,5]", "[2,7,4]", 4),
                Arguments.of("[4,1,5,9]", "[1,3,2,6]", 7),
                Arguments.of("[2,2,6,6]", "[1,3,2,6]", 4)
        );
    }

}