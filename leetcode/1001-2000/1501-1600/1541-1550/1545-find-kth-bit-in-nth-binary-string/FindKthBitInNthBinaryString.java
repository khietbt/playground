public class FindKthBitInNthBinaryString {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.findKthBit(3, 1));
    System.out.println(solution.findKthBit(4, 11));
  }
}

class Solution {
  public char findKthBit(int n, int k) {
    return (char) (48 + kthBit(n, k));
  }

  private int kthBit(int n, int k) {
    if (n == 1) {
      return 0;
    }

    var middle = 1 << (n - 1);

    if (k == middle) {
      return 1;
    }

    if (k < middle) {
      return kthBit(n - 1, k);
    }

    return kthBit(n - 1, (1 << n) - k) ^ 1;
  }
}
