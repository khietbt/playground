import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MakingALargeIsland {
  public static void main(String[] args) {
    int[][] grid = {
        { 1, 1, 0, 1 },
        { 1, 1, 0, 1 },
        { 1, 1, 0, 1 },
        { 1, 1, 0, 1 }
    };

    System.out.println(new Solution().largestIsland(grid));
  }
}

class Solution {
  public int largestIsland(int[][] grid) {
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    int[][] directions = {
        { -1, 0 },
        { 0, 1 },
        { 1, 0 },
        { 0, -1 }
    };

    Map<Integer, Integer> islands = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) {
          continue;
        }

        if (grid[i][j] == 0) {
          visited[i][j] = true;
          continue;
        }

        int id = i * n + j + 1;
        int area = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });

        while (!queue.isEmpty()) {
          int[] poll = queue.poll();

          int x = poll[0];
          int y = poll[1];

          if (visited[x][y]) {
            continue;
          }

          visited[x][y] = true;

          if (grid[x][y] == 0) {
            continue;
          }

          grid[x][y] = id;
          area++;

          for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];

            int newX = x + dx;
            int newY = y + dy;

            if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
              continue;
            }

            if (grid[newX][newY] == 0) {
              visited[newX][newY] = true;
              continue;
            }

            queue.offer(new int[] { newX, newY });
          }
        }

        islands.put(id, area);
      }
    }

    if (islands.isEmpty()) {
      return 1;
    }

    int max = Collections.max(islands.values());

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] > 0) {
          continue;
        }

        int sum = 1;

        Set<Integer> neighbours = new HashSet<>();

        for (int[] direction : directions) {
          int dx = direction[0];
          int dy = direction[1];

          int x = i + dx;
          int y = j + dy;

          if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) {
            continue;
          }

          neighbours.add(grid[x][y]);
        }

        for (int id : neighbours) {
          sum += islands.getOrDefault(id, 0);
        }

        max = Math.max(max, sum);
      }
    }

    return max;
  }
}
