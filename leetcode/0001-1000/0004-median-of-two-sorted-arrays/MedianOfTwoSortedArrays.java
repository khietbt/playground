public class MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    int[] first = new int[] { 1, 2 };
    int[] second = new int[] { 3, 4, 5 };

    System.out.println(new Solution().findMedianSortedArrays(first, second));
  }
}

class Solution {
  public double findMedianSortedArrays(int[] first, int[] second) {
    int n = first.length;
    int m = second.length;
    int times = (n + m + 1) / 2;
    int current = 0;
    int previous = 0;
    int i = 0;
    int j = 0;

    for (int index = 0; index < times; index++) {
      previous = current;

      if (i >= n) {
        current = second[j++];
      } else if (j >= m) {
        current = first[i++];
      } else {
        current = first[i] >= second[j] ? second[j++] : first[i++];
      }
    }

    if ((n + m) % 2 == 1) {
      return current;
    }

    return 1.0 * (current + previous) / 2;
  }
}
