public class ClimbingStairs {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.climbStairs(3));
  }
}

class Solution {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    var a = 1;
    var b = 2;
    var c = a + b;

    for (var i = 2; i < n; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }
}

// 1 --> 1
// 2 --> 2
// 3 = f(1) + f(2)
