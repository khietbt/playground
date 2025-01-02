public class FindPivotIndex {
  public static void main(String[] args) {
    // int[] numbers = new int[] { 1, 7, 3, 6, 5, 6 };
    int[] numbers = new int[] { -1, 1, 2 };

    System.out.println(new Solution().pivotIndex(numbers));
  }
}

class Solution {
  public int pivotIndex(int[] numbers) {
    int[] leftAccumulated = new int[numbers.length + 1];
    int[] rightAccumulated = new int[numbers.length + 1];
    int length = numbers.length;

    for (int i = 0; i < length; i++) {
      leftAccumulated[i + 1] = leftAccumulated[i] + numbers[i];
      rightAccumulated[length - i - 1] = rightAccumulated[length - i] + numbers[length - i - 1];
    }

    for (int i = 0; i < length; i++) {
      if (leftAccumulated[i] == rightAccumulated[i + 1]) {
        return i;
      }
    }

    return -1;
  }
}
