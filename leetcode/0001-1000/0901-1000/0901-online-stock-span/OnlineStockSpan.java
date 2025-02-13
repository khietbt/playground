import java.util.ArrayList;
import java.util.List;

class StockSpanner {
  List<Integer> prices;

  public StockSpanner() {
    prices = new ArrayList<>();
  }

  public int next(int price) {
    prices.add(price);

    int span = 0;
    int n = prices.size();

    for (int i = 0; i < n; i++) {
      if (prices.get(n - 1 - i) > price) {
        break;
      }

      span++;
    }

    return span;
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
