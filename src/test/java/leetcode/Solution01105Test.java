package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01105Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minHeightShelves(String booksStr, int shelfWidth, int expected) {
        int[][] books = ArrayUtils.stringTo2DIntArray(booksStr);
        assertEquals(expected, new Solution01105().minHeightShelves(books, shelfWidth));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]", 4, 6),
                Arguments.of("[[1,3],[2,4],[3,2]]", 6, 4)
        );
    }

}