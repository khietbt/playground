public class DivideTwoInteger {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.divide(10, 3));
    System.out.println(solution.divide(7, -3));
  }
}

class Solution {
  public int divide(int dividend, int divisor) {
    var sign = (dividend > 0) == (divisor > 0);
    var quotient = 0;

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    while (dividend > divisor) {
      dividend -= divisor;
      quotient++;
    }

    return sign ? quotient : -quotient;
  }
}
