import java.util.ArrayList;

public class TrionicArrayII {

  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(
    // solution.maxSumTrionic(
    // new int[] { -754, 167, -172, 202, 735, -941, 992 }));
    System.out.println(
        solution.maxSumTrionic(
            new int[] { 0, -2, -1, -3, 0, 2, -1 }));
    //
    // System.out.println(
    // solution.maxSumTrionic(
    // new int[] { 1, 4, 2, 7 }));
  }
}

class Solution {
  private long sum(long[] prefixes, int i, int j) {
    return prefixes[j] - (i > 0 ? prefixes[i - 1] : 0);
  }

  public long maxSumTrionic(int[] nums) {
    var prefixes = new long[nums.length];
    var n = nums.length;

    for (var i = 0; i < n; i++) {
      prefixes[i] = ((i > 0) ? prefixes[i - 1] : 0) + nums[i];
    }

    // System.out.println(Arrays.toString(prefixes));

    var data = new ArrayList<int[]>();
    data.add(new int[] { 0, Integer.compare(nums[0], nums[1]) });

    // System.out.println("previous = " + previous);

    var previous = data.get(data.size() - 1)[1];

    for (var i = 1; i < n - 1; i++) {
      var current = Integer.compare(nums[i], nums[i + 1]);

      if (current != previous) {
        data.add(new int[] { i, current });
      }

      previous = current;
    }

    data.add(new int[] { n - 1, 0 });

    // data.forEach(v -> System.out.println(v[0] + " ==> " + v[1]));

    var max = Long.MIN_VALUE;

    // System.out.println("data.size() = " + data.size());

    for (var i = 0; i < data.size() - 3; i++) {
      // System.out.println("i = " + i);
      if (data.get(i)[1] != -1) {
        continue;
      }

      if (data.get(i + 1)[1] != 1) {
        continue;
      }

      if (data.get(i + 2)[1] != -1) {
        continue;
      }

      var l = data.get(i)[0];
      var p = data.get(i + 1)[0];
      var q = data.get(i + 2)[0];
      var r = data.get(i + 3)[0];

      var left = sum(prefixes, l, p - 1);

      while (++l <= p - 1) {
        left = Math.max(left, sum(prefixes, l, p - 1));
      }

      var middle = sum(prefixes, p, q);

      var right = sum(prefixes, q + 1, r);

      while (--r >= q + 1) {
        right = Math.max(right, sum(prefixes, q + 1, r));
      }

      max = Math.max(max, left + middle + right);
    }

    return max;
  }
}
