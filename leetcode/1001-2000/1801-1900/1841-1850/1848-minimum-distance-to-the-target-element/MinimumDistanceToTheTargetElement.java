public class MinimumDistanceToTheTargetElement {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.getMinDistance(new int[] { 1, 2, 3, 4, 5 }, 5, 3));
  }
}

class Solution {
  public int getMinDistance(int[] nums, int target, int start) {
    var minimum = Integer.MAX_VALUE;

    for (var i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        minimum = Math.min(minimum, Math.abs(i - start));
      }
    }

    return minimum;
  }
}
