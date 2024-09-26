package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00729Test {

    @Test
    void test1() {
        Solution00729.MyCalendar myCalendar = new Solution00729.MyCalendar();
        assertThat(myCalendar.book(10, 20)).isTrue(); // return True
        assertThat(myCalendar.book(15, 25)).isFalse(); // return False, It can not be booked because time 15 is already booked by another event.
        assertThat(myCalendar.book(20, 30)).isTrue(); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
    }

}