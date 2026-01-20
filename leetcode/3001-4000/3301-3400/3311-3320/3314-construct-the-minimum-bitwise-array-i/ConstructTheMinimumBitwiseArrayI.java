import java.util.Arrays;
import java.util.List;

public class ConstructTheMinimumBitwiseArrayI {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.toString(
            solution.minBitwiseArray(
                Arrays.asList(2, 3, 5, 7, 9, 11, 31))));
  }
}

class Solution {
  public int[] minBitwiseArray(List<Integer> nums) {
    var answers = new int[nums.size()];

    for (var i = 0; i < nums.size(); i++) {
      var n = (int) nums.get(i);

      if (n == 2) {
        answers[i] = -1;
      } else {
        var z = ((n + 1) & (~n)) >> 1;

        answers[i] = n & (~z);
      }
    }

    return answers;
  }
}
