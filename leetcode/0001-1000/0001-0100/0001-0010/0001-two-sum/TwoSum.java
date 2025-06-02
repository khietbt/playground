import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int[] numbers = new int[] {
        2, 7, 11, 15
    };

    int target = 9;

    int[] result = new Solution().twoSum(numbers, target);

    System.out.print(Arrays.toString(result));
  }
}

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
      int lhs = numbers[i];

      int rhs = target - lhs;

      if (m.get(rhs) != null) {
        return new int[] { i, m.get(rhs) };
      }

      m.put(lhs, i);
    }

    // Bypass warnings
    return new int[] {};
  }
}
