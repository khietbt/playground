public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
  public static void main(String[] args) {
    var numbers = new int[] { 1, 3, 2, 3, 3 };
    var k = 2;

    System.out.println((new Solution()).countSubarrays(numbers, k));
  }
}

class Solution {
  public long countSubarrays(int[] numbers, int k) {
    if (numbers.length == 0 || k < 1) {
      return 0;
    }

    int maxElement = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > maxElement) {
        maxElement = numbers[i];
      }
    }

    long totalSubarrays = 0;
    int totalMaxElements = 0;

    int j = 0;

    for (int i = 0; i < numbers.length; i++) {
      while (totalMaxElements < k && j < numbers.length) {
        if (numbers[j] == maxElement) {
          totalMaxElements++;
        }

        j++;
      }

      if (totalMaxElements < k) {
        break;
      }

      totalSubarrays += numbers.length - j + 1;

      if (numbers[i] == maxElement) {
        totalMaxElements--;
      }

    }

    return totalSubarrays;
  }
}
