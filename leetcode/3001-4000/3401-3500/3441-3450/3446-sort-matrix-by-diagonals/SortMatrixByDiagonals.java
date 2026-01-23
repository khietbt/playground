import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortMatrixByDiagonals {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.deepToString(
            solution.sortMatrix(
                new int[][] {
                    { 1, 7, 3 },
                    { 9, 8, 2 },
                    { 4, 5, 6 }
                })));
  }
}

class Solution {
  public int[][] sortMatrix(int[][] grid) {
    var n = grid.length;

    if (n < 2) {
      return grid;
    }

    var data = new HashMap<Integer, PriorityQueue<Integer>>();

    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        var index = j - i;

        data.computeIfAbsent(index, k -> new PriorityQueue<Integer>((a, b) -> (index > 0 ? (a - b) : (b - a))))
            .offer(grid[i][j]);
      }
    }

    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        grid[i][j] = data.get(j - i).poll();
      }
    }

    return grid;
  }
}
