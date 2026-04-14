public class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    System.out.println(solution.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
  }
}

class Solution {
  public int maxProfit(int[] prices) {
    var maximum = 0;

    var l = 0;

    for (var i = 0; i < prices.length; i++) {
      if (prices[i] > prices[l]) {
        maximum = Math.max(maximum, prices[i] - prices[l]);
      } else {
        l = i;
      }
    }

    return maximum;
  }
}
