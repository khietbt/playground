import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

  public static void main(String[] args) {
    var solution = new Solution();

    // var n = 2147483647;
    //
    // System.out.println(n);
    // System.out.println(n / 2);
    // System.out.println(n + 1);
    System.out.println(solution.integerReplacement(2147483647));
  }
}

class Solution {
  public int integerReplacement(int n) {
    return integerReplacement(n, new HashMap<>());
  }

  private int integerReplacement(long n, Map<Long, Long> cached) {
    if (n == 1 || n == 0) {
      return 0;
    }

    if (cached.containsKey(n)) {
      return cached.get(n).intValue();
    }

    if (n % 2 == 0) {
      var v = 1L + integerReplacement(n / 2, cached);

      cached.put(n, v);

      return cached.get(n).intValue();
    }

    var u = integerReplacement(n + 1, cached);
    var v = integerReplacement(n - 1, cached);

    cached.put(n, 1L + Math.min(u, v));

    return cached.get(n).intValue();
  }
}
