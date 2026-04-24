import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistanceBetweenThreEqualElementsII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minimumDistance(new int[] {
        1, 1, 1, 1, 1, 1, 1, 2, 1, 2
    }));
  }
}

class Solution {
  public int minimumDistance(int[] nums) {
    var cached = new HashMap<Integer, List<Integer>>();
    var minimum = Integer.MAX_VALUE;

    for (var i = 0; i < nums.length; i++) {
      cached.computeIfAbsent(nums[i], k -> new ArrayList<Integer>()).add(i);
      // cached.computeIfAbsent(nums[i], ArrayList<Integer>::new).add(i);
    }

    for (var v : cached.values()) {
      if (v.size() < 3) {
        continue;
      }

      for (var i = 2; i < v.size(); i++) {
        minimum = Math.min(minimum, Math.abs(v.get(i) - v.get(i - 2)));
      }
    }

    if (minimum == Integer.MAX_VALUE) {
      return -1;
    }

    return 2 * minimum;
  }
}
