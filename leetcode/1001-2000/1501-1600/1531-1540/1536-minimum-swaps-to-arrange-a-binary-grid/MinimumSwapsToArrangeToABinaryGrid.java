public class MinimumSwapsToArrangeToABinaryGrid {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minSwaps(
        new int[][] {
            { 0, 0, 1 },
            { 1, 1, 0 },
            { 1, 0, 0 }
        }));

    System.out.println(solution.minSwaps(
        new int[][] {
            { 0, 1, 1, 0 },
            { 0, 1, 1, 0 },
            { 0, 1, 1, 0 },
            { 0, 1, 1, 0 }
        }));
  }
}

class Solution {
  public int minSwaps(int[][] grid) {
    var n = grid.length;
    var indices = new int[n];

    for (var i = 0; i < n; i++) {
      var j = n - 1;

      while (j >= 0 && grid[i][j] == 0) {
        j--;
      }

      indices[i] = j;
    }

    var totalSwaps = 0;

    for (var i = 0; i < n; i++) {
      if (indices[i] <= i) {
        continue;
      }

      var j = i + 1;

      while (j < n && indices[j] > i) {
        j++;
      }

      if (j == n) {
        return -1;
      }

      totalSwaps += j - i;

      while (j > i) {
        indices[j] = indices[j - 1];

        j--;
      }
      //
    }

    return totalSwaps;
  }
}
