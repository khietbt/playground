import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumTimeToVisitACellInAGrid {
  public static void main(String[] args) {
    int[][] grid = {
        { 0, 1, 3, 2 },
        { 5, 1, 2, 5 },
        { 4, 3, 8, 6 }
    };

    System.out.println((new Solution().minimumTime(grid)));
  }
}

class Solution {
  public int minimumTime(int[][] grid) {
    if (grid[0][1] > 1 && grid[1][0] > 1) {
      return -1;
    }

    int totalRows = grid.length;
    int totalColumns = grid[0].length;
    int[][] directions = new int[][] {
        { -1, 0 },
        { 0, -1 },
        { 1, 0 },
        { 0, 1 }
    };

    int[][] seen = new int[totalRows][totalColumns];

    for (int[] is : seen) {
      Arrays.fill(is, Integer.MAX_VALUE);
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

    queue.offer(new int[] { 0, 0, 0 });

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int currentX = poll[0];
      int currentY = poll[1];
      int currentStep = poll[2];

      if (currentX == totalRows - 1 && currentY == totalColumns - 1) {
        return currentStep;
      }

      for (int[] direction : directions) {
        int newX = currentX + direction[0];
        int newY = currentY + direction[1];

        if (newX < 0 || newX >= totalRows || newY < 0 || newY >= totalColumns) {
          continue;
        }

        int newStep = Math.max(currentStep + 1, grid[newX][newY] + (grid[newX][newY] - currentStep - 1) % 2);

        if (newStep >= seen[newX][newY]) {
          continue;
        }

        seen[newX][newY] = newStep;

        queue.offer(new int[] { newX, newY, newStep });
      }
    }

    return -1;
  }
}
