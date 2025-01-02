public class FindTheHighestAltitude {
  public static void main(String[] args) {
    int[] gain = new int[] {
        -5, 1, 5, 0, -7
    };

    System.out.println(new Solution().largestAltitude(gain));
  }
}

class Solution {
  public int largestAltitude(int[] gain) {
    int max = 0;
    int current = 0;

    for (int i = 0; i < gain.length; i++) {
      current += gain[i];

      max = Math.max(max, current);
    }

    return max;
  }
}
