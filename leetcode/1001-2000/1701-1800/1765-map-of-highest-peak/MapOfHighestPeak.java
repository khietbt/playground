import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
  public static void main(String[] args) {
    int[][] waters = {
        { 0, 0, 1 },
        { 1, 0, 0 },
        { 0, 0, 0 }
    };

    System.out.println(Arrays.toString(new Solution().highestPeak(waters)));
  }
}

class Solution {
  public int[][] highestPeak(int[][] waters) {
    int m = waters.length;
    int n = waters[0].length;
    int[][] peaks = new int[m][n];
    boolean[][] seen = new boolean[m][n];

    int[][] directions = {
        { -1, 0 },
        { 0, 1 },
        { 1, 0 },
        { 0, -1 }
    };

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        peaks[i][j] = waters[i][j] - 1;

        if (waters[i][j] == 1) {
          queue.offer(new int[] { i, j });
        }
      }
    }

    while (!queue.isEmpty()) {
      Queue<int[]> newqQueue = new LinkedList<>();

      while (!queue.isEmpty()) {
        int[] e = queue.poll();
        int x = e[0];
        int y = e[1];

        for (int[] direction : directions) {
          int dx = direction[0];
          int dy = direction[1];

          int newX = x + dx;
          int newY = y + dy;

          if (newX >= 0 && newX < m && newY >= 0 && newY < n && !seen[newX][newY]) {
            seen[newX][newY] = true;
            peaks[newX][newY] = peaks[x][y] + 1;

            newqQueue.offer(new int[] { newX, newY });
          }
        }
      }

      queue = newqQueue;
    }

    return peaks;
  }
}
