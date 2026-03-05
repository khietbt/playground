import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.prefixesDivBy5(new int[] {
        0, 1, 1
    }));
  }
}

class Solution {
  public List<Boolean> prefixesDivBy5(int[] nums) {
    var answer = new ArrayList<Boolean>();

    var v = 0;

    for (var n : nums) {
      v = (v * 2 + n) % 5;

      answer.add(v == 0);
    }

    return answer;
  }
}
