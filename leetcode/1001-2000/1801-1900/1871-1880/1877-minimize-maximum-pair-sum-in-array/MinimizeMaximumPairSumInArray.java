import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minPairSum(new int[] { 3, 5, 2, 3 }));
    System.out.println(solution.minPairSum(new int[] { 3, 5, 4, 2, 4, 6 }));
  }
}

class Solution {
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);

    var min = -Integer.MAX_VALUE;

    for (var i = 0; i < nums.length / 2; i++) {
      var sum = nums[i] + nums[nums.length - i - 1];

      min = Math.max(sum, min);
    }

    return min;
  }
}
