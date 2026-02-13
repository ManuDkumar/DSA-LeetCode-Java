import java.util.Queue;
import java.util.ArrayDeque;
public class import java.util.Queue;
import java.util.ArrayDeque;
public class NumberOfIslands {

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;        
    }
    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.offer(new int[]{x - 1, y});
                grid[x - 1][y] = '0';
            }
            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                queue.offer(new int[]{x + 1, y});
                grid[x + 1][y] = '0';
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.offer(new int[]{x, y - 1});
                grid[x][y - 1] = '0';
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                queue.offer(new int[]{x, y + 1});
                grid[x][y + 1] = '0';
            }
        }
    }
} {

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;        
    }
    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.offer(new int[]{x - 1, y});
                grid[x - 1][y] = '0';
            }
            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                queue.offer(new int[]{x + 1, y});
                grid[x + 1][y] = '0';
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.offer(new int[]{x, y - 1});
                grid[x][y - 1] = '0';
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                queue.offer(new int[]{x, y + 1});
                grid[x][y + 1] = '0';
            }
        }
    }
}
