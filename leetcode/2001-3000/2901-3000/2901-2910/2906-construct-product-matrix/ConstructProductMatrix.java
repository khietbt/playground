import java.util.Arrays;

public class ConstructProductMatrix {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(Arrays.deepToString(
        solution.constructProductMatrix(new int[][] {
            { 1, 2 },
            { 3, 4 }
        })));
  }
}

class Solution {
  public int[][] constructProductMatrix(int[][] grid) {
    var n = grid.length;
    var m = grid[0].length;
    var p = new int[n][m];

    var x = 1L;
    var MODULO = 12345;

    for (var i = n - 1; i >= 0; i--) {
      for (var j = m - 1; j >= 0; j--) {
        p[i][j] = (int) (x % MODULO);
        x = (x * grid[i][j]) % MODULO;
      }
    }

    var y = 1L;
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < m; j++) {
        p[i][j] = (int) (((y * p[i][j])) % MODULO);

        y = (y * grid[i][j]) % MODULO;
      }
    }

    return p;
  }
}
