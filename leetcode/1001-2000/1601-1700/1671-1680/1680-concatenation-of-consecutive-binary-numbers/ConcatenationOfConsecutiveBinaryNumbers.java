public class ConcatenationOfConsecutiveBinaryNumbers {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.concatenatedBinary(12));
  }
}

class Solution {
  public int concatenatedBinary(int n) {
    var v = 0L;
    var MODULO = 1_000_000_007L;
    var length = 0;

    for (var i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        length++;
      }

      v = ((v << length) + i) % MODULO;
    }

    return (int) v;
  }
}
