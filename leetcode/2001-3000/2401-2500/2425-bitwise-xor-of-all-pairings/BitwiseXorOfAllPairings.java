public class BitwiseXorOfAllPairings {
  public static void main(String[] args) {

    System.out.println(new Solution().xorAllNums(new int[] { 2, 1, 3 }, new int[] { 10, 2, 5, 0 }));
  }
}

class Solution {
  public int xorAllNums(int[] lhs, int[] rhs) {
    int left = 0;
    for (int i = 0; i < lhs.length; i++) {
      left ^= lhs[i];
    }

    int right = 0;
    for (int i = 0; i < rhs.length; i++) {
      right ^= rhs[i];
    }

    int x = 0;

    if (rhs.length % 2 == 1) {
      x ^= left;
    }

    if (lhs.length % 2 == 1) {
      x ^= right;
    }

    return x;
  }
}
