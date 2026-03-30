import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class FindXSumOfAllKLongSubarraysII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(Arrays.toString(solution.findXSum(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2)));
  }
}

class Solution {
  public long[] findXSum(int[] nums, int k, int x) {
    var comparator = new Comparator<long[]>() {
      @Override
      public int compare(long[] a, long[] b) {
        if (b[1] == a[1]) {
          return Long.compare(b[0], a[0]);
        }

        return Long.compare(b[1], a[1]);
      }
    };

    var top = new TreeSet<>(comparator);
    var bottom = new TreeSet<>(comparator);
    var cached = new HashMap<Long, Integer>();

    var n = nums.length;

    var answers = new long[n - k + 1];
    var runningSum = 0L;

    for (var i = 0; i < n; i++) {
      var rightValue = (long) nums[i];
      var rightOldCount = cached.getOrDefault(rightValue, 0);

      if (rightOldCount > 0) {
        var e = new long[] { rightValue, rightOldCount };

        if (top.contains(e)) {
          runningSum = runningSum - rightValue * rightOldCount;
          top.remove(e);
        } else {
          bottom.remove(e);
        }
      }

      // Add the right value into the top
      var rightNewCount = rightOldCount + 1;
      cached.put(rightValue, rightNewCount);
      runningSum = runningSum + rightValue * rightNewCount;
      top.add(new long[] { rightValue, rightNewCount });

      if (i < k - 1) {
        continue;
      }

      if (i >= k) {
        var leftValue = (long) nums[i - k];
        var leftOldCount = cached.get(leftValue);
        var e = new long[] { leftValue, leftOldCount };

        if (top.contains(e)) {
          top.remove(e);
          runningSum = runningSum - leftValue * leftOldCount;
        } else {
          bottom.remove(e);
        }

        var leftNewCount = leftOldCount - 1;
        bottom.add(new long[] { leftValue, leftNewCount });
        cached.put(leftValue, leftNewCount);

        e = bottom.pollFirst();

        top.add(e);
        runningSum = runningSum + e[0] * e[1];
      }

      while (top.size() > x) {
        var e = top.pollLast();
        runningSum = runningSum - e[0] * e[1];
        bottom.add(e);
      }

      if (i >= k - 1) {
        answers[i - k + 1] = runningSum;
      }
    }

    return answers;
  }
}
