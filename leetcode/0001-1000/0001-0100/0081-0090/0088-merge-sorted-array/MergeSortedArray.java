import java.util.Arrays;

public class MergeSortedArray {

  public static void main(String[] args) {
    var solution = new Solution();

    // solution.merge(
    // new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
    //
    // solution.merge(new int[] { 1 }, 1, new int[0], 0);
    solution.merge(new int[] { 0 }, 0, new int[] { 1 }, 1);
  }
}

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    var i1 = m - 1;
    var i2 = n - 1;

    for (var i = m + n - 1; i >= 0; i--) {
      if (i1 < 0) {
        nums1[i] = nums2[i2--];
      } else if (i2 < 0) {
        continue;
      } else if (nums1[i1] > nums2[i2]) {
        nums1[i] = nums1[i1--];
      } else {
        nums1[i] = nums2[i2--];
      }
    }
  }
}
