public class MinimumTimeVisitingAllPoints {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.minTimeToVisitAllPoints(
            new int[][] {
                { 1, 1 }, { 3, 4 }, { -1, 0 }
            }));

    System.out.println(
        solution.minTimeToVisitAllPoints(
            new int[][] {
                { 3, 2 }, { -2, 2 }
            }));
  }
}

class Solution {
  public int minTimeToVisitAllPoints(int[][] points) {
    var totalTime = 0;

    for (var i = 0; i < points.length - 1; i++) {
      var x = points[i];
      var y = points[i + 1];

      totalTime += Math.max(Math.abs(y[0] - x[0]), Math.abs(y[1] - x[1]));
    }

    return totalTime;
  }
}
