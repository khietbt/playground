import java.util.HashSet;

public class ContainsDuplicateII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
  }
}

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    var cached = new HashSet<Integer>();

    for (var i = 0; i < nums.length; i++) {
      if (cached.contains(nums[i])) {
        return true;
      }

      cached.add(nums[i]);

      if (i >= k) {
        cached.remove(nums[i - k]);
      }
    }

    return false;
  }
}
