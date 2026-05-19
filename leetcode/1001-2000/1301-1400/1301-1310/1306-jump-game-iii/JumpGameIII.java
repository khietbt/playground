import java.util.LinkedList;

public class JumpGameIII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.canReach(
        new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5));

    System.out.println(solution.canReach(
        new int[] { 3, 0, 2, 1, 2 }, 2));
  }
}

class Solution {
  public boolean canReach(int[] arr, int start) {
    var n = arr.length;
    var seen = new boolean[n];
    var queue = new LinkedList<Integer>();
    seen[start] = true;

    queue.offer(start);

    while (!queue.isEmpty()) {
      var i = queue.poll();
      var v = arr[i];

      if (v == 0) {
        return true;
      }

      var left = i - v;
      if (left >= 0 && !seen[left]) {
        queue.offer(left);
        seen[left] = true;
      }

      var right = i + v;

      if (right < n && !seen[right]) {
        queue.offer(right);
        seen[right] = true;
      }

    }

    return false;
  }
}
