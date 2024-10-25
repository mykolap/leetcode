package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01233Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeSubfolders(String foldersString, String expected) {
        Solution01233 solution = new Solution01233();
        String[] folders = ArrayUtils.stringToStringArray(foldersString);
        List<String> actual = solution.removeSubfolders(folders);
        assertThat(ArrayUtils.stringCollectionToString(actual)).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"/a\",\"/a/b\",\"/c/d\",\"/c/d/e\",\"/c/f\"]", "[\"/a\",\"/c/d\",\"/c/f\"]"),
                Arguments.of("[\"/a\",\"/a/b/c\",\"/a/b/d\"]", "[\"/a\"]"),
                Arguments.of("[\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]", "[\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]")
        );
    }

}