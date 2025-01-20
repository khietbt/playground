public class FirstCompletelyPaintedRowOrColumn {
  public static void main(String[] args) {
    int[] arr = {
        2, 8, 7, 4, 1, 3, 5, 6, 9
    };

    int[][] mat = {
        { 3, 2, 5 },
        { 1, 4, 6 },
        { 8, 7, 9 }
    };

    System.out.println(new Solution().firstCompleteIndex(arr, mat));
  }
}

class Solution {
  public int firstCompleteIndex(int[] arr, int[][] mat) {
    int[] rows = new int[mat.length];
    int[] columns = new int[mat[0].length];

    int[] values = new int[mat.length * mat[0].length];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        int index = i * mat[0].length + j;
        values[index] = mat[i][j];
      }
    }

    int[] indices = new int[values.length];

    for (int i = 0; i < values.length; i++) {
      indices[values[i] - 1] = i;
    }

    for (int i = 0; i < arr.length; i++) {
      int a = arr[i];
      int v = indices[a - 1];

      int r = v / mat[0].length;
      int c = v % mat[0].length;

      rows[r]++;
      columns[c]++;

      if (rows[r] == columns.length || columns[c] == rows.length) {
        return i;
      }
    }

    return 0;
  }
}
