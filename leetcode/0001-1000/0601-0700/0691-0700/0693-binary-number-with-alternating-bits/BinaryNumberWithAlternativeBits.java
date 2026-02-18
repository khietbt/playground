public class BinaryNumberWithAlternativeBits {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.hasAlternatingBits(5));
    System.out.println(solution.hasAlternatingBits(7));
    System.out.println(solution.hasAlternatingBits(11));
  }
}

class Solution {
  public boolean hasAlternatingBits(int n) {
    var previous = n & 1;

    n >>= 1;

    while (n > 0) {
      var current = n & 1;

      if (previous == current) {
        return false;
      }

      previous = current;

      n >>= 1;
    }

    return true;
  }
}
