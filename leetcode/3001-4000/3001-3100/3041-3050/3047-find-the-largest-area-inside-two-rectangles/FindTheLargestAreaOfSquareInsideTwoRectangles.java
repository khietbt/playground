import java.util.Arrays;

public class FindTheLargestAreaOfSquareInsideTwoRectangles {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.largestSquareArea(
            new int[][] { { 1, 1 }, { 2, 2 }, { 3, 1 } },
            new int[][] { { 3, 3 }, { 4, 4 }, { 6, 6 }
            }));

    System.out.println(
        solution.largestSquareArea(
            new int[][] {
                { 1, 1 }, { 1, 3 }, { 1, 5 }
            },
            new int[][] {
                { 5, 5 }, { 5, 7 }, { 5, 9 }
            }));

    System.out.println(
        solution.largestSquareArea(
            new int[][] {
                { 1, 1 }, { 2, 2 }, { 1, 2 }
            },
            new int[][] {
                { 3, 3 }, { 4, 4 }, { 3, 4 }
            }));

    System.out.println(
        solution.largestSquareArea(
            new int[][] {
                { 1, 1 }, { 3, 3 }, { 3, 1 }
            },
            new int[][] {
                { 2, 2 }, { 4, 4 }, { 4, 2 }
            }));
  }
}

class Solution {
  public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    var max = 0l;
    var l = bottomLeft.length;
    var indexes = new int[l];

    for (var i = 0; i < l; i++) {
      indexes[i] = i;
    }

    for (var i = 0; i < l; i++) {
      for (var j = i + 1; j < l; j++) {
        var bl1 = bottomLeft[i];
        var bl1x = bl1[0];
        var bl1y = bl1[1];

        var tr1 = topRight[i];
        var tr1x = tr1[0];
        var tr1y = tr1[1];

        var bl2 = bottomLeft[j];
        var bl2x = bl2[0];
        var bl2y = bl2[1];

        var tr2 = topRight[j];
        var tr2x = tr2[0];
        var tr2y = tr2[1];

        var width = Math.min(tr1x, tr2x) - Math.max(bl1x, bl2x);
        var height = Math.min(tr1y, tr2y) - Math.max(bl1y, bl2y);

        var size = Math.min(width, height);

        max = Math.max(max, size);
      }
    }

    return max * max;
  }
}
