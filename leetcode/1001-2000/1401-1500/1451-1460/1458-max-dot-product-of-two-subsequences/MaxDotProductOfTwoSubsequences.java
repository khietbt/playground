public class MaxDotProductOfTwoSubsequences {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.maxDotProduct(
            new int[] { 2, 1, -2, 5 },
            new int[] { 3, 0, -6 }));

    System.out.println(
        solution.maxDotProduct(
            new int[] { 3, -2 },
            new int[] { 2, -6, 7 }));

    System.out.println(
        solution.maxDotProduct(
            new int[] { -1, -1 },
            new int[] { 1, 1 }));
  }
}

class Solution {
  public int maxDotProduct(int[] nums1, int[] nums2) {
    var m = nums1.length;
    var n = nums2.length;
    var data = new int[m][n];

    data[0][0] = nums1[0] * nums2[0];

    for (var i = 1; i < m; i++) {
      data[i][0] = Math.max(data[i - 1][0], nums1[i] * nums2[0]);
    }

    for (var j = 1; j < n; j++) {
      data[0][j] = Math.max(data[0][j - 1], nums1[0] * nums2[j]);
    }

    for (var i = 1; i < m; i++) {
      for (var j = 1; j < n; j++) {
        var p = nums1[i] * nums2[j];

        data[i][j] = Math.max(p, data[i - 1][j - 1] + p);
        var neighbour = Math.max(data[i][j - 1], data[i - 1][j]);

        data[i][j] = Math.max(data[i][j], neighbour);
      }
    }

    return data[m - 1][n - 1];
  }
}
