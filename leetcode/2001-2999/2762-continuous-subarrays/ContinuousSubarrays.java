public class ContinuousSubarrays {
  public static void main(String[] args) {
    System.out.println((new Solution()).continuousSubarrays(new int[] { 5, 4, 2, 4 }));
    System.out.println((new Solution()).continuousSubarrays(new int[] { 1, 2, 3 }));
  }
}

class Solution {
  public long continuousSubarrays(int[] numbers) {
    long sum = 0;

    for (int i = 0; i < numbers.length; i++) {
      int min = numbers[i];
      int max = numbers[i];

      int j = i + 1;

      for (; j < numbers.length; j++) {
        if (numbers[j] < min) {
          min = numbers[j];
        }

        if (numbers[j] > max) {
          max = numbers[j];
        }

        if (max - min > 2) {
          break;
        }
      }

      sum += j - i;
    }

    return sum;
  }
}
