import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.lengthOfLIS(
        new int[] { 0, 1, 0, 2, 3, 2, 3 }));
  }
}

class Solution {
  public int lengthOfLIS(int[] nums) {
    var longest = new ArrayList<Integer>();

    for (var n : nums) {
      if (longest.isEmpty() || longest.get(longest.size() - 1) < n) {
        longest.add(n);
        continue;
      }

      var i = Collections.binarySearch(longest, n);

      longest.set(i < 0 ? (-i - 1) : i, n);
    }

    return longest.size();
  }
}
