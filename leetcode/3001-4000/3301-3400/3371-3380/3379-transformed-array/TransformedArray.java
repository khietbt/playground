import java.util.Arrays;

public class TransformedArray {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.toString(
            solution.constructTransformedArray(
                new int[] { 3, -2, 1, 1 })));
    System.out.println(
        Arrays.toString(
            solution.constructTransformedArray(
                new int[] { -1, 4, -1 })));
  }
}

class Solution {
  public int[] constructTransformedArray(int[] nums) {
    var n = nums.length;
    var transformed = new int[nums.length];

    for (var i = 0; i < n; i++) {
      var v = nums[i];

      transformed[i] = nums[((i + v) % n + n) % n];
    }

    return transformed;
  }
}
