package leetcode.climbingStairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 3",
            "4, 5",
            "5, 8",
            "6, 13",
            "7, 21",
            "8, 34",
            "9, 55",
            "10, 89",
            "11, 144",
            "12, 233",
            "13, 377",
            "14, 610",
            "15, 987",
            "16, 1597",
            "17, 2584",
            "18, 4181",
            "19, 6765",
            "20, 10946",
            "21, 17711",
            "22, 28657",
            "23, 46368",
            "24, 75025"
    })
    void climbStairs(int n, int expected) {
        assertEquals(expected, new Solution().climbStairs(n));
    }

}