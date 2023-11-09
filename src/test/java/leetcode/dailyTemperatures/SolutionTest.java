package leetcode.dailyTemperatures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Stream<Arguments> getArgsDailyTemperatures() {
        return Stream.of(
                Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0}),
                Arguments.of(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}, new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("getArgsDailyTemperatures")
    void dailyTemperaturesBruteforce(int[] temperatures, int[] expected) {
        assertThat(new Solution().dailyTemperaturesBruteforce(temperatures))
                .containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("getArgsDailyTemperatures")
    void dailyTemperatures(int[] temperatures, int[] expected) {
        assertThat(new Solution().dailyTemperatures(temperatures))
                .containsExactly(expected);
    }

}