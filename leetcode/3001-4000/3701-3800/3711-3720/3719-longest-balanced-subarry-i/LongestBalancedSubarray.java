import java.util.HashSet;

public class LongestBalancedSubarray {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.longestBalanced(new int[] { 2, 5, 4, 3 }));
    System.out.println(solution.longestBalanced(new int[] { 3, 2, 2, 4, 1 }));
  }
}

class Solution {
  public int longestBalanced(int[] nums) {
    var maximum = 0;
    var n = nums.length;

    for (var i = 0; i < n; i++) {
      var odds = new HashSet<Integer>();
      var evens = new HashSet<Integer>();

      for (var j = i; j < n; j++) {
        if (nums[j] % 2 == 1) {
          odds.add(nums[j]);
        } else {
          evens.add(nums[j]);
        }

        if (odds.size() == evens.size()) {
          maximum = Math.max(maximum, j - i + 1);
        }
      }
      //
    }

    return maximum;
  }
}
