public class EqualSumGridPartitionI {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.canPartitionGrid(
        new int[][] {
            { 1, 4 },
            { 2, 3 }
        }));

    System.out.println(solution.canPartitionGrid(
        new int[][] {
            { 1, 2, 2 },
            { 2, 2, 1 },
        }));

    System.out.println(solution.canPartitionGrid(
        new int[][] {
            { 1 },
            { 2 },
            { 3 },
            { 4 },
        }));

    System.out.println(solution.canPartitionGrid(
        new int[][] {
            { 1 }, { 2 }, { 3 }
        }));
  }
}

class Solution {
  public boolean canPartitionGrid(int[][] grid) {
    var m = grid.length;
    var n = grid[0].length;
    var p = new long[m + 1][n + 1];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        p[i + 1][j + 1] = grid[i][j] + p[i][j + 1] + p[i + 1][j] - p[i][j];
      }
    }

    var total = p[m][n];

    if (total % 2 == 1) {
      return false;
    }

    var half = total / 2;

    // horizontal cut
    var l = 0;
    var r = m - 1;

    while (l <= r) {
      var middle = l + ((r - l) / 2);

      var t = p[middle + 1][n] - p[0][n] - p[middle + 1][0] + p[0][0];

      if (t == half) {
        return true;
      } else if (t > half) {
        r = middle - 1;
      } else {
        l = middle + 1;
      }
    }

    // vertical cut.
    l = 0;
    r = n - 1;

    while (l <= r) {
      var middle = l + (r - l) / 2;
      var t = p[m][middle + 1] - p[m][0] - p[0][middle + 1] + p[0][0];

      if (t == half) {
        return true;
      } else if (t > half) {
        r = middle - 1;
      } else {
        l = middle + 1;
      }
    }

    return false;
  }
}
