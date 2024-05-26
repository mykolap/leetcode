package leetcode;

/**
 * 552. Student Attendance Record II
 * https://leetcode.com/problems/student-attendance-record-ii/
 * Hard
 */

public class Solution00552 {

    public int checkRecord(int n) {
        int modValue = 1000000007;

        if (n == 1) {
            return 3;
        }

        long[][] attendanceRecord = new long[2][3];
        attendanceRecord[0][0] = 1;
        attendanceRecord[0][1] = 1;
        attendanceRecord[0][2] = 0;
        attendanceRecord[1][0] = 1;
        attendanceRecord[1][1] = 0;
        attendanceRecord[1][2] = 0;

        for (int i = 1; i < n; i++) {
            long[][] nextRecord = new long[2][3];

            // choose P
            long sumOfFirstRow = (attendanceRecord[0][0] + attendanceRecord[0][1] + attendanceRecord[0][2]) % modValue;
            long sumOfSecondRow = (attendanceRecord[1][0] + attendanceRecord[1][1] + attendanceRecord[1][2]) % modValue;
            nextRecord[0][0] = (int) sumOfFirstRow;
            nextRecord[1][0] = (int) sumOfSecondRow;

            // choose L
            nextRecord[0][1] = attendanceRecord[0][0];
            nextRecord[1][1] = attendanceRecord[1][0];
            nextRecord[0][2] = attendanceRecord[0][1];
            nextRecord[1][2] = attendanceRecord[1][1];

            // choose A
            nextRecord[1][0] = (int) ((nextRecord[1][0] + sumOfFirstRow) % modValue);

            attendanceRecord = nextRecord;
        }

        long totalSum = 0;
        for (long[] row : attendanceRecord) {
            for (long i : row) {
                totalSum = (totalSum + i) % modValue;
            }
        }
        return (int) totalSum;
    }

    public int checkRecordAlternative(int n) {
        int modValue = 1000000007;
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1;
        PorL[1] = 2;
        P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % modValue;
        }

        long res = PorL[n];
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
            long s = (PorL[i] * PorL[n - i - 1]) % modValue;
            res = (res + s) % modValue;
        }

        return (int) res;
    }

}