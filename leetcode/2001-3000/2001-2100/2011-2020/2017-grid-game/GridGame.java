public class GridGame {
  public static void main(String[] args) {
    int[][] grid = {
        { 1, 3, 1, 15 },
        { 1, 3, 3, 1 }
    };

    System.out.println(new Solution().gridGame(grid));
  }
}

class Solution {
  public long gridGame(int[][] grid) {
    int length = grid[0].length;
    long max = Long.MAX_VALUE;

    long right = 0;
    long left = 0;

    for (int i = 0; i < length; i++) {
      right += grid[0][i];
    }

    /* i is the transition point of the first robot. */
    for (int i = 0; i < length; i++) {
      right -= grid[0][i];
      max = Math.min(max, Math.max(left, right));
      left += grid[1][i];
    }

    return max;
  }
}
