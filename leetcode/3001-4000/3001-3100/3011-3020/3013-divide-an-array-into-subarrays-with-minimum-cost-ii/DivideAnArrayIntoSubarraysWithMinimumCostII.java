import java.util.TreeSet;

public class DivideAnArrayIntoSubarraysWithMinimumCostII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.minimumCost(
            new int[] { 1, 3, 2, 6, 4, 2 },
            3,
            3));
  }
}

class Solution {
  public long minimumCost(int[] nums, int k, int dist) {
    // Cost of the first subarray.
    var sum = Long.valueOf(nums[0]);

    var usings = new TreeSet<Integer>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
    var waitings = new TreeSet<Integer>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

    // The first window from 1 --> dist + 1.
    for (var i = 1; i <= dist + 1; i++) {
      usings.add(i);
      sum += nums[i];
    }

    while (usings.size() > k - 1) {
      var waiting = usings.pollLast();
      sum -= nums[waiting];
      waitings.add(waiting);
    }

    var min = sum;

    for (var indexToRemove = 1; indexToRemove < nums.length - dist - 1; indexToRemove++) {
      var indexToAdd = indexToRemove + dist + 1;

      // i = 1
      if (usings.contains(indexToRemove)) {
        usings.remove(indexToRemove);
        sum -= nums[indexToRemove];

        waitings.add(indexToAdd);
        var adding = waitings.pollFirst();

        usings.add(adding);
        sum += nums[adding];
      } else {
        waitings.remove(indexToRemove);

        usings.add(indexToAdd);
        sum += nums[indexToAdd];

        var waiting = usings.pollLast();
        sum -= nums[waiting];

        waitings.add(waiting);
      }

      min = Math.min(sum, min);
    }

    return min;
  }
}
