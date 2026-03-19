public class CountSubmatricesWithTopLeftElementAndSumLessThanK {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.countSubmatrices(
        new int[][] {
            { 7, 2, 9 },
            { 1, 5, 0 },
            { 2, 6, 6 }
        }, 20));
  }
}

class Solution {
  public int countSubmatrices(int[][] grid, int k) {
    var total = 0;

    var m = grid.length;
    var n = grid[0].length;
    var prefix = new int[m + 1][n + 1];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        prefix[i + 1][j + 1] = grid[i][j] - prefix[i][j] + prefix[i + 1][j] + prefix[i][j + 1];

        if (prefix[i + 1][j + 1] > k) {
          break;
        }

        total++;
      }
    }

    return total;
  }
}
