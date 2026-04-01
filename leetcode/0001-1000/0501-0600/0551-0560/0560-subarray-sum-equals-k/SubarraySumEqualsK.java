import java.util.HashMap;

public class SubarraySumEqualsK {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.subarraySum(new int[] { 1, 2, 3 }, 3));
  }
}

class Solution {
  public int subarraySum(int[] nums, int k) {
    var cached = new HashMap<Integer, Integer>();

    var totalSubarrays = 0;
    var sum = 0;

    cached.put(0, 1);

    for (var n : nums) {
      sum += n;
      var c = sum - k;

      if (cached.containsKey(c)) {
        totalSubarrays += cached.get(c);
      }

      //
      cached.merge(sum, 1, Integer::sum);
    }

    return totalSubarrays;
  }
}
