public class DivideAnArrayIntoSubarraysWithMinimumCostI {

  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(solution.minimumCost(
    // new int[] { 1, 2, 3, 12 }));

    System.out.println(solution.minimumCost(
        new int[] { 5, 4, 3 }));

    // System.out.println(solution.minimumCost(
    // new int[] { 10, 3, 1, 1 }));
  }
}

class Solution {
  public int minimumCost(int[] nums) {
    var n = nums.length;

    var smallest = Integer.MAX_VALUE;

    var first = nums[0];

    for (var i = 1; i < n - 1; i++) {
      var second = nums[i];

      for (var j = i + 1; j < n; j++) {
        var third = nums[j];

        smallest = Math.min(smallest, first + second + third);
      }
    }

    return smallest;
  }
}
