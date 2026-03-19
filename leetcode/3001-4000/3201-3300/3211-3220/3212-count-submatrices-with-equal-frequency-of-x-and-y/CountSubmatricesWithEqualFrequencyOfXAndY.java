public class CountSubmatricesWithEqualFrequencyOfXAndY {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.numberOfSubmatrices(new char[][] {
        { 'X', 'Y', '.' },
        { 'Y', '.', '.' }
    }));
  }
}

class Solution {
  public int numberOfSubmatrices(char[][] grid) {
    var total = 0;

    var m = grid.length;
    var n = grid[0].length;

    var y = new int[m + 1][n + 1];
    var x = new int[m + 1][n + 1];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        x[i + 1][j + 1] = (grid[i][j] == 'X' ? 1 : 0) + x[i][j + 1] + x[i + 1][j] - x[i][j];
        y[i + 1][j + 1] = (grid[i][j] == 'Y' ? 1 : 0) + y[i][j + 1] + y[i + 1][j] - y[i][j];

        if (x[i + 1][j + 1] == y[i + 1][j + 1] && x[i + 1][j + 1] > 0) {
          total++;
        }
      }
    }

    return total;
  }
}
