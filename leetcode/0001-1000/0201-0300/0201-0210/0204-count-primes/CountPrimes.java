import java.util.Arrays;

public class CountPrimes {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.countPrimes(10));
  }
}

class Solution {
  public int countPrimes(int n) {
    var sieve = new int[n];
    Arrays.fill(sieve, 1);
    sieve[0] = 0;
    sieve[1] = 0;

    for (var i = 2; i * i < n; i++) {
      for (var j = i * i; j < n; j = j + i) {
        sieve[j] = 0;
      }
    }

    var totalPrimes = 0;

    for (var i = 0; i < n; i++) {
      totalPrimes += sieve[i];
    }

    return totalPrimes;
  }
}
