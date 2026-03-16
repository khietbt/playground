public class MinimumNumberOfSecondsToMakeMountainHeightZero {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minNumberOfSeconds(4, new int[] { 2, 1, 1 }));
    System.out.println(solution.minNumberOfSeconds(10, new int[] { 3, 2, 2, 4 }));
    System.out.println(solution.minNumberOfSeconds(5, new int[] { 1 }));
  }
}

class Solution {
  private long calculateReducibleHeight(long workerTime, long totalTime) {
    // workerTime * k * (k + 1) / 2 <= totalTime
    // ==> k * k + k - 2 * totalTime / workerTime <= 0
    // ==> k <= (-1 + Math.sqrt(1 - 4 * (-2) * totalTime / workerTime)) / 2.
    return (long) Math.floor((-1 + Math.sqrt(1 - 4 * (-2) * totalTime / workerTime)) / 2);
  }

  private boolean canFlatten(int[] workerTimes, long mountainHeight, long totalTime) {
    var totalReducibleHeights = 0L;

    for (var workerTime : workerTimes) {
      totalReducibleHeights += calculateReducibleHeight(workerTime, totalTime);
    }

    return totalReducibleHeights >= mountainHeight;
  }

  public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    if (workerTimes.length == 1) {
      return workerTimes[0] * mountainHeight * (mountainHeight + 1) / 2;
    }

    long maxWorkingTime = Integer.MIN_VALUE;
    for (var workerTime : workerTimes) {
      maxWorkingTime = Math.max(maxWorkingTime, workerTime);
    }

    long minimumConsumingTime = 1L;
    long left = 1L;
    long right = maxWorkingTime * mountainHeight * (mountainHeight + 1) / 2;

    while (left <= right) {
      var middle = (left + right) / 2;

      if (canFlatten(workerTimes, mountainHeight, middle)) {
        right = middle - 1;
        minimumConsumingTime = middle;
      } else {
        left = middle + 1;
      }
      //
    }

    return minimumConsumingTime;
  }
}
