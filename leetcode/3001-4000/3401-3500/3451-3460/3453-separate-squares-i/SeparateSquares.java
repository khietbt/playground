import java.util.Arrays;

public class SeparateSquares {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.separateSquares(
        new int[][] {
            { 0, 0, 1 },
            { 2, 2, 1 }
        }));

    System.out.println(solution.separateSquares(
        new int[][] {
            { 0, 0, 2 },
            { 1, 1, 1 }
        }));

    System.out.println(
        solution.separateSquares(
            new int[][] {
                { 522261215, 954313664, 225462 },
                { 628661372, 718610752, 10667 },
                { 619734768, 941310679, 44788 },
                { 352367502, 656774918, 289036 },
                { 860247066, 905800565, 100123 },
                { 817623994, 962847576, 71460 },
                { 691552058, 782740602, 36271 },
                { 911356, 152015365, 513881 },
                { 462847044, 859151855, 233567 },
                { 672324240, 954509294, 685569 }
            }));
  }
}

class Solution {
  public double separateSquares(int[][] squares) {
    var total = Arrays.stream(squares).mapToDouble(s -> s[2]).map(d -> d * d).sum();
    var low = Arrays.stream(squares).mapToDouble(s -> s[1]).min().orElse(Double.MAX_VALUE);
    var high = Arrays.stream(squares).mapToDouble(s -> s[1] + s[2]).max().orElse(-Double.MAX_VALUE);
    var half = total / 2;
    var threshold = 0.00001d;

    while (high - low > threshold) {
      var mid = (high + low) / 2.0;

      var below = Arrays.stream(squares).mapToDouble(s -> {
        var y = (double) s[1];
        var l = (double) s[2];
        var t = y + l;

        if (t <= mid) {
          return l * l;
        }

        if (y <= mid) {
          return l * (mid - y);
        }

        return 0d;
      }).sum();

      if (below >= half) {
        high = mid;
      } else {
        low = mid;
      }
    }

    return low;
  }
}
