public class MinimumPenaltyForAShop {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.bestClosingTime("YYNY"));
    System.out.println(solution.bestClosingTime("NNNNN"));
    System.out.println(solution.bestClosingTime("YYYY"));
  }
}

class Solution {
  public int bestClosingTime(String customers) {
    var bestClosingTime = 0;

    var minimum = 0;
    var penalty = 0;

    for (var i = 0; i < customers.length(); i++) {
      if (customers.charAt(i) == 'Y') {
        penalty--;
      } else {
        penalty++;
      }

      if (penalty < minimum) {
        minimum = penalty;
        bestClosingTime = i + 1;
      }
    }

    return bestClosingTime;
  }
}
