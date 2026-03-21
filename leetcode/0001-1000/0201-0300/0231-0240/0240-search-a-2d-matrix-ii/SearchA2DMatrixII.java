public class SearchA2DMatrixII {
  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(
    // solution.searchMatrix(
    // new int[][] {
    // { 1, 4, 7, 11, 15 },
    // { 2, 5, 8, 12, 19 },
    // { 3, 6, 9, 16, 22 },
    // { 10, 13, 14, 17, 24 },
    // { 18, 21, 23, 26, 30 }
    // }, 14));
    //
    // System.out.println(
    // solution.searchMatrix(
    // new int[][] {
    // { 1, 4, 7, 11, 15 },
    // { 2, 5, 8, 12, 19 },
    // { 3, 6, 9, 16, 22 },
    // { 10, 13, 14, 17, 24 },
    // { 18, 21, 23, 26, 30 }
    // }, 16));
    //
    // System.out.println(
    // solution.searchMatrix(
    // new int[][] {
    // { 1, 4, 7, 11, 15 },
    // { 2, 5, 8, 12, 19 },
    // { 3, 6, 9, 16, 22 },
    // // { 10, 13, 14, 17, 24 },
    // { 18, 21, 23, 26, 30 }
    // }, 11));
    //
    // System.out.println(
    // solution.searchMatrix(
    // new int[][] {
    // { 1, 4, 7, 11, 15 },
    // { 2, 5, 8, 12, 19 },
    // { 3, 6, 9, 16, 22 },
    // // { 10, 13, 14, 17, 24 },
    // { 18, 21, 23, 26, 30 }
    // }, 13));
    //
    // System.out.println(
    // solution.searchMatrix(
    // new int[][] {
    // { 1, 4, 7, 11, 15 },
    // { 2, 5, 8, 12, 19 },
    // { 3, 6, 9, 16, 22 },
    // { 10, 13, 14, 17, 24 },
    // { 18, 21, 23, 26, 30 }
    // }, 20));
    //
    // System.out.println(solution.searchMatrix(new int[][] { { 1, 3, 5 } }, 3));
    //
    // System.out.println(
    // solution.searchMatrix(new int[][] {
    // { 2, 5 }, { 2, 8 }, { 7, 9 }, { 7, 11 }, { 9, 11 }
    // }, 7));

    // System.out.println(
    // solution.searchMatrix(
    // new int[][] {
    // { 4, 4, 4 }, { 9, 9, 9 }, { 9, 14, 15 }, { 9, 18, 23 }, { 11, 22, 26 }
    // }, 27));

    System.out.println(
        solution.searchMatrix(
            new int[][] {
                { 5, 6, 10, 14 }, { 6, 10, 13, 18 }, { 10, 13, 18, 19 }
            }, 14));
  }
}

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    var m = matrix.length;
    var n = matrix[0].length;
    var x = 0;
    var y = n - 1;

    while (x < m && y >= 0) {
      if (matrix[x][y] == target) {
        return true;
      } else if (matrix[x][y] < target) {
        x++;
      } else {
        y--;
      }
    }

    return false;
  }
}
