import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.lengthOfLIS(
        new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
  }
}

class Solution {
  public int lengthOfLIS(int[] nums) {
    var longest = new int[nums.length];
    longest[0] = nums[0];
    var size = 1;

    for (var i = 1; i < nums.length; i++) {
      if (longest[size - 1] < nums[i]) {
        longest[size++] = nums[i];
        continue;
      }

      var j = Arrays.binarySearch(longest, 0, size, nums[i]);

      longest[j < 0 ? (-j - 1) : j] = nums[i];
    }

    return size;
  }
}
