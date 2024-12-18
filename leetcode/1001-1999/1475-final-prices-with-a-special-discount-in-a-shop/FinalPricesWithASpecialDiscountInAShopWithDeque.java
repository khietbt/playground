import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShopWithDeque {
  public static void main(String[] args) {
    int[] prices = { 10, 1, 1, 6 };

    System.out.println(Arrays.toString((new Solution()).finalPrices(prices)));
  }
}

class Solution {
  public int[] finalPrices(int[] prices) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
        prices[stack.pop()] -= prices[i];
      }

      stack.push(i);
    }

    return prices;
  }
}
