import java.util.Arrays;

public class CellsWithOddValuesInAMatrix {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.oddCells(2, 3, new int[][] {
        { 0, 1 },
        { 1, 1 }
    }));

    System.out.println(solution.oddCells(2, 2, new int[][] {
        { 1, 1 },
        { 0, 0 }
    }));
  }
}

class Solution {
  public int oddCells(int m, int n, int[][] indices) {
    var rows = new int[m];
    var cols = new int[n];

    for (var i : indices) {
      rows[i[0]]++;
      cols[i[1]]++;
    }

    var or = Arrays.stream(rows).filter(r -> r % 2 == 1).count();
    var oc = Arrays.stream(cols).filter(c -> c % 2 == 1).count();

    return (int) (or * n + oc * m - 2 * or * oc);
  }
}
