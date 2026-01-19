import java.util.Arrays;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maxSideLength(
        new int[][] {
            { 1, 1, 3, 2, 4, 3, 2 },
            { 1, 1, 3, 2, 4, 3, 2 },
            { 1, 1, 3, 2, 4, 3, 2 }
        }, 4));

    // System.out.println(solution.maxSideLength(
    // new int[][] {
    // { 2, 2, 2, 2, 2 },
    // { 2, 2, 2, 2, 2 },
    // { 2, 2, 2, 2, 2 },
    // { 2, 2, 2, 2, 2 },
    // { 2, 2, 2, 2, 2 },
    // }, 4));
  }
}

class Solution {
  public int maxSideLength(int[][] mat, int threshold) {
    var m = mat.length;
    var n = mat[0].length;

    for (var i = 0; i < m; i++) {
      for (var j = 1; j < n; j++) {
        mat[i][j] += mat[i][j - 1];
      }
    }

    for (var j = 0; j < n; j++) {
      for (var i = 1; i < m; i++) {
        mat[i][j] += mat[i - 1][j];
      }
    }

    for (var k = Math.min(m, n); k > 0; k--) {
      for (var i = 0; i <= m - k; i++) {
        for (var j = 0; j <= n - k; j++) {
          var sum = mat[i + k - 1][j + k - 1] + ((i > 0 && j > 0) ? mat[i - 1][j - 1] : 0)
              - (j > 0 ? mat[i + k - 1][j - 1] : 0)
              - (i > 0 ? mat[i - 1][j + k - 1] : 0);

          if (sum <= threshold) {
            return k;
          }
        }
      }
    }

    return 0;
  }
}
