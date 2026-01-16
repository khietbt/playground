import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.maximizeSquareHoleArea(
            2,
            1,
            new int[] { 1, 3 },
            new int[] { 2 }));

    System.out.println(
        solution.maximizeSquareHoleArea(
            1,
            1,
            new int[] { 2 },
            new int[] { 2 }));

    System.out.println(
        solution.maximizeSquareHoleArea(
            2,
            3,
            new int[] { 2, 3 },
            new int[] { 2, 4 }));
  }
}

class Solution {
  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    Arrays.sort(hBars);
    Arrays.sort(vBars);

    var consecutiveHorizontalBar = 1;
    var maxConsecutiveHorizontalBar = 1;

    for (var i = 1; i < hBars.length; i++) {
      if (hBars[i - 1] + 1 == hBars[i]) {
        consecutiveHorizontalBar++;
      } else {
        consecutiveHorizontalBar = 1;
      }

      maxConsecutiveHorizontalBar = Math.max(maxConsecutiveHorizontalBar, consecutiveHorizontalBar);
    }

    var consecutiveVerticalBar = 1;
    var maxConsecutiveVerticalBar = 1;

    for (var j = 1; j < vBars.length; j++) {
      if (vBars[j - 1] + 1 == vBars[j]) {
        consecutiveVerticalBar++;
      } else {
        consecutiveVerticalBar = 1;
      }

      maxConsecutiveVerticalBar = Math.max(maxConsecutiveVerticalBar, consecutiveVerticalBar);
    }

    var width = 1 + Math.min(maxConsecutiveVerticalBar, maxConsecutiveHorizontalBar);

    return width * width;
  }
}
