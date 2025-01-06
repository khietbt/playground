import java.util.Arrays;

public class EqualRowAndColumnPairs {

  public static void main(String[] args) {
    // int[][] grid = {
    // { 3, 2, 1 },
    // { 1, 7, 6 },
    // { 2, 7, 7 }
    // };

    int[][] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };

    System.out.println(new Solution().equalPairs(grid));
  }
}

class Solution {
  public int equalPairs(int[][] grid) {
    int n = grid.length;
    int[][] transposed = new int[n][n];

    int totalEqualPairs = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        transposed[i][j] = grid[j][i];
      }
    }

    for (int[] row : grid) {
      for (int[] column : transposed) {
        totalEqualPairs += Arrays.equals(row, column) ? 1 : 0;
      }
    }

    return totalEqualPairs;
  }
}
