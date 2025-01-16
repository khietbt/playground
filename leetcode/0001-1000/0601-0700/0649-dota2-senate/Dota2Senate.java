import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate {
  public static void main(String[] args) {
    System.out.println(new Solution().predictPartyVictory("RDRDRDRDR"));
  }
}

class Solution {
  public String predictPartyVictory(String senate) {
    Deque<Integer> qr = new ArrayDeque<>();
    Deque<Integer> qd = new ArrayDeque<>();

    for (int i = 0; i < senate.length(); i++) {
      if (senate.charAt(i) == 'D') {
        qd.offerLast(i);
      } else {
        qr.offerLast(i);
      }
    }

    while (!qr.isEmpty() && !qd.isEmpty()) {
      int r = qr.pollFirst();
      int d = qd.pollFirst();

      if (r < d) {
        qr.offerLast(r + senate.length());
      } else {
        qd.offerLast(d + senate.length());
      }
    }

    return qr.isEmpty() ? "Dire" : "Radiant";
  }
}
