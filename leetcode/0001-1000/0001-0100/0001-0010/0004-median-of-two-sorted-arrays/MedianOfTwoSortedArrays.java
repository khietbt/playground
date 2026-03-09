public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.findMedianSortedArrays(
        new int[] { 1, 2 }, new int[] { 3, 4 }));

    System.out.println(solution.findMedianSortedArrays(
        new int[] { 1, 3 }, new int[] {}));
  }
}

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    var m = nums1.length;
    var n = nums2.length;

    var current = 0;
    var previous = 0;
    var first = 0;
    var second = 0;

    for (var i = 0; i <= (m + n) / 2; i++) {
      if (first >= nums1.length) {
        previous = current;
        current = nums2[second];

        second++;
      } else if (second >= nums2.length) {

        previous = current;
        current = nums1[first];

        first++;
      } else if (nums1[first] > nums2[second]) {
        previous = current;
        current = nums2[second];
        second++;
      } else {
        previous = current;
        current = nums1[first];
        first++;
      }
    }

    if ((m + n) % 2 == 1) {
      previous = current;
    }

    return 0.5 * (previous + current);
  }
}
