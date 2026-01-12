import java.util.Arrays;
import java.util.Stack;

public class MaximalSquare {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.maximalSquare(
            new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
            }));
  }
}

class Solution {
  private int largest(int heights[]) {
    var n = heights.length;

    var lefts = new int[n];
    var rights = new int[n];

    Arrays.fill(lefts, -1);
    Arrays.fill(rights, n);

    var max = 0;

    var stack = new Stack<Integer>();

    for (var j = 0; j < n; j++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
        rights[stack.pop()] = j;
      }

      if (!stack.isEmpty()) {
        lefts[j] = stack.peek();
      }

      stack.push(j);
    }

    for (var j = 0; j < n; j++) {
      var height = heights[j];
      var width = rights[j] - lefts[j] - 1;
      var a = Math.min(height, width);

      max = Math.max(max, a * a);
    }

    return max;
  }

  public int maximalSquare(char[][] matrix) {
    var m = matrix.length;
    var n = matrix[0].length;
    var max = 0;
    var heights = new int[n];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          heights[j]++;
        } else {
          heights[j] = 0;
        }
      }

      max = Math.max(max, largest(heights));
    }

    return max;
  }
}
