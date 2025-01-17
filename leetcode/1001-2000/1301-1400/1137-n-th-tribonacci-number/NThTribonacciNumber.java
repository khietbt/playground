public class NThTribonacciNumber {
  public static void main(String[] args) {
    System.out.println(new Solution().tribonacci(25));
  }
}

class Solution {
  public int tribonacci(int n) {
    int t0 = 0;
    int t1 = 1;
    int t2 = 1;
    int t = 2;

    while (n-- > 2) {
      t = t0 + t1 + t2;

      t0 = t1;
      t1 = t2;
      t2 = t;
    }

    return t;
  }
}
