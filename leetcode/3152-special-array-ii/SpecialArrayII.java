import java.util.Arrays;

public class SpecialArrayII {
  public static void main(String[] args) {
    var numbers = new int[] { 3, 4, 1, 2, 6 };
    var queries = new int[][] { { 0, 4 } };

    System.out.println(Arrays.toString(new Solution().isArraySpecial(numbers, queries)));
  }
}

class Solution {
  public boolean[] isArraySpecial(int[] numbers, int[][] queries) {
    int[] specials = new int[numbers.length];

    for (int i = 1; i < specials.length; i++) {
      if (numbers[i] % 2 != numbers[i - 1] % 2) {
        specials[i] = specials[i - 1];

        continue;
      }

      specials[i] = i;
    }

    boolean[] results = new boolean[queries.length];

    for (int i = 0; i < results.length; i++) {
      results[i] = specials[queries[i][1]] <= specials[queries[i][0]];
    }

    return results;
  }
}
