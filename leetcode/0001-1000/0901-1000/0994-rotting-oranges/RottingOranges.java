import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
  public static void main(String[] args) {
    int[][] grid = {
        { 2, 2 },
        { 0, 0 },
        { 1, 1 },
        { 0, 1 },
        { 0, 2 }
    };

    System.out.println(new Solution().orangesRotting(grid));
  }
}

class Solution {
  public int orangesRotting(int[][] grid) {
    int FRESH = 1;
    int ROTTEN = 2;

    int m = grid.length;
    int n = grid[0].length;
    int totalFreshOranges = 0;
    boolean[][] visited = new boolean[m][n];
    int[][] directions = {
        { -1, 0 },
        { 0, 1 },
        { 1, 0 },
        { 0, -1 }
    };
    int steps = 0;

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == ROTTEN) {
          queue.offer(new int[] { i, j });
        } else if (grid[i][j] == FRESH) {
          totalFreshOranges++;
        }
      }
    }

    if (queue.isEmpty()) {
      return 0;
    }

    while (!queue.isEmpty()) {
      List<int[]> nodes = new ArrayList<>();

      while (!queue.isEmpty()) {
        int[] poll = queue.poll();
        int x = poll[0];
        int y = poll[1];

        if (visited[x][y]) {
          continue;
        }

        visited[x][y] = true;

        if (grid[x][y] == FRESH) {
          totalFreshOranges--;
          grid[x][y] = ROTTEN;
        }

        for (int[] direction : directions) {
          int dx = direction[0];
          int dy = direction[1];

          int newX = x + dx;
          int newY = y + dy;

          if (newX >= 0 && newX < m && newY >= 0 && newY < n && (!visited[newX][newY]) && grid[newX][newY] == FRESH) {
            nodes.add(new int[] { newX, newY });
          }
        }
      }

      for (int[] node : nodes) {
        if (!visited[node[0]][node[1]]) {
          queue.offer(node);
        }
      }

      steps++;
    }

    return (totalFreshOranges == 0) ? (steps - 1) : -1;
  }
}
