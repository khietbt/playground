import java.util.Arrays;

public class FlipSquareSubmatrixVertically {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.deepToString(
            solution.reverseSubmatrix(
                new int[][] {
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 }
                },
                1, 0, 3)));
  }
}

class Solution {
  public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
    for (var i = 0; i < k / 2; i++) {
      for (var j = 0; j < k; j++) {
        var ax = x + i;
        var ay = y + j;

        var bx = x + k - i - 1;
        var by = y + j;

        var t = grid[ax][ay];

        grid[ax][ay] = grid[bx][by];
        grid[bx][by] = t;
        //
      }
    }

    return grid;
  }
}
