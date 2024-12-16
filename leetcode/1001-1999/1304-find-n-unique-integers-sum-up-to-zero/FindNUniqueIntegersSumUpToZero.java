import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero {

  public static void main(String[] args) {
    System.out.println(Arrays.toString((new Solution()).sumZero(5)));
  }
}

class Solution {
  public int[] sumZero(int n) {
    int[] results = new int[n];

    for (int i = 1; i < results.length; i++) {
      results[i] = i;
    }

    results[0] = -n * (n - 1) / 2;

    return results;
  }
}
