import java.util.Arrays;

public class FinalPricesWithASpecialDiscountInAShop {
  public static void main(String[] args) {
    int[] prices = { 10, 1, 1, 6 };

    System.out.println(Arrays.toString((new Solution()).finalPrices(prices)));
  }
}

class Solution {
  public int[] finalPrices(int[] prices) {
    for (int i = 0; i < prices.length; i++) {
      int j = i + 1;

      while (j < prices.length && prices[j] > prices[i]) {
        j++;
      }

      if (j < prices.length) {
        prices[i] -= prices[j];
      }
    }

    return prices;
  }
}
