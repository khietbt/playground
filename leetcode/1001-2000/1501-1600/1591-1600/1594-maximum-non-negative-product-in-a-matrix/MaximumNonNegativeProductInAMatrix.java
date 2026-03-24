import java.util.Arrays;

public class MaximumNonNegativeProductInAMatrix {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maxProductPath(
        new int[][] {
            { 1, -2, 1 },
            { 1, -2, 1 },
            { 3, -4, 1 }
        }));

    System.out.println(solution.maxProductPath(
        new int[][] {
            { 1, 3 },
            { 0, -4 }
        }));
  }
}

class Solution {
  public int maxProductPath(int[][] grid) {
    var modulo = 1_000_000_007;
    var m = grid.length;
    var n = grid[0].length;

    var dp = new long[2][m][n];

    for (var i = 0; i < m; i++) {
      Arrays.fill(dp[0][i], Long.MIN_VALUE);
      Arrays.fill(dp[1][i], Long.MIN_VALUE);
    }

    dp[0][0][0] = grid[0][0];
    dp[1][0][0] = grid[0][0];

    for (var j = 1; j < n; j++) {
      dp[0][0][j] = (dp[0][0][j - 1] * grid[0][j]);
      dp[1][0][j] = (dp[1][0][j - 1] * grid[0][j]);
    }

    for (var i = 1; i < m; i++) {
      dp[0][i][0] = (dp[0][i - 1][0] * grid[i][0]);
      dp[1][i][0] = (dp[1][i - 1][0] * grid[i][0]);
    }

    for (var i = 1; i < m; i++) {
      for (var j = 1; j < n; j++) {
        if (grid[i][j] >= 0) {
          dp[0][i][j] = (Math.min(dp[0][i - 1][j], dp[0][i][j - 1]) * grid[i][j]);
          dp[1][i][j] = (Math.max(dp[1][i - 1][j], dp[1][i][j - 1]) * grid[i][j]);
        } else {
          dp[1][i][j] = (Math.min(dp[0][i - 1][j], dp[0][i][j - 1]) * grid[i][j]);
          dp[0][i][j] = (Math.max(dp[1][i - 1][j], dp[1][i][j - 1]) * grid[i][j]);
        }

      }
    }

    return (int) (Math.max(dp[1][m - 1][n - 1], -1) % modulo);
  }
}
