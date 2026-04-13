import java.util.HashMap;

public class ContinuousSubarraySum {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
    System.out.println(solution.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 13));
    System.out.println(solution.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 7));
    System.out.println(solution.checkSubarraySum(new int[] { 7, 7 }, 7));
  }
}

class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    var cached = new HashMap<Integer, Integer>();

    cached.put(0, -1);

    var r = 0;

    for (var i = 0; i < nums.length; i++) {
      r = (r + nums[i]) % k;

      if (cached.containsKey(r)) {
        if (i - cached.get(r) > 1) {
          return true;
        }

        continue;
      }

      cached.put(r, i);
    }

    return false;
  }
}
