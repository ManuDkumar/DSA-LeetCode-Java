import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        int time = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] { r, c });
                }
                if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0)
            return 0;

        int[][] directions = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {

                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR >= 0 && newR < rows &&
                            newC >= 0 && newC < cols &&
                            grid[newR][newC] == 1) {

                        grid[newR][newC] = 2;
                        freshCount--;
                        queue.offer(new int[] { newR, newC });
                        rottenThisMinute = true;
                    }
                }
            }
            if (rottenThisMinute)
                time++;
        }
        return freshCount == 0 ? time : -1;
    }
}
