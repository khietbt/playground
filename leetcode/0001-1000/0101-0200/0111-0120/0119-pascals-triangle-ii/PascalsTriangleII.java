import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.getRow(0));
    System.out.println(solution.getRow(1));
    System.out.println(solution.getRow(2));
    System.out.println(solution.getRow(3));
    System.out.println(solution.getRow(4));
    System.out.println(solution.getRow(5));
  }
}

class Solution {
  public List<Integer> getRow(int rowIndex) {
    var row = new ArrayList<Integer>();

    var v = 1;

    row.add(v);

    for (var i = 0; i < rowIndex; i++) {
      v = (int) ((long) v * (rowIndex - i) / (i + 1));

      row.add(v);
    }

    return row;
  }
}

// C(1, n) = 1
// C(2, n) = n! / (n - 2)! * 2!
