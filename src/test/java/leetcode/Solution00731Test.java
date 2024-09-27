package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00731Test {

    @Test
    void test1() {
        Solution00731.MyCalendarTwo myCalendarTwo = new Solution00731.MyCalendarTwo();
        assertThat(myCalendarTwo.book(10, 20)).isTrue(); // return True
        assertThat(myCalendarTwo.book(50, 60)).isTrue(); // return True
        assertThat(myCalendarTwo.book(10, 40)).isTrue(); // return True
        assertThat(myCalendarTwo.book(5, 15)).isFalse(); // return False
        assertThat(myCalendarTwo.book(5, 10)).isTrue(); // return True
        assertThat(myCalendarTwo.book(25, 55)).isTrue(); // return True
    }

}