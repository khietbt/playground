public class SingleNumberII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
  }
}

class Solution {
  public int singleNumber(int[] nums) {
    var ones = 0;
    var twos = 0;

    for (var n : nums) {
      ones ^= n & ~twos;
      twos ^= n & ~ones;
    }

    return ones;
  }
}
