import java.util.Arrays;

public class LargestMagicSquare {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.largestMagicSquare(
            new int[][] {
                { 7, 1, 4, 5, 6 },
                { 2, 5, 1, 6, 4 },
                { 1, 5, 4, 3, 2 },
                { 1, 2, 7, 3, 4 }
            }));

    System.out.println(
        solution.largestMagicSquare(
            new int[][] {
                { 5, 1, 3, 1 },
                { 9, 3, 3, 1 },
                { 1, 3, 3, 8 }
            }));
  }
}

class Solution {
  public int largestMagicSquare(int[][] grid) {
    var m = grid.length;
    var n = grid[0].length;

    var columns = new int[m][n];

    for (var i = 0; i < m; i++) {
      columns[i][0] = grid[i][0];

      for (var j = 1; j < n; j++) {
        columns[i][j] = grid[i][j] + columns[i][j - 1];
      }
    }

    var rows = new int[m][n];

    for (var j = 0; j < n; j++) {
      rows[0][j] = grid[0][j];

      for (var i = 1; i < m; i++) {
        rows[i][j] = grid[i][j] + rows[i - 1][j];
      }
    }

    for (var k = Math.min(m, n); k >= 2; k--) {
      for (var i = 0; i <= m - k; i++) {
        for (var j = 0; j <= n - k; j++) {
          if (isMagicSquare(grid, rows, columns, i, j, k)) {
            return k;
          }
        }
      }
    }

    return 1;
  }

  boolean isMagicSquare(int grid[][], int rows[][], int columns[][], int i, int j, int k) {
    var diagonal = diagonalSum(grid, i, j, k);

    var revesedDiagonal = reversedDiagonalSum(grid, i, j, k);

    if (diagonal != revesedDiagonal) {
      return false;
    }

    for (var l = 0; l < k; l++) {
      if (rowSum(columns, i, j, k, l) != diagonal) {
        return false;
      }

      if (columnSum(rows, i, j, k, l) != diagonal) {
        return false;
      }
    }

    return true;
  }

  int rowSum(int columns[][], int i, int j, int k, int l) {
    return columns[i + l][j + k - 1] - (j > 0 ? columns[i + l][j - 1] : 0);
  }

  int columnSum(int rows[][], int i, int j, int k, int l) {
    return rows[i + k - 1][j + l] - (i > 0 ? rows[i - 1][j + l] : 0);
  }

  int diagonalSum(int grid[][], int i, int j, int k) {
    var total = 0;

    for (var l = 0; l < k; l++) {
      total += grid[i + l][j + l];
    }

    return total;
  }

  int reversedDiagonalSum(int grid[][], int i, int j, int k) {
    var total = 0;

    for (var l = 0; l < k; l++) {
      total += grid[i + l][j + k - l - 1];
    }

    return total;
  }
}
