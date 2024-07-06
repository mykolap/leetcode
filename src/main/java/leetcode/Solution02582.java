package leetcode;

/**
 * 2582. Pass the Pillow
 * <a href="https://leetcode.com/problems/pass-the-pillow">Web link</a> |
 * Easy
 */

public class Solution02582 {

    public int passThePillow(int n, int time) {
        int idx = 1;
        int direction = 1;
        for (int currentTime = 1; currentTime <= time; currentTime++) {
            if (idx == n) {
                direction = -1;
            } else if (idx == 1) {
                direction = 1;
            }
            idx += direction;
        }
        return idx;
    }

    public int passThePillowOptimized(int n, int time) {
        int cycle = 2 * (n - 1);
        int effectiveTime = time % cycle;
        if (effectiveTime < n) {
            return effectiveTime + 1;
        } else {
            return n - effectiveTime % n - 1;
        }
    }

}







































        /*

    }
        int current = start;
        while (true) {
            if (current == 1) {
                return 1;
            }
            if (current % 2 == 0) {
                current = n - current / 2;
            } else {
                current = n - (current + 1) / 2;
            }
        }
    }

         */