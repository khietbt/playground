import java.util.Arrays;
import java.util.stream.IntStream;

public class FinalPricesWithASpecialDiscountInAShop {
  public static void main(String[] args) {
    int[] prices = { 10, 1, 1, 6 };

    System.out.println(Arrays.toString((new Solution()).finalPrices(prices)));
  }
}

class Solution {
  public int[] finalPrices(int[] prices) {
    IntStream
        .range(0, prices.length)
        .forEach(
            i -> IntStream
                .range(i + 1, prices.length)
                .filter((j) -> prices[j] <= prices[i]).findFirst()

                .ifPresent(j -> prices[i] -= prices[j]));
    return prices;
  }
}
