import java.util.Arrays;

public class SingleNumberIII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(Arrays.toString(
        solution.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })));
  }
}

class Solution {
  public int[] singleNumber(int[] nums) {
    var a = 0;
    var b = 0;

    var xor = 0;

    for (var n : nums) {
      xor ^= n;
    }

    var lowestBit = xor & -xor;

    for (var n : nums) {
      if ((lowestBit & n) == 0) {
        a ^= n;
      } else {
        b ^= n;
      }
    }

    return new int[] { a, b };
  }
}
