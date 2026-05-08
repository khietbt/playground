import java.util.Arrays;

public class JumpGameIX {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.toString(
            solution.maxValue(new int[] { 2, 1, 3 })));

    System.out.println(
        Arrays.toString(
            solution.maxValue(new int[] { 2, 3, 1 })));
  }
}

class Solution {
  public int[] maxValue(int[] nums) {
    var n = nums.length;

    var prefixes = new int[n];
    prefixes[0] = nums[0];
    for (var i = 1; i < n; i++) {
      prefixes[i] = Math.max(prefixes[i - 1], nums[i]);
    }

    var suffix = Integer.MAX_VALUE;

    var answer = new int[n];

    for (var i = n - 1; i >= 0; i--) {
      answer[i] = suffix < prefixes[i] ? answer[i + 1] : prefixes[i];
      // answer[i] = prefix[i] > suffix ? answer[i + 1] : prefix[i];
      suffix = Math.min(suffix, nums[i]);
    }

    return answer;
  }
}
