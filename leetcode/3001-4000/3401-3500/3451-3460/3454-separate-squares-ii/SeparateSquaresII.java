import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeparateSquaresII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.separateSquares(
        new int[][] {
            { 0, 0, 2 },
            { 1, 1, 1 }
        }));
  }
}

class Solution {
  public double separateSquares(int[][] squares) {
    var segments = new ArrayList<double[]>();

    Arrays.stream(squares).forEach(
        square -> {
          var x = square[0];
          var y = square[1];
          var l = square[2];

          segments.add(new double[] { y, 1, x, x + l });
          segments.add(new double[] { y + l, -1, x, x + l });
        });

    Collections.sort(segments, (a, b) -> {
      if (a[0] == b[0]) {
        return Double.compare(b[1], a[1]);
      }

      return Double.compare(a[0], b[0]);
    });

    var rectangles = new ArrayList<double[]>();
    var previousY = segments.getFirst()[0];
    var active = new ArrayList<double[]>();
    var total = 0d;

    for (var segment : segments) {
      var currentY = segment[0];
      var height = currentY - previousY;
      var t = segment[1];
      var l = segment[2];
      var r = segment[3];

      if (height > 0) {
        var width = getUnionLength(active);

        total += width * height;
        rectangles.add(new double[] { previousY, width, height });
      }

      if (t == 1) {
        active.add(new double[] { l, r });
      } else {
        active.stream().filter(a -> a[0] == l && a[1] == r).findFirst().ifPresent(x -> active.remove(x));
      }

      previousY = currentY;
    }

    var half = total / 2;
    var accumulated = 0d;

    for (var r : rectangles) {
      var width = r[1];
      var height = r[2];
      var area = width * height;

      if (accumulated + area >= half) {
        var missing = half - accumulated;

        return r[0] + missing / width;
      }

      accumulated += area;
    }

    return 0;
  }

  double getUnionLength(List<double[]> active) {
    active.sort((a, b) -> Double.compare(a[0], b[0]));
    var previousEnd = Double.NEGATIVE_INFINITY;
    var union = 0d;

    for (var line : active) {
      double start = line[0];
      var end = line[1];

      if (end > previousEnd) {
        union += end - Math.max(previousEnd, start);
        previousEnd = end;
      }
    }
    return union;
  }
}
