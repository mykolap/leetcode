package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 * 1700. Number of Students Unable to Eat Lunch
 * Easy
 */

public class Solution01700 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new ArrayDeque<>();
        for (int student : students) {
            studentQueue.add(student);
        }

        for (int sandwich : sandwiches) {
            int queueSize = studentQueue.size();
            int unableToEat = 0;
            for (int i = 0; i < queueSize; i++) {
                int currentStudent = studentQueue.poll();
                if (sandwich == currentStudent) {
                    unableToEat = 0;
                    break;
                } else {
                    unableToEat++;
                    studentQueue.add(currentStudent);
                }
            }
            if (unableToEat == queueSize) {
                return unableToEat;
            }
        }

        return studentQueue.size();
    }

    public int countStudentsNoQueue(int[] students, int[] sandwiches) {
        int count0 = 0;
        int count1 = 0;

        for (int student : students) {
            if (student == 0) {
                count0++;
            } else {
                count1++;
            }
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (count0 == 0) {
                    return count0 + count1;
                } else {
                    count0--;
                }
            } else if (sandwich == 1) {
                if (count1 == 0) {
                    return count0 + count1;
                } else {
                    count1--;
                }
            }
        }

        return count0 + count1;
    }

}