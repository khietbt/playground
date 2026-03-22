public class ArrangingCoins {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.arrangeCoins(5));
    System.out.println(solution.arrangeCoins(8));
    System.out.println(solution.arrangeCoins(10));
    System.out.println(solution.arrangeCoins(11));
  }
}

class Solution {
  public int arrangeCoins2(int n) {
    // k * (k - 1) / 2 <= n;
    // k * k - k - 2 * n <= 0;
    // delta = 1 + 8 * n
    // roots = (-1 + sqrt(1 + 8 * n)) / 2
    return (int) Math.floor(
        (-1 + Math.sqrt(1 + 8 * n)) / 2);
  }

  public int arrangeCoins(int n) {
    var answer = 1;
    var left = 1;
    var right = n;

    while (left <= right) {
      var middle = left + (right - left) / 2;

      if (middle % 2 == 0) {
        if (middle / 2 <= n / (middle + 1)) {
          answer = middle;
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      } else {
        if ((middle + 1) / 2 <= n / middle) {
          answer = middle;
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      }
    }

    return answer;
  }
}
