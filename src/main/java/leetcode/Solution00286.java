package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 286. Walls and Gates
 * <a href="https://leetcode.com/problems/walls-and-gates">Web link</a>
 * Medium
 */

public class Solution00286 {

    static final int GATE = 0;
    static final int WALL = -1;

    public void wallsAndGates(int[][] rooms) {
        int rowCount = rooms.length;
        int colCount = rooms[0].length;

        boolean[][] visited = new boolean[rowCount][colCount];
        Queue<Room> deque = new ArrayDeque<>();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (rooms[row][col] == GATE) {
                    deque.offer(new Room(row, col));
                    visited[row][col] = true;
                }
            }
        }

        int dist = 0;
        while (!deque.isEmpty()) {
            int numToPop = deque.size();
            for (int i = 0; i < numToPop; i++) {
                Room room = deque.poll();
                final int row = room.row;
                final int col = room.col;

                rooms[row][col] = dist;

                addRoom(rooms, row + 1, col, deque, visited);
                addRoom(rooms, row - 1, col, deque, visited);
                addRoom(rooms, row, col + 1, deque, visited);
                addRoom(rooms, row, col - 1, deque, visited);

            }
            dist++;
        }

    }

    private void addRoom(int[][] rooms, int row, int col, Queue<Room> deque, boolean[][] visited) {
        if (row < 0 || row >= rooms.length ||
            col < 0 || col >= rooms[0].length ||
            rooms[row][col] == WALL ||
            visited[row][col]) {
            return;
        }

        deque.offer(new Room(row, col));
        visited[row][col] = true;
    }

    private static class Room {
        private final int row;
        private final int col;

        public Room(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}