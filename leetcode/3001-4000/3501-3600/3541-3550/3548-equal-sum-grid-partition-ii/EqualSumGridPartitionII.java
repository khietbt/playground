import java.util.HashSet;

public class EqualSumGridPartitionII {

  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(
    // soultion.canPartitionGrid(
    // new int[][] {
    // { 1, 1, 2, 3 },
    // }));

    System.out.println(
        solution.canPartitionGrid(
            new int[][] {
                { 1, 1, 2 },
                { 3, 2, 1 }
            }));
  }
}

class Solution {
  int[][] rotate(int[][] source) {
    var m = source.length;
    var n = source[0].length;

    var target = new int[n][m];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        target[j][m - i - 1] = source[i][j];
      }
    }

    return target;
  }

  public boolean canPartitionGrid(int[][] grid) {
    var totalRounnds = 4;

    var sum = 0L;

    for (var i = 0; i < grid.length; i++) {
      for (var j = 0; j < grid[0].length; j++) {
        sum += grid[i][j];
      }
    }

    while (totalRounnds-- > 0) {
      var m = grid.length;

      if (m == 1) {
        // This is the 1 x n matrix, turn it to n x 1 matrix.
        grid = rotate(grid);
        continue;
      }

      var n = grid[0].length;

      if (n == 1) {
        // There is only colunm.
        var top = 0L;

        for (var i = 0; i < m - 1; i++) {
          top += grid[i][0];

          var x = 2 * top - sum;

          if (x == 0 || x == grid[0][0] || x == grid[i][0]) {
            return true;
          }
        }

        // No valid cut, prepare for next round.
        grid = rotate(grid);
        continue;
      }

      var top = 0L;
      var seen = new HashSet<Long>();

      for (var i = 0; i < m - 1; i++) {
        for (var j = 0; j < n; j++) {
          top += grid[i][j];
          seen.add((long) grid[i][j]);
        }

        var x = 2 * top - sum;

        if (x == 0) {
          return true;
        }

        if (i == 0) {
          if (x == grid[0][0] || x == grid[0][n - 1]) {
            return true;
          }
        } else if (seen.contains(x)) {
          return true;
        }
      }

      // Next round.
      grid = rotate(grid);
    }

    return false;
  }
}
