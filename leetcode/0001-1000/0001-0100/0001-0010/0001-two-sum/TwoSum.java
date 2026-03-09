public class TwoSum {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
  }
}

class Solution {
  public int[] twoSum(int[] nums, int target) {
    for (var i = 0; i < nums.length; i++) {
      for (var j = i + 1; i < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }

    return new int[0];
  }
}
