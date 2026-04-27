import java.util.Arrays;

public class RotateImage {

  public static void main(String[] args) {
    var matrix = new int[][] {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 },
    };

    var solution = new Solution();

    solution.rotate(matrix);

    for (var r : matrix) {
      System.out.println(Arrays.toString(r));
    }
  }
}

class Solution {
  void swap(int matrix[][], int x1, int y1, int x2, int y2) {
    var t = matrix[x1][y1];
    matrix[x1][y1] = matrix[x2][y2];
    matrix[x2][y2] = t;
  }

  void reverse(int matrix[][], int i) {
    var start = 0;
    var end = matrix[i].length - 1;

    while (start < end) {
      swap(matrix, i, start, i, end);
      start++;
      end--;
    }
  }

  public void rotate(int[][] matrix) {
    for (var i = 0; i < matrix.length; i++) {
      for (var j = 0; j < i; j++) {
        swap(matrix, i, j, j, i);
      }
    }

    for (var i = 0; i < matrix.length; i++) {
      reverse(matrix, i);
    }
  }
}
