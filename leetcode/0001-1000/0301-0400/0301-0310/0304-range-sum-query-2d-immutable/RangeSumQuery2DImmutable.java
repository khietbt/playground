import java.util.Arrays;

public class RangeSumQuery2DImmutable {
  public static void main(String[] args) {
    var numMatrix = new NumMatrix(
        new int[][] {
            { 3, 0, 1, 4, 2 },
            { 5, 6, 3, 2, 1 },
            { 1, 2, 0, 1, 5 },
            { 4, 1, 0, 1, 7 },
            { 1, 0, 3, 0, 5 }
        });

    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
    System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
  }

  // System.out.println();
}

class NumMatrix {
  int p[][];

  public NumMatrix(int[][] matrix) {
    var m = matrix.length;
    var n = matrix[0].length;

    p = new int[m + 1][n + 1];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        p[i + 1][j + 1] = matrix[i][j] + p[i + 1][j] + p[i][j + 1] - p[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return p[row2 + 1][col2 + 1] + p[row1][col1] - p[row2 + 1][col1] - p[row1][col2 + 1];
  }
}
