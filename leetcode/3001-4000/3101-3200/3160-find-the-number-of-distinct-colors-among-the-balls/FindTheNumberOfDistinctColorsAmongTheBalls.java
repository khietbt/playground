import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfDistinctColorsAmongTheBalls {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().queryResults(
        4,
        new int[][] {
            { 1, 4 },
            { 2, 5 },
            { 1, 3 },
            { 3, 4 }
        })));
  }
}

class Solution {
  public int[] queryResults(int limit, int[][] queries) {
    int[] answers = new int[queries.length];
    Map<Integer, Integer> ball2Color = new HashMap<>();
    Map<Integer, Integer> color2TotalBalls = new HashMap<>();

    for (int i = 0; i < queries.length; i++) {
      int ballIndex = queries[i][0];
      int colorIndex = queries[i][1];

      color2TotalBalls.merge(colorIndex, 1, Integer::sum);

      if (ball2Color.containsKey(ballIndex)) {
        int oldColorIndex = ball2Color.get(ballIndex);

        color2TotalBalls.merge(oldColorIndex, -1, Integer::sum);

        if (color2TotalBalls.get(oldColorIndex) == 0) {
          color2TotalBalls.remove(oldColorIndex);
        }
      }

      ball2Color.put(ballIndex, colorIndex);

      answers[i] = color2TotalBalls.size();
    }

    return answers;
  }
}
