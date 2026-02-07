import java.util.HashMap;

public class CountElementsWithMaximumFrequency {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
  }
}

class Solution {
  public int maxFrequencyElements(int[] nums) {
    var data = new int[101];

    var maximum = Integer.MIN_VALUE;

    for (var i = 0; i < nums.length; i++) {
      data[nums[i]]++;
      maximum = Math.max(maximum, data[nums[i]]);
    }

    var total = 0;

    for (var i = 0; i < 101; i++) {
      if (data[i] == maximum) {
        total += data[i];
      }
    }

    return total;
  }
}
