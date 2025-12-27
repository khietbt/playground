import java.util.PriorityQueue;

public class MinimumAmountOfDamageDealtToBob {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minDamage(4, new int[] { 1, 2, 3, 4 }, new int[] { 4, 5, 6, 8 }));
    System.out.println(solution.minDamage(1, new int[] { 1, 1, 1, 1 }, new int[] { 1, 2, 3, 4 }));
    System.out.println(solution.minDamage(8, new int[] { 40 }, new int[] { 59
    }));
  }

}

class Solution {
  public long minDamage(int power, int[] damage, int[] health) {
    var n = damage.length;

    var queue = new PriorityQueue<Integer>(
        (i, j) -> {
          var ai = (health[i] - 1 + power) / power;
          var aj = (health[j] - 1 + power) / power;

          var di = aj * damage[i];
          var dj = ai * damage[j];

          return dj - di;
        });

    for (var i = 0; i < n; i++) {
      queue.offer(i);
    }

    long sum = 0L;
    int attacks = 0;

    while (!queue.isEmpty()) {
      var i = queue.poll();

      var attack = (health[i] - 1 + power) / power;
      attacks += attack;

      var di = damage[i] * attacks;
      sum += di;
    }

    return sum;
  }
}
