public class MinimumPathSum {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minPathSum(new int[][] {
        { 1, 3, 1 },
        { 1, 5, 1 },
        { 4, 2, 1 },
    }));

    System.out.println(solution.minPathSum(new int[][] {
        { 1, 2, 3 },
        { 4, 5, 6 },
    }));
  }
}

class Solution {
  public int minPathSum(int[][] grid) {
    var m = grid.length;
    var n = grid[0].length;
    var dp = new int[m][n];

    dp[0][0] = grid[0][0];

    for (var j = 1; j < n; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }

    for (var i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    for (var i = 1; i < m; i++) {
      for (var j = 1; j < n; j++) {
        //
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[m - 1][n - 1];
  }
}
