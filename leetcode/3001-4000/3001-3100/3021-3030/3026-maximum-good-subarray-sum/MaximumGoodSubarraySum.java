import java.util.HashMap;

public class MaximumGoodSubarraySum {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maximumSubarraySum(new int[] { 1, 2, 3, 4, 5, 6 }, 1));

    System.out.println(solution.maximumSubarraySum(new int[] { -1, 3, 2, 4, 5 }, 3));

    System.out.println(solution.maximumSubarraySum(new int[] { -1, -2, -3, -4 }, 1));
  }
}

class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    var accumulated = 0L;
    var maximum = -Long.MAX_VALUE;
    var seen = new HashMap<Integer, Long>();

    for (var n : nums) {
      seen.merge(n, accumulated, Math::min);

      accumulated += n;

      var left = n - k;

      if (seen.containsKey(left)) {
        maximum = Math.max(maximum, accumulated - seen.get(left));
      }

      var right = n + k;

      if (seen.containsKey(right)) {
        maximum = Math.max(maximum, accumulated - seen.get(right));
      }
    }

    return maximum == -Long.MAX_VALUE ? 0 : maximum;
  }
}
