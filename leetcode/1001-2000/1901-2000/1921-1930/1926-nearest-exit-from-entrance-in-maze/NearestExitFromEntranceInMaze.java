import java.util.PriorityQueue;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
  public static void main(String[] args) {
    char[][] maze = {
        { '+', '+', '+', '+' },
        { '.', '.', '.', '.' },
        { '+', '+', '+', '+' }
    };

    int[] entrance = { 1, 0 };

    System.out.println(new Solution().nearestExit(maze, entrance));
  }
}

class Solution {
  public int nearestExit(char[][] maze, int[] entrance) {
    char WALL = '+';
    int m = maze.length;
    int n = maze[0].length;
    boolean[][] seen = new boolean[m][n];

    int[][] directions = {
        { -1, 0 },
        { 0, 1 },
        { 1, 0 },
        { 0, -1 }
    };

    Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

    queue.offer(new int[] { entrance[0], entrance[1], 0 });

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();

      int x = poll[0];
      int y = poll[1];
      int steps = poll[2];

      if (seen[x][y]) {
        continue;
      }

      seen[x][y] = true;

      for (int[] direction : directions) {
        int dx = direction[0];
        int dy = direction[1];

        int newX = x + dx;
        int newY = y + dy;

        if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
          if (steps > 0) {
            return steps;

          }

          continue;
        }

        if (seen[newX][newY]) {
          continue;
        }

        if (maze[newX][newY] == WALL) {
          seen[newX][newY] = true;
          continue;
        }

        queue.offer(new int[] { newX, newY, steps + 1 });
      }
    }

    return -1;
  }
}
