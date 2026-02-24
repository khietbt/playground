public class PowerOfTwo {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.isPowerOfTwo(16));
  }
}

class Solution {
  public boolean isPowerOfTwo(int n) {
    return n > 0 && ((n & (n - 1)) == 0);
  }
}
