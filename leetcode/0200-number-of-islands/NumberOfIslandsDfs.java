import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslandsBfs {
  public static void main(String[] args) {
    // char[][] grid = {
    // { '1', '1', '1', '1', '0' },
    // { '1', '1', '0', '1', '0' },
    // { '1', '1', '0', '0', '0' },
    // { '0', '0', '0', '0', '0' }
    // };

    char[][] grid = {
        { '1', '1', '0', '0', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '1', '0', '0' },
        { '0', '0', '0', '1', '1' }
    };

    System.out.println((new Solution()).numIslands(grid));
  }
}

class Solution {
  public int numIslands(char[][] grid) {
    int totalRows = grid.length;
    int totalColumns = grid[0].length;

    boolean[][] visited = new boolean[totalRows][totalColumns];
    int numberOfIslands = 0;

    int[][] directions = {
        { -1, 0 },
        { 0, -1 },
        { 1, 0 },
        { 0, 1 }
    };

    for (int i = 0; i < totalRows; i++) {
      for (int j = 0; j < totalColumns; j++) {
        if (visited[i][j]) {
          continue;
        }

        if (grid[i][j] == '0') {
          continue;
        }

        visited[i][j] = true;

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { i, j });

        while (!queue.isEmpty()) {
          int[] poll = queue.poll();

          int x = poll[0];
          int y = poll[1];

          for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX < 0 || newX >= totalRows || newY < 0 || newY >= totalColumns) {
              continue;
            }

            if (visited[newX][newY]) {
              continue;
            }

            visited[newX][newY] = true;

            if (grid[newX][newY] == '1') {
              queue.offer(new int[] { newX, newY });
            }
          }
        }

        //
        numberOfIslands++;
      }
    }

    return numberOfIslands;
  }
}
