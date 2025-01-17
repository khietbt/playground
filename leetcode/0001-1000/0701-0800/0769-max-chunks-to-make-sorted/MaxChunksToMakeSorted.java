public class MaxChunksToMakeSorted {
  public static void main(String[] args) {
    System.out.println((new Solution()).maxChunksToSorted(new int[] { 0, 1, 2, 3, 4, 5 }));
  }
}

class Solution {
  public int maxChunksToSorted(int[] integers) {
    int max = 0;
    int totalChunks = 0;

    for (int i = 0; i < integers.length; i++) {
      max = Math.max(max, integers[i]);

      if (max == i) {
        totalChunks++;
      }
    }

    return totalChunks;
  }
}
