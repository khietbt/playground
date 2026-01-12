import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.largestRectangleArea(
            new int[] { 2, 1, 5, 6, 2, 3 }));

    System.out.println(
        solution.largestRectangleArea(
            new int[] { 2, 4 }));
  }
}

class Solution {
  public int largestRectangleArea(int[] heights) {
    var n = heights.length;
    var lefts = new int[n];
    var rights = new int[n];

    Arrays.fill(lefts, -1);
    Arrays.fill(rights, n);

    var stack = new Stack<Integer>();

    for (var i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        rights[stack.pop()] = i;
      }

      if (!stack.isEmpty()) {
        lefts[i] = stack.peek();
      }

      stack.push(i);
    }

    var max = 0;

    for (var i = 0; i < n; i++) {
      var height = heights[i];
      var width = rights[i] - lefts[i] - 1;

      max = Math.max(max, width * height);
    }

    return max;
  }
}
