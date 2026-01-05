public class FourDivisors {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.sumFourDivisors(new int[] { 21 }));
    System.out.println(solution.sumFourDivisors(new int[] { 21, 4, 7 }));
    System.out.println(solution.sumFourDivisors(new int[] { 21, 21 }));
    System.out.println(solution.sumFourDivisors(new int[] { 1, 2, 3, 4, 5 }));
  }
}

class Solution {
  boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }

    for (var i = 2; i * i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  public int sumFourDivisors(int[] nums) {
    var sum = 0;

    for (var n : nums) {
      var cbrt = (int) Math.cbrt(n);

      if (cbrt * cbrt * cbrt == n) {
        if (isPrime(cbrt)) {
          sum += 1 + cbrt + cbrt * cbrt + n;
          continue;
        }
      }

      for (var i = 2; i * i <= n; i++) {
        if (!isPrime(i)) {
          continue;
        }

        if (n % i != 0) {
          continue;
        }

        var j = n / i;

        if (i == j) {
          continue;
        }

        if (!isPrime(j)) {
          continue;
        }

        sum += 1 + i + j + n;
      }
    }

    return sum;
  }
}
