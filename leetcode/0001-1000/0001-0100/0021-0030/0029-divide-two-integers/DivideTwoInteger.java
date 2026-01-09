import java.io.Console;

public class DivideTwoInteger {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.divide(10, 3));
    System.out.println(solution.divide(7, -3));
    System.out.println(solution.divide(-2147483648, 1));
    System.out.println(solution.divide(-2147483648, 2));
  }
}

class Solution {
  public int divide(int dividend, int divisor) {
    if (divisor == 1) {
      return dividend;
    }

    if (dividend == 0) {
      return 0;
    }

    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    var sign = (dividend > 0) == (divisor > 0);
    var quotient = 0;

    if (dividend > 0) {
      dividend = -dividend;
    }

    if (divisor > 0) {
      divisor = -divisor;
    }

    while (dividend <= divisor) {
      var currentQuotient = 1;
      var currentDivisor = divisor;

      while ((currentDivisor >= (Integer.MIN_VALUE >> 1)) && (currentDivisor << 1) >= dividend) {
        currentQuotient <<= 1;
        currentDivisor <<= 1;
      }

      dividend -= currentDivisor;
      quotient += currentQuotient;
    }

    return sign ? quotient : -quotient;
  }
}
