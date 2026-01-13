public class New21Game {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.new21Game(10, 1, 10));
    System.out.println(solution.new21Game(6, 1, 10));
    System.out.println(solution.new21Game(21, 17, 10));
  }
}

class Solution {
  public double new21Game(int n, int k, int maxPts) {
    if (k == 0) {
      return 1;
    }

    var data = new double[n + 1];

    data[0] = 1;

    var s = 1.0d;

    for (var i = 1; i <= n; i++) {
      data[i] = s / maxPts;

      if (i < k) {
        s += data[i];
      }

      if (i - maxPts < k && i - maxPts >= 0) {
        s -= data[i - maxPts];
      }
    }

    var total = 0d;

    for (var i = k; i <= n; i++) {
      total += data[i];
    }

    return total;
  }
}
