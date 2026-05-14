public class CheckIfArrayIsGood {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.isGood(new int[] { 1, 3, 3, 2 }));
  }
}

class Solution {
  public boolean isGood(int[] nums) {
    var l = nums.length;
    var frequencies = new int[l];

    for (var i = 0; i < nums.length; i++) {
      var n = nums[i];

      if (n < 1) {
        return false;
      }

      if (n > l - 1) {
        return false;
      }

      frequencies[n]++;
    }

    for (var i = 1; i < nums.length - 1; i++) {
      if (frequencies[i] != 1) {
        return false;
      }
    }

    return frequencies[l - 1] == 2;
  }
}
