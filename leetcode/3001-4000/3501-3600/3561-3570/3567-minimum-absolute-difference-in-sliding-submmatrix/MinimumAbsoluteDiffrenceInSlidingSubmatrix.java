import java.util.Arrays;
import java.util.TreeSet;

public class MinimumAbsoluteDiffrenceInSlidingSubmatrix {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.deepToString(solution.minAbsDiff(
            new int[][] {
                { 1, -2, 3 },
                { 2, 3, 5 }
            }, 2)));
  }
}

class Solution {
  public int[][] minAbsDiff(int[][] grid, int k) {
    var m = grid.length;
    var n = grid[0].length;
    var answers = new int[m - k + 1][n - k + 1];

    for (var i = 0; i < m - k + 1; i++) {
      for (var j = 0; j < n - k + 1; j++) {
        var temp = new TreeSet<Integer>();

        for (var r = i; r < i + k; r++) {
          for (var c = j; c < j + k; c++) {
            temp.add(grid[r][c]);
          }
        }

        var minimum = Integer.MAX_VALUE;

        var previous = temp.pollFirst();
        var current = previous;

        while ((current = temp.pollFirst()) != null) {
          minimum = Math.min(minimum, Math.abs(current - previous));
          previous = current;
        }

        answers[i][j] = minimum == Integer.MAX_VALUE ? 0 : minimum;
      }
    }

    return answers;
  }
}
